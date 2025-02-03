package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLStickerSet extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean archived;

    protected boolean official;

    protected boolean masks;

    protected boolean emojis;

    protected boolean textColor;

    protected boolean channelEmojiStatus;

    protected boolean creator;

    protected Integer installedDate;

    protected long id;

    protected long accessHash;

    protected String title;

    protected String shortName;

    protected TLVector<TLAbsPhotoSize> thumbs;

    protected Integer thumbDcId;

    protected Integer thumbVersion;

    protected Long thumbDocumentId;

    protected int count;

    protected int hash;

    private final String _constructor = "stickerSet#0";

    public TLStickerSet() {
    }

    public TLStickerSet(boolean archived, boolean official, boolean masks, boolean emojis, boolean textColor, boolean channelEmojiStatus, boolean creator, Integer installedDate, long id, long accessHash, String title, String shortName, TLVector<TLAbsPhotoSize> thumbs, Integer thumbDcId, Integer thumbVersion, Long thumbDocumentId, int count, int hash) {
        this.archived = archived;
        this.official = official;
        this.masks = masks;
        this.emojis = emojis;
        this.textColor = textColor;
        this.channelEmojiStatus = channelEmojiStatus;
        this.creator = creator;
        this.installedDate = installedDate;
        this.id = id;
        this.accessHash = accessHash;
        this.title = title;
        this.shortName = shortName;
        this.thumbs = thumbs;
        this.thumbDcId = thumbDcId;
        this.thumbVersion = thumbVersion;
        this.thumbDocumentId = thumbDocumentId;
        this.count = count;
        this.hash = hash;
    }

    private void computeFlags() {
        flags = 0;
        flags = archived ? (flags | 2) : (flags & ~2);
        flags = official ? (flags | 4) : (flags & ~4);
        flags = masks ? (flags | 8) : (flags & ~8);
        flags = emojis ? (flags | 128) : (flags & ~128);
        flags = textColor ? (flags | 512) : (flags & ~512);
        flags = channelEmojiStatus ? (flags | 1024) : (flags & ~1024);
        flags = creator ? (flags | 2048) : (flags & ~2048);
        flags = installedDate != null ? (flags | 1) : (flags & ~1);
        flags = thumbs != null ? (flags | 16) : (flags & ~16);
        flags = thumbDcId != null ? (flags | 16) : (flags & ~16);
        flags = thumbVersion != null ? (flags | 16) : (flags & ~16);
        flags = thumbDocumentId != null ? (flags | 256) : (flags & ~256);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (installedDate == null) throwNullFieldException("installedDate", flags);
            writeInt(installedDate, stream);
        }
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeString(title, stream);
        writeString(shortName, stream);
        if ((flags & 16) != 0) {
            if (thumbs == null) throwNullFieldException("thumbs", flags);
            writeTLVector(thumbs, stream);
        }
        if ((flags & 16) != 0) {
            if (thumbDcId == null) throwNullFieldException("thumbDcId", flags);
            writeInt(thumbDcId, stream);
        }
        if ((flags & 16) != 0) {
            if (thumbVersion == null) throwNullFieldException("thumbVersion", flags);
            writeInt(thumbVersion, stream);
        }
        if ((flags & 256) != 0) {
            if (thumbDocumentId == null) throwNullFieldException("thumbDocumentId", flags);
            writeLong(thumbDocumentId, stream);
        }
        writeInt(count, stream);
        writeInt(hash, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        archived = (flags & 2) != 0;
        official = (flags & 4) != 0;
        masks = (flags & 8) != 0;
        emojis = (flags & 128) != 0;
        textColor = (flags & 512) != 0;
        channelEmojiStatus = (flags & 1024) != 0;
        creator = (flags & 2048) != 0;
        installedDate = (flags & 1) != 0 ? readInt(stream) : null;
        id = readLong(stream);
        accessHash = readLong(stream);
        title = readTLString(stream);
        shortName = readTLString(stream);
        thumbs = (flags & 16) != 0 ? readTLVector(stream, context) : null;
        thumbDcId = (flags & 16) != 0 ? readInt(stream) : null;
        thumbVersion = (flags & 16) != 0 ? readInt(stream) : null;
        thumbDocumentId = (flags & 256) != 0 ? readLong(stream) : null;
        count = readInt(stream);
        hash = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (installedDate == null) throwNullFieldException("installedDate", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(title);
        size += computeTLStringSerializedSize(shortName);
        if ((flags & 16) != 0) {
            if (thumbs == null) throwNullFieldException("thumbs", flags);
            size += thumbs.computeSerializedSize();
        }
        if ((flags & 16) != 0) {
            if (thumbDcId == null) throwNullFieldException("thumbDcId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 16) != 0) {
            if (thumbVersion == null) throwNullFieldException("thumbVersion", flags);
            size += SIZE_INT32;
        }
        if ((flags & 256) != 0) {
            if (thumbDocumentId == null) throwNullFieldException("thumbDocumentId", flags);
            size += SIZE_INT64;
        }
        size += SIZE_INT32;
        size += SIZE_INT32;
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public boolean getArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean getOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    public boolean getMasks() {
        return masks;
    }

    public void setMasks(boolean masks) {
        this.masks = masks;
    }

    public boolean getEmojis() {
        return emojis;
    }

    public void setEmojis(boolean emojis) {
        this.emojis = emojis;
    }

    public boolean getTextColor() {
        return textColor;
    }

    public void setTextColor(boolean textColor) {
        this.textColor = textColor;
    }

    public boolean getChannelEmojiStatus() {
        return channelEmojiStatus;
    }

    public void setChannelEmojiStatus(boolean channelEmojiStatus) {
        this.channelEmojiStatus = channelEmojiStatus;
    }

    public boolean getCreator() {
        return creator;
    }

    public void setCreator(boolean creator) {
        this.creator = creator;
    }

    public Integer getInstalledDate() {
        return installedDate;
    }

    public void setInstalledDate(Integer installedDate) {
        this.installedDate = installedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public TLVector<TLAbsPhotoSize> getThumbs() {
        return thumbs;
    }

    public void setThumbs(TLVector<TLAbsPhotoSize> thumbs) {
        this.thumbs = thumbs;
    }

    public Integer getThumbDcId() {
        return thumbDcId;
    }

    public void setThumbDcId(Integer thumbDcId) {
        this.thumbDcId = thumbDcId;
    }

    public Integer getThumbVersion() {
        return thumbVersion;
    }

    public void setThumbVersion(Integer thumbVersion) {
        this.thumbVersion = thumbVersion;
    }

    public Long getThumbDocumentId() {
        return thumbDocumentId;
    }

    public void setThumbDocumentId(Long thumbDocumentId) {
        this.thumbDocumentId = thumbDocumentId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }
}
