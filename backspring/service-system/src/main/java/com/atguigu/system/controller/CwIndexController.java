package com.atguigu.system.controller;

import com.atguigu.common.result.Result;
import com.atguigu.common.utils.JwtHelper;
import com.atguigu.common.utils.MD5;
import com.atguigu.model.system.SysUser;
import com.atguigu.model.vo.LoginVo;
import com.atguigu.system.exception.GuiguException;
import com.atguigu.system.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
@Api(tags = "client login")
@RestController
@RequestMapping("/admin/system/cwindex")
public class CwIndexController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("login")
    public Result login(@RequestBody LoginVo loginVo) {
        // search data by username
        SysUser sysUser = sysUserService.getUserInfoByUserName(loginVo.getUsername());

        // if not found
        if(sysUser == null){
            throw new GuiguException(20001, "user not existed");
        }

        // check password
        String password = loginVo.getPassword();
        return Result.ok();
    }

}
