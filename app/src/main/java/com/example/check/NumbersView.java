package com.example.check;

public class NumbersView {


    // the resource ID for the imageView
//    private Integer ivNumbersImageId;

    // TextView 1
    private String mNumberInDigit;

    // TextView 1
    private String mNumbersInText;


    // create constructor to set the values for all the parameters of the each single view
    public NumbersView(String NumbersInDigit, String NumbersInText) {
//        ivNumbersImageId = NumbersImageId;
        mNumberInDigit = NumbersInDigit;
        mNumbersInText = NumbersInText;

    }

    // getter method for returning the ID of the imageview
//    public Integer getNumbersImageId() {
//        return ivNumbersImageId;
//    }

    // getter method for returning the ID of the TextView 1
    public String getNumberInDigit() {
        return mNumberInDigit;
    }

    // getter method for returning the ID of the TextView 2
    public String getNumbersInText() {
        return mNumbersInText;
    }
}
