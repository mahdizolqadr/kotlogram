package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputFile;
import com.github.badoualy.telegram.tl.api.TLAbsWallPaper;
import com.github.badoualy.telegram.tl.api.TLWallPaperSettings;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestAccountUploadWallPaper extends TLMethod<TLAbsWallPaper> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean forChat;

    protected TLAbsInputFile file;

    protected String mimeType;

    protected TLWallPaperSettings settings;

    private final String _constructor = "account.uploadWallPaper#0";

    public TLRequestAccountUploadWallPaper() {
    }

    public TLRequestAccountUploadWallPaper(boolean forChat, TLAbsInputFile file, String mimeType, TLWallPaperSettings settings) {
        this.forChat = forChat;
        this.file = file;
        this.mimeType = mimeType;
        this.settings = settings;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsWallPaper deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsWallPaper)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsWallPaper) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = forChat ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(file, stream);
        writeString(mimeType, stream);
        writeTLObject(settings, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        forChat = (flags & 1) != 0;
        file = readTLObject(stream, context, TLAbsInputFile.class, -1);
        mimeType = readTLString(stream);
        settings = readTLObject(stream, context, TLWallPaperSettings.class, TLWallPaperSettings.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += file.computeSerializedSize();
        size += computeTLStringSerializedSize(mimeType);
        size += settings.computeSerializedSize();
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

    public boolean getForChat() {
        return forChat;
    }

    public void setForChat(boolean forChat) {
        this.forChat = forChat;
    }

    public TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(TLAbsInputFile file) {
        this.file = file;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public TLWallPaperSettings getSettings() {
        return settings;
    }

    public void setSettings(TLWallPaperSettings settings) {
        this.settings = settings;
    }
}
