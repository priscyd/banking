package com.finance.bank.controller.dto

class TransactionDTO(
    val targetAccount: String,
    val amount: Double,
    val description: String = "",
)

