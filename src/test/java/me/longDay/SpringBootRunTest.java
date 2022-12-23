package me.longDay;


import me.longDay.db.domain.IdiomTable;
import me.longDay.db.service.IdiomTableService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @author 君
 * @version 1.0
 * @desc TODO
 * @since 2022-11-14
 */

@SpringBootTest
public class SpringBootRunTest {
    @Autowired
    IdiomTableService idiomTableService;

    @Test
    public void common(){
        char[][] table = new char[10][8];
//        IdiomTable id = idiomTableService.getById(1);
//        System.out.println(id);
//        char[] idiom = new Utils().getIdiom(4, "南");
        List<IdiomTable> s = idiomTableService.getOneIdiom(4,"南");
        s.forEach(System.out::println);

    }
}

@Component
class Utils{

    @Autowired
    private IdiomTableService idiomTableService;
    /**
     * 获取一个成语
     * @param lengthOfIdiom 成语的长度
     * @param keyWord [可选项] 约束: 获取的成语中包含此关键字
     * @return 返回一个指定位数的成语
     */
    public char[] getIdiom(int lengthOfIdiom,String keyWord){
        List<IdiomTable> s = idiomTableService.getOneIdiom(lengthOfIdiom,keyWord);
        System.out.println("res: "+s);
        return null;
    }
}