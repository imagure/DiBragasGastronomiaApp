package com.dibraga.sheets;

import java.util.List;

public class Dish {

    private String key;
    private String value;
    private List<Dish> sideDishes;

    public Dish(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    public Dish(String key, String value, List<Dish> sideDishes)
    {
        this.key = key;
        this.value = value;
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

    public List<Dish> getSideDishes()
    {
        return sideDishes;
    }
}
