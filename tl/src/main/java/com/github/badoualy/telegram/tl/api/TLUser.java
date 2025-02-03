package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUser extends TLAbsUser {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean self;

    protected boolean contact;

    protected boolean mutualContact;

    protected boolean deleted;

    protected boolean bot;

    protected boolean botChatHistory;

    protected boolean botNochats;

    protected boolean verified;

    protected boolean restricted;

    protected boolean min;

    protected boolean botInlineGeo;

    protected boolean support;

    protected boolean scam;

    protected boolean applyMinPhoto;

    protected boolean fake;

    protected boolean botAttachMenu;

    protected boolean premium;

    protected boolean attachMenuEnabled;

    protected int flags2;

    protected boolean botCanEdit;

    protected boolean closeFriend;

    protected boolean storiesHidden;

    protected boolean storiesUnavailable;

    protected boolean contactRequirePremium;

    protected boolean botBusiness;

    protected boolean botHasMainApp;

    protected Long accessHash;

    protected String firstName;

    protected String lastName;

    protected String username;

    protected String phone;

    protected TLAbsUserProfilePhoto photo;

    protected TLAbsUserStatus status;

    protected Integer botInfoVersion;

    protected TLVector<TLRestrictionReason> restrictionReason;

    protected String botInlinePlaceholder;

    protected String langCode;

    protected TLAbsEmojiStatus emojiStatus;

    protected TLVector<TLUsername> usernames;

    protected Integer storiesMaxId;

    protected TLPeerColor color;

    protected TLPeerColor profileColor;

    protected Integer botActiveUsers;

    private final String _constructor = "user#0";

    public TLUser() {
    }

    public TLUser(boolean self, boolean contact, boolean mutualContact, boolean deleted, boolean bot, boolean botChatHistory, boolean botNochats, boolean verified, boolean restricted, boolean min, boolean botInlineGeo, boolean support, boolean scam, boolean applyMinPhoto, boolean fake, boolean botAttachMenu, boolean premium, boolean attachMenuEnabled, boolean botCanEdit, boolean closeFriend, boolean storiesHidden, boolean storiesUnavailable, boolean contactRequirePremium, boolean botBusiness, boolean botHasMainApp, long id, Long accessHash, String firstName, String lastName, String username, String phone, TLAbsUserProfilePhoto photo, TLAbsUserStatus status, Integer botInfoVersion, TLVector<TLRestrictionReason> restrictionReason, String botInlinePlaceholder, String langCode, TLAbsEmojiStatus emojiStatus, TLVector<TLUsername> usernames, Integer storiesMaxId, TLPeerColor color, TLPeerColor profileColor, Integer botActiveUsers) {
        this.self = self;
        this.contact = contact;
        this.mutualContact = mutualContact;
        this.deleted = deleted;
        this.bot = bot;
        this.botChatHistory = botChatHistory;
        this.botNochats = botNochats;
        this.verified = verified;
        this.restricted = restricted;
        this.min = min;
        this.botInlineGeo = botInlineGeo;
        this.support = support;
        this.scam = scam;
        this.applyMinPhoto = applyMinPhoto;
        this.fake = fake;
        this.botAttachMenu = botAttachMenu;
        this.premium = premium;
        this.attachMenuEnabled = attachMenuEnabled;
        this.botCanEdit = botCanEdit;
        this.closeFriend = closeFriend;
        this.storiesHidden = storiesHidden;
        this.storiesUnavailable = storiesUnavailable;
        this.contactRequirePremium = contactRequirePremium;
        this.botBusiness = botBusiness;
        this.botHasMainApp = botHasMainApp;
        this.id = id;
        this.accessHash = accessHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.phone = phone;
        this.photo = photo;
        this.status = status;
        this.botInfoVersion = botInfoVersion;
        this.restrictionReason = restrictionReason;
        this.botInlinePlaceholder = botInlinePlaceholder;
        this.langCode = langCode;
        this.emojiStatus = emojiStatus;
        this.usernames = usernames;
        this.storiesMaxId = storiesMaxId;
        this.color = color;
        this.profileColor = profileColor;
        this.botActiveUsers = botActiveUsers;
    }

    private void computeFlags() {
        flags = 0;
        flags = self ? (flags | 1024) : (flags & ~1024);
        flags = contact ? (flags | 2048) : (flags & ~2048);
        flags = mutualContact ? (flags | 4096) : (flags & ~4096);
        flags = deleted ? (flags | 8192) : (flags & ~8192);
        flags = bot ? (flags | 16384) : (flags & ~16384);
        flags = botChatHistory ? (flags | 32768) : (flags & ~32768);
        flags = botNochats ? (flags | 65536) : (flags & ~65536);
        flags = verified ? (flags | 131072) : (flags & ~131072);
        flags = restricted ? (flags | 262144) : (flags & ~262144);
        flags = min ? (flags | 1048576) : (flags & ~1048576);
        flags = botInlineGeo ? (flags | 2097152) : (flags & ~2097152);
        flags = support ? (flags | 8388608) : (flags & ~8388608);
        flags = scam ? (flags | 16777216) : (flags & ~16777216);
        flags = applyMinPhoto ? (flags | 33554432) : (flags & ~33554432);
        flags = fake ? (flags | 67108864) : (flags & ~67108864);
        flags = botAttachMenu ? (flags | 134217728) : (flags & ~134217728);
        flags = premium ? (flags | 268435456) : (flags & ~268435456);
        flags = attachMenuEnabled ? (flags | 536870912) : (flags & ~536870912);
        flags = accessHash != null ? (flags | 1) : (flags & ~1);
        flags = firstName != null ? (flags | 2) : (flags & ~2);
        flags = lastName != null ? (flags | 4) : (flags & ~4);
        flags = username != null ? (flags | 8) : (flags & ~8);
        flags = phone != null ? (flags | 16) : (flags & ~16);
        flags = photo != null ? (flags | 32) : (flags & ~32);
        flags = status != null ? (flags | 64) : (flags & ~64);
        flags = botInfoVersion != null ? (flags | 16384) : (flags & ~16384);
        flags = restrictionReason != null ? (flags | 262144) : (flags & ~262144);
        flags = botInlinePlaceholder != null ? (flags | 524288) : (flags & ~524288);
        flags = langCode != null ? (flags | 4194304) : (flags & ~4194304);
        flags = emojiStatus != null ? (flags | 1073741824) : (flags & ~1073741824);

        // Following parameters might be forced to true by another field that updated the flags
        self = (flags & 1024) != 0;
        contact = (flags & 2048) != 0;
        mutualContact = (flags & 4096) != 0;
        deleted = (flags & 8192) != 0;
        bot = (flags & 16384) != 0;
        restricted = (flags & 262144) != 0;
    }

    private void computeFlags2() {
        flags2 = 0;
        flags2 = botCanEdit ? (flags2 | 2) : (flags2 & ~2);
        flags2 = closeFriend ? (flags2 | 4) : (flags2 & ~4);
        flags2 = storiesHidden ? (flags2 | 8) : (flags2 & ~8);
        flags2 = storiesUnavailable ? (flags2 | 16) : (flags2 & ~16);
        flags2 = contactRequirePremium ? (flags2 | 1024) : (flags2 & ~1024);
        flags2 = botBusiness ? (flags2 | 2048) : (flags2 & ~2048);
        flags2 = botHasMainApp ? (flags2 | 8192) : (flags2 & ~8192);
        flags2 = usernames != null ? (flags | 1) : (flags2 & ~1);
        flags2 = storiesMaxId != null ? (flags | 32) : (flags2 & ~32);
        flags2 = color != null ? (flags | 256) : (flags2 & ~256);
        flags2 = profileColor != null ? (flags | 512) : (flags2 & ~512);
        flags2 = botActiveUsers != null ? (flags | 4096) : (flags2 & ~4096);

        // Following parameters might be forced to true by another field that updated the flags
        botCanEdit = (flags2 & 2) != 0;
        closeFriend = (flags2 & 4) != 0;
        storiesHidden = (flags2 & 8) != 0;
        storiesUnavailable = (flags2 & 16) != 0;
        contactRequirePremium = (flags2 & 1024) != 0;
        botBusiness = (flags2 & 2048) != 0;
        botHasMainApp = (flags2 & 8192) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        computeFlags2();

        writeInt(flags, stream);
        writeInt(flags2, stream);
        writeLong(id, stream);
        if ((flags & 1) != 0) {
            if (accessHash == null) throwNullFieldException("accessHash", flags);
            writeLong(accessHash, stream);
        }
        if ((flags & 2) != 0) {
            if (firstName == null) throwNullFieldException("firstName", flags);
            writeString(firstName, stream);
        }
        if ((flags & 4) != 0) {
            if (lastName == null) throwNullFieldException("lastName", flags);
            writeString(lastName, stream);
        }
        if ((flags & 8) != 0) {
            if (username == null) throwNullFieldException("username", flags);
            writeString(username, stream);
        }
        if ((flags & 16) != 0) {
            if (phone == null) throwNullFieldException("phone", flags);
            writeString(phone, stream);
        }
        if ((flags & 32) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            writeTLObject(photo, stream);
        }
        if ((flags & 64) != 0) {
            if (status == null) throwNullFieldException("status", flags);
            writeTLObject(status, stream);
        }
        if ((flags & 16384) != 0) {
            if (botInfoVersion == null) throwNullFieldException("botInfoVersion", flags);
            writeInt(botInfoVersion, stream);
        }
        if ((flags & 262144) != 0) {
            if (restrictionReason == null) throwNullFieldException("restrictionReason", flags);
            writeTLVector(restrictionReason, stream);
        }
        if ((flags & 524288) != 0) {
            if (botInlinePlaceholder == null) throwNullFieldException("botInlinePlaceholder", flags);
            writeString(botInlinePlaceholder, stream);
        }
        if ((flags & 4194304) != 0) {
            if (langCode == null) throwNullFieldException("langCode", flags);
            writeString(langCode, stream);
        }
        if ((flags & 1073741824) != 0) {
            if (emojiStatus == null) throwNullFieldException("emojiStatus", flags);
            writeTLObject(emojiStatus, stream);
        }
        if ((flags2 & 1) != 0) {
            if (usernames == null) throwNullFieldException("usernames", flags2);
            writeTLVector(usernames, stream);
        }
        if ((flags2 & 32) != 0) {
            if (storiesMaxId == null) throwNullFieldException("storiesMaxId", flags2);
            writeInt(storiesMaxId, stream);
        }
        if ((flags2 & 256) != 0) {
            if (color == null) throwNullFieldException("color", flags2);
            writeTLObject(color, stream);
        }
        if ((flags2 & 512) != 0) {
            if (profileColor == null) throwNullFieldException("profileColor", flags2);
            writeTLObject(profileColor, stream);
        }
        if ((flags2 & 4096) != 0) {
            if (botActiveUsers == null) throwNullFieldException("botActiveUsers", flags2);
            writeInt(botActiveUsers, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        self = (flags & 1024) != 0;
        contact = (flags & 2048) != 0;
        mutualContact = (flags & 4096) != 0;
        deleted = (flags & 8192) != 0;
        bot = (flags & 16384) != 0;
        botChatHistory = (flags & 32768) != 0;
        botNochats = (flags & 65536) != 0;
        verified = (flags & 131072) != 0;
        restricted = (flags & 262144) != 0;
        min = (flags & 1048576) != 0;
        botInlineGeo = (flags & 2097152) != 0;
        support = (flags & 8388608) != 0;
        scam = (flags & 16777216) != 0;
        applyMinPhoto = (flags & 33554432) != 0;
        fake = (flags & 67108864) != 0;
        botAttachMenu = (flags & 134217728) != 0;
        premium = (flags & 268435456) != 0;
        attachMenuEnabled = (flags & 536870912) != 0;
        flags2 = readInt(stream);
        botCanEdit = (flags2 & 2) != 0;
        closeFriend = (flags2 & 4) != 0;
        storiesHidden = (flags2 & 8) != 0;
        storiesUnavailable = (flags2 & 16) != 0;
        contactRequirePremium = (flags2 & 1024) != 0;
        botBusiness = (flags2 & 2048) != 0;
        botHasMainApp = (flags2 & 8192) != 0;
        id = readLong(stream);
        accessHash = (flags & 1) != 0 ? readLong(stream) : null;
        firstName = (flags & 2) != 0 ? readTLString(stream) : null;
        lastName = (flags & 4) != 0 ? readTLString(stream) : null;
        username = (flags & 8) != 0 ? readTLString(stream) : null;
        phone = (flags & 16) != 0 ? readTLString(stream) : null;
        photo = (flags & 32) != 0 ? readTLObject(stream, context, TLAbsUserProfilePhoto.class, -1) : null;
        status = (flags & 64) != 0 ? readTLObject(stream, context, TLAbsUserStatus.class, -1) : null;
        botInfoVersion = (flags & 16384) != 0 ? readInt(stream) : null;
        restrictionReason = (flags & 262144) != 0 ? readTLVector(stream, context) : null;
        botInlinePlaceholder = (flags & 524288) != 0 ? readTLString(stream) : null;
        langCode = (flags & 4194304) != 0 ? readTLString(stream) : null;
        emojiStatus = (flags & 1073741824) != 0 ? readTLObject(stream, context, TLAbsEmojiStatus.class, -1) : null;
        usernames = (flags2 & 1) != 0 ? readTLVector(stream, context) : null;
        storiesMaxId = (flags2 & 32) != 0 ? readInt(stream) : null;
        color = (flags2 & 256) != 0 ? readTLObject(stream, context, TLPeerColor.class, TLPeerColor.CONSTRUCTOR_ID) : null;
        profileColor = (flags2 & 512) != 0 ? readTLObject(stream, context, TLPeerColor.class, TLPeerColor.CONSTRUCTOR_ID) : null;
        botActiveUsers = (flags2 & 4096) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        computeFlags2();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (accessHash == null) throwNullFieldException("accessHash", flags);
            size += SIZE_INT64;
        }
        if ((flags & 2) != 0) {
            if (firstName == null) throwNullFieldException("firstName", flags);
            size += computeTLStringSerializedSize(firstName);
        }
        if ((flags & 4) != 0) {
            if (lastName == null) throwNullFieldException("lastName", flags);
            size += computeTLStringSerializedSize(lastName);
        }
        if ((flags & 8) != 0) {
            if (username == null) throwNullFieldException("username", flags);
            size += computeTLStringSerializedSize(username);
        }
        if ((flags & 16) != 0) {
            if (phone == null) throwNullFieldException("phone", flags);
            size += computeTLStringSerializedSize(phone);
        }
        if ((flags & 32) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            size += photo.computeSerializedSize();
        }
        if ((flags & 64) != 0) {
            if (status == null) throwNullFieldException("status", flags);
            size += status.computeSerializedSize();
        }
        if ((flags & 16384) != 0) {
            if (botInfoVersion == null) throwNullFieldException("botInfoVersion", flags);
            size += SIZE_INT32;
        }
        if ((flags & 262144) != 0) {
            if (restrictionReason == null) throwNullFieldException("restrictionReason", flags);
            size += restrictionReason.computeSerializedSize();
        }
        if ((flags & 524288) != 0) {
            if (botInlinePlaceholder == null) throwNullFieldException("botInlinePlaceholder", flags);
            size += computeTLStringSerializedSize(botInlinePlaceholder);
        }
        if ((flags & 4194304) != 0) {
            if (langCode == null) throwNullFieldException("langCode", flags);
            size += computeTLStringSerializedSize(langCode);
        }
        if ((flags & 1073741824) != 0) {
            if (emojiStatus == null) throwNullFieldException("emojiStatus", flags);
            size += emojiStatus.computeSerializedSize();
        }
        if ((flags2 & 1) != 0) {
            if (usernames == null) throwNullFieldException("usernames", flags2);
            size += usernames.computeSerializedSize();
        }
        if ((flags2 & 32) != 0) {
            if (storiesMaxId == null) throwNullFieldException("storiesMaxId", flags2);
            size += SIZE_INT32;
        }
        if ((flags2 & 256) != 0) {
            if (color == null) throwNullFieldException("color", flags2);
            size += color.computeSerializedSize();
        }
        if ((flags2 & 512) != 0) {
            if (profileColor == null) throwNullFieldException("profileColor", flags2);
            size += profileColor.computeSerializedSize();
        }
        if ((flags2 & 4096) != 0) {
            if (botActiveUsers == null) throwNullFieldException("botActiveUsers", flags2);
            size += SIZE_INT32;
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

    public boolean getSelf() {
        return self;
    }

    public void setSelf(boolean self) {
        this.self = self;
    }

    public boolean getContact() {
        return contact;
    }

    public void setContact(boolean contact) {
        this.contact = contact;
    }

    public boolean getMutualContact() {
        return mutualContact;
    }

    public void setMutualContact(boolean mutualContact) {
        this.mutualContact = mutualContact;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean getBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }

    public boolean getBotChatHistory() {
        return botChatHistory;
    }

    public void setBotChatHistory(boolean botChatHistory) {
        this.botChatHistory = botChatHistory;
    }

    public boolean getBotNochats() {
        return botNochats;
    }

    public void setBotNochats(boolean botNochats) {
        this.botNochats = botNochats;
    }

    public boolean getVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean getRestricted() {
        return restricted;
    }

    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public boolean getMin() {
        return min;
    }

    public void setMin(boolean min) {
        this.min = min;
    }

    public boolean getBotInlineGeo() {
        return botInlineGeo;
    }

    public void setBotInlineGeo(boolean botInlineGeo) {
        this.botInlineGeo = botInlineGeo;
    }

    public boolean getSupport() {
        return support;
    }

    public void setSupport(boolean support) {
        this.support = support;
    }

    public boolean getScam() {
        return scam;
    }

    public void setScam(boolean scam) {
        this.scam = scam;
    }

    public boolean getApplyMinPhoto() {
        return applyMinPhoto;
    }

    public void setApplyMinPhoto(boolean applyMinPhoto) {
        this.applyMinPhoto = applyMinPhoto;
    }

    public boolean getFake() {
        return fake;
    }

    public void setFake(boolean fake) {
        this.fake = fake;
    }

    public boolean getBotAttachMenu() {
        return botAttachMenu;
    }

    public void setBotAttachMenu(boolean botAttachMenu) {
        this.botAttachMenu = botAttachMenu;
    }

    public boolean getPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public boolean getAttachMenuEnabled() {
        return attachMenuEnabled;
    }

    public void setAttachMenuEnabled(boolean attachMenuEnabled) {
        this.attachMenuEnabled = attachMenuEnabled;
    }

    public boolean getBotCanEdit() {
        return botCanEdit;
    }

    public void setBotCanEdit(boolean botCanEdit) {
        this.botCanEdit = botCanEdit;
    }

    public boolean getCloseFriend() {
        return closeFriend;
    }

    public void setCloseFriend(boolean closeFriend) {
        this.closeFriend = closeFriend;
    }

    public boolean getStoriesHidden() {
        return storiesHidden;
    }

    public void setStoriesHidden(boolean storiesHidden) {
        this.storiesHidden = storiesHidden;
    }

    public boolean getStoriesUnavailable() {
        return storiesUnavailable;
    }

    public void setStoriesUnavailable(boolean storiesUnavailable) {
        this.storiesUnavailable = storiesUnavailable;
    }

    public boolean getContactRequirePremium() {
        return contactRequirePremium;
    }

    public void setContactRequirePremium(boolean contactRequirePremium) {
        this.contactRequirePremium = contactRequirePremium;
    }

    public boolean getBotBusiness() {
        return botBusiness;
    }

    public void setBotBusiness(boolean botBusiness) {
        this.botBusiness = botBusiness;
    }

    public boolean getBotHasMainApp() {
        return botHasMainApp;
    }

    public void setBotHasMainApp(boolean botHasMainApp) {
        this.botHasMainApp = botHasMainApp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(Long accessHash) {
        this.accessHash = accessHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public TLAbsUserProfilePhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsUserProfilePhoto photo) {
        this.photo = photo;
    }

    public TLAbsUserStatus getStatus() {
        return status;
    }

    public void setStatus(TLAbsUserStatus status) {
        this.status = status;
    }

    public Integer getBotInfoVersion() {
        return botInfoVersion;
    }

    public void setBotInfoVersion(Integer botInfoVersion) {
        this.botInfoVersion = botInfoVersion;
    }

    public TLVector<TLRestrictionReason> getRestrictionReason() {
        return restrictionReason;
    }

    public void setRestrictionReason(TLVector<TLRestrictionReason> restrictionReason) {
        this.restrictionReason = restrictionReason;
    }

    public String getBotInlinePlaceholder() {
        return botInlinePlaceholder;
    }

    public void setBotInlinePlaceholder(String botInlinePlaceholder) {
        this.botInlinePlaceholder = botInlinePlaceholder;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public TLAbsEmojiStatus getEmojiStatus() {
        return emojiStatus;
    }

    public void setEmojiStatus(TLAbsEmojiStatus emojiStatus) {
        this.emojiStatus = emojiStatus;
    }

    public TLVector<TLUsername> getUsernames() {
        return usernames;
    }

    public void setUsernames(TLVector<TLUsername> usernames) {
        this.usernames = usernames;
    }

    public Integer getStoriesMaxId() {
        return storiesMaxId;
    }

    public void setStoriesMaxId(Integer storiesMaxId) {
        this.storiesMaxId = storiesMaxId;
    }

    public TLPeerColor getColor() {
        return color;
    }

    public void setColor(TLPeerColor color) {
        this.color = color;
    }

    public TLPeerColor getProfileColor() {
        return profileColor;
    }

    public void setProfileColor(TLPeerColor profileColor) {
        this.profileColor = profileColor;
    }

    public Integer getBotActiveUsers() {
        return botActiveUsers;
    }

    public void setBotActiveUsers(Integer botActiveUsers) {
        this.botActiveUsers = botActiveUsers;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLUser getAsUser() {
        return this;
    }
}
