package com.example.youssef.testtechnique;

/**
 * Created by youssef on 10/07/2017.
 */
import com.google.gson.annotations.SerializedName;

public class ResponseValue {
    public String getFullname() {
        return name;
    }

    @SerializedName("name")
    public String name;
}
