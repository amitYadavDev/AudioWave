package com.amit.musicplayer.playSong

import com.amit.musicplayer.BaseView
import com.amit.musicplayer.model.Song

interface PlaySongView : BaseView {
    fun updateSongState(song: Song, isPlaying: Boolean, progress: Int)

    fun showRepeat(isRepeat: Boolean)

    fun showRandom(isRandom: Boolean)
}