package com.appnet.android.football.sofa.data;

public class Promotion {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(!(obj instanceof Promotion)) {
            return false;
        }
        return id == ((Promotion)obj).id;
    }
}
