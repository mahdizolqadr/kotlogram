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
public class TLChannelAdminLogEventsFilter extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean join;

    protected boolean leave;

    protected boolean invite;

    protected boolean ban;

    protected boolean unban;

    protected boolean kick;

    protected boolean unkick;

    protected boolean promote;

    protected boolean demote;

    protected boolean info;

    protected boolean settings;

    protected boolean pinned;

    protected boolean edit;

    protected boolean delete;

    protected boolean groupCall;

    protected boolean invites;

    protected boolean send;

    protected boolean forums;

    protected boolean subExtend;

    private final String _constructor = "channelAdminLogEventsFilter#0";

    public TLChannelAdminLogEventsFilter() {
    }

    public TLChannelAdminLogEventsFilter(boolean join, boolean leave, boolean invite, boolean ban, boolean unban, boolean kick, boolean unkick, boolean promote, boolean demote, boolean info, boolean settings, boolean pinned, boolean edit, boolean delete, boolean groupCall, boolean invites, boolean send, boolean forums, boolean subExtend) {
        this.join = join;
        this.leave = leave;
        this.invite = invite;
        this.ban = ban;
        this.unban = unban;
        this.kick = kick;
        this.unkick = unkick;
        this.promote = promote;
        this.demote = demote;
        this.info = info;
        this.settings = settings;
        this.pinned = pinned;
        this.edit = edit;
        this.delete = delete;
        this.groupCall = groupCall;
        this.invites = invites;
        this.send = send;
        this.forums = forums;
        this.subExtend = subExtend;
    }

    private void computeFlags() {
        flags = 0;
        flags = join ? (flags | 1) : (flags & ~1);
        flags = leave ? (flags | 2) : (flags & ~2);
        flags = invite ? (flags | 4) : (flags & ~4);
        flags = ban ? (flags | 8) : (flags & ~8);
        flags = unban ? (flags | 16) : (flags & ~16);
        flags = kick ? (flags | 32) : (flags & ~32);
        flags = unkick ? (flags | 64) : (flags & ~64);
        flags = promote ? (flags | 128) : (flags & ~128);
        flags = demote ? (flags | 256) : (flags & ~256);
        flags = info ? (flags | 512) : (flags & ~512);
        flags = settings ? (flags | 1024) : (flags & ~1024);
        flags = pinned ? (flags | 2048) : (flags & ~2048);
        flags = edit ? (flags | 4096) : (flags & ~4096);
        flags = delete ? (flags | 8192) : (flags & ~8192);
        flags = groupCall ? (flags | 16384) : (flags & ~16384);
        flags = invites ? (flags | 32768) : (flags & ~32768);
        flags = send ? (flags | 65536) : (flags & ~65536);
        flags = forums ? (flags | 131072) : (flags & ~131072);
        flags = subExtend ? (flags | 262144) : (flags & ~262144);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        join = (flags & 1) != 0;
        leave = (flags & 2) != 0;
        invite = (flags & 4) != 0;
        ban = (flags & 8) != 0;
        unban = (flags & 16) != 0;
        kick = (flags & 32) != 0;
        unkick = (flags & 64) != 0;
        promote = (flags & 128) != 0;
        demote = (flags & 256) != 0;
        info = (flags & 512) != 0;
        settings = (flags & 1024) != 0;
        pinned = (flags & 2048) != 0;
        edit = (flags & 4096) != 0;
        delete = (flags & 8192) != 0;
        groupCall = (flags & 16384) != 0;
        invites = (flags & 32768) != 0;
        send = (flags & 65536) != 0;
        forums = (flags & 131072) != 0;
        subExtend = (flags & 262144) != 0;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
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

    public boolean getJoin() {
        return join;
    }

    public void setJoin(boolean join) {
        this.join = join;
    }

    public boolean getLeave() {
        return leave;
    }

    public void setLeave(boolean leave) {
        this.leave = leave;
    }

    public boolean getInvite() {
        return invite;
    }

    public void setInvite(boolean invite) {
        this.invite = invite;
    }

    public boolean getBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }

    public boolean getUnban() {
        return unban;
    }

    public void setUnban(boolean unban) {
        this.unban = unban;
    }

    public boolean getKick() {
        return kick;
    }

    public void setKick(boolean kick) {
        this.kick = kick;
    }

    public boolean getUnkick() {
        return unkick;
    }

    public void setUnkick(boolean unkick) {
        this.unkick = unkick;
    }

    public boolean getPromote() {
        return promote;
    }

    public void setPromote(boolean promote) {
        this.promote = promote;
    }

    public boolean getDemote() {
        return demote;
    }

    public void setDemote(boolean demote) {
        this.demote = demote;
    }

    public boolean getInfo() {
        return info;
    }

    public void setInfo(boolean info) {
        this.info = info;
    }

    public boolean getSettings() {
        return settings;
    }

    public void setSettings(boolean settings) {
        this.settings = settings;
    }

    public boolean getPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public boolean getEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public boolean getDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean getGroupCall() {
        return groupCall;
    }

    public void setGroupCall(boolean groupCall) {
        this.groupCall = groupCall;
    }

    public boolean getInvites() {
        return invites;
    }

    public void setInvites(boolean invites) {
        this.invites = invites;
    }

    public boolean getSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }

    public boolean getForums() {
        return forums;
    }

    public void setForums(boolean forums) {
        this.forums = forums;
    }

    public boolean getSubExtend() {
        return subExtend;
    }

    public void setSubExtend(boolean subExtend) {
        this.subExtend = subExtend;
    }
}
