package br.pro.aguiar.dkaep4.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.DocumentReference

// Model
class Filme (
    var nome: String? = null,
    var ano: Int? = null,
    var categoria: String? = null,

    //var atores: List<Ator>? = null,
    var atores: List<DocumentReference>? = null,

    @DocumentId
    var id: String? = null
)
