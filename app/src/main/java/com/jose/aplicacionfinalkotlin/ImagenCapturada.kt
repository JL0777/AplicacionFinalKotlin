package com.jose.aplicacionfinalkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jose.aplicacionfinalkotlin.databinding.ActivityImagenCapturadaBinding

class ImagenCapturada : AppCompatActivity() {
    lateinit var binding: ActivityImagenCapturadaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityImagenCapturadaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        val uriImage = bundle?.getString("uri")
        binding.ivImagenCapturada.setImageURI(uriImage?.toUri())
        }
}