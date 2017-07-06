package org.demo.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Map;

/**
 * 
 * @author wang
 *
 */
public class BeanUtil {

	/**
	 * 内省，将request的Map映射到具体的Bean
	 * 
	 * @param map
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T toBean(Map<String, String[]> map, Class<T> type) {
		try {
			Object instance = type.newInstance();
			BeanInfo beanInfo = Introspector.getBeanInfo(type, Object.class);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				for (String key : map.keySet()) {
					if (key.equals(propertyDescriptor.getName())) {
						String[] StringValues = map.get(key);
						Object value = processValue(StringValues[0], propertyDescriptor.getPropertyType());
						propertyDescriptor.getWriteMethod().invoke(instance, value);
						break;
					}
				}
			}
			return (T) instance;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 类型转换
	 * 
	 * @param value
	 * @param propType
	 * @return
	 */
	private static Object processValue(String value, Class<?> propType) {
		if (propType.equals(Integer.TYPE) || propType.equals(Integer.class)) {
			return Integer.valueOf(value);
		} else if (propType.equals(Boolean.TYPE) || propType.equals(Boolean.class)) {
			return Boolean.valueOf(value);
		} else if (propType.equals(Long.TYPE) || propType.equals(Long.class)) {
			return Long.valueOf(value);
		} else if (propType.equals(Double.TYPE) || propType.equals(Double.class)) {
			return Double.valueOf(value);
		} else if (propType.equals(Float.TYPE) || propType.equals(Float.class)) {
			return Float.valueOf(value);
		} else if (propType.equals(Short.TYPE) || propType.equals(Short.class)) {
			return Short.valueOf(value);
		} else if (propType.equals(Byte.TYPE) || propType.equals(Byte.class)) {
			return Byte.valueOf(value);
		} else {
			return value;
		}
	}
}
