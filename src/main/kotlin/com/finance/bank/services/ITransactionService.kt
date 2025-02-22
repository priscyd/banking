package com.finance.bank.services

import com.finance.bank.controller.dto.OverviewTransactionDTO
import com.finance.bank.controller.dto.TransactionDTO

interface ITransactionService {

    fun addBank(dto: TransactionDTO): TransactionDTO?
    fun getBankById(id: Long): OverviewTransactionDTO?
    fun getAllTransactions(): List<OverviewTransactionDTO>
}