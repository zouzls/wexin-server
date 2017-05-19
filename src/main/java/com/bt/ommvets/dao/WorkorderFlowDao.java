package com.bt.ommvets.dao;

import com.bt.ommvets.entity.WorkorderFlow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zouzl
 * @create 2017-05-11-10:26
 */
@Mapper
@Repository
public interface WorkorderFlowDao {


    @Insert("INSERT INTO WORKORDER_FLOW(id,create_date,operation_memo,operation_type,"
            +"workorder_id, operate_user_id,receive_user_id,del_flag)"
            +"VALUES ("
            +"#{id},"
            +"#{createDate},"
            +"#{operationMemo},"
            +"#{operationType},"
            +"#{workorderId},"
            +"#{operateUserId},"
            +"#{receiveUserId},"
            +"#{delFlag})")
    int add(WorkorderFlow workorderFlow);
}
