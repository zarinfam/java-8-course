package com.dotin.course.services;

import com.dotin.course.model.Apple;

import java.util.ArrayList;
import java.util.List;

public class AppleServiceFunctional implements AppleService {

    public List<Apple> filterGreenApples(List<Apple> appleList) {
        return null;
    }

    public List<Apple> filterApples(List<Apple> appleList, ApplePredicate predicate) {
        List<Apple> greenApple = new ArrayList<Apple>();

        for (Apple apple : appleList) {
            if (predicate.test(apple)) {
                greenApple.add(apple);
            }
        }

        return greenApple;

    }
}
