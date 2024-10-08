package com.murilobarbosa.java.modular.architecture.application.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {

      public static String asJsonString(Object obj) {
          try {
              return new ObjectMapper().writeValueAsString(obj);
          } catch (Exception e) {
              throw new RuntimeException(e);
          }
      }

      public static <T> T fromJsonString(String json, Class<T> clazz) {
          try {
              return new ObjectMapper().readValue(json, clazz);
          } catch (Exception e) {
              throw new RuntimeException(e);
          }
      }
}
