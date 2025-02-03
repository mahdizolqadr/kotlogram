package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLPhoneConnectionWebrtc extends TLAbsPhoneConnection {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean turn;

    protected boolean stun;

    protected String username;

    protected String password;

    private final String _constructor = "phoneConnectionWebrtc#0";

    public TLPhoneConnectionWebrtc() {
    }

    public TLPhoneConnectionWebrtc(boolean turn, boolean stun, long id, String ip, String ipv6, int port, String username, String password) {
        this.turn = turn;
        this.stun = stun;
        this.id = id;
        this.ip = ip;
        this.ipv6 = ipv6;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    private void computeFlags() {
        flags = 0;
        flags = turn ? (flags | 1) : (flags & ~1);
        flags = stun ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(id, stream);
        writeString(ip, stream);
        writeString(ipv6, stream);
        writeInt(port, stream);
        writeString(username, stream);
        writeString(password, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        turn = (flags & 1) != 0;
        stun = (flags & 2) != 0;
        id = readLong(stream);
        ip = readTLString(stream);
        ipv6 = readTLString(stream);
        port = readInt(stream);
        username = readTLString(stream);
        password = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(ip);
        size += computeTLStringSerializedSize(ipv6);
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(username);
        size += computeTLStringSerializedSize(password);
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

    public boolean getTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean getStun() {
        return stun;
    }

    public void setStun(boolean stun) {
        this.stun = stun;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
