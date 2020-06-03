package br.pro.aguiar.dkaep4.apiservice

import br.pro.aguiar.dkaep4.model.Livro
import retrofit2.Call
import retrofit2.http.GET


interface LivrosService {

    // URL                          + Recurso    // URI
    // http://biblio.aguiar.pro.br  + api/livros
    // http://biblio.aguiar.pro.br/api/livros
    @GET("api/livros")
    fun all() : Call<List<Livro>>
    /*
        [
            {LivroA},
            {LivroB},
            ...
        ]
     */

    // http://biblio.aguiar.pro.br/api/donos
//    @GET("api/donos")
//    fun donos_all() : Call<List<Livro>>
}