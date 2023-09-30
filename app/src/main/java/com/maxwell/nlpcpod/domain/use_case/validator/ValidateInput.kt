package com.maxwell.nlpcpod.domain.use_case.validator

import com.maxwell.nlpcpod.domain.model.ValidationResult

class ValidateInput {

    operator fun invoke(value:String,name:String):ValidationResult{

        if (value.isBlank()) return ValidationResult("$name is required",false)

        return  ValidationResult(null,true)
    }
}