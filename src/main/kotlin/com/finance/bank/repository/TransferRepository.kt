package com.finance.bank.repository

import com.finance.bank.repository.models.TransactionDBModel
import org.springframework.data.jpa.repository.JpaRepository

interface TransferRepository: JpaRepository<TransactionDBModel, Long>