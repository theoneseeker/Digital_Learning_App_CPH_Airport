package cdio.group21.digital_learning_app.ui.video

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cdio.group21.digital_learning_app.R
import cdio.group21.digital_learning_app.databinding.ActivityMainBinding
import cdio.group21.digital_learning_app.ui.video.VideoActivity



class VideoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)


    }


}