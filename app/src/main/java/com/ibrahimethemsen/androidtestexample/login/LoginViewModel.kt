package com.ibrahimethemsen.androidtestexample.login


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ibrahimethemsen.androidtestexample.base.BaseViewModel

class LoginViewModel : BaseViewModel() {
    //giris livedata
    private val _isLoggidIn = MutableLiveData<Boolean>()
    val isLogginIn : LiveData<Boolean> = _isLoggidIn

    fun userIsRegistered(email: String?, password: String?): String {
        return if (!nullOrEmptyCheck(email) && !nullOrEmptyCheck(password)){
            if (epostaFormatCheck(email!!)){
                _isLoggidIn.value = true
                "Giriş Yapıldı"
            }else{
                _isLoggidIn.value = false
                "Geçerli bir eposta formati giriniz"
            }
        }else{
            _isLoggidIn.value = false
            "Eposta ve Şifre Alanlarını Boş Bırakmayın"
        }
    }
}