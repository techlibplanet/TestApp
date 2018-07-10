package com.example.mayank.testapp

import java.util.*


object Utils {
    var currencyLocaleMap: SortedMap<Currency, Locale>

    init {
        currencyLocaleMap = TreeMap<Currency, Locale>(Comparator<Currency> { c1, c2 -> c1.currencyCode.compareTo(c2.currencyCode) })
        for (locale in Locale.getAvailableLocales()) {
            try {
                val currency = Currency.getInstance(locale)
                currencyLocaleMap.put(currency, locale)
            } catch (e: Exception) {
            }

        }
    }


    fun getCurrencySymbol(currencyCode: String): String {
        val currency = Currency.getInstance(currencyCode)
        println(currencyCode + ":-" + currency.getSymbol(currencyLocaleMap.get(currency)))
        return currency.getSymbol(currencyLocaleMap.get(currency))
    }

}