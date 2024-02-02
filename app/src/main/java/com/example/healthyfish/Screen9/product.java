package com.example.healthyfish.Screen9;

public class product  {
    private int id;
    private String title;
    private static String shortdesc;
    private static double price;
    private static int image;

    public product(int id,String title,String shortdesc,double price,int image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.price = price;
        this.image = image;
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public static String getShortdesc() {
        return shortdesc;
    }

    public static double getPrice() {
        return price;
    }

    public static int getImage() {
        return image;
    }
}

