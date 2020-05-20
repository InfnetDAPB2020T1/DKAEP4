package br.pro.aguiar.dkaep4.ui.lista

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.pro.aguiar.dkaep4.adapter.FilmeRecyclerAdapter
import br.pro.aguiar.dkaep4.model.Filme
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class ListaViewModel : ViewModel() {

    fun setupRecyclerView(
        //field: String, valor: Any,
        recyclerView: RecyclerView, context: Context, pgrBar: ProgressBar? = null
    ){
        pgrBar?.visibility = View.VISIBLE
        val firebaseFirestore = FirebaseFirestore.getInstance()
        val collection = firebaseFirestore.collection("filme")

        /*
        // Where
        // val task = collection.whereEqualTo("categoria", "Drama").get()
        // val task = collection.whereGreaterThan("ano", 2000).get()

        // Order
        // val task = collection.orderBy("ano").get()
        //val task = collection.orderBy("ano", Query.Direction.DESCENDING).get()

        // Where com Order
        //val task = collection.whereGreaterThan("ano", 2000)
        //    .orderBy("ano", Query.Direction.DESCENDING).get()

        // Limit
        */
//        val query = collection
//            .whereEqualTo("categoria", "ação")
//            .whereGreaterThanOrEqualTo("ano", 2000) // >=
//            .orderBy("ano", Query.Direction.ASCENDING)
//            .limit(5)

            // A .. B
            // A .. C

//        // Nao eh necessaria a interacao do usuario
//        query.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
//            //
//        }

        //collection.document("asdaosdasd").addSnapshotListener { querySnapshot, firebaseFirestoreException ->
        collection.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
            if (firebaseFirestoreException != null){
                Log.e("Firestore", firebaseFirestoreException.message)
            } else {
                if (querySnapshot != null){
                    // 10 filmes
                    // 1 mudou - consumo de dados
                    val filmes = querySnapshot.toObjects(Filme::class.java)
                    recyclerView.adapter = FilmeRecyclerAdapter(filmes)
                    recyclerView.layoutManager = LinearLayoutManager(context)

                    querySnapshot.documentChanges.forEach {
                        val verify = it.type == DocumentChange.Type.REMOVED
                        // manter componente visual - informacao de remocao
                    }

                }
            }
        }


        // Menu com as Categorias
        // Lista os filmes
//        task.addOnSuccessListener {
//            if (it != null){
//                val filmes = it.toObjects(Filme::class.java)
//                recyclerView.adapter = FilmeRecyclerAdapter(filmes)
//                recyclerView.layoutManager = LinearLayoutManager(context)
//            }
//            pgrBar?.visibility = View.GONE
//        }
//            .addOnFailureListener {
//            pgrBar?.visibility = View.GONE
//            Log.i("Index Firestore", it.message.toString())
//            Toast.makeText(
//                context, it.message, Toast.LENGTH_LONG
//            ).show()
//        }
    }

}