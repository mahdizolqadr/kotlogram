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
public class TLUpdateBotBusinessConnect extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLBotBusinessConnection connection;

    protected int qts;

    private final String _constructor = "updateBotBusinessConnect#0";

    public TLUpdateBotBusinessConnect() {
    }

    public TLUpdateBotBusinessConnect(TLBotBusinessConnection connection, int qts) {
        this.connection = connection;
        this.qts = qts;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(connection, stream);
        writeInt(qts, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        connection = readTLObject(stream, context, TLBotBusinessConnection.class, TLBotBusinessConnection.CONSTRUCTOR_ID);
        qts = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += connection.computeSerializedSize();
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

    public TLBotBusinessConnection getConnection() {
        return connection;
    }

    public void setConnection(TLBotBusinessConnection connection) {
        this.connection = connection;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }
}
