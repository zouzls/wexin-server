package com.bt.ommvets.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zouzl
 * @create 2017-05-11-16:52
 */
@RestController
public class ScheduleTaskController {

    @RequestMapping("/createScheduleTask")
    @ResponseBody
    public String createScheduleTask(RequestBody body){

        return "";
    }
}
