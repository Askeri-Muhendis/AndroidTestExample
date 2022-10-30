package com.ibrahimethemsen.androidtestexample.base

import android.util.Patterns
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {


    //null veya boşluk karakterinden mi oluşuyor
    fun nullOrEmptyCheck(inputEditText : String?) : Boolean{
        return inputEditText.isNullOrBlank()
    }

    //e posta formatı kontrol
    fun epostaFormatCheck(inputEposta : String) : Boolean{
        //android kütüphanesi olduğu için runner gerekli
        return Patterns.EMAIL_ADDRESS.matcher(inputEposta).matches()
    }
}