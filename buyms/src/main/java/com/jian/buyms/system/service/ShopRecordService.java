package com.jian.buyms.system.service;

import com.jian.buyms.system.model.ShopRecord;

public interface ShopRecordService {
    public ShopRecord getById(String id);
    public void save(ShopRecord shopRecord);
}
