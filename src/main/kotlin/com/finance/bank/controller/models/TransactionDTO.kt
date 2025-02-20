package com.finance.bank.controller.models

import com.finance.bank.repository.models.TransactionDBModel

class TransactionDTO(
    val id: Long? = -1,
    val targetAccount: String,
    val amount: Double,
    val description: String = "",
)

fun TransactionDTO.toEntity(): TransactionDBModel {
    val model =  TransactionDBModel()
    model.accountIdentifier = targetAccount
    model.amount = amount
    model.description = description
    return model
}