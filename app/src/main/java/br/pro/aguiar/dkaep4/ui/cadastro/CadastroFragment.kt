package br.pro.aguiar.dkaep4.ui.cadastro

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.pro.aguiar.dkaep4.R
import kotlinx.android.synthetic.main.fragment_cadastro.*

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

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCadastroFilmeCadastrar.setOnClickListener {
            cadastroViewModel.storeFilme(
                edtTxtCadastroFilmeNome,
                edtTxtCadastroFilmeAno,
                edtTxtCadastroFilmeCategoria
            )

            Log.d("EditText", edtTxtCadastroFilmeNome.text.toString())
            Log.d("EditText", edtTxtCadastroFilmeAno.text.toString())
            Log.d("EditText", edtTxtCadastroFilmeCategoria.text.toString())

            Log.d("EditText", edtTxtCadastroFilmeNome.text.isBlank().toString())
            Log.d("EditText", edtTxtCadastroFilmeNome.text.isEmpty().toString())
        }
    }
}
