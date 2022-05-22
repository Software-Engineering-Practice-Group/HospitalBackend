package com.example.hospitalbackend.controller;

import com.example.hospitalbackend.constant.Constant;
import com.example.hospitalbackend.entity.UserAuth;
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


    /**
     * @Description: login
     * @Param: username, password
     * @return: Msg
     * @Author: 赵熙
     */
    @RequestMapping("/login")
    public Msg login(@RequestBody Map<String,String> params){
        String username=params.get(Constant.USERNAME);
        String password=params.get(Constant.PASSWORD);

        UserAuth auth=userService.checkUser(username,password);
        if(auth !=null){
            JSONObject obj=new JSONObject();
            obj.put(Constant.USER_ID,auth.getUserid());
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
     * @Description: logout
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
}
