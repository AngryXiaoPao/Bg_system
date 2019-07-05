package cn.pawn.ratel.mapper;

import cn.pawn.ratel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}