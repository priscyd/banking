package com.finance.bank.repository.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.finance.bank.controller.models.TransactionDTO
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "Transaction")
class TransactionDBModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var date: Date = Date()
    var accountIdentifier: String? = ""
    var amount: Double? = 0.0
    var description: String = ""

    companion object{
        fun TransactionDBModel.toDTO(): TransactionDTO {
            val transactionDTO = TransactionDTO(
                targetAccount = accountIdentifier!!,
                amount = amount!!,
                description = description
            )

            return transactionDTO
        }
    }

}