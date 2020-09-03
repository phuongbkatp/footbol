package com.appnet.android.football.sofa.data;

import android.text.TextUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Round {
    @SerializedName("round")
    @Expose
    private int round;
    @SerializedName("name")
    @Expose
    private String name;

    public int getRound() {
        return round;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Round)) {
            return false;
        }
        Round roundInfo = (Round) obj;
        if(roundInfo.round != round) {
            return false;
        }
        if(TextUtils.isEmpty(name) && TextUtils.isEmpty(roundInfo.getName()) && roundInfo.round == round) {
            return true;
        }
        if(!TextUtils.isEmpty(name) && name.equals(roundInfo.getName()) && roundInfo.round == round) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + round;
        if(!TextUtils.isEmpty(name)) {
            result = 31 * result + name.hashCode();
        }
        return result;
    }
}
