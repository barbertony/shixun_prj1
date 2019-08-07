package com.neuedu.service.impl;

import com.neuedu.dao.UserInfoMapper;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo login(UserInfo userInfo) throws MyException {

        //step1:参数的非空校验
        if(userInfo==null){
            throw  new MyException("参数不能为空");
        }
        if(userInfo.getUsername()==null||userInfo.getUsername().equals("")){
            throw new MyException("用户名不能为空");
        }
        if(userInfo.getPassword()==null||userInfo.getPassword().equals("")){
            throw new MyException("密码不能为空");
        }
        //step2：判断用户名是否存在

        int username_result= userInfoMapper.exsitsUsername(userInfo.getUsername());
        if(username_result==0){//用户名不存在
            throw new MyException("用户名不能为空");
        }

        //step3：根据用户名和密码登录
        UserInfo userinfo_result=userInfoMapper.findByUsernameAndPassword(userInfo);
        if(userinfo_result==null){
            throw new MyException("密码错误");
        }
        //step4：判断权限
        if(userinfo_result.getRole()!=0){
            throw new MyException("没有权限访问");
        }

        return userinfo_result;
    }
    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserInfo record) {
        if(record.getUsername()==null||record.getUsername().equals("") ){//用户名为空

            throw  new MyException("用户名不能为空");

        }
        if(record.getPassword()==null||record.getPassword().equals("") ){//密码为空

            throw  new MyException("密码不能为空");

        }
        if (record.getEmail()==null||record.getEmail().equals(""))
        {
            throw new MyException("邮箱不能为空");
        }
        if (record.getAnswer()==null||record.getAnswer().equals(""))
        {
            throw new MyException("密保答案不能为空");
        }
        if (record.getQuestion()==null||record.getQuestion().equals(""))
        {
            throw new MyException("密保问腿不能为空");
        }
        if (record.getPhone()==null||record.getPhone().equals(""))
        {
            throw new MyException("电话不能为空");
        }
        if (record.getRole()==null)
        {
            record.setRole(1);
        }
        int result=userInfoMapper.exsitsUsername(record.getUsername());
        if (result>0)
        {
            System.out.println("用户名重复");
            return 0;
        }
        result=userInfoMapper.insert(record);
        return result;
    }
}
