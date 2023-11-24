package com.amit.musicplayer.player

import android.database.ContentObserver
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Message

/*ContentObserver class is part of the Android framework and is used to monitor
changes to a content provider, such as changes to data in a database.*/


//A Handler is used to schedule messages and runnables on a thread.
class AudioObserver constructor(private val handler: Handler) : ContentObserver(handler) {
    override fun onChange(selfChange: Boolean, uri: Uri?) {
        super.onChange(selfChange, uri)

        if (selfChange) return

        uri?.lastPathSegment?.let {

//            Creates a new Bundle to hold data.
            val b = Bundle()
            b.putString("songID", it)



/*
            The line val msg = Message() creates a new instance of the Message class in Kotlin.
            This is commonly used in Android development when working with a Handler.
*/

            val msg = Message()
            msg.data = b

            handler.sendMessage(msg)
        }
    }
}