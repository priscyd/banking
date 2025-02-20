package com.finance.bank.repository

import com.finance.bank.repository.models.TransactionDBModel
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TransferRepository: CrudRepository<TransactionDBModel, UUID>