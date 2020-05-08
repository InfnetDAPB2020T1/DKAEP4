package br.pro.aguiar.dkaep4

import com.google.firebase.firestore.DocumentReference
import java.io.Serializable

//@Entity
class User (
    var nome: String? = null,
    var sobrenome: String? = null,
    var cidade: String? = null,
    var email: String? = null,
    var cpf: String? = null,
    var nascimento: String? = null
) {
    override fun toString(): String {
        return "$nome, $sobrenome, $cidade," +
                "$email, $cpf, $nascimento"
    }
}