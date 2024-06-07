package com.example.worldcupapp;

public class CountryModelClass {
    private String country_name,win_count;
    private int img_flag;

    public CountryModelClass(String country_name, String win_count, int img_flag) {
        this.country_name = country_name;
        this.win_count = win_count;
        this.img_flag = img_flag;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getWin_count() {
        return win_count;
    }

    public void setWin_count(String win_count) {
        this.win_count = win_count;
    }

    public int getImg_flag() {
        return img_flag;
    }

    public void setImg_flag(int img_flag) {
        this.img_flag = img_flag;
    }
}
