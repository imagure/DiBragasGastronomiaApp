package com.dibraga.sheets;

import java.util.List;

public class Dish {

    private String key;
    private String value;
    private Float price;
    private List<Dish> sideDishes;

    public Dish(String key, String value, Float price)
    {
        this.key = key;
        this.value = value;
        this.price = price;
    }

    public Dish(String key, String value, Float price, List<Dish> sideDishes)
    {
        this.key = key;
        this.value = value;
        this.price = price;
        this.sideDishes = sideDishes;
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }

    public Float getPrice()
    {
        return price;
    }

    public List<Dish> getSideDishes()
    {
        return sideDishes;
    }
}
