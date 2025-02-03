package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageMediaDocument extends TLAbsMessageMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean nopremium;

    protected boolean spoiler;

    protected boolean video;

    protected boolean round;

    protected boolean voice;

    protected TLAbsDocument document;

    protected TLVector<TLAbsDocument> altDocuments;

    protected Integer ttlSeconds;

    private final String _constructor = "messageMediaDocument#0";

    public TLMessageMediaDocument() {
    }

    public TLMessageMediaDocument(boolean nopremium, boolean spoiler, boolean video, boolean round, boolean voice, TLAbsDocument document, TLVector<TLAbsDocument> altDocuments, Integer ttlSeconds) {
        this.nopremium = nopremium;
        this.spoiler = spoiler;
        this.video = video;
        this.round = round;
        this.voice = voice;
        this.document = document;
        this.altDocuments = altDocuments;
        this.ttlSeconds = ttlSeconds;
    }

    private void computeFlags() {
        flags = 0;
        flags = nopremium ? (flags | 8) : (flags & ~8);
        flags = spoiler ? (flags | 16) : (flags & ~16);
        flags = video ? (flags | 64) : (flags & ~64);
        flags = round ? (flags | 128) : (flags & ~128);
        flags = voice ? (flags | 256) : (flags & ~256);
        flags = document != null ? (flags | 1) : (flags & ~1);
        flags = altDocuments != null ? (flags | 32) : (flags & ~32);
        flags = ttlSeconds != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            writeTLObject(document, stream);
        }
        if ((flags & 32) != 0) {
            if (altDocuments == null) throwNullFieldException("altDocuments", flags);
            writeTLVector(altDocuments, stream);
        }
        if ((flags & 4) != 0) {
            if (ttlSeconds == null) throwNullFieldException("ttlSeconds", flags);
            writeInt(ttlSeconds, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        nopremium = (flags & 8) != 0;
        spoiler = (flags & 16) != 0;
        video = (flags & 64) != 0;
        round = (flags & 128) != 0;
        voice = (flags & 256) != 0;
        document = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsDocument.class, -1) : null;
        altDocuments = (flags & 32) != 0 ? readTLVector(stream, context) : null;
        ttlSeconds = (flags & 4) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            size += document.computeSerializedSize();
        }
        if ((flags & 32) != 0) {
            if (altDocuments == null) throwNullFieldException("altDocuments", flags);
            size += altDocuments.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (ttlSeconds == null) throwNullFieldException("ttlSeconds", flags);
            size += SIZE_INT32;
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

    public boolean getNopremium() {
        return nopremium;
    }

    public void setNopremium(boolean nopremium) {
        this.nopremium = nopremium;
    }

    public boolean getSpoiler() {
        return spoiler;
    }

    public void setSpoiler(boolean spoiler) {
        this.spoiler = spoiler;
    }

    public boolean getVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public boolean getRound() {
        return round;
    }

    public void setRound(boolean round) {
        this.round = round;
    }

    public boolean getVoice() {
        return voice;
    }

    public void setVoice(boolean voice) {
        this.voice = voice;
    }

    public TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsDocument document) {
        this.document = document;
    }

    public TLVector<TLAbsDocument> getAltDocuments() {
        return altDocuments;
    }

    public void setAltDocuments(TLVector<TLAbsDocument> altDocuments) {
        this.altDocuments = altDocuments;
    }

    public Integer getTtlSeconds() {
        return ttlSeconds;
    }

    public void setTtlSeconds(Integer ttlSeconds) {
        this.ttlSeconds = ttlSeconds;
    }
}
