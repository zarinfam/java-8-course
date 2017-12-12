package com.dotin.course.services;

import com.dotin.course.model.Apple;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class AppleServiceImperative implements AppleService {

    public List<Apple> filterGreenApples(List<Apple> appleList) {
        List<Apple> greenApple = new ArrayList<Apple>();

        for (Apple apple : appleList) {
            if (APPLE_COLOR_GREEN.equals(apple.getColor())){
                greenApple.add(apple);
            }
        }

        return greenApple;
    }

    public List<Apple> filterApples(List<Apple> appleList, ApplePredicate predicate) {
        throw new RuntimeException("not yet implemented");
    }
}
