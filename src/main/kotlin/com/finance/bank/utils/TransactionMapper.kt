package com.finance.bank.utils

import com.finance.bank.controller.dto.OverviewTransactionDTO
import com.finance.bank.controller.dto.TransactionDTO
import com.finance.bank.repository.models.TransactionDBModel

object TransactionMapper {

    fun toDto(model: TransactionDBModel): TransactionDTO{
        val transactionDTO = TransactionDTO(
            targetAccount = model.accountIdentifier!!,
            amount = model.amount!!,
            description = model.description
        )

        return transactionDTO
    }

    fun toEntity(dto: TransactionDTO): TransactionDBModel{
        val model =  TransactionDBModel()
        model.accountIdentifier = dto.targetAccount
        model.amount = dto.amount
        model.description = dto.description
        return model
    }

    fun toTransactionEntity(model: TransactionDBModel):OverviewTransactionDTO{
        val overviewTransactionDTO = OverviewTransactionDTO(
            targetAccount = model.accountIdentifier!!,
            createdDate = model.createdAt!!,
            description = model.description,
            id = model.id!!,
            amount = model.amount!!
        )
        return  overviewTransactionDTO
    }

}