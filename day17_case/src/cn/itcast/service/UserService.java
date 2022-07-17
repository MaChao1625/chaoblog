package cn.itcast.service;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/*
* 用户管理的业务接口*/
public interface UserService {
    /*查询所有的用户信息
    * */
    public List<User> findAll();
    /*用户登录*/
    public User login(User user);

    /*添加用户*/
    public void addUser(User user);
    /*根据id删除用户*/
    public void deleteUser(String id);

    /*根据id查询用户*/
    User findUserById(String id);
    /*修改用户信息*/
    void updateUser(User user);
    /*删除选中用户*/
    void delSelectedUser(String[] ids);
    /*分页查询,分页条件查询*/
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
