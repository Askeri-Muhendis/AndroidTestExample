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
    fun passwordMinSize() {
        //Given
        //val loginViewModel = LoginViewModel()

        //when
        val sonuc = viewModel.passwordSizeUserMessage("123")
        //expected -> beklenen, actual -> gerçek
        /*assertEquals(
            "Şifre 6 haneden küçük",
            sonuc
        )*/
        //then
        //ters tirnak alt gr + ;
        assertThat(
            sonuc,
            `is`("Şifre 6 haneden küçük")
        )
    }

    @Test
    fun editTextInputEmpty() {
        //given
        //val loginViewModel = LoginViewModel()
        //when
        val funSonuc = viewModel.nullOrEmptyCheck("   ")
        //then
        assertThat(
            funSonuc,
            `is`(true)
        )
    }

    @Test
    fun epostaFormatCheckTest() {
        //given
        //val loginViewModel = LoginViewModel()
        //when
        val fonksiyonSonuc = viewModel.epostaFormatCheck("asd")
        //then
        /*assertEquals(
            "Şifre 6 haneden küçük",
            sonuc
        )*/
        assertThat(
            fonksiyonSonuc,
            `is`(false)
        )
    }

    @Test
    fun userRegisteredDbCheck() {
        //given
        //val loginViewModel = LoginViewModel()
        //when
        viewModel.userIsRegistered("deneme@gmail.com", "123")
        //val valueLiveData = viewModel.isLogginIn -> true yada false dönmüyor

        val valueLiveData = viewModel.isLogginIn.getOrAwaitValue()
        //then
        assertThat(
            valueLiveData,
            `is`(true)
        )
    }
}