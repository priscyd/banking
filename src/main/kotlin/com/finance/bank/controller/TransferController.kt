package com.finance.bank.controller

import com.finance.bank.controller.dto.ApiResponseDto
import com.finance.bank.controller.dto.OverviewTransactionDTO
import com.finance.bank.controller.dto.TransactionDTO
import com.finance.bank.services.ITransactionService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transfer")
class TransferController(val service: ITransactionService) {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/ping")
    fun ping(): String{
        return "ping"
    }

    @PostMapping("/new")
    fun createNewTransfer(@RequestBody transactionDTO: TransactionDTO): ResponseEntity<String> {

        val transactionPersistResponseData = service.addBank(transactionDTO)
            ?: return ResponseEntity.status(400).body("failed to add transaction")

        logger.info("transactionPersistResponseData :: {} ", transactionPersistResponseData)

        // response when adding transaction passed
        return ResponseEntity.status(201).body("data created successfully")

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

}