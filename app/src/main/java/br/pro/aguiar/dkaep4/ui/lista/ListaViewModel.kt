package br.pro.aguiar.dkaep4.ui.lista

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class ListaViewModel : ViewModel() {
    fun setupRecyclerView(
        recyclerView: RecyclerView
    ){
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val collection = firebaseFirestore.collection("filme")
        val task = collection.get()
    }

}