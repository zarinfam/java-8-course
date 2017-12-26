package com.dotin.course.streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

/**
 * Created by saeed on 2/17/16.
 */
public class MainStream {

    public static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));


    public static void main(String[] args) {

        menu.stream().collect(groupingBy(Dish::getType));
//
//        Stream.of(1,2,3,4)
////                .reduce((i1, i2) -> i1 + i2)
//                .mapToInt(Integer::intValue)
//                .sum();
//                .ifPresent(System.out::println);


        Stream.of("Hello", "World")
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList())
        .forEach(System.out::println);
        ;


        //
//        menu.stream()
//                .filter(Dish::isVegetarian)
//                .sorted(comparing(Dish::getCalories))
//                .map(Dish::getName)
//                .collect(joining(","))
//                ;


//        Map<Dish.Type, List<Dish>> dishesByType =
//                menu.stream().collect(groupingBy(Dish::getType));
//
//        dishesByType.forEach((key , value) -> {
//            System.out.println(key);
//            System.out.println("-------");
//            value.forEach(System.out::println);
//        });

//        List<String> lowCaloricDishesName =
//                menu.stream().filter(d -> d.getCalories() < 400)
//                .sorted(comparing(Dish::getCalories))
//                .map(Dish::getName)
//                .forEach(System.out::println);

//        lowCaloricDishesName.;


    }
}
