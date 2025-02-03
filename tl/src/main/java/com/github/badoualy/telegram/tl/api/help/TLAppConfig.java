package com.github.badoualy.telegram.tl.api.help;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsJSONValue;
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
public class TLAppConfig extends TLAbsAppConfig {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int hash;

    protected TLAbsJSONValue config;

    private final String _constructor = "help.appConfig#0";

    public TLAppConfig() {
    }

    public TLAppConfig(int hash, TLAbsJSONValue config) {
        this.hash = hash;
        this.config = config;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(hash, stream);
        writeTLObject(config, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readInt(stream);
        config = readTLObject(stream, context, TLAbsJSONValue.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += config.computeSerializedSize();
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

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public TLAbsJSONValue getConfig() {
        return config;
    }

    public void setConfig(TLAbsJSONValue config) {
        this.config = config;
    }
}
