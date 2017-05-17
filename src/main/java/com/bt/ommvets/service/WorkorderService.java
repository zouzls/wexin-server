package com.bt.ommvets.service;

import com.bt.ommvets.dao.WorkorderDao;
import com.bt.ommvets.dao.WorkorderFlowDao;
import com.bt.ommvets.entity.Workorder;
import com.bt.ommvets.entity.WorkorderAutoRule;
import com.bt.ommvets.entity.WorkorderFlow;
import com.bt.ommvets.util.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author zouzl
 * @create 2017-05-11-14:52
 */
@Service
@Transactional
public class WorkorderService {

    @Autowired
    private WorkorderDao workorderDao;

    @Autowired
    private WorkorderFlowDao workorderFlowDao;

    public void addWorkorderByAutoRule(WorkorderAutoRule rule){
        //添加工单主表
        Workorder workorder=new Workorder();
        workorder.setId(IdGen.uuid());
        workorder.setCreateTime(new Date());
        workorder.setCreateUserId(rule.getCreateUserId());
        workorder.setCurrentFlowId(IdGen.uuid());
        workorder.setDeviceId(rule.getDeviceId());
        workorder.setPriority(rule.getPriority());
        workorder.setStationId(rule.getStationId());
        workorder.setStatus(rule.getWorkorderStatus());
        workorder.setWorkorderRemark(rule.getRemark());
        workorderDao.add(workorder);

        //添加流程
        WorkorderFlow workorderFlow=new WorkorderFlow();
        workorderFlow.setId(IdGen.uuid());
        workorderFlow.setOperateUser(rule.getCreateUserId());
        workorderFlow.setReceiveUserId(rule.getCreateUserId());
        workorderFlow.setOperationMemo(rule.getRemark());
        workorderFlow.setWorkorderId(workorder.getId());
        workorderFlowDao.add(workorderFlow);
    }
}
