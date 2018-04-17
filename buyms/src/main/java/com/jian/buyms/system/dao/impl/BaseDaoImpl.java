package com.jian.buyms.system.dao.impl;

import com.jian.buyms.system.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

@Repository
public class BaseDaoImpl implements BaseDao {
	private static final long serialVersionUID = 1636313121638665197L;
	  @Resource
	  private SessionFactory sessionFactory;
	  
	  public Session getCurrentSession()
	  {
	    return this.sessionFactory.getCurrentSession();
	  }
	  
	  public void delete(Object object)
	  {
	    getCurrentSession().delete(object);
	  }
	  
	  public void deleteAll(List list)
	  {
	    for (Iterator i$ = list.iterator(); i$.hasNext();)
	    {
	      Object obj = i$.next();
	      delete(obj);
	    }
	  }
	  
	  public void flush()
	  {
	    getCurrentSession().flush();
	  }
	  
	  public Serializable save(Object object)
	  {
	    Serializable id = getCurrentSession().save(object);
	    return id;
	  }
	  
	  public void update(Object object)
	  {
	    getCurrentSession().update(object);
	  }
	  
	  public void saveOrUpdate(Object object)
	  {
	    getCurrentSession().saveOrUpdate(object);
	  }
	  
	  public List findByNamedParam(String hql, String paramName, Object paramValue)
	  {
	    Session session = getCurrentSession();
	    Query query = session.createQuery(hql);
	    query.setParameter(paramName, paramValue);
	    List list = query.list();
	    return list;
	  }
	  
	  public List findByNamedParam(String hql, String[] paramName, Object[] paramValue)
	  {
	    Session session = getCurrentSession();
	    Query query = session.createQuery(hql);
	    if (paramName != null) {
	      for (int i = 0; i < paramName.length; i++) {
	        query.setParameter(paramName[i], paramValue[i]);
	      }
	    }
	    List list = query.list();
	    return list;
	  }
	  
	  public List findByHql(String hql)
	  {
	    return getCurrentSession().createQuery(hql).list();
	  }
	  
	  public List findBySql(String sql)
	  {
	    Session session = getCurrentSession();
	    Query query = session.createSQLQuery(sql);
	    List list = query.list();
	    return list;
	  }
	  
	  public List findBySql(String sql, String[] paramName, Object[] paramValue)
	  {
	    Session session = getCurrentSession();
	    Query query = session.createSQLQuery(sql);
	    if (paramName != null) {
	      for (int i = 0; i < paramName.length; i++) {
	        query.setParameter(paramName[i], paramValue[i]);
	      }
	    }
	    List list = query.list();
	    return list;
	  }
	  
	  public List findBySql(String sql, Object[] paramValue)
	  {
	    Session session = getCurrentSession();
	    Query query = session.createSQLQuery(sql);
	    if (paramValue != null) {
	      for (int i = 0; i < paramValue.length; i++) {
	        query.setParameter(i, paramValue[i]);
	      }
	    }
	    List list = query.list();
	    return list;
	  }
	  
	  public List findByHql(String hql, int size)
	  {
	    Session session = getCurrentSession();
	    Query query = session.createQuery(hql);
	    query.setMaxResults(size);
	    List list = query.list();
	    return list;
	  }
	  
	  public List findByHql(String hql, int minSize, int maxSize)
	  {
	    Session session = getCurrentSession();
	    Query query = session.createQuery(hql);
	    query.setFirstResult(minSize).setMaxResults(maxSize);
	    List list = query.list();
	    if (list.size() > 0) {
	      return list;
	    }
	    return null;
	  }
	  
	  public int execUpdateHql(String hql)
	  {
	    Session session = getCurrentSession();
	    Query query = session.createQuery(hql);
	    int i = query.executeUpdate();
	    return i;
	  }
	  
	  public int execUpdateSql(String sql)
	  {
	    Session session = getCurrentSession();
	    Query query = session.createSQLQuery(sql);
	    int i = query.executeUpdate();
	    return i;
	  }
	  
