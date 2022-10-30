package com.ibrahimethemsen.androidtestexample

import com.ibrahimethemsen.androidtestexample.register.RegisterViewModel
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


class RegisterViewModelTest {
    @Test
    fun passwordValidationTest(){
        //given
        val viewModel = RegisterViewModel()
        //when
        val sonuc = viewModel.passwordValidation("1234","123")
        //then
        assertThat(
            sonuc,
            `is`(false)
        )
    }

    @Test
    fun passwordValidationUserInfo(){
        //given
        val viewModel = RegisterViewModel()
        //when
        val sonuc = viewModel.passwordValidationUserInfo("123","123")
        //then
        assertThat(
            sonuc,
            `is`("Şifreler Aynı")
        )
    }
}