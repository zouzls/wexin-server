package com.bt.ommvets.service;


import com.bt.ommvets.dao.WorkorderAutoRuleDao;
import com.bt.ommvets.entity.WorkorderAutoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zouzl on 2017/5/10.
 */
@Service
public class WorkorderAutoRuleService {

    @Autowired
    private WorkorderAutoRuleDao autoworkorderRuleDao;

    public WorkorderAutoRule findById(String id){
        return autoworkorderRuleDao.findById(id);
    }

    public List<WorkorderAutoRule> findAllNoUsedAutoRule(){
        return autoworkorderRuleDao.findAllByNoUsed();
    }
}
