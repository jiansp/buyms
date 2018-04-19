package com.jian.buyms.util;

import org.apache.commons.beanutils.*;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BeanUtil {

	private static Log logger = LogFactory.getLog(BeanUtil.class);
	/**
	 * BeanUtil类型转换器
	 */
	public static ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();

	static {
		convertUtilsBean.register(new LongConverter(null), Long.class);
	}

	/**
	 * 拷贝一个bean中的非空属性于另一个bean中
	 * 
	 * @param dest
	 *            目标bean
	 * @param orig
	 *            源bean
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("rawtypes")
	public static void copyNotNullProperties(Object dest, Object orig)
			throws IllegalAccessException, InvocationTargetException {
		BeanUtilsBean beanUtils = BeanUtilsBean.getInstance();
		// Validate existence of the specified beans
		if (dest == null) {
			throw new IllegalArgumentException("No destination bean specified");
		}
		if (orig == null) {
			throw new IllegalArgumentException("No origin bean specified");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("BeanUtils.copyProperties(" + dest + ", " + orig + ")");
		}

		// Copy the properties, converting as necessary
		if (orig instanceof DynaBean) {
			DynaProperty[] origDescriptors = ((DynaBean) orig).getDynaClass()
					.getDynaProperties();
			for (int i = 0; i < origDescriptors.length; i++) {
				String name = origDescriptors[i].getName();
				// Need to check isReadable() for WrapDynaBean
				// (see Jira issue# BEANUTILS-61)
				if (beanUtils.getPropertyUtils().isReadable(orig, name)
						&& beanUtils.getPropertyUtils().isWriteable(dest, name)) {
					Object value = ((DynaBean) orig).get(name);
					beanUtils.copyProperty(dest, name, value);
				}
			}
		} else if (orig instanceof Map) {
			Iterator entries = ((Map) orig).entrySet().iterator();
			while (entries.hasNext()) {
				Entry entry = (Entry) entries.next();
				String name = (String) entry.getKey();
				if (beanUtils.getPropertyUtils().isWriteable(dest, name)) {
					beanUtils.copyProperty(dest, name, entry.getValue());
				}
			}
		} else /* if (orig is a standard JavaBean) */{
			PropertyDescriptor[] origDescriptors = beanUtils.getPropertyUtils()
					.getPropertyDescriptors(orig);
			for (int i = 0; i < origDescriptors.length; i++) {
				String name = origDescriptors[i].getName();
				if ("class".equals(name)) {
					continue; // No point in trying to set an object's class
				}
				if (beanUtils.getPropertyUtils().isReadable(orig, name)
						&& beanUtils.getPropertyUtils().isWriteable(dest, name)) {
					try {
						Object value = beanUtils.getPropertyUtils()
								.getSimpleProperty(orig, name);
						if (value != null) {
							if (value instanceof HashSet) {
								HashSet valMap = (HashSet) value;
								if (valMap.size() > 0) {
									beanUtils.copyProperty(dest, name, value);
								}
							} else {
								beanUtils.copyProperty(dest, name, value);
							}
						}
					} catch (NoSuchMethodException e) {
						// Should not happen
					}
				}
			}
		}

	}

	/**
	 * 拷贝一个bean中的非空属性于另一个bean中
	 *
	 * @param dest
	 *            目标bean
	 * @param orig
	 *            源bean
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("rawtypes")
	public static void copyProperties(Object dest, Object orig)
			throws IllegalAccessException, InvocationTargetException {
		BeanUtilsBean beanUtils = BeanUtilsBean.getInstance();
		// Validate existence of the specified beans
		if (dest == null) {
			throw new IllegalArgumentException("No destination bean specified");
		}
		if (orig == null) {
			throw new IllegalArgumentException("No origin bean specified");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("BeanUtils.copyProperties(" + dest + ", " + orig + ")");
		}

		// Copy the properties, converting as necessary
		if (orig instanceof DynaBean) {
			DynaProperty[] origDescriptors = ((DynaBean) orig).getDynaClass()
					.getDynaProperties();
			for (int i = 0; i < origDescriptors.length; i++) {
				String name = origDescriptors[i].getName();
				// Need to check isReadable() for WrapDynaBean
				// (see Jira issue# BEANUTILS-61)
				if (beanUtils.getPropertyUtils().isReadable(orig, name)
						&& beanUtils.getPropertyUtils().isWriteable(dest, name)) {
					Object value = ((DynaBean) orig).get(name);
					beanUtils.copyProperty(dest, name, value);
				}
			}
		} else if (orig instanceof Map) {
			Iterator entries = ((Map) orig).entrySet().iterator();
			while (entries.hasNext()) {
				Entry entry = (Entry) entries.next();
				String name = (String) entry.getKey();
				if (beanUtils.getPropertyUtils().isWriteable(dest, name)) {
					beanUtils.copyProperty(dest, name, entry.getValue());
				}
			}
		} else /* if (orig is a standard JavaBean) */{
			PropertyDescriptor[] origDescriptors = beanUtils.getPropertyUtils()
					.getPropertyDescriptors(orig);
			for (int i = 0; i < origDescriptors.length; i++) {
				String name = origDescriptors[i].getName();
				if ("class".equals(name)) {
					continue; // No point in trying to set an object's class
				}
				if (beanUtils.getPropertyUtils().isReadable(orig, name)
						&& beanUtils.getPropertyUtils().isWriteable(dest, name)) {
					try {
						Object value = beanUtils.getPropertyUtils()
								.getSimpleProperty(orig, name);
						if (orig.getClass().getDeclaredField(name).getAnnotation(NotCopy.class) == null) {
							if (value instanceof HashSet) {
								HashSet valMap = (HashSet) value;
								if (valMap.size() > 0) {
									beanUtils.copyProperty(dest, name, value);
								}
							} else {
								beanUtils.copyProperty(dest, name, value);
							}
						}
					} catch (NoSuchMethodException e) {
						// Should not happen
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}



	/**
	 * 取得能转化类型的bean
	 *
	 * @return
	 */
	public static BeanUtilsBean getBeanUtils() {
		BeanUtilsBean beanUtilsBean = new BeanUtilsBean(convertUtilsBean,
				new PropertyUtilsBean());
		return beanUtilsBean;
	}

	/**
	 * 返回请求中的所有的对应的Map值
	 *
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> getMapFromRequest(
			HttpServletRequest request) {
		Map<String, String[]> reqMap = request.getParameterMap();

		HashMap<String, Object> datas = new HashMap<String, Object>();
		Iterator<?> it = reqMap.entrySet().iterator();

		while (it.hasNext()) {

			Entry entry = (Entry) it.next();
			String key = (String) entry.getKey();
			String[] val = (String[]) entry.getValue();
			if (val.length == 1) {
				datas.put(key, val[0]);
			} else {
				datas.put(key, val);
			}
		}
		return datas;
	}

	/**
	 * 可以用于判断 Map,Collection,String,Array,Long,Short是否为空
	 * 
	 * @param o
	 *            java.lang.Object.
	 * @return boolean.
	 */
	@SuppressWarnings("unused")
	public static boolean isEmpty(Object o) {
		if (o == null)
			return true;
		if (o instanceof String) {
			if (((String) o).trim().length() == 0) 
				return true;
		} else if (o instanceof Collection) {
			if (((Collection<?>) o).isEmpty()) 
				return true;
		} else if (o.getClass().isArray()) {
			if (((Object[]) o).length == 0) 
				return true;
		} else if (o instanceof Map) {
			if (((Map<?, ?>) o).isEmpty()) 
				return true;
		} else if (o instanceof Long) {
			if (((Long) o) == null) 
				return true;
		} else if (o instanceof Short) {
			if (((Short) o) == null) 
				return true;
		} else {
			return false;
		}
		return false;

	}

	/**
	 * 可以用于判断 Map,Collection,StringArray,Long,Short是否不为空
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isNotEmpty(Object o) {
		return !isEmpty(o);
	}
	
	/**
	 * 驼峰法转下划线
	 * @param line
	 * @return
	 */
	public static String camel2Underline(String line) {
		if (StringUtils.isEmpty(line)) {
			return "";
		}
		
		line = String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
		Matcher matcher = pattern.matcher(line);
		
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(word.toUpperCase());
			sb.append(matcher.end() == line.length() ? "" : "_");
		}
		
		return sb.toString();
	}
}
