package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

/*
* 用户操作的DAO*/
public interface UserDao {
    public List<User> findAll();
    /*用户登录*/
    public User findUserByUsernameAndPassword(String username, String password);

    public void add(User user);
    /*通过id删除用户*/
    public void deleteById(int id);

    User finById(int parseInt);

    void update(User user);
    /*查询总记录数*/
    int findTotalCount(Map<String, String[]> condition);
    /*分页查询每页记录*/
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
