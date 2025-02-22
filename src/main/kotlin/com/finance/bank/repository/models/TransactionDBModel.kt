package com.finance.bank.repository.models

import com.finance.bank.audit.AuditAwareImpl
import jakarta.persistence.*


@Entity
@Table(name = "transactions")
class TransactionDBModel : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "account_identifier", length = 255)
    var accountIdentifier: String? = ""
    var amount: Double? = 0.0
    var description: String = ""
}