package com.dibraga.order;

import java.util.List;

public class Order {

    private List<String> dishes;
    private List<String> drinks;
    private Float total;
    private String payment;
    private String delivery;
    private String observations;

    public Order(List<String> dishes, List<String> drinks, Float total, String payment, String delivery, String observations)
    {
        this.drinks = drinks;
        this.dishes = dishes;
        this.total = total;
        this.payment = payment;
        this.delivery = delivery;
        this.observations = observations;
    }

    @Override
    public String toString()
    {
        return dishes.toString() + ", " + drinks.toString() +  ", " +
                Float.toString(total) + ", " + payment +  ", "  +
                delivery +  ", " + observations;
    }

    public List<String> getDishes()
    {
        return dishes;
    }

    public List<String> getDrinks()
    {
        return drinks;
    }

    public Float getTotal()
    {
        return total;
    }

    public String getPayment()
    {
        return payment;
    }

    public String getDelivery()
    {
        return delivery;
    }

    public String getObservations()
    {
        return observations;
    }
}