	  public int execUpdateSql(String sql, Object[] paramValue)
	  {
	    Session session = getCurrentSession();
	    Query query = session.createSQLQuery(sql);
	    if (paramValue != null) {
	      for (int i = 0; i < paramValue.length; i++) {
	        query.setParameter(i, paramValue[i]);
	      }
	    }
	   int i = query.executeUpdate();
	    return i;
	  }
	  
	  public List findBySqlForIn(String sql, String paramName, Object[] paramValue , Object[] paramValues) {
			Session session = getCurrentSession();
			Query query = session.createSQLQuery(sql);
			if (paramValue != null) {
				for (int i = 0; i < paramValue.length; i++) {
					query.setParameter(i, paramValue[i]);
				}
				query.setParameterList(paramName, paramValues);
			}
			List list = query.list();
			return list;
		}
	  
	  public int execUpdateSqlForIn(String sql,String paramName, Object[] paramValue, Object[] paramValues)
	  {
	    Session session = getCurrentSession();
	    Query query = session.createSQLQuery(sql);
	    if (paramValue != null) {
			for (int i = 0; i < paramValue.length; i++) {
				query.setParameter(i, paramValue[i]);
			}
			query.setParameterList(paramName, paramValues);
		}
	   int i = query.executeUpdate();
	    return i;
	  }
	  
	  public Object findById(Class clazz, Serializable id)
	  {
	    return getCurrentSession().get(clazz, id);
	  }
	  
	  public void saveAll(List list)
	  {
	    for (Iterator i$ = list.iterator(); i$.hasNext();)
	    {
	      Object obj = i$.next();
	      save(obj);
	    }
	  }
	  
	  public void updateAll(List list)
	  {
	    for (Iterator i$ = list.iterator(); i$.hasNext();)
	    {
	      Object obj = i$.next();
	      update(obj);
	    }
	  }
	  
	  public void evict(Class clazz, Serializable id)
	  {
	    Object obj = getCurrentSession().load(clazz, id);
	    if (obj.getClass().getName().equals(clazz.getName())) {
	      getCurrentSession().evict(obj);
	    }
	  }
	  
	  public List findByNamedParam(String hql, String paramName, Object paramValue, int size)
	  {
	    Session session = getCurrentSession();
	    Query query = session.createQuery(hql);
	    query.setParameter(paramName, paramValue);
	    query.setMaxResults(size);
	    List list = query.list();
	    return list;
	  }
	  
	  public List findByNamedParam(String hql, String[] paramName, Object[] paramValue, int size)
	  {
	    Session session = getCurrentSession();
	    Query query = session.createQuery(hql);
	    if (paramName != null) {
	      for (int i = 0; i < paramName.length; i++) {
	        query.setParameter(paramName[i], paramValue[i]);
	      }
	    }
	    query.setMaxResults(size);
	    List list = query.list();
	    return list;
	  }
	  
	  public List findByNamedParam(String hql, String[] paramName, Object[] paramValue, int minSize, int maxSize)
	  {
	    Session session = getCurrentSession();
	    Query query = session.createQuery(hql);
	    if (paramName != null) {
	      for (int i = 0; i < paramName.length; i++) {
	        query.setParameter(paramName[i], paramValue[i]);
	      }
	    }
	    query.setFirstResult(minSize);
	    query.setMaxResults(maxSize);
	    List list = query.list();
	    return list;
	  }
	  
	  public Map findMapBySql(String sql)
	  {
	    Query query = getCurrentSession().createSQLQuery(sql)
	      .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	    Map hashMap = new HashMap();
	    List list = query.list();
	    String key = "";
	    String value = "";
	    for (Object objList : list)
	    {
	      Map map = (Map)objList;
	      Set keyset = map.keySet();
	      for (Object object : keyset) {
	        key = key + object.toString() + "|";
	      }
	      hashMap.put(map.get(key.split("|")[1]), map.get(key.split("|")[3]));
	    }
	    return hashMap;
	  }
	  
	  public Map findKeyMapBySql(String sql)
	  {
	    Map hashMap = new HashMap();
	    Query query = getCurrentSession().createSQLQuery(sql)
	      .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	    List list = query.list();
	    for (Object objList : list)
	    {
	      Map map = (Map)objList;
	      hashMap.put(map.get("KEY"), map);
	    }
	    return hashMap;
	  }
	  
