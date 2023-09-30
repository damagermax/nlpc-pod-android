package com.maxwell.nlpcpod.domain.use_case.validator

import android.util.Patterns
import com.maxwell.nlpcpod.domain.model.ValidationResult

class ValidateEmail {

    operator fun invoke(email: String): ValidationResult {

        if (email.isBlank()) return ValidationResult("Email is required", false)



        if (!Patterns.EMAIL_ADDRESS.matcher(email)
                .matches()
        ) return ValidationResult("Invalid Email", false)

        return ValidationResult(null, true)
    }
}