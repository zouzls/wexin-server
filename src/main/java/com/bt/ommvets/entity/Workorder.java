/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bt.ommvets.entity;

import java.io.Serializable;
import java.util.Date;

public class Workorder  implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private Integer workorderType=2;		// 工单类型
	private Integer status;		// 工单状态
	private Integer priority;		// 优先级
	private String createUserId;		// 创建工单用户id
	private Date createTime;		// 创建工单时间
	private String workorderRemark;		// 备注


	private String stationId;		// 站点id
	private String deviceId;		// 设备id
	private String currentFlowId;		// 当前流程id

	private String delFlag="0";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getWorkorderType() {
		return workorderType;
	}

	public void setWorkorderType(Integer workorderType) {
		this.workorderType = workorderType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getCurrentFlowId() {
		return currentFlowId;
	}

	public void setCurrentFlowId(String currentFlowId) {
		this.currentFlowId = currentFlowId;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getWorkorderRemark() {
		return workorderRemark;
	}

	public void setWorkorderRemark(String workorderRemark) {
		this.workorderRemark = workorderRemark;
	}
}