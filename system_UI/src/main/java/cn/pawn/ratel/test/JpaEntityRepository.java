package cn.pawn.ratel.test;

import org.springframework.data.repository.CrudRepository;

public interface JpaEntityRepository extends CrudRepository<JpaEntity, Long> {
    JpaEntity queryById(Long id);
}
