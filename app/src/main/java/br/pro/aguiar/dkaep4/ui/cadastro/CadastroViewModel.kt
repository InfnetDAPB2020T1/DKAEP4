package br.pro.aguiar.dkaep4.ui.cadastro

import android.util.Log
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.pro.aguiar.dkaep4.model.Filme
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class CadastroViewModel : ViewModel() {

    init {
        Log.d("EditText", "CadastroViewModel iniciado")
    }

    fun storeFilme(
        edtTxtNome: EditText,
        edtTxtAno: EditText,
        edtTxtCategoria: EditText
    ): Task<DocumentReference> {
       if (
           edtTxtNome.text.isNullOrBlank() ||
           edtTxtAno.text.isNullOrBlank() ||
           edtTxtCategoria.text.isNullOrBlank()
       )
           throw object : Throwable() {
               override val message: String?
                   get() = "Preencha todos os campos."
           }

        // FilmeDao.storeFilme(Filme(
        //               edtTxtNome.text.toString(),
        //               edtTxtAno.text.toString().toInt(),
        //               edtTxtCategoria.text.toString()
        //           ))

       val firebaseFirestore = FirebaseFirestore.getInstance()
       val collection = firebaseFirestore.collection("filme")
       val task = collection.add(
           Filme(
               edtTxtNome.text.toString(),
               edtTxtAno.text.toString().toInt(),
               edtTxtCategoria.text.toString()
           )
       )
       return task
    }
}