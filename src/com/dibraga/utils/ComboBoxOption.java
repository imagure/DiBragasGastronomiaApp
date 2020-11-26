package com.dibraga.utils;

import java.util.List;

public class ComboBoxOption {

    private String key;
    private String value;
    private Float price;
    private List<ComboBoxOption> sideDishes;

    public ComboBoxOption(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    public ComboBoxOption(String key, String value, Float price)
    {
        this.key = key;
        this.value = value;
        this.price = price;
    }

    public ComboBoxOption(String key, String value, Float price, List<ComboBoxOption> sideDishes)
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

    public List<ComboBoxOption> getSideDishes()
    {
        return sideDishes;
    }
}
