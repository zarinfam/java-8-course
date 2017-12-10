package com.dotin.course;

import com.dotin.course.model.Apple;

import java.util.List;

public class App {

    private static List<Apple> appleList ;

    static {
        appleList = DataUtil.createSampleApple();
    }

    public static void main(String[] args) {

    }
}
