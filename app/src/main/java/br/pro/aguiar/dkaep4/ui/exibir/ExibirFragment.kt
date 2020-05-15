package br.pro.aguiar.dkaep4.ui.exibir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.pro.aguiar.dkaep4.HomeViewModel
import br.pro.aguiar.dkaep4.R
import kotlinx.android.synthetic.main.fragment_exibir.*

class ExibirFragment : Fragment() {

    private lateinit var exibirViewModel: ExibirViewModel
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        exibirViewModel =
            ViewModelProviders.of(this).get(ExibirViewModel::class.java)
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_exibir, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val filme = homeViewModel.filme
        txtVwExibirFilmeNome.text = filme.value?.nome
        txtVwExibirFilmeAno.text = filme.value?.ano.toString()
        txtVwExibirFilmeCategoria.text = filme.value?.categoria
    }
}
