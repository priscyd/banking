package com.finance.bank.controller.dto

data class ApiResponseDto<T>(
    val code: String? = "",
    val message: String? = "",
    val data: T?
)

