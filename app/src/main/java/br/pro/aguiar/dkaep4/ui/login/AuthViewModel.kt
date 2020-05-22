package br.pro.aguiar.dkaep4.ui.login

import android.widget.EditText
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {

    val firebaseAuth = FirebaseAuth.getInstance()

    fun createUser(
        edtTxtEmail: EditText, edtTxtSenha: EditText,
        edtTxtRepetirSenha: EditText
    ): Task<AuthResult> {
        // Verifica se os campos estao preenchidos
        if (edtTxtEmail.text.isNullOrBlank()
            || edtTxtSenha.text.isNullOrBlank()
            || edtTxtRepetirSenha.text.isNullOrBlank()
                )  throw object : Throwable() {
                override val message: String?
                    get() = "Preencha todos os campos."
            }

        // Verifica se as senhas sao iguais
        if (edtTxtSenha.text.toString().compareTo(
                edtTxtRepetirSenha.text.toString()) != 0
        ) throw object : Throwable() {
                override val message: String?
                    get() = "As senhas não conferem."
            }

        return firebaseAuth.createUserWithEmailAndPassword(
            edtTxtEmail.text.toString(),
            edtTxtSenha.text.toString()
        )
    }

    fun signInUser(edtTxtEmail: EditText, edtTxtSenha: EditText): Task<AuthResult> {
        // Verifica se os campos estao preenchidos
        if (edtTxtEmail.text.isNullOrBlank()
            || edtTxtSenha.text.isNullOrBlank()
        )  throw object : Throwable() {
            override val message: String?
                get() = "Preencha todos os campos."
        }

        return firebaseAuth.signInWithEmailAndPassword(
            edtTxtEmail.text.toString(),
            edtTxtSenha.text.toString()
        )
    }
}