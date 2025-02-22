package com.finance.bank.controller.dto

class TransactionDTO(
    val id: Long? = -1,
    val targetAccount: String,
    val amount: Double,
    val description: String = "",
)

