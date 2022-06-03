package com.github.badoualy.telegram.api.utils

import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.core.TLBytes

fun TLAbsMessageMedia.getLocation(): TLGeoPoint? = when (this) {
    is TLMessageMediaGeo -> if (geo is TLGeoPoint) geo as TLGeoPoint else null
    else -> null
}

fun TLMessageMediaGeo.getLocation(): TLGeoPoint? = when (geo) {
    is TLGeoPoint -> geo as TLGeoPoint
    else -> null
}

fun TLAbsMessageMedia.getAbsMediaInput() = when (this) {
    is TLMessageMediaContact -> null // nothing to download
    is TLMessageMediaDocument -> getMediaInput()
    is TLMessageMediaEmpty -> null // nothing to download
    is TLMessageMediaGeo -> null // nothing to download
    is TLMessageMediaPhoto -> getMediaInput()
    is TLMessageMediaUnsupported -> null // nothing to download
    is TLMessageMediaVenue -> null // nothing to download
    is TLMessageMediaWebPage -> getMediaInput()
    else -> null
}

fun TLAbsMessageMedia.getAbsMediaThumbnailInput() = when (this) {
    is TLMessageMediaContact -> null // nothing to download
    is TLMessageMediaDocument -> getMediaThumbnailInput()
    is TLMessageMediaEmpty -> null // nothing to download
    is TLMessageMediaGeo -> null // nothing to download
    is TLMessageMediaPhoto -> getMediaThumbnailInput()
    is TLMessageMediaUnsupported -> null // nothing to download
    is TLMessageMediaVenue -> null // nothing to download
    is TLMessageMediaWebPage -> getMediaThumbnailInput()
    else -> null
}

fun TLMessageMediaDocument.getMediaInput() = when (document) {
    is TLDocument -> {
        val document = document as TLDocument
        //TODO: fix TLInputDocumentFileLocation if method will be required
        val inputFileLocation = InputFileLocation(TLInputDocumentFileLocation(document.id, document.accessHash, 0), document.dcId)
        MediaInput(inputFileLocation, document.size, document.mimeType)
    }
    else -> null
}

fun TLMessageMediaDocument.getMediaThumbnailInput() = when (document) {
    is TLDocument -> (document as TLDocument).thumbs.get(0).getMediaInput()
    else -> null
}

fun TLMessageMediaPhoto.getMediaInput() = when (photo) {
    is TLPhoto -> (photo as TLPhoto).sizes.getMaxSize()?.getMediaInput()
    else -> null
}

fun TLMessageMediaPhoto.getMediaThumbnailInput() = when (photo) {
    is TLPhoto -> (photo as TLPhoto).sizes.getMinSize()?.getMediaInput()
    else -> null
}

fun TLMessageMediaWebPage.getMediaInput() = when (webpage) {
    is TLWebPage -> {
        val photo = (webpage as TLWebPage).photo
        if (photo is TLPhoto)
            photo.sizes.getMaxSize()?.getMediaInput()
        else null
    }
    else -> null
}

fun TLMessageMediaWebPage.getMediaThumbnailInput() = when (webpage) {
    is TLWebPage -> {
        val photo = (webpage as TLWebPage).photo
        if (photo is TLPhoto)
            photo.sizes.getMinSize()?.getMediaInput()
        else null
    }
    else -> null
}

//TODO: fix getting file location by file id
fun TLAbsPhotoSize?.getMediaInput() = null

fun Collection<TLAbsPhotoSize>?.getMaxSize(): TLAbsPhotoSize? {
    if (this == null || isEmpty())
        return null

    val maxSize = this.filterIsInstance<TLPhotoSize>().sortedByDescending { it.w * it.h }.firstOrNull()
    if (maxSize != null)
        return maxSize

    // No TLPhotoSize, look for cached size
    return this.filterIsInstance<TLPhotoCachedSize>().firstOrNull()
}

fun Collection<TLAbsPhotoSize>?.getMinSize(): TLAbsPhotoSize? {
    if (this == null || isEmpty())
        return null

    // Look for cached size
    val minSize = this.filterIsInstance<TLPhotoCachedSize>().firstOrNull()
    if (minSize != null)
        return minSize

    return this.filterIsInstance<TLPhotoSize>().sortedBy { it.w * it.h }.firstOrNull()
}

fun TLAbsFileLocation.toInputFileLocation() = when (this) {
    is TLFileLocation -> InputFileLocation(TLInputFileLocation(volumeId, localId, secret), dcId)
    is TLFileLocationUnavailable -> null
    else -> null
}

data class MediaInput(val inputFileLocation: InputFileLocation, val size: Int, val mimeType: String, val cached: TLBytes? = null)
data class InputFileLocation(val inputFileLocation: TLAbsInputFileLocation, val dcId: Int)