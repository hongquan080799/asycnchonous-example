package com.example.VertxDemo;

import com.google.gson.Gson;

public class JsonUtils {
    private static final Gson gson = new Gson();

    public static <T> T parse(String jsonString, Class<T> type) {
        return gson.fromJson(jsonString, type);
    }
}
