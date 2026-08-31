package com.br.SAarcodicionados.util;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtil {

    public static String formatCurrency(double amount) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return currencyFormatter.format(amount);
    }

    public static double parseCurrency(String amount) throws Exception {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return currencyFormatter.parse(amount).doubleValue();
    }
}