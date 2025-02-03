package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLPhoneCallRequested extends TLAbsPhoneCall {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean video;

    protected long accessHash;

    protected int date;

    protected long adminId;

    protected long participantId;

    protected TLBytes gAHash;

    protected TLPhoneCallProtocol protocol;

    private final String _constructor = "phoneCallRequested#0";

    public TLPhoneCallRequested() {
    }

    public TLPhoneCallRequested(boolean video, long id, long accessHash, int date, long adminId, long participantId, TLBytes gAHash, TLPhoneCallProtocol protocol) {
        this.video = video;
        this.id = id;
        this.accessHash = accessHash;
        this.date = date;
        this.adminId = adminId;
        this.participantId = participantId;
        this.gAHash = gAHash;
        this.protocol = protocol;
    }

    private void computeFlags() {
        flags = 0;
        flags = video ? (flags | 64) : (flags & ~64);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeInt(date, stream);
        writeLong(adminId, stream);
        writeLong(participantId, stream);
        writeTLBytes(gAHash, stream);
        writeTLObject(protocol, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        video = (flags & 64) != 0;
        id = readLong(stream);
        accessHash = readLong(stream);
        date = readInt(stream);
        adminId = readLong(stream);
        participantId = readLong(stream);
        gAHash = readTLBytes(stream, context);
        protocol = readTLObject(stream, context, TLPhoneCallProtocol.class, TLPhoneCallProtocol.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLBytesSerializedSize(gAHash);
        size += protocol.computeSerializedSize();
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

    public boolean getVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(long participantId) {
        this.participantId = participantId;
    }

    public TLBytes getGAHash() {
        return gAHash;
    }

    public void setGAHash(TLBytes gAHash) {
        this.gAHash = gAHash;
    }

    public TLPhoneCallProtocol getProtocol() {
        return protocol;
    }

    public void setProtocol(TLPhoneCallProtocol protocol) {
        this.protocol = protocol;
    }
}
