package com.dotin.course;

import com.dotin.course.model.Apple;
import com.dotin.course.services.ApplePredicate;
import com.dotin.course.services.AppleService;
import com.dotin.course.services.ServiceFactory;
import com.dotin.course.streams.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.dotin.course.services.AppleService.APPLE_COLOR_GREEN;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.*;
import static org.junit.Assert.assertThat;

public class AppTest {

    private List<Apple> appleList;
    private List<Dish> dishes;
    private AppleService appleService = ServiceFactory.getAppleService();

    @Before
    public void init() {
        appleList = TestDataUtil.createSampleApples();
        dishes = TestDataUtil.createSampleDishes();
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

        Function<Apple, Boolean> p1 = (Apple apple) -> (APPLE_COLOR_GREEN.equals(apple.getColor()));
        Function<Apple, Boolean> p2 = (Apple apple) -> (10 > apple.getWeight());
        Function<Apple, Boolean> f = (apple) -> p1.apply(apple) && p2.apply(apple);

        Predicate<Apple> a1 = (Apple apple) -> (APPLE_COLOR_GREEN.equals(apple.getColor()));

        final int x = 10;
        Predicate<Apple> a2 = (Apple apple) -> (x > apple.getWeight());

        Predicate<Apple> f1 = a1.and(a2);
        ApplePredicate f2 = (Apple apple) -> (APPLE_COLOR_GREEN.equals(apple.getColor()) && 10 > apple.getWeight());

        assertThat(appleService.filterApples(appleList
                , f2)
                , hasSize(1));

        assertThat(appleService.filterApples1(appleList
                , f1)
                , hasSize(1));

        assertThat(appleService.filterApples1(appleList
                , a -> f.apply(a))
                , hasSize(1));


    }

    @Test
    public void success_open_optional() {
        String name1 = "Ali";
        Optional<String> name2 = Optional.of("Asghar");

        String name3 = concatNames(name1, name2);

        assertThat(name3, equalTo("Ali-Asghar"));
    }

    @Test
    public void fail_open_empty_optional() {
        String name1 = "Ali";
        Optional<String> name2 = Optional.ofNullable(null);

        String name3 = concatNames(name1, name2);

        assertThat(name3, equalTo("Ali-"));
    }

    @Test
    public void success_map_optional() {

        Optional<Integer> sum = generateOptionalNumber(1)
                .flatMap(n1 -> generateOptionalNumber(2).map(n2 -> n1 + n2))
                .flatMap(n12 -> generateOptionalNumber(3).map(n3 -> n12 + n3));

        assertThat(sum.orElse(0), equalTo(6));
    }

    @Test
    public void success_filter_green_apple_and_weight_greater_10_using_stream() {
        assertThat(appleList.stream().filter(apple -> (APPLE_COLOR_GREEN.equals(apple.getColor()) && 10 > apple.getWeight()))
                .collect(Collectors.toList()), hasSize(1));
    }

    @Test
    public void success_filter_vegetarians_using_stream() {

        assertThat(dishes.stream().filter(Dish::isVegetarian)
                        .flatMap(dish -> Stream.of(dish.getName().split("")))
                        .collect(Collectors.toList())
                , hasSize(33));
    }

    @Test
    public void success_sum_fish_type_calories_using_stream() {

        assertThat(dishes.stream()
                        .filter(dish -> dish.getType() == Dish.Type.FISH)
                        .map(Dish::getCalories).reduce(Integer::sum)
                , is(750));


    }


    private String concatNames(String name1, Optional<String> name2) {

        return name1 + "-" + name2.orElse("");
    }

    private Optional<Integer> generateOptionalNumber(int i) {
        return Optional.of(i);
    }

}
