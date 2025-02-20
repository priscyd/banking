package com.finance.bank.controller

import com.finance.bank.controller.models.OverviewTransactionModel
import com.finance.bank.controller.models.TransactionModel
import com.finance.bank.controller.models.convertToDBModel
import com.finance.bank.controller.models.convertToOverviewTransactionModel
import com.finance.bank.repository.TransferRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transfer")
class TransferController(val repository: TransferRepository) {
    @PostMapping("/new")
    fun createNewTransfer(@RequestBody transactionModel: TransactionModel){
        repository.save(transactionModel.convertToDBModel())
    }

    @GetMapping("/retrieve")
    fun getTransfers(): List<OverviewTransactionModel>{
        return repository.findAll().map { it.convertToOverviewTransactionModel() }
    }
}