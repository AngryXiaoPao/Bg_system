package cn.pawn.ratel.test;

import java.util.List;

/***
 * @Author zengyejun
 * @Description //TODO
 * @Date 2019-07-03 10:30:23
 * @Param 
 * @return 
 **/
public interface JpaService {
    /***
     * @Author zengyejun
     * @Description 获取全部数据
     * @Date 2019-07-03 10:30:48
     * @Param []
     * @return 返回实体
     **/
    List<JpaEntity> getList();

    /***
     * @Author zengyejun
     * @Description 查询数据
     * @Date 2019-07-03 10:31:06
     * @Param [id]
     * @return 返回实体
     **/
    JpaEntity queryById(Long id);
}
