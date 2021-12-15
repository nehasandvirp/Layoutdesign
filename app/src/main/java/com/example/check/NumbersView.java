package com.example.check;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NumbersView {


    // the resource ID for the imageView
//    private Integer ivNumbersImageId;

    // TextView 1
    @SerializedName("id")
    @Expose
    private int mNumberInDigit;

    // TextView 1
    @SerializedName("name")
    @Expose
    private String mNumbersInText;
    @SerializedName("username")
    @Expose
    private String Username;
    @SerializedName("email")
    @Expose
    private String Email;

    // create constructor to set the values for all the parameters of the each single view
    public NumbersView(int NumbersInDigit, String NumbersInText,String email,String username) {
//        ivNumbersImageId = NumbersImageId;
        mNumberInDigit = NumbersInDigit;
        mNumbersInText = NumbersInText;
        Username= username;
        Email=email;

    }

    // getter method for returning the ID of the imageview
//    public Integer getNumbersImageId() {
//        return ivNumbersImageId;
//    }

    // getter method for returning the ID of the TextView 1
    public int getNumberInDigit() {
        return mNumberInDigit;
    }

    // getter method for returning the ID of the TextView 2
    public String getNumbersInText() {
        return mNumbersInText;
    }

    public String getUsername() { return Username; }

    public String getEmail() { return Email; }
}



