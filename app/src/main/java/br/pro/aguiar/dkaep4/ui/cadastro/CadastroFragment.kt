package br.pro.aguiar.dkaep4.ui.cadastro

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import br.pro.aguiar.dkaep4.R
import com.google.android.material.snackbar.Snackbar
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
            try {
                cadastroViewModel.storeFilme(
                    edtTxtCadastroFilmeNome,
                    edtTxtCadastroFilmeAno,
                    edtTxtCadastroFilmeCategoria
                ).addOnSuccessListener {
                    clearForms()
                    showSnackBar("Filme cadastrado com sucesso.")
                    findNavController().navigate(R.id.navigation_lista)
                }.addOnFailureListener {
                    showSnackBar(it.message.toString())
                }
            } catch (e: Throwable){
                showSnackBar(e.message.toString())
            }
        }
    }

    fun showSnackBar(msg: String, time: Int = Snackbar.LENGTH_LONG){
        Snackbar.make(
            root_layout_cadastro_fragment, msg, time
        )
            .setAction("Action", null)
            .show()
    }

    fun clearForms(){
        edtTxtCadastroFilmeNome.setText("")
        edtTxtCadastroFilmeAno.setText("")
        edtTxtCadastroFilmeCategoria.setText("")
    }
}
