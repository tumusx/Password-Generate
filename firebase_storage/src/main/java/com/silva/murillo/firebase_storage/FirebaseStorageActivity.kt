package com.silva.murillo.firebase_storage

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import java.io.File

@GlideModule
class FirebaseStorageActivity : AppCompatActivity() {
    private lateinit var txtDownload: TextView
    private lateinit var appButonDownload: AppCompatButton
    private lateinit var txtUpload: TextView
    private lateinit var appButonUpload: AppCompatButton
    private lateinit var imgFirebase: ImageView
    val storageReference = Firebase.storage.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_storage)
        txtDownload = findViewById(R.id.txtDownload)
        txtUpload = findViewById(R.id.txtUpload)
        appButonDownload = findViewById(R.id.appButonDownload)
        imgFirebase = findViewById(R.id.imgFirebase)
        appButonUpload = findViewById(R.id.appButonUpload)
        onConfigureDownloadStorage()
    }

    private fun onConfigureDownloadStorage() {
        var showResponseDownload = "Sucesso ao realizar o download."
        val storageRef = storageReference
        appButonDownload.apply {
            setOnClickListener {
                val storageDownload: StorageReference =
                    storageRef.child("storage").child("ticketlog.png")
                storageDownload.downloadUrl.addOnSuccessListener {it->
                    Log.d("string", "${it}")
                    Toast.makeText(context, showResponseDownload, Toast.LENGTH_SHORT).show()
                    Glide.with(this).asDrawable()
                        .load(storageRef).into(imgFirebase)
                }.addOnFailureListener{
                    showResponseDownload = "Erro ao realizar o download"
                    Toast.makeText(context, showResponseDownload, Toast.LENGTH_SHORT).show()
                }
            }

        }

    }

    private fun onConfigureUploadStorage(){

    }

}