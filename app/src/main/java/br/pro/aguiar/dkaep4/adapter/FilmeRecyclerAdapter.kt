package br.pro.aguiar.dkaep4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.pro.aguiar.dkaep4.R
import br.pro.aguiar.dkaep4.model.Filme
import kotlinx.android.synthetic.main.rcy_lista_filme.view.*

class FilmeRecyclerAdapter(
    private val filmes : List<Filme>
) : RecyclerView.Adapter
        <FilmeRecyclerAdapter.FilmeViewHolder>() {

    class FilmeViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){
        val txtVwFilmeNome = itemView.txtVwFilmeNome
        val txtVwFilmeAno = itemView.txtVwFilmeAno
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.rcy_lista_filme,
                parent,
                false
            )
        val filmeViewHolder = FilmeViewHolder(view)
        return filmeViewHolder
    }

    override fun getItemCount(): Int = filmes.size

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        val filme = filmes[position]
        // filme.capa : Bitmap | Int (Resource)
        // ImageView.setImageBitmap(filme.capa)
        // ImageView.setImageResource(filme.capa)
        holder.txtVwFilmeNome.text = filme.nome
        holder.txtVwFilmeAno.text = filme.ano.toString()
    }
}