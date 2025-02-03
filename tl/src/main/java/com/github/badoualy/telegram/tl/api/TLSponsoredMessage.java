package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSponsoredMessage extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean recommended;

    protected boolean canReport;

    protected TLBytes randomId;

    protected String url;

    protected String title;

    protected String message;

    protected TLVector<TLAbsMessageEntity> entities;

    protected TLAbsPhoto photo;

    protected TLAbsMessageMedia media;

    protected TLPeerColor color;

    protected String buttonText;

    protected String sponsorInfo;

    protected String additionalInfo;

    private final String _constructor = "sponsoredMessage#0";

    public TLSponsoredMessage() {
    }

    public TLSponsoredMessage(boolean recommended, boolean canReport, TLBytes randomId, String url, String title, String message, TLVector<TLAbsMessageEntity> entities, TLAbsPhoto photo, TLAbsMessageMedia media, TLPeerColor color, String buttonText, String sponsorInfo, String additionalInfo) {
        this.recommended = recommended;
        this.canReport = canReport;
        this.randomId = randomId;
        this.url = url;
        this.title = title;
        this.message = message;
        this.entities = entities;
        this.photo = photo;
        this.media = media;
        this.color = color;
        this.buttonText = buttonText;
        this.sponsorInfo = sponsorInfo;
        this.additionalInfo = additionalInfo;
    }

    private void computeFlags() {
        flags = 0;
        flags = recommended ? (flags | 32) : (flags & ~32);
        flags = canReport ? (flags | 4096) : (flags & ~4096);
        flags = entities != null ? (flags | 2) : (flags & ~2);
        flags = photo != null ? (flags | 64) : (flags & ~64);
        flags = media != null ? (flags | 16384) : (flags & ~16384);
        flags = color != null ? (flags | 8192) : (flags & ~8192);
        flags = sponsorInfo != null ? (flags | 128) : (flags & ~128);
        flags = additionalInfo != null ? (flags | 256) : (flags & ~256);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLBytes(randomId, stream);
        writeString(url, stream);
        writeString(title, stream);
        writeString(message, stream);
        if ((flags & 2) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            writeTLVector(entities, stream);
        }
        if ((flags & 64) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            writeTLObject(photo, stream);
        }
        if ((flags & 16384) != 0) {
            if (media == null) throwNullFieldException("media", flags);
            writeTLObject(media, stream);
        }
        if ((flags & 8192) != 0) {
            if (color == null) throwNullFieldException("color", flags);
            writeTLObject(color, stream);
        }
        writeString(buttonText, stream);
        if ((flags & 128) != 0) {
            if (sponsorInfo == null) throwNullFieldException("sponsorInfo", flags);
            writeString(sponsorInfo, stream);
        }
        if ((flags & 256) != 0) {
            if (additionalInfo == null) throwNullFieldException("additionalInfo", flags);
            writeString(additionalInfo, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        recommended = (flags & 32) != 0;
        canReport = (flags & 4096) != 0;
        randomId = readTLBytes(stream, context);
        url = readTLString(stream);
        title = readTLString(stream);
        message = readTLString(stream);
        entities = (flags & 2) != 0 ? readTLVector(stream, context) : null;
        photo = (flags & 64) != 0 ? readTLObject(stream, context, TLAbsPhoto.class, -1) : null;
        media = (flags & 16384) != 0 ? readTLObject(stream, context, TLAbsMessageMedia.class, -1) : null;
        color = (flags & 8192) != 0 ? readTLObject(stream, context, TLPeerColor.class, TLPeerColor.CONSTRUCTOR_ID) : null;
        buttonText = readTLString(stream);
        sponsorInfo = (flags & 128) != 0 ? readTLString(stream) : null;
        additionalInfo = (flags & 256) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(randomId);
        size += computeTLStringSerializedSize(url);
        size += computeTLStringSerializedSize(title);
        size += computeTLStringSerializedSize(message);
        if ((flags & 2) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            size += entities.computeSerializedSize();
        }
        if ((flags & 64) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            size += photo.computeSerializedSize();
        }
        if ((flags & 16384) != 0) {
            if (media == null) throwNullFieldException("media", flags);
            size += media.computeSerializedSize();
        }
        if ((flags & 8192) != 0) {
            if (color == null) throwNullFieldException("color", flags);
            size += color.computeSerializedSize();
        }
        size += computeTLStringSerializedSize(buttonText);
        if ((flags & 128) != 0) {
            if (sponsorInfo == null) throwNullFieldException("sponsorInfo", flags);
            size += computeTLStringSerializedSize(sponsorInfo);
        }
        if ((flags & 256) != 0) {
            if (additionalInfo == null) throwNullFieldException("additionalInfo", flags);
            size += computeTLStringSerializedSize(additionalInfo);
        }
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

    public boolean getRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public boolean getCanReport() {
        return canReport;
    }

    public void setCanReport(boolean canReport) {
        this.canReport = canReport;
    }

    public TLBytes getRandomId() {
        return randomId;
    }

    public void setRandomId(TLBytes randomId) {
        this.randomId = randomId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }

    public TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsPhoto photo) {
        this.photo = photo;
    }

    public TLAbsMessageMedia getMedia() {
        return media;
    }

    public void setMedia(TLAbsMessageMedia media) {
        this.media = media;
    }

    public TLPeerColor getColor() {
        return color;
    }

    public void setColor(TLPeerColor color) {
        this.color = color;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getSponsorInfo() {
        return sponsorInfo;
    }

    public void setSponsorInfo(String sponsorInfo) {
        this.sponsorInfo = sponsorInfo;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
