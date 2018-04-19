package com.jian.buyms.system.controller;

import com.alibaba.druid.util.StringUtils;
import com.jian.buyms.system.model.ShopRecord;
import com.jian.buyms.system.service.ShopRecordService;
import com.jian.buyms.system.vo.Grid;
import com.jian.buyms.system.vo.Json;
import com.jian.buyms.system.vo.SessionInfo;
import com.jian.buyms.util.BeanUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        Date now = new Date();

        try {

            if (StringUtils.isEmpty(shopRecord.getId())) {
                shopRecord.setCreator(getSessionInfo().getId());
                shopRecord.setCreatorName(getSessionInfo().getName());
                shopRecord.setCreateDate(now);
                shopRecord.setLifeCycle(1);
                this.shopRecordService.save(shopRecord);
            } else {
                ShopRecord old = this.shopRecordService.getById(shopRecord.getId());
                if (old != null) {
                    BeanUtil.copyNotNullProperties(old , shopRecord);
                    old.setModifyDate(now);
                    old.setModifier(getSessionInfo().getId());
                    old.setModifierName(getSessionInfo().getName());
                    this.shopRecordService.save(old);
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

    @ResponseBody
    @RequestMapping("/bootstrapTable")
    public Grid bootstrapTable(int limit, int offset) {
        Grid grid = new Grid();
        List<Map> lstRes = this.shopRecordService.getList(limit , offset);
        int count = this.shopRecordService.getListCount();
        grid.setRows(lstRes);
        grid.setTotal(Long.valueOf(count));
        return grid;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Json delete(String id) {
        Json result = new Json();
        try{
            result.setMsg("删除成功");
            result.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
            result.setSuccess(false);
            result.setMsg(ex.getMessage());
        }
        return result;
    }

    private SessionInfo getSessionInfo(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession httpSession = servletRequestAttributes.getRequest().getSession();
        SessionInfo sessionInfo = (SessionInfo) httpSession.getAttribute("currentUser");
        return sessionInfo;
    }
}
