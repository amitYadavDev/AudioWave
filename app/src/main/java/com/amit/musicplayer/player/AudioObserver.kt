package com.amit.musicplayer.player

import android.database.ContentObserver
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Message

/*ContentObserver class is part of the Android framework and is used to monitor
changes to a content provider, such as changes to data in a database.*/
class AudioObserver(private val handler: Handler) : ContentObserver(handler) {
    override fun onChange(selfChange: Boolean, uri: Uri?) {
        super.onChange(selfChange, uri)

        if (selfChange) return

        uri?.lastPathSegment?.let {
            val b = Bundle()
            b.putString("songID", it)

            val msg = Message()
            msg.data = b

            handler.sendMessage(msg)
        }
    }
}