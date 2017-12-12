package com.dotin.course.services;

import com.dotin.course.model.Apple;

import java.util.List;

public interface AppleService {

    String APPLE_COLOR_GREEN = "GREEN";

    List<Apple> filterGreenApples(List<Apple> appleList);
    List<Apple> filterApples(List<Apple> appleList, ApplePredicate predicate);
}
