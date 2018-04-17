package com.jian.buyms.system.dao;

import com.jian.buyms.system.model.ShopRecord;

import java.util.List;
import java.util.Map;

public interface ShopRecordDao {
    public ShopRecord getById(String id);
    public void save(ShopRecord shopRecord);
    public void update(ShopRecord shopRecord);

    public List<Map> getList(int limit, int offset);

    public int getListCount();
}
