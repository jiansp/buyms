package com.jian.buyms.system.dao.impl;

import com.jian.buyms.system.dao.ShopRecordDao;
import com.jian.buyms.system.model.ShopRecord;
import org.springframework.stereotype.Repository;

@Repository
public class ShopRecordDaoImpl extends BaseDaoImpl implements ShopRecordDao {

    public ShopRecord getById(String id) {
        return (ShopRecord) this.findById(ShopRecord.class, id);
    }

    public void save(ShopRecord shopRecord) {
        super.save(shopRecord);
    }

    public void update(ShopRecord shopRecord) {
        super.update(shopRecord);
    }
}
