package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChat extends TLAbsChat {

    public static final int CONSTRUCTOR_ID = 0x41cbf256;

    protected int flags;

    protected boolean creator;

    protected boolean kicked;

    protected boolean left;

    protected boolean deactivated;

    protected boolean callActive;

    protected boolean callNotEmpty;

    protected boolean noforwards;

    protected String title;

    protected TLAbsChatPhoto photo;

    protected int participantsCount;

    protected int date;

    protected int version;

    protected TLAbsInputChannel migratedTo;

    protected TLChatAdminRights adminRights;

    protected TLChatBannedRights defaultBannedRights;

    private final String _constructor = "chat#41cbf256";

    public TLChat() {
    }

    public TLChat(boolean creator, boolean kicked, boolean left,
                  boolean deactivated, boolean callActive, boolean callNotEmpty,
                  boolean noforwards, long id,
                  String title, TLAbsChatPhoto photo, int participantsCount,
                  int date, int version, TLAbsInputChannel migratedTo,
                  TLChatAdminRights adminRights, TLChatBannedRights defaultBannedRights) {
        this.creator = creator;
        this.kicked = kicked;
        this.left = left;
        this.deactivated = deactivated;
        this.callActive = callActive;
        this.callNotEmpty = callNotEmpty;
        this.noforwards = noforwards;
        this.id = id;
        this.title = title;
        this.photo = photo;
        this.participantsCount = participantsCount;
        this.date = date;
        this.version = version;
        this.migratedTo = migratedTo;
        this.adminRights = adminRights;
        this.defaultBannedRights = defaultBannedRights;
    }

    private void computeFlags() {
        flags = 0;
        flags = creator ? (flags | 1) : (flags & ~1);
        flags = kicked ? (flags | 2) : (flags & ~2);
        flags = left ? (flags | 4) : (flags & ~4);
        flags = deactivated ? (flags | 32) : (flags & ~32);
        flags = callActive ? (flags | 8388608) : (flags & ~8388608);
        flags = callNotEmpty ? (flags | 16777216) : (flags & ~16777216);
        flags = migratedTo != null ? (flags | 64) : (flags & ~64);
        flags = adminRights != null ? (flags | 16384) : (flags & ~16384);
        flags = defaultBannedRights != null ? (flags | 262144) : (flags & ~262144);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeLong(id, stream);
        writeString(title, stream);
        writeTLObject(photo, stream);
        writeInt(participantsCount, stream);
        writeInt(date, stream);
        writeInt(version, stream);
        if ((flags & 64) != 0) {
            if (migratedTo == null) throwNullFieldException("migratedTo", flags);
            writeTLObject(migratedTo, stream);
        }
        if ((flags & 16384) != 0) {
            if (adminRights == null) throwNullFieldException("adminRights", flags);
            writeTLObject(adminRights, stream);
        }
        if ((flags & 262144) != 0) {
            if (defaultBannedRights == null) throwNullFieldException("defaultBannedRights", flags);
            writeTLObject(defaultBannedRights, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        creator = (flags & 1) != 0;
        kicked = (flags & 2) != 0;
        left = (flags & 4) != 0;
        deactivated = (flags & 32) != 0;
        callActive = (flags & 8388608) != 0;
        callNotEmpty = (flags & 16777216) != 0;
        id = readLong(stream);
        title = readTLString(stream);
        photo = readTLObject(stream, context, TLAbsChatPhoto.class, -1);
        participantsCount = readInt(stream);
        date = readInt(stream);
        version = readInt(stream);
        migratedTo = (flags & 64) != 0 ? readTLObject(stream, context, TLAbsInputChannel.class, -1) : null;
        adminRights = (flags & 16384) != 0 ? readTLObject(stream, context, TLChatAdminRights.class, -1) : null;
        defaultBannedRights = (flags & 262144) != 0 ? readTLObject(stream, context, TLChatBannedRights.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        size += photo.computeSerializedSize();
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += adminRights.computeSerializedSize();
        size += defaultBannedRights.computeSerializedSize();
        if ((flags & 64) != 0) {
            if (migratedTo == null) throwNullFieldException("migratedTo", flags);
            size += migratedTo.computeSerializedSize();
        }
        if ((flags & 16384) != 0) {
            if (adminRights == null) throwNullFieldException("adminRights", flags);
            size += adminRights.computeSerializedSize();
        }
        if ((flags & 262144) != 0) {
            if (defaultBannedRights == null) throwNullFieldException("defaultBannedRights", flags);
            size += defaultBannedRights.computeSerializedSize();
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

    public boolean isCreator() {
        return creator;
    }

    public void setCreator(boolean creator) {
        this.creator = creator;
    }

    public boolean isKicked() {
        return kicked;
    }

    public void setKicked(boolean kicked) {
        this.kicked = kicked;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isDeactivated() {
        return deactivated;
    }

    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }

    public boolean isCallActive() {
        return callActive;
    }

    public void setCallActive(boolean callActive) {
        this.callActive = callActive;
    }

    public boolean isCallNotEmpty() {
        return callNotEmpty;
    }

    public void setCallNotEmpty(boolean callNotEmpty) {
        this.callNotEmpty = callNotEmpty;
    }

    public boolean isNoforwards() {
        return noforwards;
    }

    public void setNoforwards(boolean noforwards) {
        this.noforwards = noforwards;
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

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int participantsCount) {
        this.participantsCount = participantsCount;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public TLAbsInputChannel getMigratedTo() {
        return migratedTo;
    }

    public void setMigratedTo(TLAbsInputChannel migratedTo) {
        this.migratedTo = migratedTo;
    }

    public TLChatAdminRights getAdminRights() {
        return adminRights;
    }

    public void setAdminRights(TLChatAdminRights adminRights) {
        this.adminRights = adminRights;
    }

    public TLChatBannedRights getDefaultBannedRights() {
        return defaultBannedRights;
    }

    public void setDefaultBannedRights(TLChatBannedRights defaultBannedRights) {
        this.defaultBannedRights = defaultBannedRights;
    }
}
