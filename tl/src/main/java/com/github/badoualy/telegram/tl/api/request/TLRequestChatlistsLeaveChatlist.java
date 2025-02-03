package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
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
public class TLRequestChatlistsLeaveChatlist extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLInputChatlistDialogFilter chatlist;

    protected TLVector<TLAbsInputPeer> peers;

    private final String _constructor = "chatlists.leaveChatlist#0";

    public TLRequestChatlistsLeaveChatlist() {
    }

    public TLRequestChatlistsLeaveChatlist(TLInputChatlistDialogFilter chatlist, TLVector<TLAbsInputPeer> peers) {
        this.chatlist = chatlist;
        this.peers = peers;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsUpdates) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(chatlist, stream);
        writeTLVector(peers, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chatlist = readTLObject(stream, context, TLInputChatlistDialogFilter.class, TLInputChatlistDialogFilter.CONSTRUCTOR_ID);
        peers = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += chatlist.computeSerializedSize();
        size += peers.computeSerializedSize();
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

    public TLVector<TLAbsInputPeer> getPeers() {
        return peers;
    }

    public void setPeers(TLVector<TLAbsInputPeer> peers) {
        this.peers = peers;
    }
}
