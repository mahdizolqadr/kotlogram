package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLExportedChatlistInvite;
import com.github.badoualy.telegram.tl.api.TLInputChatlistDialogFilter;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestChatlistsEditExportedInvite extends TLMethod<TLExportedChatlistInvite> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLInputChatlistDialogFilter chatlist;

    protected String slug;

    protected String title;

    protected TLVector<TLAbsInputPeer> peers;

    private final String _constructor = "chatlists.editExportedInvite#0";

    public TLRequestChatlistsEditExportedInvite() {
    }

    public TLRequestChatlistsEditExportedInvite(TLInputChatlistDialogFilter chatlist, String slug, String title, TLVector<TLAbsInputPeer> peers) {
        this.chatlist = chatlist;
        this.slug = slug;
        this.title = title;
        this.peers = peers;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLExportedChatlistInvite deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLExportedChatlistInvite)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLExportedChatlistInvite) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = title != null ? (flags | 2) : (flags & ~2);
        flags = peers != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(chatlist, stream);
        writeString(slug, stream);
        if ((flags & 2) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            writeString(title, stream);
        }
        if ((flags & 4) != 0) {
            if (peers == null) throwNullFieldException("peers", flags);
            writeTLVector(peers, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        chatlist = readTLObject(stream, context, TLInputChatlistDialogFilter.class, TLInputChatlistDialogFilter.CONSTRUCTOR_ID);
        slug = readTLString(stream);
        title = (flags & 2) != 0 ? readTLString(stream) : null;
        peers = (flags & 4) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += chatlist.computeSerializedSize();
        size += computeTLStringSerializedSize(slug);
        if ((flags & 2) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            size += computeTLStringSerializedSize(title);
        }
        if ((flags & 4) != 0) {
            if (peers == null) throwNullFieldException("peers", flags);
            size += peers.computeSerializedSize();
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

    public TLInputChatlistDialogFilter getChatlist() {
        return chatlist;
    }

    public void setChatlist(TLInputChatlistDialogFilter chatlist) {
        this.chatlist = chatlist;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TLVector<TLAbsInputPeer> getPeers() {
        return peers;
    }

    public void setPeers(TLVector<TLAbsInputPeer> peers) {
        this.peers = peers;
    }
}
