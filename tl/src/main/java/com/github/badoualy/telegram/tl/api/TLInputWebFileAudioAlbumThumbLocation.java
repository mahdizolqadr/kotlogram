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
public class TLInputWebFileAudioAlbumThumbLocation extends TLAbsInputWebFileLocation {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean small;

    protected TLAbsInputDocument document;

    protected String title;

    protected String performer;

    private final String _constructor = "inputWebFileAudioAlbumThumbLocation#0";

    public TLInputWebFileAudioAlbumThumbLocation() {
    }

    public TLInputWebFileAudioAlbumThumbLocation(boolean small, TLAbsInputDocument document, String title, String performer) {
        this.small = small;
        this.document = document;
        this.title = title;
        this.performer = performer;
    }

    private void computeFlags() {
        flags = 0;
        flags = small ? (flags | 4) : (flags & ~4);
        flags = document != null ? (flags | 1) : (flags & ~1);
        flags = title != null ? (flags | 2) : (flags & ~2);
        flags = performer != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            writeTLObject(document, stream);
        }
        if ((flags & 2) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            writeString(title, stream);
        }
        if ((flags & 2) != 0) {
            if (performer == null) throwNullFieldException("performer", flags);
            writeString(performer, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        small = (flags & 4) != 0;
        document = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsInputDocument.class, -1) : null;
        title = (flags & 2) != 0 ? readTLString(stream) : null;
        performer = (flags & 2) != 0 ? readTLString(stream) : null;
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
        if ((flags & 2) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            size += computeTLStringSerializedSize(title);
        }
        if ((flags & 2) != 0) {
            if (performer == null) throwNullFieldException("performer", flags);
            size += computeTLStringSerializedSize(performer);
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

    public boolean getSmall() {
        return small;
    }

    public void setSmall(boolean small) {
        this.small = small;
    }

    public TLAbsInputDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsInputDocument document) {
        this.document = document;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }
}
