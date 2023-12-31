package com.newaeon.mahaapp.ui

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.newaeon.mahaapp.R
import com.newaeon.mahaapp.databinding.SplashscreenBinding


class SplashScreenFragment : Fragment() {
    private var binding: SplashscreenBinding? = null
    private var videoView: VideoView? = null


//    // to send data from screen to another
//    private val PREFS_NAME = "MyPrefsFile"
//    private val KEY_NAME = "name"
//    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SplashscreenBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // to send data from screen to another
//        sharedPreferences = activity?.getSharedPreferences(
//            PREFS_NAME,
//            Context.MODE_PRIVATE
//        );  // private to prevent share it  with another app
//        val editor = sharedPreferences!!.edit()
//        editor.putString(KEY_NAME, "John Doe")
//        editor.apply()
        playVideo()
//        val handler = Handler(Looper.getMainLooper())
//        val runnable = Runnable {
//            findNavController().navigate(SplashScreenFragmentDirections.actionNavigationSplashscreenToCreateaccount("Mahaaaa"))
//        }
//        handler.postDelayed(runnable, 5000);
//


    }

    private fun playVideo() {
        val videoPath = "android.resource://${requireActivity().packageName}/${R.raw.spalsh_video}"
        val videoUri = Uri.parse(videoPath)
        binding?.videoView?.setVideoURI(videoUri)
        binding?.videoView?.setOnPreparedListener { mediaPlayer: MediaPlayer ->
            mediaPlayer.start()
            mediaPlayer.isLooping=true
//            mediaPlayer.setOnCompletionListener {
//                findNavController().navigate(SplashScreenFragmentDirections.actionNavigationSplashscreenToCreateaccount("Mahaaaa"))
//            }
        }
    }
//    override fun onResume() {
//        super.onResume()
//        if ( binding?.videoView?.isPlaying==true) {
//            binding?.videoView?.start()
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        binding?.videoView?.stopPlayback()
    }
}