package br.pro.aguiar.dkaep4

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        firebaseFirestore = FirebaseFirestore.getInstance()

        val collection = firebaseFirestore
                            .collection("users")

        val user = User(
            "Thiago",
            "Aguiar",
            "Rio de Janeiro")

        val task = collection.add(user)

        task.addOnSuccessListener {
            if (it != null)
                Toast.makeText(
                    this, "Documento ${it.id} salvo com " +
                            "sucesso",
                    Toast.LENGTH_LONG).show()
        }.addOnFailureListener {
            Toast.makeText(
                this, it.message,
                Toast.LENGTH_LONG).show()
        }



        //setupStorageDownload()

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
