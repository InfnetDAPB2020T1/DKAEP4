package br.pro.aguiar.dkaep4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.pro.aguiar.dkaep4.apiservice.ApiClient
import br.pro.aguiar.dkaep4.apiservice.LivrosService
import br.pro.aguiar.dkaep4.model.Livro
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    /*
            private lateinit var firebaseStorage: FirebaseStorage

    //private lateinit var storageReference: StorageReference

//    private lateinit var firebaseFirestore: FirebaseFirestore
//    private var mAuth: FirebaseAuth? = null

     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
mAuth = FirebaseAuth.getInstance();

        //startActivity(Intent(this, HomeActivity::class.java))

        // login (email e senha)

//        mAuth!!.createUserWithEmailAndPassword("thigo", "654321")
//            .addOnSuccessListener {
//                if (it != null){
//                    val user = it.user // FirebaseUser
//                    Log.d("Autenticacao", "Cadastrado: " +
//                            "${user!!.uid} - ${user!!.email}!")
//                    startActivity(Intent(this, SignInActivity::class.java))
//                } else {
//                    Log.d("Autenticacao", "Cadastrado!")
//                }
//            }
//            .addOnFailureListener {
//                Log.d("Autenticacao", it.message)
//            }
//
//        mAuth!!.signInWithEmailAndPassword("thi@go.com", "654321")
//            .addOnSuccessListener {
//                if (it != null){
//                    val user = it.user // FirebaseUser
//                    Log.d("Autenticacao", "Permitido: " +
//                            "${user!!.uid} - ${user!!.email}!")
//                    startActivity(Intent(this, HomeActivity::class.java))
//                } else {
//                    Log.d("Autenticacao", "Negado!")
//                }
//            }
//            .addOnFailureListener {
//                Log.d("Autenticacao", it.message)
//            }
*/

        /* URL + Recursos
//        val retrofit : Retrofit = Retrofit.Builder()
//            .baseUrl("http://biblio.aguiar.pro.br/") // URL
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val livrosService : LivrosService = retrofit
//                .create(LivrosService::class.java)
*/
        // GET api/livros -> lista de livros [ {..}, {..}, ]
        // fun all() : Call<List<Livro>>
        ApiClient.getLivrosService().show(30).enqueue(
            object : Callback<Livro>{
                override fun onFailure(
                        call: Call<Livro>,
                        t: Throwable) {
                    Log.d("Retrofit", t.message)
                }

                override fun onResponse(
                        call: Call<Livro>,
                        response: Response<Livro>)
                {
                    val livro = response.body()
                    Log.d("Retrofit", livro?.titulo)
                }

        })

    }









    private fun setupStorageDownload() {
        // Instancia do FirebaseStorage - Conexao
        //firebaseStorage = FirebaseStorage.getInstance()

        // Referencia - Diretorio Raiz
        //storageReference = firebaseStorage.reference              // C:/

        //        storageReference.listAll().addOnSuccessListener {
        //            it.items.forEach {
        //                it.metadata.addOnSuccessListener {
        //                    it.contentType
        //                }
        //            }
        //        }

        //val arq = storageReference.child("js.png")      // C:/js.png

        //val task = arq.getBytes(1024 * 1024)
        // val task = arq.getFile(File(filesDir, "js.png"))
        // data/data/pacote/files

//        task.addOnSuccessListener {
//            //if (it != null)
//            var bitmap = BitmapFactory.decodeByteArray(it, 0, it.size)
//            imgVwDown.setImageBitmap(bitmap)
//        }.addOnFailureListener {
//            Toast.makeText(
//                this,
//                it.message,
//                Toast.LENGTH_LONG
//            ).show()
//        }

        //        FirebaseStorage.getInstance().reference.child()
        //            .getBytes()
        //            .addOnFailureListener {  }
        //            .addOnSuccessListener {  }
    }
}
