package com.github.badoualy.telegram.api.utils

import com.github.badoualy.telegram.tl.api.TLAbsInputFileLocation
import com.github.badoualy.telegram.tl.api.TLAbsMessageMedia
import com.github.badoualy.telegram.tl.api.TLAbsPhotoSize
import com.github.badoualy.telegram.tl.api.TLDocument
import com.github.badoualy.telegram.tl.api.TLGeoPoint
import com.github.badoualy.telegram.tl.api.TLInputDocumentFileLocation
import com.github.badoualy.telegram.tl.api.TLMessageMediaContact
import com.github.badoualy.telegram.tl.api.TLMessageMediaDocument
import com.github.badoualy.telegram.tl.api.TLMessageMediaEmpty
import com.github.badoualy.telegram.tl.api.TLMessageMediaGeo
import com.github.badoualy.telegram.tl.api.TLMessageMediaPhoto
import com.github.badoualy.telegram.tl.api.TLMessageMediaUnsupported
import com.github.badoualy.telegram.tl.api.TLMessageMediaVenue
import com.github.badoualy.telegram.tl.api.TLMessageMediaWebPage
import com.github.badoualy.telegram.tl.api.TLPhoto
import com.github.badoualy.telegram.tl.api.TLPhotoCachedSize
import com.github.badoualy.telegram.tl.api.TLPhotoSize
import com.github.badoualy.telegram.tl.api.TLWebPage
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
        val inputFileLocation = InputFileLocation(
            TLInputDocumentFileLocation(document.id, document.accessHash, document.fileReference, ""),
            document.dcId
        )
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

fun Collection<TLAbsPhotoSize>?.getMaxSize() = this?.getFilteredPhotoSize {
    filterIsInstance<TLPhotoSize>().sortedByDescending { it.w * it.h }.firstOrNull()
        ?: filterIsInstance<TLPhotoCachedSize>().firstOrNull()
}

fun Collection<TLAbsPhotoSize>?.getMinSize() = this?.getFilteredPhotoSize {
    filterIsInstance<TLPhotoCachedSize>().firstOrNull()
        ?: filterIsInstance<TLPhotoSize>().sortedBy { it.w * it.h }.firstOrNull()
}

data class MediaInput(
    val inputFileLocation: InputFileLocation,
    val size: Int,
    val mimeType: String,
    val cached: TLBytes? = null
)

data class InputFileLocation(val inputFileLocation: TLAbsInputFileLocation, val dcId: Int)

fun Collection<TLAbsPhotoSize>.getFilteredPhotoSize(filter: Collection<TLAbsPhotoSize>.() -> TLAbsPhotoSize?) =
    if (isNotEmpty()) filter() else null
