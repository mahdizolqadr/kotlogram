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
public class TLChat extends TLAbsChat {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean creator;

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

    private final String _constructor = "chat#0";

    public TLChat() {
    }

    public TLChat(boolean creator, boolean left, boolean deactivated, boolean callActive, boolean callNotEmpty, boolean noforwards, long id, String title, TLAbsChatPhoto photo, int participantsCount, int date, int version, TLAbsInputChannel migratedTo, TLChatAdminRights adminRights, TLChatBannedRights defaultBannedRights) {
        this.creator = creator;
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
        flags = left ? (flags | 4) : (flags & ~4);
        flags = deactivated ? (flags | 32) : (flags & ~32);
        flags = callActive ? (flags | 8388608) : (flags & ~8388608);
        flags = callNotEmpty ? (flags | 16777216) : (flags & ~16777216);
        flags = noforwards ? (flags | 33554432) : (flags & ~33554432);
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
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        creator = (flags & 1) != 0;
        left = (flags & 4) != 0;
        deactivated = (flags & 32) != 0;
        callActive = (flags & 8388608) != 0;
        callNotEmpty = (flags & 16777216) != 0;
        noforwards = (flags & 33554432) != 0;
        id = readLong(stream);
        title = readTLString(stream);
        photo = readTLObject(stream, context, TLAbsChatPhoto.class, -1);
        participantsCount = readInt(stream);
        date = readInt(stream);
        version = readInt(stream);
        migratedTo = (flags & 64) != 0 ? readTLObject(stream, context, TLAbsInputChannel.class, -1) : null;
        adminRights = (flags & 16384) != 0 ? readTLObject(stream, context, TLChatAdminRights.class, TLChatAdminRights.CONSTRUCTOR_ID) : null;
        defaultBannedRights = (flags & 262144) != 0 ? readTLObject(stream, context, TLChatBannedRights.class, TLChatBannedRights.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(title);
        size += photo.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public boolean getCreator() {
        return creator;
    }

    public void setCreator(boolean creator) {
        this.creator = creator;
    }

    public boolean getLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }

    public boolean getCallActive() {
        return callActive;
    }

    public void setCallActive(boolean callActive) {
        this.callActive = callActive;
    }

    public boolean getCallNotEmpty() {
        return callNotEmpty;
    }

    public void setCallNotEmpty(boolean callNotEmpty) {
        this.callNotEmpty = callNotEmpty;
    }

    public boolean getNoforwards() {
        return noforwards;
    }

    public void setNoforwards(boolean noforwards) {
        this.noforwards = noforwards;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
