package br.pro.aguiar.dkaep4

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    //private lateinit var firebaseStorage: FirebaseStorage
    //private lateinit var storageReference: StorageReference

    private lateinit var firebaseFirestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, HomeActivity::class.java))

//        // Intancia do Firestore: Conexao
//        firebaseFirestore = FirebaseFirestore.getInstance()
//
//        // Apontar uma colecao
//        val collection = firebaseFirestore
//                            .collection("users")
//
//        // Apontar um documento e usar Set para alimentar o doc
//        val document = collection.document("thi@go.com")
//        val task = document.get()
//
//        task
//        .addOnSuccessListener {
//            if (it != null){
//                var user = it.toObject(User::class.java)
//                Log.i("Documento", user.toString())
//            }
//        }
//        .addOnFailureListener {
//            Toast.makeText(
//                this, it.message,
//                Toast.LENGTH_LONG).show()
//        }
//
//        //setupStorageDownload()

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
