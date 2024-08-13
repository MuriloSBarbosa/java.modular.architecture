package com.murilobarbosa.java.modular.architecture.application.utils;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

import org.json.JSONException;

public class AssertJsonUtils {

    public static void assertJsonEquals(String json1, String json2) throws JSONException {
        assertEquals(json1, json2, true);
    }
}
