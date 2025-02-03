package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLDcOption extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean ipv6;

    protected boolean mediaOnly;

    protected boolean tcpoOnly;

    protected boolean cdn;

    protected boolean sstatic;

    protected boolean thisPortOnly;

    protected int id;

    protected String ipAddress;

    protected int port;

    protected TLBytes secret;

    private final String _constructor = "dcOption#0";

    public TLDcOption() {
    }

    public TLDcOption(boolean ipv6, boolean mediaOnly, boolean tcpoOnly, boolean cdn, boolean sstatic, boolean thisPortOnly, int id, String ipAddress, int port, TLBytes secret) {
        this.ipv6 = ipv6;
        this.mediaOnly = mediaOnly;
        this.tcpoOnly = tcpoOnly;
        this.cdn = cdn;
        this.sstatic = sstatic;
        this.thisPortOnly = thisPortOnly;
        this.id = id;
        this.ipAddress = ipAddress;
        this.port = port;
        this.secret = secret;
    }

    private void computeFlags() {
        flags = 0;
        flags = ipv6 ? (flags | 1) : (flags & ~1);
        flags = mediaOnly ? (flags | 2) : (flags & ~2);
        flags = tcpoOnly ? (flags | 4) : (flags & ~4);
        flags = cdn ? (flags | 8) : (flags & ~8);
        flags = sstatic ? (flags | 16) : (flags & ~16);
        flags = thisPortOnly ? (flags | 32) : (flags & ~32);
        flags = secret != null ? (flags | 1024) : (flags & ~1024);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeString(ipAddress, stream);
        writeInt(port, stream);
        if ((flags & 1024) != 0) {
            if (secret == null) throwNullFieldException("secret", flags);
            writeTLBytes(secret, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        ipv6 = (flags & 1) != 0;
        mediaOnly = (flags & 2) != 0;
        tcpoOnly = (flags & 4) != 0;
        cdn = (flags & 8) != 0;
        sstatic = (flags & 16) != 0;
        thisPortOnly = (flags & 32) != 0;
        id = readInt(stream);
        ipAddress = readTLString(stream);
        port = readInt(stream);
        secret = (flags & 1024) != 0 ? readTLBytes(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(ipAddress);
        size += SIZE_INT32;
        if ((flags & 1024) != 0) {
            if (secret == null) throwNullFieldException("secret", flags);
            size += computeTLBytesSerializedSize(secret);
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

    public boolean getIpv6() {
        return ipv6;
    }

    public void setIpv6(boolean ipv6) {
        this.ipv6 = ipv6;
    }

    public boolean getMediaOnly() {
        return mediaOnly;
    }

    public void setMediaOnly(boolean mediaOnly) {
        this.mediaOnly = mediaOnly;
    }

    public boolean getTcpoOnly() {
        return tcpoOnly;
    }

    public void setTcpoOnly(boolean tcpoOnly) {
        this.tcpoOnly = tcpoOnly;
    }

    public boolean getCdn() {
        return cdn;
    }

    public void setCdn(boolean cdn) {
        this.cdn = cdn;
    }

    public boolean getSstatic() {
        return sstatic;
    }

    public void setSstatic(boolean sstatic) {
        this.sstatic = sstatic;
    }

    public boolean getThisPortOnly() {
        return thisPortOnly;
    }

    public void setThisPortOnly(boolean thisPortOnly) {
        this.thisPortOnly = thisPortOnly;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public TLBytes getSecret() {
        return secret;
    }

    public void setSecret(TLBytes secret) {
        this.secret = secret;
    }
}
