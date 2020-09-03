package com.appnet.android.football.fbvn.data;

public class User {
    private int id;
    private String first_name;
    private String last_name;
    private String fullname;
    private String email;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getFullName() {
        if(fullname == null || fullname.isEmpty()) {
            return first_name + " " + last_name;
        }
        return fullname;
    }

    public String getEmail() {
        return email;
    }

}
