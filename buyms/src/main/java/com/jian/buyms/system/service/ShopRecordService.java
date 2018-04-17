package com.jian.buyms.system.service;

import com.jian.buyms.system.model.ShopRecord;

import java.util.List;
import java.util.Map;

public interface ShopRecordService {
    public ShopRecord getById(String id);
    public void save(ShopRecord shopRecord);

    public List<Map> getList(int limit, int offset);

    public int getListCount();
}
