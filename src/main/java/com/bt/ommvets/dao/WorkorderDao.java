package com.bt.ommvets.dao;

import com.bt.ommvets.entity.Workorder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zouzl on 2017/5/10.
 */
@Mapper
@Repository
public interface WorkorderDao {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "workorderType", column = "workorder_type"),
            @Result(property = "status", column = "status"),
            @Result(property = "priority", column = "priority"),
            @Result(property = "createUserId", column = "create_user_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "workorderRemark", column = "workorder_remark"),
            @Result(property = "workorderStatus", column = "workorder_status"),
            @Result(property = "stationId", column = "station_id"),
            @Result(property = "deviceId", column = "device_id"),
            @Result(property = "delFlag", column = "del_flag")
    })
    @Select("SELECT * FROM WORKORDER WHERE del_flag = '0' ")
    List<Workorder> findAll();


    @Insert("INSERT INTO WORKORDER" +
            "(id,workorder_type,status,priority,create_user_id,create_time,workorder_remark, workorder_status,station_id,device_id,del_flag) " +
            "VALUES" +
            "(#{id}, #{workorderType},#{status},#{priority},#{createUserId},#{createTime},#{workorderRemark},,#{workorderStatus},#{stationId},#{deviceId},#{delFlag})")
    int add(Workorder workorder);
}
