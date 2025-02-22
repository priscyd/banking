package com.finance.bank.controller.dto

import java.time.LocalDateTime

class OverviewTransactionDTO (
    val targetAccount: String,
    val amount: Double,
    val description: String ,
    val createdDate: LocalDateTime,
    val id: Long
)

