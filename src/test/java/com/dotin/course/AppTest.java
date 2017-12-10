package com.dotin.course;

import com.dotin.course.model.Apple;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AppTest {

    private List<Apple> appleList ;

    @Before
    public void init(){
        appleList = DataUtil.createSampleApple();
    }

    @Test
    public void success_filter_green_apple(){

    }

}
