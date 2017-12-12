package com.dotin.course;

import com.dotin.course.model.Apple;
import com.dotin.course.services.AppleService;
import com.dotin.course.services.ServiceFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
        assertThat(appleService.filterGreenApples(appleList)
                , hasSize(3));
    }

}
