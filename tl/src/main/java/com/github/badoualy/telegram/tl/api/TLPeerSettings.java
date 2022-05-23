package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPeerSettings extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x733f2961;

    protected int flags;
    protected boolean reportSpam;
    protected boolean addContact;
    protected boolean blockContact;
    protected boolean shareContact;
    protected boolean needContactsException;
    protected boolean reportGeo;
    protected boolean autoarchived;
    protected boolean inviteMembers;
    protected boolean geoDistance;

    private final String _constructor = "peerSettings#733f2961";

    public TLPeerSettings() {
    }

    public TLPeerSettings(boolean reportSpam, boolean addContact, boolean blockContact, boolean shareContact,
                          boolean needContactsException, boolean reportGeo, boolean autoarchived,
                          boolean inviteMembers, boolean geoDistance) {
        this.reportSpam = reportSpam;
        this.addContact = addContact;
        this.blockContact = blockContact;
        this.shareContact = shareContact;
        this.needContactsException = needContactsException;
        this.reportGeo = reportGeo;
        this.autoarchived = autoarchived;
        this.inviteMembers = inviteMembers;
        this.geoDistance = geoDistance;
    }

    private void computeFlags() {
        flags = 0;
        flags = reportSpam ? (flags | 1) : (flags & ~1);
        flags = addContact ? (flags | 2) : (flags & ~2);
        flags = blockContact ? (flags | 4) : (flags & ~4);
        flags = shareContact ? (flags | 8) : (flags & ~8);
        flags = needContactsException ? (flags | 16) : (flags & ~16);
        flags = reportGeo ? (flags | 32) : (flags & ~32);
        flags = autoarchived ? (flags | 128) : (flags & ~128);
        flags = inviteMembers ? (flags | 256) : (flags & ~256);
        flags = geoDistance ? (flags | 64) : (flags & ~64);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        reportSpam = (flags & 1) != 0;
        addContact = (flags & 2) != 0;
        blockContact = (flags & 4) != 0;
        shareContact = (flags & 8) != 0;
        needContactsException = (flags & 16) != 0;
        reportGeo = (flags & 32) != 0;
        autoarchived = (flags & 128) != 0;
        inviteMembers = (flags & 256) != 0;
        geoDistance = (flags & 64) != 0;
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

    public boolean getReportSpam() {
        return reportSpam;
    }

    public void setReportSpam(boolean reportSpam) {
        this.reportSpam = reportSpam;
    }

    public boolean isAddContact() {
        return addContact;
    }

    public void setAddContact(boolean addContact) {
        this.addContact = addContact;
    }

    public boolean isBlockContact() {
        return blockContact;
    }

    public void setBlockContact(boolean blockContact) {
        this.blockContact = blockContact;
    }

    public boolean isShareContact() {
        return shareContact;
    }

    public void setShareContact(boolean shareContact) {
        this.shareContact = shareContact;
    }

    public boolean isNeedContactsException() {
        return needContactsException;
    }

    public void setNeedContactsException(boolean needContactsException) {
        this.needContactsException = needContactsException;
    }

    public boolean isReportGeo() {
        return reportGeo;
    }

    public void setReportGeo(boolean reportGeo) {
        this.reportGeo = reportGeo;
    }

    public boolean isAutoarchived() {
        return autoarchived;
    }

    public void setAutoarchived(boolean autoarchived) {
        this.autoarchived = autoarchived;
    }

    public boolean isInviteMembers() {
        return inviteMembers;
    }

    public void setInviteMembers(boolean inviteMembers) {
        this.inviteMembers = inviteMembers;
    }

    public boolean isGeoDistance() {
        return geoDistance;
    }

    public void setGeoDistance(boolean geoDistance) {
        this.geoDistance = geoDistance;
    }
}
