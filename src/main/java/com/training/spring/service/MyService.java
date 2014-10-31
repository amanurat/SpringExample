package com.training.spring.service;

/**
 * User: assanai.manurat
 * Date: 4/24/2014
 * Time: 10:45 PM
 */
public class MyService {


    private String message;


    private String firstname;
    private String lastname;


    public void message(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MyService{");
        sb.append("message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
