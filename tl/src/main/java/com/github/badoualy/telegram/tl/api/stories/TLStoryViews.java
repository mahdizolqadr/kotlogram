package com.github.badoualy.telegram.tl.api.stories;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
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
public class TLStoryViews extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLVector<com.github.badoualy.telegram.tl.api.TLStoryViews> views;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "stories.storyViews#0";

    public TLStoryViews() {
    }

    public TLStoryViews(TLVector<com.github.badoualy.telegram.tl.api.TLStoryViews> views, TLVector<TLAbsUser> users) {
        this.views = views;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(views, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        views = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += views.computeSerializedSize();
        size += users.computeSerializedSize();
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

    public TLVector<com.github.badoualy.telegram.tl.api.TLStoryViews> getViews() {
        return views;
    }

    public void setViews(TLVector<com.github.badoualy.telegram.tl.api.TLStoryViews> views) {
        this.views = views;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
