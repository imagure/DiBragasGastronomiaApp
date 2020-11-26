package com.dibraga.utils;

import java.util.List;

public class ComboBoxOption {

    private String key;
    private String value;
    private Float price;
    private List<ComboBoxOption> sideDishes;
    private String clientData;

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

    public ComboBoxOption(String key, String value, String clientData)
    {
        this.key = key;
        this.value = value;
        this.clientData = clientData;
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

    public String getClientData()
    {
        return key + ", " + clientData;
    }
}
