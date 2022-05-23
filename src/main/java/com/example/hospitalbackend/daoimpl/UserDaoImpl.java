package com.example.hospitalbackend.daoimpl;


import com.example.hospitalbackend.dao.UserDao;
import com.example.hospitalbackend.entity.Users;
import com.example.hospitalbackend.repository.UserRepository;
import com.example.hospitalbackend.utils.msgutils.Msg;
import com.example.hospitalbackend.utils.msgutils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository userRepository;


    @Override
    public Users checkUser(String account, String password){
        return userRepository.checkUser(account,password);
    }

    @Override
    public Users getById(Integer userId){
        return userRepository.getById(userId);
    }

    /*
     *
     * @Description: 检查用户名是否重复
     * @param username
     * @return com.example.hospitalbackend.utils.msgutils.Msg
     * @author 赵熙
     * @date 2022/5/23 20:22
     */
    @Override
    public Msg checkUserDup(String username) {
        Users check = userRepository.checkUserDup(username);
        if(check!=null)
            return MsgUtil.makeMsg(-1,"用户名重复");
        else return MsgUtil.makeMsg(1,"用户名不重复");
    }

    @Override
    public Msg register(String username, String password, String tel, String email, Integer gender) {
        Users Users=new Users();
        Users.setUsername(username);
        Users.setPassword(password);
        Users.setGender(gender);
        Users.setTel(tel);
        Users.setMail(email);
        Users.setIdentity(1);
        Users.setWeiyue(0);
        userRepository.saveAndFlush(Users);
//
        Integer userId=Users.getId();

        return MsgUtil.makeMsg(1,"注册成功,ID为"+userId.toString());

    }


}
