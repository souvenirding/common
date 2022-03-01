/*
 *      Copyright (c) 2018-2028, DreamLu All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: DreamLu 卢春梦 (596392912@qq.com)
 */
package com.indiev.redis.utils;

import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * 对象工具类
 *
 * @author dingyi
 */
public class ObjectUtil extends org.springframework.util.ObjectUtils {

	/**
	 * 判断元素不为空
	 * @param obj object
	 * @return boolean
	 */
	public static boolean isNotEmpty(@Nullable Object obj) {
		return !ObjectUtil.isEmpty(obj);
	}

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
}
