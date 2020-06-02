package com.hamon.sicloapp.view

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.hamon.sicloapp.R
import com.hamon.sicloapp.databinding.FragmentVideoBinding
import java.lang.Exception

class VideoFragment : Fragment() {

    private val binding: FragmentVideoBinding by lazy {
        FragmentVideoBinding.inflate(LayoutInflater.from(context))
    }
    private val bandwidthMeter: BandwidthMeter by lazy { DefaultBandwidthMeter() }
    private val trackSelector: TrackSelector by lazy {
        DefaultTrackSelector(
            AdaptiveTrackSelection.Factory(
                bandwidthMeter
            )
        )
    }
    private val exoPlayer: ExoPlayer by lazy {
        ExoPlayerFactory.newSimpleInstance(requireContext(), trackSelector)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            binding.videoPlayer.player = exoPlayer
            exoPlayer.prepare(ExtractorMediaSource(
                stingToUri(),
                DefaultHttpDataSourceFactory("sicloApp"),
                DefaultExtractorsFactory(),
                null,
                null
            ))
            exoPlayer.playWhenReady = true
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

    private fun stingToUri(): Uri = Uri.parse(getString(R.string.video_url))

}