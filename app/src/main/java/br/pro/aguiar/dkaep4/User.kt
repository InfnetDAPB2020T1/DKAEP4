package br.pro.aguiar.dkaep4

import com.google.firebase.firestore.DocumentReference
import java.io.Serializable

//@Entity
class User (
    var nome: String,
    var sobrenome: String,
    var cidade: String,
    var email: String,
    var cpf: String
)