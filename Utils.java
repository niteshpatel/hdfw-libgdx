package com.herodevelop.hdlibgdx;

public class Utils {

    public static class Json {
        private static com.badlogic.gdx.utils.Json json = new com.badlogic.gdx.utils.Json();

        public static <T> T fromJson(Class<T> type, String data) {
            return json.fromJson(type, data);
        }

        public static String toJson(Object object) {
            return json.toJson(object);
        }
    }
}
