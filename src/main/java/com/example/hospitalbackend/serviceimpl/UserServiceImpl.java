package com.example.hospitalbackend.serviceimpl;


import com.example.hospitalbackend.dao.UserDao;
import com.example.hospitalbackend.entity.OrderTable;
import com.example.hospitalbackend.entity.Users;
import com.example.hospitalbackend.service.OrderTableService;
import com.example.hospitalbackend.service.UserService;
import com.example.hospitalbackend.utils.msgutils.Msg;
import com.example.hospitalbackend.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private OrderTableService orderTableService;

    @Override
    public Users checkUser(String account, String passwoed) {
        return userDao.checkUser(account, passwoed);
    }

    @Override
    public Users getById(Integer userId) {
        return userDao.getById(userId);
    }

    @Override
    public String getNameById(Integer userId){
        Users tmp = userDao.getById(userId);
        return tmp.getUsername();
    }


    @Override
    public Msg register(String username, String password, String tel, String email, Integer gender) {
        Msg msg = userDao.checkUserDup(username);
        if (msg.getStatus() < 0)
            return msg;
        System.out.println(email);
        return userDao.register(username, password, tel, email, gender);
    }

    /*{
“name”:”患者姓名” ，
“date”:”日期” ,
“time” : “挂号具体时间段” ，
“deptName” : “科室名称” ,
“doctorName” :医生姓名 ，
 “info”: “病情描述” ，
”process” : “流程”
}
*/
    @Override
    public List<JSONObject> getAllOrders() {
        Integer userId = SessionUtil.getUserId();
        Users user = userDao.getById(userId);
        List<OrderTable> orderTable = orderTableService.getOrderByUser(userId);
        List<JSONObject> orders;
        if (userId == null) return null;
        for (int i = 0; i < orderTable.size(); ++i) {
            JSONObject order = new JSONObject();
            order.put("name", user.getUsername());
            order.put("date", "");
            order.put("department", "");
        }


        return null;
    }

}
