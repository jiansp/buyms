package com.jian.buyms.system.dao;

import com.jian.buyms.system.model.ShopRecord;

public interface ShopRecordDao {
    public ShopRecord getById(String id);
    public void save(ShopRecord shopRecord);
    public void update(ShopRecord shopRecord);
}
