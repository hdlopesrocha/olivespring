package com.rochaware.model;


import com.rochaware.Tools;
import org.bson.Document;

/**
 * Created by hdlopesrocha on 8/31/16.
 */
public class User extends  DatabaseObject{

    private String email;
    private String name;
    private String photo;
    private Document password;

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.photo = null;
        setPassword(password);
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

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = Tools.generateSaltHash(password);
    }
    @Override
    public String toString() {
        return "User{" +
                "email=" + email +
                ", name=" + name +
                ", photo=" + photo +
                '}';
    }

    @Override
    protected Document toDocument() {
        Document doc = new Document();
        doc.put("email",email);
        doc.put("name",name);
        doc.put("photo",photo);
        doc.put("password",password);
        return doc;
    }
}
