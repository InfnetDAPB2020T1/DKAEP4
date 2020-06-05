package br.pro.aguiar.dkaep4.ui.ListaLivros

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.pro.aguiar.dkaep4.adapter.LivrosRecyclerAdapter
import br.pro.aguiar.dkaep4.apiservice.ApiClient
import br.pro.aguiar.dkaep4.model.Livro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaLivrosViewModel : ViewModel() {

    fun setupRecyclerView(
        recyclerView: RecyclerView,
        context: Context
    ){
        ApiClient.getLivrosService().all()
            .enqueue(
                object : Callback<List<Livro>>{
                    override fun onFailure(call: Call<List<Livro>>, t: Throwable) {
                        Toast.makeText(
                            context,
                            t.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    override fun onResponse(
                        call: Call<List<Livro>>,
                        response: Response<List<Livro>>
                    ) {
                        val livros = response.body()
                        if (livros != null && !livros.isEmpty()){
                            recyclerView.adapter = LivrosRecyclerAdapter(
                                livros.toMutableList()
                            )
                            recyclerView.layoutManager = LinearLayoutManager(context)
                        } else {
                            Toast.makeText(
                                context,
                                "Lista de Livros vazia!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            )
    }
}