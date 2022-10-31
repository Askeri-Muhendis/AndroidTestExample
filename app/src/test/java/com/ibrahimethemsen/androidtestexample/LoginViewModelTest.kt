package com.ibrahimethemsen.androidtestexample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ibrahimethemsen.androidtestexample.login.LoginViewModel
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//JUnitRunner
@RunWith(AndroidJUnit4::class)
class LoginViewModelTest {
    /** BDD - Gherkin bir tür DSL(Domain Specific Language)
     *  given -> ihtiyac duydugumuz nesneleri ve uygulama durumunu ayarlıyoruz
     *  when  -> eylemi/action'u test ettiğimiz alan
     *  then  -> testin geçip geçmediğini kontrol ettiğimiz alan
     * */

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    //Her test için viewModel yazmak yerine @Before kullanıyoruz
    private lateinit var viewModel: LoginViewModel

    //Birden çok test için aynı kurulum kodunu kullandığımızda @Before kullanabiliriz.
    @Before
    fun setupViewModel() {
        viewModel = LoginViewModel()
    }

    @Test
    fun editTextInputEmpty() {
        //given
        //val loginViewModel = LoginViewModel()
        //when
        val actual = viewModel.nullOrEmptyCheck("   ")
        //then
        assertThat(
            actual,
            `is`(true)
        )
    }

    @Test
    fun epostaFormatCheckTest() {
        //given
        //val loginViewModel = LoginViewModel()
        //when
        val actual = viewModel.epostaFormatCheck("asd")
        //then
        /*assertEquals(
            "Şifre 6 haneden küçük",
            sonuc
        )*/
        assertThat(
            actual,
            `is`(false)
        )
    }

    @Test
    fun userRegisteredDbCheck() {
        //given
        //val loginViewModel = LoginViewModel()
        //when
        val actual = viewModel.userIsRegistered("deneme@gmail.com", "123")
        //then
        assertThat(
            actual,
            `is`("Giriş Yapıldı")
        )
    }

    @Test
    fun userRegisteredLiveDataCheck() {
        //given
        //val loginViewModel = LoginViewModel()
        //when
        viewModel.userIsRegistered("deneme@gmail.com", "123")
        //val valueLiveData = viewModel.isLogginIn -> true yada false dönmüyor

        val actual = viewModel.isLogginIn.getOrAwaitValue()
        //then
        assertThat(
            actual,
            `is`(true)
        )
    }
}