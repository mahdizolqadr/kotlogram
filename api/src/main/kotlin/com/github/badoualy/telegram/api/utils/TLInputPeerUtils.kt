package com.github.badoualy.telegram.api.utils

import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.api.peer.TLInputPeerChannel
import com.github.badoualy.telegram.tl.api.peer.TLInputPeerChat
import com.github.badoualy.telegram.tl.api.peer.TLInputPeerUser

fun TLUser.toInputPeer() = TLInputPeerUser(id, accessHash)
fun TLAbsChat.toInputPeer() = when (this) {
    is TLChat -> TLInputPeerChat(id)
    is TLChannel -> TLInputPeerChannel(id, accessHash)
    else -> null
}