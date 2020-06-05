package br.pro.aguiar.dkaep4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.pro.aguiar.dkaep4.R
import br.pro.aguiar.dkaep4.model.Livro

class LivrosRecyclerAdapter(
        var livros: MutableList<Livro>
    ): RecyclerView.Adapter<
        LivrosRecyclerAdapter.LivrosViewHolder // RecyclerView.ViewHolder()
        >() {

    class LivrosViewHolder(view: View)
        : RecyclerView.ViewHolder(view)  {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivrosViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.layout_livros_item,
                parent,
                false
            )

        val livrosViewHolder = LivrosViewHolder(view)

        return livrosViewHolder
    }

    override fun getItemCount(): Int = livros.size

    override fun onBindViewHolder(holder: LivrosViewHolder, position: Int) {

    }
}