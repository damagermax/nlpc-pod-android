package com.maxwell.nlpcpod.domain.use_case.validator

import com.maxwell.nlpcpod.domain.model.ValidationResult

class ValidatePassword {
    operator fun invoke(password: String,): ValidationResult {

        if (password.isBlank()) return ValidationResult("Password is required")

        if (password.length < 8) return ValidationResult("Password must be least 8 character")

        return ValidationResult(null, true)
    }
}