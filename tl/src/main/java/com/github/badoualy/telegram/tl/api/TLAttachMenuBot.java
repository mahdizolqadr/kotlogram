package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLAttachMenuBot extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean inactive;

    protected boolean hasSettings;

    protected boolean requestWriteAccess;

    protected boolean showInAttachMenu;

    protected boolean showInSideMenu;

    protected boolean sideMenuDisclaimerNeeded;

    protected long botId;

    protected String shortName;

    protected TLVector<TLAbsAttachMenuPeerType> peerTypes;

    protected TLVector<TLAttachMenuBotIcon> icons;

    private final String _constructor = "attachMenuBot#0";

    public TLAttachMenuBot() {
    }

    public TLAttachMenuBot(boolean inactive, boolean hasSettings, boolean requestWriteAccess, boolean showInAttachMenu, boolean showInSideMenu, boolean sideMenuDisclaimerNeeded, long botId, String shortName, TLVector<TLAbsAttachMenuPeerType> peerTypes, TLVector<TLAttachMenuBotIcon> icons) {
        this.inactive = inactive;
        this.hasSettings = hasSettings;
        this.requestWriteAccess = requestWriteAccess;
        this.showInAttachMenu = showInAttachMenu;
        this.showInSideMenu = showInSideMenu;
        this.sideMenuDisclaimerNeeded = sideMenuDisclaimerNeeded;
        this.botId = botId;
        this.shortName = shortName;
        this.peerTypes = peerTypes;
        this.icons = icons;
    }

    private void computeFlags() {
        flags = 0;
        flags = inactive ? (flags | 1) : (flags & ~1);
        flags = hasSettings ? (flags | 2) : (flags & ~2);
        flags = requestWriteAccess ? (flags | 4) : (flags & ~4);
        flags = showInAttachMenu ? (flags | 8) : (flags & ~8);
        flags = showInSideMenu ? (flags | 16) : (flags & ~16);
        flags = sideMenuDisclaimerNeeded ? (flags | 32) : (flags & ~32);
        flags = peerTypes != null ? (flags | 8) : (flags & ~8);

        // Following parameters might be forced to true by another field that updated the flags
        showInAttachMenu = (flags & 8) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(botId, stream);
        writeString(shortName, stream);
        if ((flags & 8) != 0) {
            if (peerTypes == null) throwNullFieldException("peerTypes", flags);
            writeTLVector(peerTypes, stream);
        }
        writeTLVector(icons, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        inactive = (flags & 1) != 0;
        hasSettings = (flags & 2) != 0;
        requestWriteAccess = (flags & 4) != 0;
        showInAttachMenu = (flags & 8) != 0;
        showInSideMenu = (flags & 16) != 0;
        sideMenuDisclaimerNeeded = (flags & 32) != 0;
        botId = readLong(stream);
        shortName = readTLString(stream);
        peerTypes = (flags & 8) != 0 ? readTLVector(stream, context) : null;
        icons = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(shortName);
        if ((flags & 8) != 0) {
            if (peerTypes == null) throwNullFieldException("peerTypes", flags);
            size += peerTypes.computeSerializedSize();
        }
        size += icons.computeSerializedSize();
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

    public boolean getInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public boolean getHasSettings() {
        return hasSettings;
    }

    public void setHasSettings(boolean hasSettings) {
        this.hasSettings = hasSettings;
    }

    public boolean getRequestWriteAccess() {
        return requestWriteAccess;
    }

    public void setRequestWriteAccess(boolean requestWriteAccess) {
        this.requestWriteAccess = requestWriteAccess;
    }

    public boolean getShowInAttachMenu() {
        return showInAttachMenu;
    }

    public void setShowInAttachMenu(boolean showInAttachMenu) {
        this.showInAttachMenu = showInAttachMenu;
    }

    public boolean getShowInSideMenu() {
        return showInSideMenu;
    }

    public void setShowInSideMenu(boolean showInSideMenu) {
        this.showInSideMenu = showInSideMenu;
    }

    public boolean getSideMenuDisclaimerNeeded() {
        return sideMenuDisclaimerNeeded;
    }

    public void setSideMenuDisclaimerNeeded(boolean sideMenuDisclaimerNeeded) {
        this.sideMenuDisclaimerNeeded = sideMenuDisclaimerNeeded;
    }

    public long getBotId() {
        return botId;
    }

    public void setBotId(long botId) {
        this.botId = botId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public TLVector<TLAbsAttachMenuPeerType> getPeerTypes() {
        return peerTypes;
    }

    public void setPeerTypes(TLVector<TLAbsAttachMenuPeerType> peerTypes) {
        this.peerTypes = peerTypes;
    }

    public TLVector<TLAttachMenuBotIcon> getIcons() {
        return icons;
    }

    public void setIcons(TLVector<TLAttachMenuBotIcon> icons) {
        this.icons = icons;
    }
}
