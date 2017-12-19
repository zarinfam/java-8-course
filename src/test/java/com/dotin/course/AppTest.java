package com.dotin.course;

import com.dotin.course.model.Apple;
import com.dotin.course.services.ApplePredicate;
import com.dotin.course.services.AppleService;
import com.dotin.course.services.ServiceFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.dotin.course.services.AppleService.APPLE_COLOR_GREEN;
import static org.hamcrest.collection.IsCollectionWithSize.*;
import static org.junit.Assert.assertThat;

public class AppTest {

    private List<Apple> appleList;
    private AppleService appleService = ServiceFactory.getAppleService();

    @Before
    public void init() {
        appleList = TestDataUtil.createSampleApple();
    }

    @Test
    public void success_filter_green_apple() {
        assertThat(appleService.filterApples(appleList,
                apple -> (APPLE_COLOR_GREEN.equals(apple.getColor()))
                )
                , hasSize(3));

        assertThat(appleService.filterApples(appleList, (Apple apple) -> (APPLE_COLOR_GREEN.equals(apple.getColor())))
                , hasSize(3));


    }

    @Test
    public void success_filter_green_apple_and_weight_greater_10() {

        Function<Apple, Boolean> f = (Apple apple) -> (APPLE_COLOR_GREEN.equals(apple.getColor()) && 10 > apple.getWeight());
        Predicate<Apple> a1 = (Apple apple) -> (APPLE_COLOR_GREEN.equals(apple.getColor()));
        Predicate<Apple> a2 = (Apple apple) -> (10 > apple.getWeight());
        Predicate<Apple> f1 = a1.and(a2);
        ApplePredicate f2 = (Apple apple) -> (APPLE_COLOR_GREEN.equals(apple.getColor()) && 10 > apple.getWeight());

        assertThat(appleService.filterApples(appleList
                , f2)
                , hasSize(1));

        assertThat(appleService.filterApples1(appleList
                , f1)
                , hasSize(1));

    }

}
