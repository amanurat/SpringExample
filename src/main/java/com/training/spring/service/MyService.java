package com.training.spring.service;

/**
 * User: assanai.manurat
 * Date: 4/24/2014
 * Time: 10:45 PM
 */
public class MyService {
    private String message;

    public void message(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MyService{");
        sb.append("message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
