package com.dotin.course.services;

import com.dotin.course.model.Apple;

import java.util.List;
import java.util.function.Predicate;

public interface AppleService {

    String APPLE_COLOR_GREEN = "GREEN";

    List<Apple> filterGreenApples(List<Apple> appleList);
    List<Apple> filterApples(List<Apple> appleList, ApplePredicate predicate);
    List<Apple> filterApples1(List<Apple> appleList, Predicate<Apple> predicate);
}
