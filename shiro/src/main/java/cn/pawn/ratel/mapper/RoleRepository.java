package cn.pawn.ratel.mapper;

import cn.pawn.ratel.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @ClassName RoleRepository
 * @Description TODO
 * @Author zengyejun
 * @Date 2019-07-10 13:15:35
 **/
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
