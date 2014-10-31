package com.training.spring.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

/**
 * User: assanai.manurat
 * Date: 4/20/2014
 * Time: 4:09 PM
 */
public class Hello {


    Humen humen;

    String message = "";

    public Hello() {

    }

    public Hello(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Humen getHumen() {
        return humen;
    }

    public void setHumen(Humen humen) {
        this.humen = humen;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("message", message)
                .toString();
    }
}
