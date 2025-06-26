package com.example.formulaonesport

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.ComponentActivity

class VideoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val videoView = findViewById<VideoView>(R.id.videoView)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        val piloto = intent.getStringExtra("piloto") ?: "senna"

        val videoId = when (piloto) {
            "verstappen" -> R.raw.verstappen
            "hamilton" -> R.raw.hamilton
            else -> R.raw.senna
        }

        val videoUri = Uri.parse("android.resource://${packageName}/$videoId")
        videoView.setVideoURI(videoUri)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        videoView.start()

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}
