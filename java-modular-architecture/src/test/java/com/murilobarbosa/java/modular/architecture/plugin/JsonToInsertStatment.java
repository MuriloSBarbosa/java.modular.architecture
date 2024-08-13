package com.murilobarbosa.java.modular.architecture.plugin;


import static com.murilobarbosa.java.modular.architecture.utils.FileReaderUtils.getJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonToInsertStatment {

    private static final String BASE_PATH = "src/test/resources/json/%s";

    public JsonToInsertStatment() {
    }

    public static List<String> convertJsonToInsertStatment(String json) {
        try {
            String object = getJson(json);
            ObjectMapper mapper = new ObjectMapper();
            List<String> sqls = new ArrayList<>();
            Map<String, List<Map<String, Object>>> map = mapper.readValue(object, Map.class);

            map.forEach((table, values) -> {
                var columns = values.stream().map(Map::keySet).findFirst().get();
                var sql = new StringBuilder("INSERT INTO ")
                      .append(table)
                      .append(" (")
                      .append(String.join(", ", columns))
                      .append(")")
                      .append(" VALUES");

                values.forEach(value -> {
                    sql.append(" (");

                    columns.forEach(column -> {
                        var val = value.get(column);
                        if (val instanceof String) {
                            sql.append("'").append(val).append("', ");
                        } else {
                            sql.append(val).append(", ");
                        }
                    });
                    sql.delete(sql.length() - 2, sql.length());
                    sql.append("), ");
                });
                sql.delete(sql.length() - 2, sql.length());
                sqls.add(sql.toString());
            });

            return sqls;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
