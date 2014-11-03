package com.training.spring.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: assanai.manurat
 * Date: 4/20/2014
 * Time: 4:09 PM
 */
public class Hello {


    Humen humen;

    String message = "";

    int age = 0;
    public Hello() {

    }

    public Hello(String message, int age) {
        this.message = message;
        this.age = age;
    }

    public Hello(String message) {
        this.message = message;
    }

    public Hello(int age) {
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("message", message)
                .append("age", age)
                .toString();
    }
}
