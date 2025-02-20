package com.finance.bank.services.impl

import com.finance.bank.controller.models.TransactionDTO
import com.finance.bank.controller.models.toEntity
import com.finance.bank.repository.TransferRepository
import com.finance.bank.repository.models.TransactionDBModel
import com.finance.bank.repository.models.TransactionDBModel.Companion.toDTO
import com.finance.bank.services.ITransactionService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TransactionServiceImpl(val repository: TransferRepository) : ITransactionService {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun addBank(dto: TransactionDTO): TransactionDTO? {
       logger.info("TransactionServiceImpl :: addBank :: creating a transaction with :: $dto")
        try {
            repository.save(dto.toEntity())
            logger.info("successfully created transaction ")
            return  dto
        }catch (e: Exception){
            logger.error("TransactionServiceImpl :: addBank :: Error occurred whilst creating transaction ", e)
            return  null
        }

    }

    override fun getBankById(id: Long): TransactionDTO? {
        val optionalTransaction = repository.findById(id)
        if (optionalTransaction.isPresent) {
            val entityModel = optionalTransaction.get() as TransactionDBModel
            return entityModel.toDTO()
        }
        return null
    }


}