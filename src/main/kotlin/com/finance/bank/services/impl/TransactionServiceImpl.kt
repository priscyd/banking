package com.finance.bank.services.impl

import com.finance.bank.controller.dto.OverviewTransactionDTO
import com.finance.bank.controller.dto.TransactionDTO
import com.finance.bank.repository.TransferRepository
import com.finance.bank.services.ITransactionService
import com.finance.bank.utils.TransactionMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TransactionServiceImpl(val repository: TransferRepository) : ITransactionService {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun addBank(dto: TransactionDTO): TransactionDTO? {
       logger.info("TransactionServiceImpl :: addBank :: creating a transaction with :: $dto")
        try {

            val dataModel = TransactionMapper.toEntity(dto)

            repository.save(dataModel)
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

            val entityModel = optionalTransaction.get()

            logger.info("Successfully retrieved transaction with id {} ", id)

            val dataDto = TransactionMapper.toDto(entityModel)

            logger.info("Successfully converted model to dto {} ", dataDto)

            return dataDto
        }
        return null
    }

    override fun getAllTransactions(): List<OverviewTransactionDTO> {
        val allTransactions = repository.findAll()

        return allTransactions.map { TransactionMapper.toTransactionEntity(it) }
    }


}