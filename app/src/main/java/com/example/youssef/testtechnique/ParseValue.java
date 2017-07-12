package com.example.youssef.testtechnique;
import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Vector;

/**
 * Created by youssef on 10/07/2017.
 */

public class ParseValue {
    private String response;

    public String getOnlynames() {
        return onlynames;
    }

    public String onlynames;

    public void setOnlynames(String onlynames) {
        this.onlynames = onlynames;
    }



    public void setResponse(String response){
        this.response = response;
    }

    public boolean fillArray(ResponseValue[] array)
    {
        System.out.println("ici -> 5");
        setOnlynames("");
        for (int i = 0; i < array.length; i++)
        {
            this.setOnlynames(this.getOnlynames().concat("\n"+array[i].getFullname()));
        }
        return false;
    }

    public String parseresponse(){
        Gson gson = new Gson();
        ResponseValue[] responseValues =  gson.fromJson(response,ResponseValue[].class);
        if (responseValues.length > 0)
            fillArray(responseValues);
        System.out.println("only names 25" + getOnlynames());
        return getOnlynames();
    }
}
