package cn.pawn.ratel.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName JpaController
 * @Descriptios test controller for jpa
 * @Author zengyejun
 * @Date 2019-07-01 16:11:28
 **/
@Controller
@Slf4j
public class JpaController {
    @Autowired
    private JpaService jpaService;

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "test sucessful!";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<JpaEntity> list(){
        return jpaService.getList();
    }

    @GetMapping("/query")
    @ResponseBody
    public JpaEntity queryById(@RequestParam(name = "id") Long id){
        log.info("parameter:"+id);
        return jpaService.queryById(id);
    }
}
