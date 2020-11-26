package com.dibraga.payment;

import com.dibraga.utils.ComboBoxOption;

import java.util.ArrayList;
import java.util.List;

public class Payments {

    private List<ComboBoxOption> paymentMethods = new ArrayList<>();

    public Payments() {
        ComboBoxOption money = new ComboBoxOption("Dinheiro", "money");
        ComboBoxOption credit_card = new ComboBoxOption("Cartão de Crédito", "credit_card");
        ComboBoxOption debit_card = new ComboBoxOption("Cartão de Débito", "debit_card");
        ComboBoxOption app = new ComboBoxOption("Aplicativo", "app");

        paymentMethods.add(money);
        paymentMethods.add(credit_card);
        paymentMethods.add(debit_card);
        paymentMethods.add(app);
    }

    public List<ComboBoxOption> getPaymentMethods() {
        return this.paymentMethods;
    }
}
