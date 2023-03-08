package com.imedia24.interviewapp.util

import java.util.Currency

class CurrencyChecker {
    companion object {
        fun isValidCurrencyCode(currencyCode: String): Boolean {
            return try {
                Currency.getInstance(currencyCode)
                true
            } catch (e: IllegalArgumentException) {
                false
            }

        }
    }
}