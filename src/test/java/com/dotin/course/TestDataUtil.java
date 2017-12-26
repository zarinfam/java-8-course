package com.dotin.course;

import com.dotin.course.model.Apple;
import com.dotin.course.streams.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDataUtil {

    public static List<Apple> createSampleApples() {
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

    public static List<Dish> createSampleDishes() {

        return new ArrayList<>(Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)));

    }
}
