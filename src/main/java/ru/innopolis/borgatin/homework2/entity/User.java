package ru.innopolis.borgatin.homework2.entity;

import java.util.Date;

/**
 * Класс описывает сущность Пользователь
 */
public class User {

    private long id;

    private String login;

    private String password;

    private String email;

    private Date registrationDay;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getRegistrationDay() {
        return registrationDay;
    }

    public void setRegistrationDay(Date registrationDay) {
        this.registrationDay = registrationDay;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
