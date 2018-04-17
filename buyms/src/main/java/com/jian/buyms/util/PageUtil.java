package com.jian.buyms.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageUtil {

    public static int PAGE_SIZE = 15;

    public static int[] init(Page<?> page, HttpServletRequest request) {
        int pageNumber = Integer.parseInt(StringUtils.defaultIfBlank(request.getParameter("p"), "1"));
        page.setPageNo(pageNumber);
        int pageSize = Integer.parseInt(StringUtils.defaultIfBlank(request.getParameter("ps"), String.valueOf(PAGE_SIZE)));
        page.setPageSize(pageSize);
        int firstResult = page.getFirst() - 1;
        int maxResults = page.getPageSize();
        return new int[]{firstResult, maxResults};
    }
    
    public String buildPageSql(String sql, int page, int pageSize) {
    	String sql_str = sql + " LIMIT " + (page - 1) * pageSize + "," + pageSize;
    	return sql_str;
    }
    
    public String buildCountSql(String sql) {
    	String countSql = "SELECT COUNT(*) " + removeSelect(removeOrders(sql));
    	return countSql;
    }
    
	/**
	 * 去除hql的orderby 子句，用于pagedQuery.
	 * 
	 * @see #pagedQuery(String,int,int,Object[])
	 */
	private String removeOrders(String hql) {
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	/**
	 * 去除sql的select 子句，未考虑union的情况,用于pagedQuery.
	 * 
	 * @see #pagedQuery(String,int,int,Object[])
	 */
	private String removeSelect(String sql){
		//不明白之前的修改什么意思，还原包含group by的sql处理 
		//Author chopper 2016-06-28
		sql=sql.toLowerCase(); 
		if(sql.indexOf("group by") != -1) {
			return " from (" + sql + ") temp_table";
		}
		
		//FIXME 当查询中含有函数，比如SUM(),替换SQL出错
		Pattern p = Pattern.compile("\\(.*\\)",Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(sql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			int c = m.end()-m.start();
			m.appendReplacement(sb, getStr(c,"~"));
		}
		m.appendTail(sb);
		
		String replacedSql = sb.toString();
		
		int index = replacedSql.indexOf("from");
		
		//如果不存在
		if(index == -1) {
			index  = replacedSql.indexOf("FROM");
		}
		return sql.substring(index);
	}
	
	private String getStr(int num, String str) {
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			sb.append(str);
		}
		return sb.toString();
	}
}
