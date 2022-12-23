package me.longDay.controller;

import me.longDay.db.domain.IdiomTable;
import me.longDay.db.service.IdiomTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 君
 * @version 1.0
 * @date 2022/4/4 19:57
 */
@RestController
public class HelloWorld {

    @Autowired
    private IdiomTableService idiomTableService;

    @GetMapping("/hello")
    public IdiomTable hello(){
        System.out.println("he");
        return idiomTableService.getById(1);
    }
}
