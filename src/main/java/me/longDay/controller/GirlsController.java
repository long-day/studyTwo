package me.longDay.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.longDay.db.domain.Girls;
import me.longDay.db.dto.GirlDto;
import me.longDay.db.service.GirlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author 君
 * @version 1.0
 * @desc TODO
 * @since 2022-11-15
 */
@RestController()
@RequestMapping("/girls")
public class GirlsController {

    @Autowired
    private GirlsService girlsService;

    @RequestMapping("/one")
    public Girls getAllGirls(int id){
        System.out.println("==");
         return girlsService.getById(id);
    }

    @RequestMapping("/page")
    @CrossOrigin()
    public Map<String, Object> getPage(GirlDto girlDto){
        HashMap<String, Object> map = new HashMap<>();
        Page<Girls> page = new Page<>(girlDto.getCurrent(), girlDto.getSize());
        LambdaQueryWrapper<Girls> queryWrapper = new LambdaQueryWrapper<>();

        if(girlDto.getFullName() != null && !Objects.equals(girlDto.getFullName(), "")){
            queryWrapper.like(Girls::getFullName, girlDto.getFullName());
        }
        if(girlDto.getAge() != 0){
            queryWrapper.le(Girls::getAge, girlDto.getAge());
        }
        if(girlDto.getGender() != null && !Objects.equals(girlDto.getGender(), "")){
            queryWrapper.eq(Girls::getGender, girlDto.getGender());
        }
        if(girlDto.getMarried() != null && !Objects.equals(girlDto.getMarried(), "")){
            queryWrapper.eq(Girls::getMarried, girlDto.getMarried());
        }

        Page<Girls> girlsPage = girlsService.page(page,queryWrapper);
        map.put("code",200);
        map.put("msg","请求成功");
        map.put("list",girlsPage.getRecords());
        map.put("total",girlsPage.getTotal());
        return map;
    }

}
