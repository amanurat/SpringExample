package com.training.spring;

import org.springframework.stereotype.Component;

/**
 * User: assanai.manurat
 * Date: 4/24/2014
 * Time: 10:33 PM
 */
@Component
public class ExampleComponent {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
