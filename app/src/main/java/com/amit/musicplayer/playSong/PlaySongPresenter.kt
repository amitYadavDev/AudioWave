package com.amit.musicplayer.playSong

import com.amit.musicplayer.BasePresenter
import com.amit.musicplayer.player.PlayerService

class PlaySongPresenter(view: PlaySongView) : com.amit.musicplayer.BasePresenter<PlaySongView>(view) {
    private lateinit var player: PlayerService

    fun setPlayerManager(player: PlayerService) {
        this.player = player

        fetchSongState()
    }

    fun fetchSongState() {
        player.getSong()?.let {
            view.updateSongState(it, player.isPlaying(), player.getProgress())

            view.showRepeat(player.isRepeat)
            view.showRandom(player.isRandom)
        }
    }

    fun updateRepeat(): Boolean {
        player.isRepeat = !player.isRepeat
        return player.isRepeat
    }

    fun updateRandom(): Boolean {
        player.isRandom = !player.isRandom
        return player.isRandom
    }

    fun onSongPlay() {
        if (!player.isPlaying()) {
            player.play()
        } else {
            player.pause()
        }
    }

    fun skipToNext() = player.skipToNext()

    fun skipToPrevious() = player.skipToPrevious()

    fun seekTo(duration: Int) = player.seekTo(duration)
}