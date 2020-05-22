package br.pro.aguiar.dkaep4.ui.login

import android.widget.EditText
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {

    val firebaseAuth = FirebaseAuth.getInstance()
    // createUser...
    // signIn...

    fun createUser(
        edtTxtEmail: EditText,
        edtTxtSenha : EditText
    ){
        if (
            edtTxtEmail.text.isNullOrBlank()
            || edtTxtSenha.text.isNullOrBlank()
                )
            throw object : Throwable() {
                override val message: String?
                    get() = "Preencha todos os campos."
            }
        firebaseAuth.createUserWithEmailAndPassword(
            edtTxtEmail.text.toString(),
            edtTxtSenha.text.toString()
        )
    }

}