package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLUpdateBotMessageReaction extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsPeer peer;

    protected int msgId;

    protected int date;

    protected TLAbsPeer actor;

    protected TLVector<TLAbsReaction> oldReactions;

    protected TLVector<TLAbsReaction> newReactions;

    protected int qts;

    private final String _constructor = "updateBotMessageReaction#0";

    public TLUpdateBotMessageReaction() {
    }

    public TLUpdateBotMessageReaction(TLAbsPeer peer, int msgId, int date, TLAbsPeer actor, TLVector<TLAbsReaction> oldReactions, TLVector<TLAbsReaction> newReactions, int qts) {
        this.peer = peer;
        this.msgId = msgId;
        this.date = date;
        this.actor = actor;
        this.oldReactions = oldReactions;
        this.newReactions = newReactions;
        this.qts = qts;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeInt(msgId, stream);
        writeInt(date, stream);
        writeTLObject(actor, stream);
        writeTLVector(oldReactions, stream);
        writeTLVector(newReactions, stream);
        writeInt(qts, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        msgId = readInt(stream);
        date = readInt(stream);
        actor = readTLObject(stream, context, TLAbsPeer.class, -1);
        oldReactions = readTLVector(stream, context);
        newReactions = readTLVector(stream, context);
        qts = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += actor.computeSerializedSize();
        size += oldReactions.computeSerializedSize();
        size += newReactions.computeSerializedSize();
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

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLAbsPeer getActor() {
        return actor;
    }

    public void setActor(TLAbsPeer actor) {
        this.actor = actor;
    }

    public TLVector<TLAbsReaction> getOldReactions() {
        return oldReactions;
    }

    public void setOldReactions(TLVector<TLAbsReaction> oldReactions) {
        this.oldReactions = oldReactions;
    }

    public TLVector<TLAbsReaction> getNewReactions() {
        return newReactions;
    }

    public void setNewReactions(TLVector<TLAbsReaction> newReactions) {
        this.newReactions = newReactions;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }
}
