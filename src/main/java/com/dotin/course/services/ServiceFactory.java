package com.dotin.course.services;

public class ServiceFactory {

    public static AppleService getAppleService(){
        return new AppleServiceFunctional();
    }
}
