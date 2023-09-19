package com.amit.musicplayer.songList

import com.amit.musicplayer.BaseView
import com.amit.musicplayer.model.Song

interface SongListView : BaseView {
    fun showLoading()

    fun stopLoading()

    fun updateSongState(song: Song, isPlaying: Boolean)

    fun onSongClick()
}