	  public List findListMapBySql(String sql)
	  {
	    Map hashMap = new HashMap();
	    Query query = getCurrentSession().createSQLQuery(sql)
	      .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	    List list = query.list();
	    return list;
	  }
	  
	  public List findListMapBySql(String sql, String[] paramName, Object[] paramValue)
	  {
	    Map hashMap = new HashMap();
	    Query query = getCurrentSession().createSQLQuery(sql)
	      .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	    if (paramName != null) {
	      for (int i = 0; i < paramName.length; i++) {
	        query.setParameter(paramName[i], paramValue[i]);
	      }
		}
	    List list = query.list();
	    return list;
	  }
	  
	  public List findListMapBySql(String sql, Object[] paramValue)
	  {
	    Map hashMap = new HashMap();
	    Query query = getCurrentSession().createSQLQuery(sql)
	      .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	    if (paramValue != null) {
	      for (int i = 0; i < paramValue.length; i++) {
	        query.setParameter(i, paramValue[i]);
	      }
		}
	    List list = query.list();
	    return list;
	  }
	  
	  public List getPageVO(String hql, int begin, int rows, Object[] paramValue)
	  {
	    Query query = getCurrentSession().createQuery(hql);
	    if (paramValue != null) {
	      for (int i = 0; i < paramValue.length; i++)
	      {
	        System.out.println(paramValue[i]);
	        query.setParameter(i, paramValue[i]);
	      }
	    }
	    query.setFirstResult(begin);
	    query.setMaxResults(rows);
	    List all = query.list();
	    return all;
	  }
	  
	  public List getPageTotalVO(String hql, Object[] paramValue)
	  {
	    Query query = getCurrentSession().createQuery(hql);
	    if (paramValue != null) {
	      for (int i = 0; i < paramValue.length; i++)
	      {
	        System.out.println(paramValue[i]);
	        query.setParameter(i, paramValue[i]);
	      }
	    }
	    List all = query.list();
	    return all;
	  }
	  
	  public int callProcBySql(String sql, Object[] paramValue)
	  {
	    Session session = getCurrentSession();
	    SQLQuery query = session.createSQLQuery(sql);
	    if (paramValue != null) {
	      for (int i = 0; i < paramValue.length; i++)
	      {
	        System.out.println(paramValue[i]);
	        query.setString(i, paramValue[i].toString());
	      }
	    }
	    int i = query.executeUpdate();
	    return i;
	  }
	  
	  public Map<String, Object> findAllByPageAndPageSize(String className, int currPage, int pageSize)
	  {
	    String hql = "from " + className;
	    Session session = getCurrentSession();
	    
	    Query query = session.createQuery(hql);
	    
	    int minSize = (currPage - 1) * pageSize;
	    query.setFirstResult(minSize).setMaxResults(pageSize);
	    List list = query.list();
	    
	    int total = 0;
	    
	    Map<String, Object> map = new HashMap();
	    if ((list == null) || (list.isEmpty()))
	    {
	      map.put("result", list);
	      map.put("total", Integer.valueOf(total));
	      return map;
	    }
	    hql = "select count(*) from " + className;
	    query = session.createQuery(hql);
	    List listCount = query.list();
	    if ((listCount == null) || (listCount.isEmpty()))
	    {
	      map.put("result", list);
	      map.put("total", Integer.valueOf(total));
	      return map;
	    }
	    total = Integer.valueOf(listCount.get(0).toString()).intValue();
	    
	    map.put("result", list);
	    map.put("total", Integer.valueOf(total));
	    
	    return map;
	  }
	  
	  public List findAll(String className)
	  {
	    String hql = "from " + className;
	    Session session = getCurrentSession();
	    Query query = session.createQuery(hql);
	    return query.list();
	  }
	  
	  public int findPageTotalCount(String hql)
	  {
	    Session session = getCurrentSession();
	    Query query = session.createQuery(hql);
	    List<Object> list = query.list();
	    
	    return (list == null) || (list.isEmpty()) ? 0 : Integer.valueOf(list.get(0).toString()).intValue();
	  }

}
