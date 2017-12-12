package com.dotin.course.services;

import com.dotin.course.model.Apple;

import static com.dotin.course.services.AppleService.APPLE_COLOR_GREEN;

public class ApplePredicateGreenApple implements ApplePredicate {
    public boolean test(Apple apple) {
        return (APPLE_COLOR_GREEN.equals(apple.getColor()));
    }
}
