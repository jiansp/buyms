package com.jian.buyms.system.vo;

import java.util.List;

public class SessionInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;// 用户ID
	private String loginname;// 登录名
	private String name;// 姓名
	private String ip;// 用户IP
    private String systemIds;
	private List<String> resourceList;// 用户可以访问的资源地址列表
	public static String systemCode = "ENTER_INFO_SYS";
	
	
	public static String getSystemCode() {
		return systemCode;
	}

	public static void setSystemCode(String systemCode) {
		SessionInfo.systemCode = systemCode;
	}

	private List<String> resourceAllList;

	public String getSystemIds() {
		return systemIds;
	}

	public void setSystemIds(String systemIds) {
		this.systemIds = systemIds;
	}

	public List<String> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<String> resourceList) {
		this.resourceList = resourceList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
	public List<String> getResourceAllList() {
		return resourceAllList;
	}

	public void setResourceAllList(List<String> resourceAllList) {
		this.resourceAllList = resourceAllList;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
