package com.hamon.sicloapp.view

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.hamon.sicloapp.R
import com.hamon.sicloapp.databinding.FragmentVideoBinding
import java.lang.Exception

class VideoFragment : Fragment() {

    private val binding: FragmentVideoBinding by lazy {
        FragmentVideoBinding.inflate(LayoutInflater.from(context))
    }
    private val bandwidthMeter: BandwidthMeter by lazy { DefaultBandwidthMeter() }
    private val trackSelector: TrackSelector by lazy { DefaultTrackSelector(AdaptiveTrackSelection.Factory(bandwidthMeter)) }
    private lateinit var exoPlayer : ExoPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            exoPlayer = ExoPlayerFactory.newSimpleInstance(requireContext(), trackSelector)
            val defaultHttpDataSourceFactory = DefaultHttpDataSourceFactory("sicloApp")
            val extractorFactory = DefaultExtractorsFactory()
            val mediaSource = ExtractorMediaSource(stingToUri(), defaultHttpDataSourceFactory, extractorFactory, null, null)
            binding.videoPlayer.player = exoPlayer
            exoPlayer.prepare(mediaSource)
            exoPlayer.playWhenReady = true
        }catch (exception: Exception){

        }
    }

    private fun stingToUri(): Uri = Uri.parse(getString(R.string.video_url))

}