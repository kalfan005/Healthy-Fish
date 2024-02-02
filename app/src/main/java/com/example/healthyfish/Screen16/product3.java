package com.example.healthyfish.Screen16;

public class product3 {
    private int id;
    private static String title2;
    private static String shortdesc2;
    private static String detail;
    private  static String orderid;
    private static long ordernumber;
    private static int image2;

    public product3(int id,String title2,String shortdesc2,String detail,String orderid,long ordernumber,int image2) {
        this.id = id;
        this.title2 = title2;
        this.shortdesc2 = shortdesc2;
        this.detail = detail;
        this.orderid = orderid;
        this.ordernumber = ordernumber;
        this.image2 = image2;
    }
    public int getId() {
        return id;
    }

    public static String getTitle2() {
        return title2;
    }


    public static String getShortdesc2() {
        return shortdesc2;
    }

    public static String getDetail() {
        return detail;
    }

    public static String getOrderid() {
        return orderid;
    }

    public static long getOrdernumber() {return ordernumber;}

    public static int getImage2() {
        return image2;
    }
}
