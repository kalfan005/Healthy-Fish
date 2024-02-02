package com.example.healthyfish.Screen10;

public class product2 {
    private int id;
    private static String shortdesc;
    private static double price;
    private static int image;

    public product2(int id,String shortdesc,double price,int image) {
        this.id = id;
        this.shortdesc = shortdesc;
        this.price = price;
        this.image = image;
    }
    public int getId() {
        return id;
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

