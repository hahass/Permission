package com.mmall.controller;

import com.mmall.common.JsonData;
import com.mmall.common.SpringExceptionResolver;
import com.mmall.dao.SysAclModuleMapper;
import com.mmall.exception.PermissionException;
import com.mmall.util.ApplicationContextHelper;
import com.mmall.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test/")
@Slf4j
public class TestController {

    @RequestMapping("hello.json")
    @ResponseBody
    public JsonData hello(){
        log.info("hello word");
        int i = 1/0;
        return JsonData.success("sdf");
    }

    @RequestMapping("validate.json")
    @ResponseBody
    public JsonData validate(){
        log.info("hello word");
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        moduleMapper.selectByPrimaryKey(1);
       log.info(JsonUtil.obj2String(moduleMapper));
        return JsonData.success("sdf");
    }



}


