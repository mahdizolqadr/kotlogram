package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLFolder extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean autofillNewBroadcasts;

    protected boolean autofillPublicGroups;

    protected boolean autofillNewCorrespondents;

    protected int id;

    protected String title;

    protected TLAbsChatPhoto photo;

    private final String _constructor = "folder#0";

    public TLFolder() {
    }

    public TLFolder(boolean autofillNewBroadcasts, boolean autofillPublicGroups, boolean autofillNewCorrespondents, int id, String title, TLAbsChatPhoto photo) {
        this.autofillNewBroadcasts = autofillNewBroadcasts;
        this.autofillPublicGroups = autofillPublicGroups;
        this.autofillNewCorrespondents = autofillNewCorrespondents;
        this.id = id;
        this.title = title;
        this.photo = photo;
    }

    private void computeFlags() {
        flags = 0;
        flags = autofillNewBroadcasts ? (flags | 1) : (flags & ~1);
        flags = autofillPublicGroups ? (flags | 2) : (flags & ~2);
        flags = autofillNewCorrespondents ? (flags | 4) : (flags & ~4);
        flags = photo != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeString(title, stream);
        if ((flags & 8) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            writeTLObject(photo, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        autofillNewBroadcasts = (flags & 1) != 0;
        autofillPublicGroups = (flags & 2) != 0;
        autofillNewCorrespondents = (flags & 4) != 0;
        id = readInt(stream);
        title = readTLString(stream);
        photo = (flags & 8) != 0 ? readTLObject(stream, context, TLAbsChatPhoto.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        if ((flags & 8) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            size += photo.computeSerializedSize();
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

    public boolean getAutofillNewBroadcasts() {
        return autofillNewBroadcasts;
    }

    public void setAutofillNewBroadcasts(boolean autofillNewBroadcasts) {
        this.autofillNewBroadcasts = autofillNewBroadcasts;
    }

    public boolean getAutofillPublicGroups() {
        return autofillPublicGroups;
    }

    public void setAutofillPublicGroups(boolean autofillPublicGroups) {
        this.autofillPublicGroups = autofillPublicGroups;
    }

    public boolean getAutofillNewCorrespondents() {
        return autofillNewCorrespondents;
    }

    public void setAutofillNewCorrespondents(boolean autofillNewCorrespondents) {
        this.autofillNewCorrespondents = autofillNewCorrespondents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TLAbsChatPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsChatPhoto photo) {
        this.photo = photo;
    }
}
