package com.jian.buyms.system.controller;

import com.alibaba.druid.util.StringUtils;
import com.jian.buyms.system.model.ShopRecord;
import com.jian.buyms.system.service.ShopRecordService;
import com.jian.buyms.system.vo.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("shopRecord")
public class ShopRecordController {
    @Resource
    private ShopRecordService shopRecordService;

    @RequestMapping("/edit")
    public String edit(HttpServletRequest request, String id) {
        if(!StringUtils.isEmpty(id)){
            ShopRecord shopRecord = this.shopRecordService.getById(id);
            request.setAttribute("obj" , shopRecord);
        }

        return "/shopRecord/edit";
    }

    @ResponseBody
    @RequestMapping("/save")
    public Json save(HttpServletRequest request, ShopRecord shopRecord) {
        Json result = new Json();
        try {
            if (StringUtils.isEmpty(shopRecord.getId())) {
                shopRecord.setCreateDate(new Date());
                this.shopRecordService.save(shopRecord);
            } else {
                ShopRecord old = this.shopRecordService.getById(shopRecord.getId());
                if (old != null) {

                }
            }
            result.setMsg("保存成功");
            result.setSuccess(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            result.setMsg(ex.getMessage());
            result.setSuccess(false);
        }
        return result;
    }
}
