package com.finance.bank.repository.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.Date
import java.util.UUID

@Entity
class TransactionDBModel (
    val accountIdentifier: String,
    val amount : Double,
    val description: String=""
){
    @Id
    @GeneratedValue
    var id: UUID? = null
    val date: Date = Date()


}