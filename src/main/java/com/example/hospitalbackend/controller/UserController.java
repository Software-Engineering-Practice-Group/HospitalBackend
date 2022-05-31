package com.example.hospitalbackend.controller;

import com.example.hospitalbackend.constant.Constant;
import com.example.hospitalbackend.entity.Users;
import com.example.hospitalbackend.service.UserService;
import com.example.hospitalbackend.utils.msgutils.Msg;
import com.example.hospitalbackend.utils.msgutils.MsgCode;
import com.example.hospitalbackend.utils.msgutils.MsgUtil;
import com.example.hospitalbackend.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /*
     *
     * @Description: 患者注册，传入内容 username password  tel  mail gender
     * @param params
     * @return com.example.hospitalbackend.utils.msgutils.Msg
     * @author 赵熙
     * @date 2022/5/23 20:28
     */
    @RequestMapping("/register")
    public Msg register(@RequestBody Map<String,String> params){
        String username = params.get("username");
        String password =params.get("password");
        String tel=params.get("tel");
        String email =params.get("mail");
        Integer gender = Integer.valueOf(params.get("gender"));
        return userService.register(username,password,tel,email,gender);

    }

    /*
     *
     * @Description: 电话作为账号，配合密码进行登录验证
     * @param params
     * @return com.example.hospitalbackend.utils.msgutils.Msg
     * @author 赵熙
     * @date 2022/5/23 20:59
     */
    /*{
    "tel": "13365487596",
    "password": "123456",
    "remember": true
    }*/
    @RequestMapping("/login")
    public Msg login(@RequestBody Map<String,String> params){
        String account=params.get(Constant.ACCOUNT);
        String password=params.get(Constant.PASSWORD);

        Users auth=userService.checkUser(account,password);
        if(auth !=null){
            JSONObject obj=new JSONObject();
            obj.put(Constant.USER_ID,auth.getId());
            obj.put(Constant.USERNAME,auth.getUsername());
            obj.put(Constant.USER_TYPE,auth.getIdentity());
            SessionUtil.setSession(obj);

            JSONObject data = JSONObject.fromObject(auth);
            data.remove(Constant.PASSWORD);                                  //不返回用户密码信息
            return MsgUtil.makeMsg(MsgCode.SUCCESS,MsgUtil.LOGIN_SUCCESS_MSG,data);

        }
        else{
            return MsgUtil.makeMsg(MsgCode.LOGIN_USER_ERROR);
        }

    }

    /**
     * @Description:退出登录 logout
     * @Param: null
     * @return: Msg
     * @Author: Kiddo
     */
    @RequestMapping("/logout")
    public Msg logout() {
        Boolean status = SessionUtil.removeSession();

        if (status) {
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGOUT_SUCCESS_MSG);
        }
        return MsgUtil.makeMsg(MsgCode.ERROR, MsgUtil.LOGOUT_ERR_MSG);
    }

    /*
     *
     * @Description: 验证登录情况
     
     * @return com.example.hospitalbackend.utils.msgutils.Msg 
     * @author 赵熙
     * @date 2022/5/23 20:07 
     */
    @RequestMapping("/checkSession")
    public Msg checkSession(){
        JSONObject auth = SessionUtil.getAuth();

        if(auth == null){
            return MsgUtil.makeMsg(MsgCode.NOT_LOGGED_IN_ERROR);
        }
        else{
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, auth);
        }
    }
}
