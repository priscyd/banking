package com.finance.bank.services

import com.finance.bank.controller.models.TransactionDTO

interface ITransactionService {
    fun addBank(dto: TransactionDTO): TransactionDTO?
    fun getBankById(id: Long): TransactionDTO?
}