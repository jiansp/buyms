package com.jian.buyms.system.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao extends Serializable {
	public abstract Serializable save(Object paramObject);

	public abstract void update(Object paramObject);

	public abstract void delete(Object paramObject);

	public abstract void deleteAll(List paramList);

	public abstract void saveOrUpdate(Object paramObject);

	public abstract void saveAll(List paramList);

	public abstract void updateAll(List paramList);

	public abstract Object findById(Class paramClass,
                                    Serializable paramSerializable);

	public abstract int execUpdateHql(String paramString);

	public abstract int execUpdateSql(String paramString);

	public abstract int execUpdateSql(String sql, Object[] paramValue);

	public abstract List findByHql(String paramString);

	public abstract List findBySql(String paramString);

	public abstract List findByHql(String paramString, int paramInt);

	public abstract List findByHql(String paramString, int paramInt1,
                                   int paramInt2);

	public abstract List findByNamedParam(String paramString1,
                                          String paramString2, Object paramObject);

	public abstract List findByNamedParam(String paramString1,
                                          String paramString2, Object paramObject, int paramInt);

	public abstract List findByNamedParam(String paramString,
                                          String[] paramArrayOfString, Object[] paramArrayOfObject);

	public abstract List findByNamedParam(String paramString,
                                          String[] paramArrayOfString, Object[] paramArrayOfObject,
                                          int paramInt);

	public abstract List findByNamedParam(String paramString,
                                          String[] paramArrayOfString, Object[] paramArrayOfObject,
                                          int paramInt1, int paramInt2);

	public abstract void evict(Class paramClass, Serializable paramSerializable);

	public abstract void flush();

	public abstract Map findMapBySql(String paramString);

	public abstract Map findKeyMapBySql(String paramString);

	public abstract List findListMapBySql(String paramString);

	public abstract List getPageVO(String paramString, int paramInt1,
                                   int paramInt2, Object[] paramArrayOfObject);

	public abstract List getPageTotalVO(String paramString,
                                        Object[] paramArrayOfObject);

	public abstract int callProcBySql(String paramString,
                                      Object[] paramArrayOfObject);

	public abstract Map<String, Object> findAllByPageAndPageSize(
            String paramString, int paramInt1, int paramInt2);

	public abstract List findAll(String paramString);

	public abstract int findPageTotalCount(String paramString);
}
