package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsPeer;
import com.github.badoualy.telegram.tl.api.TLInputChatlistDialogFilter;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestChatlistsGetLeaveChatlistSuggestions extends TLMethod<TLVector<TLAbsPeer>> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLInputChatlistDialogFilter chatlist;

    private final String _constructor = "chatlists.getLeaveChatlistSuggestions#0";

    public TLRequestChatlistsGetLeaveChatlistSuggestions() {
    }

    public TLRequestChatlistsGetLeaveChatlistSuggestions(TLInputChatlistDialogFilter chatlist) {
        this.chatlist = chatlist;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLVector<TLAbsPeer> deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return readTLVector(stream, context);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(chatlist, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chatlist = readTLObject(stream, context, TLInputChatlistDialogFilter.class, TLInputChatlistDialogFilter.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += chatlist.computeSerializedSize();
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
}
