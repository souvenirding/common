package com.indiev.redis.utils;

import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dingyi
 */
public class RedisUtil {
    /**
     * 将key value 数组转为 map
     *
     * @param keysValues key value 数组
     * @param <K>        key
     * @param <V>        value
     * @return map 集合
     */
    public static <K, V> Map<K, V> toMap(Object... keysValues) {
        int kvLength = keysValues.length;
        if (kvLength % 2 != 0) {
            throw new IllegalArgumentException("wrong number of arguments for met, keysValues length can not be odd");
        }
        Map<K, V> keyValueMap = new HashMap<>(kvLength);
        for (int i = kvLength - 2; i >= 0; i -= 2) {
            Object key = keysValues[i];
            Object value = keysValues[i + 1];
            keyValueMap.put((K) key, (V) value);
        }
        return keyValueMap;
    }

    public static boolean isEmpty(@Nullable Object[] array) {
        return array == null || array.length == 0;
    }

    public static String join(Object[] arr, String delim) {
        return StringUtil.arrayToDelimitedString(arr, delim);
    }
}
