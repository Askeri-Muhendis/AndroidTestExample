package com.ibrahimethemsen.androidtestexample

import com.ibrahimethemsen.androidtestexample.register.RegisterViewModel
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Test


class RegisterViewModelTest {
    @Test
    fun passwordValidationTest(){
        //given
        val viewModel = RegisterViewModel()
        //when
        val actual = viewModel.passwordValidation("1234","123")
        //then
        assertEquals(
            false,
            actual
        )
        assertThat(
            actual,
            `is`(false)
        )
    }

    @Test
    fun passwordValidationUserInfo(){
        //given
        val viewModel = RegisterViewModel()
        //when
        val actual = viewModel.passwordValidationUserInfo("123","123")
        //then
        assertThat(
            actual,
            `is`("Şifreler Aynı")
        )
    }

    @Test
    fun passwordMinSize() {
        //Given
        val viewModel = RegisterViewModel()

        //when
        val actual = viewModel.passwordSizeUserMessage("123")
        //expected -> beklenen, actual -> gerçek
        /*assertEquals(
            "Şifre 6 haneden küçük",
            sonuc
        )*/

        //then
        assertThat(
            actual,
            `is`("Şifre 6 haneden küçük")
        )
    }
}