package com.murilobarbosa.java.modular.architecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@SpringBootApplication
// If there are two classes with the same name in different packages, the FullyQualifiedAnnotationBeanNameGenerator class will generate a unique bean name for each class.
//@ComponentScan(nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class)
public class JavaModularArchitectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaModularArchitectureApplication.class, args);
    }
}