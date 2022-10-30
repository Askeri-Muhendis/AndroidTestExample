package com.ibrahimethemsen.androidtestexample.register


import com.ibrahimethemsen.androidtestexample.base.BaseViewModel

class RegisterViewModel : BaseViewModel() {
    //girilen iki değer aynı mı
    fun passwordValidation(password : String,passwordValidation : String) : Boolean{
        return password == passwordValidation
    }
    //mesaj döndürdüğümüzü düşünelim
    fun passwordValidationUserInfo(password : String,passwordValidation : String) : String{
        return if (password == passwordValidation){
            "Şifreler Aynı"
        }else{
            "Şifreler Farklı"
        }
    }
    //şifre uzunlugu
    fun passwordSizeUserMessage(password : String) : String{
        return if (password.length >= 6){
            "Şifre 6 haneden büyük"
        }else {
            "Şifre 6 haneden küçük"
        }
    }

}