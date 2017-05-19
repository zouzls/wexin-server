package com.bt.ommvets.dao;


import com.bt.ommvets.entity.WorkorderAutoRule;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface WorkorderAutoRuleDao {


    @Results({
            @Result(property = "id", column = "id"),
            @Result(property ="workorderTopic", column = "workorder_topic"),
            @Result(property = "availFlag", column = "avail_flag"),
            @Result(property ="remark", column = "remark"),
            @Result(property ="priority", column = "priority"),
            @Result(property ="scheduledTime", column = "scheduled_time"),
            @Result(property ="cycleStart", column = "cycle_start"),
            @Result(property ="cycleType", column = "cycle_type"),
            @Result(property ="cycleTime", column = "cycle_time"),
            @Result(property ="autoType", column = "auto_type"),
            @Result(property ="workorderStatus", column = "workorder_status"),
            @Result(property ="stationId", column = "station_id"),
            @Result(property ="deviceId", column = "device_id"),
            @Result(property ="receiveUserId", column = "receive_user_id"),
            @Result(property ="createUserId", column = "create_user_id"),
            @Result(property ="delFlag", column = "del_flag"),
            @Result(property ="hasUsed", column = "has_used")
    })
    @Select("SELECT * FROM WORKORDER_AUTO_RULE WHERE id = #{id} ")
    WorkorderAutoRule findById(@Param("id") String id);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property ="workorderTopic", column = "workorder_topic"),
            @Result(property = "availFlag", column = "avail_flag"),
            @Result(property ="remark", column = "remark"),
            @Result(property ="priority", column = "priority"),
            @Result(property ="scheduledTime", column = "scheduled_time"),
            @Result(property ="cycleStart", column = "cycle_start"),
            @Result(property ="cycleType", column = "cycle_type"),
            @Result(property ="cycleTime", column = "cycle_time"),
            @Result(property ="autoType", column = "auto_type"),
            @Result(property ="workorderStatus", column = "workorder_status"),
            @Result(property ="stationId", column = "station_id"),
            @Result(property ="deviceId", column = "device_id"),
            @Result(property ="receiveUserId", column = "receive_user_id"),
            @Result(property ="createUserId", column = "create_user_id"),
            @Result(property ="delFlag", column = "del_flag"),
            @Result(property ="hasUsed", column = "has_used")
    })
    @Select("SELECT * FROM WORKORDER_AUTO_RULE WHERE del_flag = '0' and avail_flag='1' ")
    List<WorkorderAutoRule> findAll();
}
