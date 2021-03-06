package br.pro.aguiar.dkaep4.ui.ListaLivros

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.pro.aguiar.dkaep4.R
import kotlinx.android.synthetic.main.fragment_lista_livros.*

class ListaLivrosFragment : Fragment() {

    private lateinit var listaLivrosViewModel: ListaLivrosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listaLivrosViewModel =
            ViewModelProviders.of(this).get(ListaLivrosViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_lista_livros, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listaLivrosViewModel.setupRecyclerView(
            rcyVwListaLivros, this.requireContext()
        )
    }
}
