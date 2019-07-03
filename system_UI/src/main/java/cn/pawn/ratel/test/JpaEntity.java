package cn.pawn.ratel.test;

import javax.persistence.*;

/**
 * @ClassName JpaEntity
 * @Description test for jpa
 * @Author zengyejun
 * @Date 2019-07-01 15:58:44
 **/
@Entity
@Table(name = "test_entity")
public class JpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JpaEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
