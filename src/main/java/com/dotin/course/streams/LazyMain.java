package com.dotin.course.streams;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by saeed on 2/27/16.
 */
public class LazyMain {

    public static void main(String[] args) {
        List<String> lowCaloricDishesName =
                MainStream.menu.stream()
                        .filter(d -> {
                            System.out.println("filter " + d.getName());
                            return d.getCalories() > 300;
                        })
                        .map((dish) -> {
                            System.out.println("map "+ dish.getName());
                            return dish.getName();
                        })
                        .limit(3)
                        .collect(Collectors.toList());

        System.out.println(lowCaloricDishesName);

    }
}
