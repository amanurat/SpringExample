package com.training.spring.bean;


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
        final StringBuffer sb = new StringBuffer("Hello{");
        sb.append("humen=").append(humen);
        sb.append(", message='").append(message).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
