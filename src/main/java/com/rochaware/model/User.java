package com.rochaware.model;

/**
 * Created by hdlopesrocha on 8/31/16.
 */
public class User {

    private String email;
    private String name;
    private String photo;

    public User(String email, String name, String photo) {
        this.email = email;
        this.name = name;
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }


    public String getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
