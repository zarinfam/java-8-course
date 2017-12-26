package com.dotin.course.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by saeed on 2/27/16.
 */
public class MapStream {

    public static void main(String[] args) {

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<Integer[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new Integer[]{i, j})
                )
                .collect(toList());

        pairs.forEach(( a )-> Arrays.asList(a).forEach(System.out::println));

//        List<String> words = Arrays.asList("Hello", "World");
//
//        List<String> w = words.stream()
//                .map(word -> word.split(""))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .collect(toList());

    }
}
