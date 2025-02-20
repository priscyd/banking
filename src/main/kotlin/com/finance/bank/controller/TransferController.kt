package com.finance.bank.controller

import com.finance.bank.controller.models.*
import com.finance.bank.services.ITransactionService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

}