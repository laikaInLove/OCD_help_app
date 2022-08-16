package com.example.tococd.utils.extension

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

fun<T> Channel<T>.setEffect(effect: T) {
    CoroutineScope(Dispatchers.IO).launch {
        send(effect)
    }
}