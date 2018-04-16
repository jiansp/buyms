package com.jian.buyms.system.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * ParamConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_shop_record")

public class ShopRecord implements java.io.Serializable {


    // Fields

    private String id;
    private String goodName;
    private String shopTime;
    private String shopObject;
    private String moneyType;
    private String money;
    private String website;
    private String creator;
    private String creatorName;
    private Date createDate;
    private String modifier;
    private String modifierName;
    private Date modifyDate;
    private String deleter;
    private String deleterName;
    private Date delDate;
    private Integer lifeCycle;


    // Constructors

    /** default constructor */
    public ShopRecord() {
    }

	/** minimal constructor */
    public ShopRecord(String id) {
        this.id = id;
    }


    // Property accessors
    @Id 
    
    @Column(name="ID", unique=true, nullable=false, length=32)

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Column(name="GOOD_NAME", length=100)
    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }
    @Column(name="SHOP_TIME", length=19)
    public String getShopTime() {
        return shopTime;
    }

    public void setShopTime(String shopTime) {
        this.shopTime = shopTime;
    }
    @Column(name="SHOP_OBJECT", length=100)
    public String getShopObject() {
        return shopObject;
    }

    public void setShopObject(String shopObject) {
        this.shopObject = shopObject;
    }
    @Column(name="MONEY_TYPE", length=20)
    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }
    @Column(name="MONEY", length=50)
    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
    @Column(name="WEBSITE", length=100)
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


    @Column(name="CREATOR", length=32)

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Column(name="CREATOR_NAME", length=100)

    public String getCreatorName() {
        return this.creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    @Column(name="CREATE_DATE", length=19)

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name="MODIFIER", length=32)

    public String getModifier() {
        return this.modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Column(name="MODIFIER_NAME", length=100)

    public String getModifierName() {
        return this.modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    @Column(name="MODIFY_DATE", length=19)

    public Date getModifyDate() {
        return this.modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Column(name="DELETER", length=32)

    public String getDeleter() {
        return this.deleter;
    }

    public void setDeleter(String deleter) {
        this.deleter = deleter;
    }

    @Column(name="DELETER_NAME", length=100)

    public String getDeleterName() {
        return this.deleterName;
    }

    public void setDeleterName(String deleterName) {
        this.deleterName = deleterName;
    }

    @Column(name="DEL_DATE", length=19)

    public Date getDelDate() {
        return this.delDate;
    }

    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }

    @Column(name="LIFE_CYCLE")

    public Integer getLifeCycle() {
        return this.lifeCycle;
    }

    public void setLifeCycle(Integer lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

}