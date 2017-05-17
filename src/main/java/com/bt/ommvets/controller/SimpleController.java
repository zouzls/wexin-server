package com.bt.ommvets.controller;


import com.bt.ommvets.entity.WorkorderAutoRule;
import com.bt.ommvets.service.WorkorderAutoRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

    @Autowired
    private WorkorderAutoRuleService autoworkorderRuleService;

    @RequestMapping("/")
    @ResponseBody
    String home(String id ) {
        WorkorderAutoRule rule = autoworkorderRuleService.findById(id);
        return rule.toString();
    }
}

