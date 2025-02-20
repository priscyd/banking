package com.finance.bank.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transfer")
class TransferController {
    @PostMapping("/new")
    fun createNewTransfer(){
        println("created")
    }

    @GetMapping("/retrieve")
    fun getTransfers(): String{
        return "all transfers"
    }
}