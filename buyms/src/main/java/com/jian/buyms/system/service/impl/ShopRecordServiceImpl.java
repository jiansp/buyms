package com.jian.buyms.system.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.jian.buyms.system.dao.ShopRecordDao;
import com.jian.buyms.system.model.ShopRecord;
import com.jian.buyms.system.service.ShopRecordService;
import com.jian.buyms.util.UUIDGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ShopRecordServiceImpl implements ShopRecordService{
    @Resource
    private ShopRecordDao shopRecordDao;
    public ShopRecord getById(String id) {
        return this.shopRecordDao.getById(id);
    }

    public void save(ShopRecord shopRecord) {
        if(StringUtils.isEmpty(shopRecord.getId())){
            shopRecord.setId(UUIDGenerator.getUUID());
            this.shopRecordDao.save(shopRecord);
        }else{
            this.shopRecordDao.update(shopRecord);
        }
    }

    public List<Map> getList(int limit, int offset) {
        return this.shopRecordDao.getList(limit , offset);
    }

    public int getListCount() {
        return this.shopRecordDao.getListCount();
    }
}
