package com.maxwell.nlpcpod.domain.use_case.validator

import com.maxwell.nlpcpod.domain.model.ValidationResult

class ValidatePhoneNumber {

    operator fun invoke(phoneNumber:String):ValidationResult{
        if (phoneNumber.isBlank()) return  ValidationResult("Phone is required")

        if (phoneNumber.length < 10)return  ValidationResult("Invalid Phone number")

        return ValidationResult(null,true)
    }
}