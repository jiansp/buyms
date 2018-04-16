package com.jian.buyms.system.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.jian.buyms.system.dao.ShopRecordDao;
import com.jian.buyms.system.model.ShopRecord;
import com.jian.buyms.system.service.ShopRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShopRecordServiceImpl implements ShopRecordService{
    @Resource
    private ShopRecordDao shopRecordDao;
    public ShopRecord getById(String id) {
        return this.shopRecordDao.getById(id);
    }

    public void save(ShopRecord shopRecord) {
        if(StringUtils.isEmpty(shopRecord.getId())){
            shopRecord.setId("1");
            this.shopRecordDao.save(shopRecord);
        }else{
            this.shopRecordDao.update(shopRecord);
        }
    }
}
