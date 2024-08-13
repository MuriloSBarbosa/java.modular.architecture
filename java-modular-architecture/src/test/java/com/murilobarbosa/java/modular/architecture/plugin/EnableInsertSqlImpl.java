package com.murilobarbosa.java.modular.architecture.plugin;

import static com.murilobarbosa.java.modular.architecture.plugin.JsonToInsertStatment.convertJsonToInsertStatment;

import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.junit5.integration.Spring;
import java.sql.SQLException;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class EnableInsertSqlImpl implements BeforeAllCallback, BeforeTestExecutionCallback,
      AfterTestExecutionCallback {


    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) {
        insertData(extensionContext);
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        if (enableCleanDataSet(extensionContext)) {
            cleanDataSet(extensionContext);
        }
    }

    private void insertData(ExtensionContext extensionContext) {
        extensionContext.getTestMethod().ifPresent(method -> {
            if (method.isAnnotationPresent(InsertSql.class)) {
                var insertSqlAnnotation = method.getAnnotation(InsertSql.class);
                var sqlStatements = convertJsonToInsertStatment(insertSqlAnnotation.value());
                var connectionHolder = getTestConnection(extensionContext,
                      extensionContext.getUniqueId());

                try  {
                    var connection = connectionHolder.getConnection();
                    for (var sql : sqlStatements) {
                        connection.createStatement().execute(sql);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private ConnectionHolder getTestConnection(ExtensionContext extensionContext,
          String executorId) {
        return Spring.getConnectionFromSpringContext(extensionContext, executorId);
    }


    private void cleanDataSet(ExtensionContext extensionContext) {
        try (var connection = getTestConnection(extensionContext, extensionContext.getUniqueId()).getConnection();
              var stmt = connection.createStatement()) {
            stmt.executeUpdate("SET REFERENTIAL_INTEGRITY = 0");

            try (var rs = stmt.executeQuery("SHOW TABLES")) {
                while (rs.next()) {
                    var tableName = rs.getString("TABLE_NAME");
                    stmt.executeUpdate("TRUNCATE TABLE " + tableName);
                }
            }

            try (var rs = stmt.executeQuery("SELECT SEQUENCE_NAME FROM INFORMATION_SCHEMA.SEQUENCES")) {
                while (rs.next()) {
                    var sequenceName = rs.getString("SEQUENCE_NAME");
                    stmt.executeUpdate("ALTER SEQUENCE " + sequenceName + " RESTART WITH 1");
                }
            }

            stmt.executeUpdate("SET REFERENTIAL_INTEGRITY = 1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        if (extensionContext.getRequiredTestClass().isAnnotationPresent(InsertSql.class)) {
            insertData(extensionContext);
        }
    }

    private boolean enableCleanDataSet(ExtensionContext extensionContext) {
        return hasEnableAlwaysCleanAfter(extensionContext) ||
              hasCleanAfter(extensionContext);
    }

    private boolean hasCleanAfter(ExtensionContext extensionContext) {
        return extensionContext.getTestMethod().isPresent() &&
              extensionContext.getTestMethod().get().isAnnotationPresent(InsertSql.class) &&
              extensionContext.getTestMethod().get().getAnnotation(InsertSql.class).cleanAfter();
    }

    private boolean hasEnableAlwaysCleanAfter(ExtensionContext extensionContext) {
        return extensionContext.getRequiredTestInstances()
              .getAllInstances()
              .stream()
              .anyMatch(o -> o.getClass().isAnnotationPresent(EnableInsertSql.class) &&
                    o.getClass().getAnnotation(EnableInsertSql.class).alwaysCleanAfter());
    }
}
