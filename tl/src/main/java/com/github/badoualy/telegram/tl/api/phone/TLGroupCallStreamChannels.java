package com.github.badoualy.telegram.tl.api.phone;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLGroupCallStreamChannel;
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
public class TLGroupCallStreamChannels extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLVector<TLGroupCallStreamChannel> channels;

    private final String _constructor = "phone.groupCallStreamChannels#0";

    public TLGroupCallStreamChannels() {
    }

    public TLGroupCallStreamChannels(TLVector<TLGroupCallStreamChannel> channels) {
        this.channels = channels;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(channels, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channels = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += channels.computeSerializedSize();
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

    public TLVector<TLGroupCallStreamChannel> getChannels() {
        return channels;
    }

    public void setChannels(TLVector<TLGroupCallStreamChannel> channels) {
        this.channels = channels;
    }
}
