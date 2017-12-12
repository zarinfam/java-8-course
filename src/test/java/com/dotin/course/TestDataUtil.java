package com.dotin.course;

import com.dotin.course.model.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDataUtil {

    public static List<Apple> createSampleApple() {
        return new ArrayList(Arrays.asList(
                new Apple("GREEN", 12)
                , new Apple("GREEN", 10)
                , new Apple("RED", 5)
                , new Apple("YELLOW", 6)
                , new Apple("GREEN", 1)
                , new Apple("RED", 10)
                , new Apple("YELLOW", 13)
                , new Apple("YELLOW", 16)
        ));
    }

}
