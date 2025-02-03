package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLMessageFwdHeader extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean imported;

    protected boolean savedOut;

    protected TLAbsPeer fromId;

    protected String fromName;

    protected int date;

    protected Integer channelPost;

    protected String postAuthor;

    protected TLAbsPeer savedFromPeer;

    protected Integer savedFromMsgId;

    protected TLAbsPeer savedFromId;

    protected String savedFromName;

    protected Integer savedDate;

    protected String psaType;

    private final String _constructor = "messageFwdHeader#0";

    public TLMessageFwdHeader() {
    }

    public TLMessageFwdHeader(boolean imported, boolean savedOut, TLAbsPeer fromId, String fromName, int date, Integer channelPost, String postAuthor, TLAbsPeer savedFromPeer, Integer savedFromMsgId, TLAbsPeer savedFromId, String savedFromName, Integer savedDate, String psaType) {
        this.imported = imported;
        this.savedOut = savedOut;
        this.fromId = fromId;
        this.fromName = fromName;
        this.date = date;
        this.channelPost = channelPost;
        this.postAuthor = postAuthor;
        this.savedFromPeer = savedFromPeer;
        this.savedFromMsgId = savedFromMsgId;
        this.savedFromId = savedFromId;
        this.savedFromName = savedFromName;
        this.savedDate = savedDate;
        this.psaType = psaType;
    }

    private void computeFlags() {
        flags = 0;
        flags = imported ? (flags | 128) : (flags & ~128);
        flags = savedOut ? (flags | 2048) : (flags & ~2048);
        flags = fromId != null ? (flags | 1) : (flags & ~1);
        flags = fromName != null ? (flags | 32) : (flags & ~32);
        flags = channelPost != null ? (flags | 4) : (flags & ~4);
        flags = postAuthor != null ? (flags | 8) : (flags & ~8);
        flags = savedFromPeer != null ? (flags | 16) : (flags & ~16);
        flags = savedFromMsgId != null ? (flags | 16) : (flags & ~16);
        flags = savedFromId != null ? (flags | 256) : (flags & ~256);
        flags = savedFromName != null ? (flags | 512) : (flags & ~512);
        flags = savedDate != null ? (flags | 1024) : (flags & ~1024);
        flags = psaType != null ? (flags | 64) : (flags & ~64);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            writeTLObject(fromId, stream);
        }
        if ((flags & 32) != 0) {
            if (fromName == null) throwNullFieldException("fromName", flags);
            writeString(fromName, stream);
        }
        writeInt(date, stream);
        if ((flags & 4) != 0) {
            if (channelPost == null) throwNullFieldException("channelPost", flags);
            writeInt(channelPost, stream);
        }
        if ((flags & 8) != 0) {
            if (postAuthor == null) throwNullFieldException("postAuthor", flags);
            writeString(postAuthor, stream);
        }
        if ((flags & 16) != 0) {
            if (savedFromPeer == null) throwNullFieldException("savedFromPeer", flags);
            writeTLObject(savedFromPeer, stream);
        }
        if ((flags & 16) != 0) {
            if (savedFromMsgId == null) throwNullFieldException("savedFromMsgId", flags);
            writeInt(savedFromMsgId, stream);
        }
        if ((flags & 256) != 0) {
            if (savedFromId == null) throwNullFieldException("savedFromId", flags);
            writeTLObject(savedFromId, stream);
        }
        if ((flags & 512) != 0) {
            if (savedFromName == null) throwNullFieldException("savedFromName", flags);
            writeString(savedFromName, stream);
        }
        if ((flags & 1024) != 0) {
            if (savedDate == null) throwNullFieldException("savedDate", flags);
            writeInt(savedDate, stream);
        }
        if ((flags & 64) != 0) {
            if (psaType == null) throwNullFieldException("psaType", flags);
            writeString(psaType, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        imported = (flags & 128) != 0;
        savedOut = (flags & 2048) != 0;
        fromId = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        fromName = (flags & 32) != 0 ? readTLString(stream) : null;
        date = readInt(stream);
        channelPost = (flags & 4) != 0 ? readInt(stream) : null;
        postAuthor = (flags & 8) != 0 ? readTLString(stream) : null;
        savedFromPeer = (flags & 16) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        savedFromMsgId = (flags & 16) != 0 ? readInt(stream) : null;
        savedFromId = (flags & 256) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        savedFromName = (flags & 512) != 0 ? readTLString(stream) : null;
        savedDate = (flags & 1024) != 0 ? readInt(stream) : null;
        psaType = (flags & 64) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            size += fromId.computeSerializedSize();
        }
        if ((flags & 32) != 0) {
            if (fromName == null) throwNullFieldException("fromName", flags);
            size += computeTLStringSerializedSize(fromName);
        }
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (channelPost == null) throwNullFieldException("channelPost", flags);
            size += SIZE_INT32;
        }
        if ((flags & 8) != 0) {
            if (postAuthor == null) throwNullFieldException("postAuthor", flags);
            size += computeTLStringSerializedSize(postAuthor);
        }
        if ((flags & 16) != 0) {
            if (savedFromPeer == null) throwNullFieldException("savedFromPeer", flags);
            size += savedFromPeer.computeSerializedSize();
        }
        if ((flags & 16) != 0) {
            if (savedFromMsgId == null) throwNullFieldException("savedFromMsgId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 256) != 0) {
            if (savedFromId == null) throwNullFieldException("savedFromId", flags);
            size += savedFromId.computeSerializedSize();
        }
        if ((flags & 512) != 0) {
            if (savedFromName == null) throwNullFieldException("savedFromName", flags);
            size += computeTLStringSerializedSize(savedFromName);
        }
        if ((flags & 1024) != 0) {
            if (savedDate == null) throwNullFieldException("savedDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 64) != 0) {
            if (psaType == null) throwNullFieldException("psaType", flags);
            size += computeTLStringSerializedSize(psaType);
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

    public boolean getImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public boolean getSavedOut() {
        return savedOut;
    }

    public void setSavedOut(boolean savedOut) {
        this.savedOut = savedOut;
    }

    public TLAbsPeer getFromId() {
        return fromId;
    }

    public void setFromId(TLAbsPeer fromId) {
        this.fromId = fromId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Integer getChannelPost() {
        return channelPost;
    }

    public void setChannelPost(Integer channelPost) {
        this.channelPost = channelPost;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    public TLAbsPeer getSavedFromPeer() {
        return savedFromPeer;
    }

    public void setSavedFromPeer(TLAbsPeer savedFromPeer) {
        this.savedFromPeer = savedFromPeer;
    }

    public Integer getSavedFromMsgId() {
        return savedFromMsgId;
    }

    public void setSavedFromMsgId(Integer savedFromMsgId) {
        this.savedFromMsgId = savedFromMsgId;
    }

    public TLAbsPeer getSavedFromId() {
        return savedFromId;
    }

    public void setSavedFromId(TLAbsPeer savedFromId) {
        this.savedFromId = savedFromId;
    }

    public String getSavedFromName() {
        return savedFromName;
    }

    public void setSavedFromName(String savedFromName) {
        this.savedFromName = savedFromName;
    }

    public Integer getSavedDate() {
        return savedDate;
    }

    public void setSavedDate(Integer savedDate) {
        this.savedDate = savedDate;
    }

    public String getPsaType() {
        return psaType;
    }

    public void setPsaType(String psaType) {
        this.psaType = psaType;
    }
}
