package com.finance.bank.controller

import com.finance.bank.controller.dto.ApiResponseDto
import com.finance.bank.controller.dto.OverviewTransactionDTO
import com.finance.bank.controller.dto.TransactionDTO
import com.finance.bank.services.ITransactionService
import jakarta.persistence.Id
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transfer")
class TransferController(val service: ITransactionService) {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping("/new")
    fun createNewTransfer(@RequestBody transactionDTO: TransactionDTO): ResponseEntity<ApiResponseDto<TransactionDTO>> {

        val transactionPersistResponseData = service.addBank(transactionDTO)
        val code = if (transactionPersistResponseData != null) 201 else 400
        val message = if(transactionPersistResponseData!= null)"transaction created successfully" else "failed to add transaction"

        val apiResponse = ApiResponseDto (
            code = code.toString(),
            message = message,
            data = transactionPersistResponseData
        )

        logger.info("transactionPersistResponseData :: {} ", transactionPersistResponseData)

        // response when adding transaction passed
        return ResponseEntity.status(code).body(apiResponse)

    }

    @GetMapping("/all-transactions")
    fun getAllTransactions(): ResponseEntity<ApiResponseDto<List<OverviewTransactionDTO>>> {

        val listOfTransactionData = service.getAllTransactions()

        val code = if(listOfTransactionData.isNotEmpty()) 200 else 400
        val message = if(listOfTransactionData.isNotEmpty()) "Found transactions" else "no transactions found"

        val apiResponse = ApiResponseDto(
            code = code.toString(),
            message = message,
            data = listOfTransactionData
        )
        logger.info("get all transactions data response :: ", )
        return ResponseEntity.status(code).body(apiResponse)

    }

    @GetMapping("/transaction/{id}")
    fun getTransactionById(@PathVariable("id") id: Long): ResponseEntity<ApiResponseDto<OverviewTransactionDTO>>{

        val transactionDetails = service.getBankById(id)
        val code = if(transactionDetails != null ) 200 else 400
        val message = if (transactionDetails != null) "Transaction retrieved successfully" else "transaction not found"

        val apiResponse = ApiResponseDto(
            code = code.toString(),
            message = message,
            data = transactionDetails
        )
        logger.info("get transaction by Id response :: {}", transactionDetails)
        return ResponseEntity.status(code).body(apiResponse)
    }

}