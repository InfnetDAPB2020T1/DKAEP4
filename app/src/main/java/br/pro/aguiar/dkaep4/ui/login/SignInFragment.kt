package br.pro.aguiar.dkaep4.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import br.pro.aguiar.dkaep4.HomeActivity
import br.pro.aguiar.dkaep4.HomeLivrosActivity

import br.pro.aguiar.dkaep4.R
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_sign_in.*

/**
 * A simple [Fragment] subclass.
 */
class SignInFragment : Fragment() {

    lateinit var authViewModel: AuthViewModel
    private var callbackManager = CallbackManager.Factory.create()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            authViewModel = ViewModelProviders.of(it)
                .get(AuthViewModel::class.java)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLoginFB.setReadPermissions("email", "public_profile")
        btnLoginFB.registerCallback(
            callbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onSuccess(loginResult: LoginResult) {
                    handleFacebookAccessToken(loginResult.accessToken)
                    // Codigo completo
                }
                override fun onCancel() {
                    //
                }
                override fun onError(error: FacebookException) {
                    Toast.makeText(
                        this@SignInFragment.requireContext(),
                        error.message, Toast.LENGTH_LONG
                    ).show()
                }
        })
        btnLoginAcessar.setOnClickListener {
            try {
                authViewModel.signInUser(
                    edtTxtLoginEmail, edtTxtLoginSenha
                )
                    .addOnSuccessListener {
                        if (it != null){
                            activity?.let {
                                startActivity(Intent(it, HomeLivrosActivity::class.java))
                            }
                        } else {
                            Toast.makeText(
                                this.context, "Algo de errado ocorreu!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }.addOnFailureListener {
                        Toast.makeText(
                            this.context, it.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
            } catch (e: Throwable){
                Toast.makeText(
                    this.context, e.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        btnLoginCadstro.setOnClickListener {
            findNavController().navigate(R.id.signUp_destination)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        val credential = FacebookAuthProvider.getCredential(token.token)
        val auth = FirebaseAuth.getInstance()
        val task = auth.signInWithCredential(credential)

        task.addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Alterando a interface para a Home
                } else {
                    // Mensagem de erro.
                }
            }
    }
}
