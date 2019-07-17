package cn.pawn.ratel.service.impl;

import cn.pawn.ratel.entity.User;
import cn.pawn.ratel.mapper.UserRepository;
import cn.pawn.ratel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author zengyejun
 * @Date 2019-07-05 11:51:51
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
