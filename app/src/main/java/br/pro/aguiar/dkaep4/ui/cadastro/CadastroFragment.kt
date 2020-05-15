package br.pro.aguiar.dkaep4.ui.cadastro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.pro.aguiar.dkaep4.R

class CadastroFragment : Fragment() {

    private lateinit var cadastroViewModel: CadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cadastroViewModel =
            ViewModelProviders.of(this).get(CadastroViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_cadastro, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        cadastroViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
