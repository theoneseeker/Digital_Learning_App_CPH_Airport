package cdio.group21.digital_learning_app.ui.video

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.Player
import androidx.media3.common.util.Util
import androidx.media3.exoplayer.ExoPlayer
import cdio.group21.digital_learning_app.R
import cdio.group21.digital_learning_app.databinding.FragmentWatchBinding


import com.google.common.collect.ImmutableList

class FragmentWatch : Fragment(), Player.Listener {

    private var _binding: FragmentWatchBinding? = null
    private val binding get() = _binding!!

    private var player: ExoPlayer? = null





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWatchBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPlayer()

        addMP4Files()
        player?.play()

    }



    private fun addMP4Files() {
        val mediaItem = MediaItem.fromUri(getString(R.string.media_url_mp4))
        val mediaItem2 = MediaItem.fromUri(getString(R.string.myTestMp4))
        val newItems: List<MediaItem> = ImmutableList.of(
            mediaItem,
            mediaItem2
        )
        player?.addMediaItems(newItems)
        player?.prepare()
    }

    private fun setupPlayer() {
        player = ExoPlayer.Builder(this.requireContext()).build().also {
                exoPlayer -> binding.videoView.player = exoPlayer
        }
    }


    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            initializePlayer()
        }
    }
    override fun onStop() {
        super.onStop()
        releasePlayer()
    }
    override fun onPause() {
        super.onPause()
        releasePlayer()
    }

    override fun onResume() {
        super.onResume()
        hideSystemUi()
        if ((Util.SDK_INT <= 23 || player == null)) {
            initializePlayer()
        }
    }


    @SuppressLint("InlinedApi")
    private fun hideSystemUi() {
        WindowCompat.setDecorFitsSystemWindows(this.requireActivity().window, false)
        WindowInsetsControllerCompat(this.requireActivity().window, binding.videoView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }


    private fun initializePlayer() {
        player = ExoPlayer.Builder(this.requireContext())
            .build()
            .also { exoPlayer ->
                binding.videoView.player = exoPlayer
                val mediaItem = MediaItem.fromUri(getString(R.string.media_url_mp4))
                exoPlayer.setMediaItem(mediaItem)
                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.seekTo(currentItem, playbackPosition)
                exoPlayer.prepare()
            }
    }


    private var playWhenReady = true
    private var currentItem = 0
    private var playbackPosition = 0L

    private fun releasePlayer() {
        player?.let { exoPlayer ->
            playbackPosition = exoPlayer.currentPosition
            currentItem = exoPlayer.currentMediaItemIndex
            playWhenReady = exoPlayer.playWhenReady
            exoPlayer.release()
        }
        player = null
    }



}