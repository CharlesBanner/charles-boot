package com.charles;

import com.charles.facade.ApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: GanZiB
 * Date: 2019-04-04
 * Time: 15:05
 */
@SpringBootTest(classes = FeignDemoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDB {

   @Autowired
   private ApiService apiService;


    @Test
    public void test(){
        try {
            ExecutorService executor = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 10; i++) {
                executor.execute(() -> {
                    while (true){
                        System.out.println(apiService.hello());
                    }
                });
            }
            Thread.sleep(100000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
