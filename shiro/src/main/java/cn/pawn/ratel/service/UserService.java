package cn.pawn.ratel.service;

import cn.pawn.ratel.entity.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author zengyejun
 * @Date 2019-07-05 11:50:23
 **/
public interface UserService {

    User findByUsername(String username);
}
