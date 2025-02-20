package com.finance.bank.controller.models

import com.finance.bank.repository.models.TransactionDBModel

class TransactionModel(
    val targetAccount: String,
    val amount: Double,
    val description: String = "",
)

fun TransactionModel.convertToDBModel() = TransactionDBModel(
    accountIdentifier = this.targetAccount,
    amount = this.amount,
    description = this.description
)