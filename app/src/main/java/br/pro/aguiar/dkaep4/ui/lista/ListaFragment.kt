package br.pro.aguiar.dkaep4.ui.lista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import br.pro.aguiar.dkaep4.R
import kotlinx.android.synthetic.main.fragment_lista.*

class ListaFragment : Fragment() {

    private lateinit var listaViewModel: ListaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listaViewModel =
            ViewModelProviders.of(this).get(ListaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_lista, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        listaViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
