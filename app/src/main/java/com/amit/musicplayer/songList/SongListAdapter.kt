package com.amit.musicplayer.songList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amit.musicplayer.databinding.AdapterSongListBinding
import com.amit.musicplayer.model.Song
import com.amit.musicplayer.model.SongItemCallback
import com.amit.musicplayer.model.TimeUtil

class SongListAdapter(private val presenter: SongListPresenter) :
    ListAdapter<Song, SongListAdapter.SongHolder>(SongItemCallback()) {
    inner class SongHolder(val viewBinding: AdapterSongListBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        init {
            itemView.setOnClickListener {
                presenter.onSongClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongHolder {
        val viewBinding =
            AdapterSongListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SongHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: SongHolder, position: Int) {
        val song: Song = getItem(position)

        holder.viewBinding.tvName.text = song.name
        holder.viewBinding.tvArtist.text = song.author
        holder.viewBinding.tvDuration.text = TimeUtil.timeMillisToTime(song.duration)
    }
}