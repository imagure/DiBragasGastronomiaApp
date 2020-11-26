package com.dibraga.payment;

import java.util.ArrayList;
import java.util.List;

public class Payments {

    private List<PaymentMethod> paymentMethods = new ArrayList<>();

    public Payments() {
        PaymentMethod money = new PaymentMethod("Dinheiro", "money");
        PaymentMethod credit_card = new PaymentMethod("Cartão de Crédito", "credit_card");
        PaymentMethod debit_card = new PaymentMethod("Cartão de Débito", "debit_card");
        PaymentMethod app = new PaymentMethod("Aplicativo", "app");

        paymentMethods.add(money);
        paymentMethods.add(credit_card);
        paymentMethods.add(debit_card);
        paymentMethods.add(app);
    }

    public List<PaymentMethod> getPaymentMethods() {
        return this.paymentMethods;
    }
}
