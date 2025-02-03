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
public class TLGlobalPrivacySettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean archiveAndMuteNewNoncontactPeers;

    protected boolean keepArchivedUnmuted;

    protected boolean keepArchivedFolders;

    protected boolean hideReadMarks;

    protected boolean newNoncontactPeersRequirePremium;

    private final String _constructor = "globalPrivacySettings#0";

    public TLGlobalPrivacySettings() {
    }

    public TLGlobalPrivacySettings(boolean archiveAndMuteNewNoncontactPeers, boolean keepArchivedUnmuted, boolean keepArchivedFolders, boolean hideReadMarks, boolean newNoncontactPeersRequirePremium) {
        this.archiveAndMuteNewNoncontactPeers = archiveAndMuteNewNoncontactPeers;
        this.keepArchivedUnmuted = keepArchivedUnmuted;
        this.keepArchivedFolders = keepArchivedFolders;
        this.hideReadMarks = hideReadMarks;
        this.newNoncontactPeersRequirePremium = newNoncontactPeersRequirePremium;
    }

    private void computeFlags() {
        flags = 0;
        flags = archiveAndMuteNewNoncontactPeers ? (flags | 1) : (flags & ~1);
        flags = keepArchivedUnmuted ? (flags | 2) : (flags & ~2);
        flags = keepArchivedFolders ? (flags | 4) : (flags & ~4);
        flags = hideReadMarks ? (flags | 8) : (flags & ~8);
        flags = newNoncontactPeersRequirePremium ? (flags | 16) : (flags & ~16);
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
        archiveAndMuteNewNoncontactPeers = (flags & 1) != 0;
        keepArchivedUnmuted = (flags & 2) != 0;
        keepArchivedFolders = (flags & 4) != 0;
        hideReadMarks = (flags & 8) != 0;
        newNoncontactPeersRequirePremium = (flags & 16) != 0;
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

    public boolean getArchiveAndMuteNewNoncontactPeers() {
        return archiveAndMuteNewNoncontactPeers;
    }

    public void setArchiveAndMuteNewNoncontactPeers(boolean archiveAndMuteNewNoncontactPeers) {
        this.archiveAndMuteNewNoncontactPeers = archiveAndMuteNewNoncontactPeers;
    }

    public boolean getKeepArchivedUnmuted() {
        return keepArchivedUnmuted;
    }

    public void setKeepArchivedUnmuted(boolean keepArchivedUnmuted) {
        this.keepArchivedUnmuted = keepArchivedUnmuted;
    }

    public boolean getKeepArchivedFolders() {
        return keepArchivedFolders;
    }

    public void setKeepArchivedFolders(boolean keepArchivedFolders) {
        this.keepArchivedFolders = keepArchivedFolders;
    }

    public boolean getHideReadMarks() {
        return hideReadMarks;
    }

    public void setHideReadMarks(boolean hideReadMarks) {
        this.hideReadMarks = hideReadMarks;
    }

    public boolean getNewNoncontactPeersRequirePremium() {
        return newNoncontactPeersRequirePremium;
    }

    public void setNewNoncontactPeersRequirePremium(boolean newNoncontactPeersRequirePremium) {
        this.newNoncontactPeersRequirePremium = newNoncontactPeersRequirePremium;
    }
}
