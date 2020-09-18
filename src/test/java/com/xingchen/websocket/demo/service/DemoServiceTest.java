package com.xingchen.websocket.demo.service;

import com.xingchen.websocket.demo.WebsocketDemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebsocketDemoApplication.class)
public class DemoServiceTest {
    @Autowired
    private DemoService demoService;

    //测试三位数
    @Test
    public void getWordThree() {
        Integer[] array = new Integer[]{2, 2, 2};
        System.out.println(Arrays.toString(array));
        System.out.println(demoService.getLettersByDigits(array));
    }

    //测试两位数
    @Test
    public void getWordOne() {
        Integer[] array;
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                if (i == 0) {
                    array = new Integer[]{k};
                    System.out.println(Arrays.toString(array));
                    System.out.println(demoService.getLettersByDigits(array));
                } else {
                    array = new Integer[]{i, k};
                    System.out.println(Arrays.toString(array));
                    System.out.println(demoService.getLettersByDigits(array));
                }
            }
        }
    }

    @Test
    public void getWordTwo() {
        Integer[] integers = new Integer[2];
        for (int i = 1; i < 10; i++) {
            integers[0] = i;
            String result = demoService.getLettersByDigits(integers);
            System.out.println(result);
        }
    }
}
