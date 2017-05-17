/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bt.ommvets.entity;

import java.io.Serializable;

/**
 * 工单流程Entity
 * @author cgs
 * @version 2017-04-15
 */
public class WorkorderFlow implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String operationMemo;		// 操作备注
	private Integer operationType=0;		// 操作类型
	private String workorderId;		// 工单id
	private String operateUserId;		// 操作人id
	private String receiveUserId;		// 接收人id
	private String delFlag="0";				//

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOperationMemo() {
		return operationMemo;
	}

	public void setOperationMemo(String operationMemo) {
		this.operationMemo = operationMemo;
	}

	public Integer getOperationType() {
		return operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}

	public String getWorkorderId() {
		return workorderId;
	}

	public void setWorkorderId(String workorderId) {
		this.workorderId = workorderId;
	}

	public String getOperateUserId() {
		return operateUserId;
	}

	public void setOperateUserId(String operateUserId) {
		this.operateUserId = operateUserId;
	}

	public String getOperateUser() {
		return operateUserId;
	}

	public void setOperateUser(String operateUser) {
		this.operateUserId = operateUser;
	}

	public String getReceiveUserId() {
		return receiveUserId;
	}

	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}