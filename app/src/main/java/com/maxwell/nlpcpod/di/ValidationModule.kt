package com.maxwell.nlpcpod.di

import com.maxwell.nlpcpod.domain.use_case.validator.LoginFormValidation
import com.maxwell.nlpcpod.domain.use_case.validator.SignupFormValidation
import com.maxwell.nlpcpod.domain.use_case.validator.ValidateEmail
import com.maxwell.nlpcpod.domain.use_case.validator.ValidateInput
import com.maxwell.nlpcpod.domain.use_case.validator.ValidatePassword
import com.maxwell.nlpcpod.domain.use_case.validator.ValidatePhoneNumber
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ValidationModule {


    @Provides
    @Singleton
    fun provideValidateEmail() = ValidateEmail()

    @Provides
    @Singleton
    fun provideValidatePassword() = ValidatePassword()

    @Provides
    @Singleton
    fun provideValidateInput() = ValidateInput()

    @Provides
    @Singleton
    fun provideValidatePhoneNumber() = ValidatePhoneNumber()


    @Provides
    @Singleton
    fun provideLoginValidation(validateEmail: ValidateEmail, validatePassword: ValidatePassword) =
        LoginFormValidation(
            validateEmail = validateEmail, validatePassword = validatePassword
        )


    @Provides
    @Singleton
    fun provideSignUpValidation(
        validateEmail: ValidateEmail,
        validatePassword: ValidatePassword,
        validateInput: ValidateInput,
        validatePhoneNumber: ValidatePhoneNumber
    ) =
        SignupFormValidation(
            validateEmail = validateEmail,
            validatePassword = validatePassword,
            validateFullname =validateInput,
            validatePhoneNumber =validatePhoneNumber
        )

}