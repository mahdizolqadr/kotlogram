package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBotInfo extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean hasPreviewMedias;

    protected Long userId;

    protected String description;

    protected TLAbsPhoto descriptionPhoto;

    protected TLAbsDocument descriptionDocument;

    protected TLVector<TLBotCommand> commands;

    protected TLAbsBotMenuButton menuButton;

    protected String privacyPolicyUrl;

    protected TLBotAppSettings appSettings;

    private final String _constructor = "botInfo#0";

    public TLBotInfo() {
    }

    public TLBotInfo(boolean hasPreviewMedias, Long userId, String description, TLAbsPhoto descriptionPhoto, TLAbsDocument descriptionDocument, TLVector<TLBotCommand> commands, TLAbsBotMenuButton menuButton, String privacyPolicyUrl, TLBotAppSettings appSettings) {
        this.hasPreviewMedias = hasPreviewMedias;
        this.userId = userId;
        this.description = description;
        this.descriptionPhoto = descriptionPhoto;
        this.descriptionDocument = descriptionDocument;
        this.commands = commands;
        this.menuButton = menuButton;
        this.privacyPolicyUrl = privacyPolicyUrl;
        this.appSettings = appSettings;
    }

    private void computeFlags() {
        flags = 0;
        flags = hasPreviewMedias ? (flags | 64) : (flags & ~64);
        flags = userId != null ? (flags | 1) : (flags & ~1);
        flags = description != null ? (flags | 2) : (flags & ~2);
        flags = descriptionPhoto != null ? (flags | 16) : (flags & ~16);
        flags = descriptionDocument != null ? (flags | 32) : (flags & ~32);
        flags = commands != null ? (flags | 4) : (flags & ~4);
        flags = menuButton != null ? (flags | 8) : (flags & ~8);
        flags = privacyPolicyUrl != null ? (flags | 128) : (flags & ~128);
        flags = appSettings != null ? (flags | 256) : (flags & ~256);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (userId == null) throwNullFieldException("userId", flags);
            writeLong(userId, stream);
        }
        if ((flags & 2) != 0) {
            if (description == null) throwNullFieldException("description", flags);
            writeString(description, stream);
        }
        if ((flags & 16) != 0) {
            if (descriptionPhoto == null) throwNullFieldException("descriptionPhoto", flags);
            writeTLObject(descriptionPhoto, stream);
        }
        if ((flags & 32) != 0) {
            if (descriptionDocument == null) throwNullFieldException("descriptionDocument", flags);
            writeTLObject(descriptionDocument, stream);
        }
        if ((flags & 4) != 0) {
            if (commands == null) throwNullFieldException("commands", flags);
            writeTLVector(commands, stream);
        }
        if ((flags & 8) != 0) {
            if (menuButton == null) throwNullFieldException("menuButton", flags);
            writeTLObject(menuButton, stream);
        }
        if ((flags & 128) != 0) {
            if (privacyPolicyUrl == null) throwNullFieldException("privacyPolicyUrl", flags);
            writeString(privacyPolicyUrl, stream);
        }
        if ((flags & 256) != 0) {
            if (appSettings == null) throwNullFieldException("appSettings", flags);
            writeTLObject(appSettings, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        hasPreviewMedias = (flags & 64) != 0;
        userId = (flags & 1) != 0 ? readLong(stream) : null;
        description = (flags & 2) != 0 ? readTLString(stream) : null;
        descriptionPhoto = (flags & 16) != 0 ? readTLObject(stream, context, TLAbsPhoto.class, -1) : null;
        descriptionDocument = (flags & 32) != 0 ? readTLObject(stream, context, TLAbsDocument.class, -1) : null;
        commands = (flags & 4) != 0 ? readTLVector(stream, context) : null;
        menuButton = (flags & 8) != 0 ? readTLObject(stream, context, TLAbsBotMenuButton.class, -1) : null;
        privacyPolicyUrl = (flags & 128) != 0 ? readTLString(stream) : null;
        appSettings = (flags & 256) != 0 ? readTLObject(stream, context, TLBotAppSettings.class, TLBotAppSettings.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (userId == null) throwNullFieldException("userId", flags);
            size += SIZE_INT64;
        }
        if ((flags & 2) != 0) {
            if (description == null) throwNullFieldException("description", flags);
            size += computeTLStringSerializedSize(description);
        }
        if ((flags & 16) != 0) {
            if (descriptionPhoto == null) throwNullFieldException("descriptionPhoto", flags);
            size += descriptionPhoto.computeSerializedSize();
        }
        if ((flags & 32) != 0) {
            if (descriptionDocument == null) throwNullFieldException("descriptionDocument", flags);
            size += descriptionDocument.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (commands == null) throwNullFieldException("commands", flags);
            size += commands.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (menuButton == null) throwNullFieldException("menuButton", flags);
            size += menuButton.computeSerializedSize();
        }
        if ((flags & 128) != 0) {
            if (privacyPolicyUrl == null) throwNullFieldException("privacyPolicyUrl", flags);
            size += computeTLStringSerializedSize(privacyPolicyUrl);
        }
        if ((flags & 256) != 0) {
            if (appSettings == null) throwNullFieldException("appSettings", flags);
            size += appSettings.computeSerializedSize();
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

    public boolean getHasPreviewMedias() {
        return hasPreviewMedias;
    }

    public void setHasPreviewMedias(boolean hasPreviewMedias) {
        this.hasPreviewMedias = hasPreviewMedias;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TLAbsPhoto getDescriptionPhoto() {
        return descriptionPhoto;
    }

    public void setDescriptionPhoto(TLAbsPhoto descriptionPhoto) {
        this.descriptionPhoto = descriptionPhoto;
    }

    public TLAbsDocument getDescriptionDocument() {
        return descriptionDocument;
    }

    public void setDescriptionDocument(TLAbsDocument descriptionDocument) {
        this.descriptionDocument = descriptionDocument;
    }

    public TLVector<TLBotCommand> getCommands() {
        return commands;
    }

    public void setCommands(TLVector<TLBotCommand> commands) {
        this.commands = commands;
    }

    public TLAbsBotMenuButton getMenuButton() {
        return menuButton;
    }

    public void setMenuButton(TLAbsBotMenuButton menuButton) {
        this.menuButton = menuButton;
    }

    public String getPrivacyPolicyUrl() {
        return privacyPolicyUrl;
    }

    public void setPrivacyPolicyUrl(String privacyPolicyUrl) {
        this.privacyPolicyUrl = privacyPolicyUrl;
    }

    public TLBotAppSettings getAppSettings() {
        return appSettings;
    }

    public void setAppSettings(TLBotAppSettings appSettings) {
        this.appSettings = appSettings;
    }
}
