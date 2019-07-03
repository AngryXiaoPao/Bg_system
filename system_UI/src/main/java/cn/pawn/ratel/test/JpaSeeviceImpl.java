package cn.pawn.ratel.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName JpaSeeviceImpl
 * @Description JpaService
 * @Author zengyejun
 * @Date 2019-07-01 16:26:46
 **/
@Service
public class JpaSeeviceImpl implements JpaService {

    @Autowired
    private JpaEntityRepository jpaEntityRepository;

    @Override
    public List<JpaEntity> getList() {
        return (List<JpaEntity>) jpaEntityRepository.findAll();
    }

    @Override
    public JpaEntity queryById(Long id) {
        return jpaEntityRepository.queryById(id);
    }


}
