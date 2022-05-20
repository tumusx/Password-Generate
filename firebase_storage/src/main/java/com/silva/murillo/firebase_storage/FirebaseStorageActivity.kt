package com.silva.murillo.firebase_storage

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
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage

@GlideModule
class FirebaseStorageActivity : AppCompatActivity() {
    private lateinit var txtDownload: TextView
    private lateinit var appButtonDownload: AppCompatButton
    private lateinit var txtUpload: TextView
    private lateinit var appButtonUpload: AppCompatButton
    private lateinit var imgFirebase: ImageView
    private val storageReference = Firebase.storage.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_storage)
        txtDownload = findViewById(R.id.txtDownload)
        txtUpload = findViewById(R.id.txtUpload)
        appButtonDownload = findViewById(R.id.appButonDownload)
        imgFirebase = findViewById(R.id.imgFirebase)
        appButtonUpload = findViewById(R.id.appButonUpload)
        onConfigureDownloadStorage()
    }

    private fun onConfigureDownloadStorage() {
        var showResponseDownload = "Success ao realize o download."
        val storageRef = storageReference
        appButtonDownload.apply {
            setOnClickListener {
                val storageDownload: StorageReference =
                    storageRef.child("storage").child("file.pdf")
                storageDownload.downloadUrl.addOnSuccessListener {it->
                    Log.d("string", "$it")
                    Toast.makeText(context, showResponseDownload, Toast.LENGTH_SHORT).show()
                    Glide.with(this).asDrawable()
                        .load(storageRef).into(imgFirebase)
                }.addOnFailureListener{
                    showResponseDownload = "Error ao realize o download"
                    Toast.makeText(context, showResponseDownload, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}