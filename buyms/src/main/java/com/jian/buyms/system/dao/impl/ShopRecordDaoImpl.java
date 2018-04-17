package com.jian.buyms.system.dao.impl;

import com.jian.buyms.system.dao.ShopRecordDao;
import com.jian.buyms.system.model.ShopRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    public List<Map> getList(int limit, int offset) {
        StringBuffer sql = new StringBuffer();
        sql.append("select s.id , s.good_name goodName , s.shop_object shopObject , s.money , s.money_type moneyType ,s.website ,s.shop_time shopTime ");
        sql.append("from t_shop_record s where life_cycle = 1");
        sql.append(" LIMIT " + offset + "," + (limit - 1 + offset));
        return this.findListMapBySql(sql.toString());
    }

    public int getListCount() {
        StringBuffer sql = new StringBuffer();
        sql.append("select count(1) ");
        sql.append("from t_shop_record s where s.life_cycle = 1");
        List ret = this.findBySql(sql.toString());

        if (ret != null && !ret.isEmpty()) {
            return Integer.parseInt(ret.get(0).toString());
        }
        return 0;
    }
}
