/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bt.ommvets.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 自动工单规则Entity
 * @author cgs
 * @version 2017-04-19
 */
public class WorkorderAutoRule implements Serializable{

	private static final long serialVersionUID = 1L;
	public static final int AUTOTYPE_ONCE=0;//一次预定
	public static final int AUTOTYPE_CIRCLE=1;//循环定时

	private String id;
	private String workorderTopic;		// 工单主题

	private Integer autoType;		// 自动类型
	private Date scheduledTime;		// 预定时间

	private Date cycleStart;		// 循环开始
	private Integer cycleType;		// 循环类型
	private Integer cycleTime;		// 循环时间

	private Integer priority;		// 工单优先级
	private Integer workorderStatus;		// 工单状态

	private String stationId;		// 站点id
	private String deviceId;		// 设备id
	private String receiveUserId;		// 接收人id
	private String createUserId;		// 创建人id
	private String remark;		// 备注
	private String availFlag;		// 规则是否有效
	private String delFlag;
	private String hasUsed;			//规则是否被定时任务读取

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getWorkorderTopic() {
		return workorderTopic;
	}

	public void setWorkorderTopic(String workorderTopic) {
		this.workorderTopic = workorderTopic;
	}

	public String getAvailFlag() {
		return availFlag;
	}

	public void setAvailFlag(String availFlag) {
		this.availFlag = availFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(Date scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public Date getCycleStart() {
		return cycleStart;
	}

	public void setCycleStart(Date cycleStart) {
		this.cycleStart = cycleStart;
	}

	public Integer getAutoType() {
		return autoType;
	}

	public void setAutoType(Integer autoType) {
		this.autoType = autoType;
	}

	public Integer getCycleType() {
		return cycleType;
	}

	public void setCycleType(Integer cycleType) {
		this.cycleType = cycleType;
	}

	public Integer getCycleTime() {
		return cycleTime;
	}

	public void setCycleTime(Integer cycleTime) {
		this.cycleTime = cycleTime;
	}

	public Integer getWorkorderStatus() {
		return workorderStatus;
	}

	public void setWorkorderStatus(Integer workorderStatus) {
		this.workorderStatus = workorderStatus;
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

	public String getReceiveUserId() {
		return receiveUserId;
	}

	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getHasUsed() {
		return hasUsed;
	}

	public void setHasUsed(String hasUsed) {
		this.hasUsed = hasUsed;
	}

	@Override
	public String toString() {
		return "WorkorderAutoRule{" +
				"id='" + id + '\'' +
				", workorderTopic='" + workorderTopic + '\'' +
				", availFlag='" + availFlag + '\'' +
				", remark='" + remark + '\'' +
				", priority=" + priority +
				", scheduledTime=" + scheduledTime +
				", cycleStart=" + cycleStart +
				", cycleType=" + cycleType +
				", cycleTime=" + cycleTime +
				", autoType=" + autoType +
				", workorderStatus=" + workorderStatus +
				", stationId='" + stationId + '\'' +
				", deviceId='" + deviceId + '\'' +
				", receiveUserId='" + receiveUserId + '\'' +
				", createUserId='" + createUserId + '\'' +
				'}';
	}

}