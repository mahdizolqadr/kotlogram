package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.api.call.TLInputGroupCall;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLChannelFull}: channelFull#e9b27a17</li>
 * <li>{@link TLChatFull}: chatFull#4dbdc099</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsChatFull extends TLObject {

    protected boolean canSetUsername;
    protected boolean hasScheduled;
    protected long id;
    protected String about;
    protected TLAbsPhoto chatPhoto;
    protected TLPeerNotifySettings notifySettings;
    protected TLChatInviteExported exportedInvite;
    protected TLVector<TLBotInfo> botInfo;
    protected Integer pinnedMsgId;
    protected Integer folderId;
    protected TLInputGroupCall call;
    protected Integer ttlPeriod;
    protected TLAbsPeer groupcallDefaultJoinAs;
    protected String themeEmoticon;

    public TLAbsChatFull() {
    }

    public boolean isCanSetUsername() {
        return canSetUsername;
    }

    public void setCanSetUsername(boolean canSetUsername) {
        this.canSetUsername = canSetUsername;
    }

    public boolean isHasScheduled() {
        return hasScheduled;
    }

    public void setHasScheduled(boolean hasScheduled) {
        this.hasScheduled = hasScheduled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public TLAbsPhoto getChatPhoto() {
        return chatPhoto;
    }

    public void setChatPhoto(TLAbsPhoto chatPhoto) {
        this.chatPhoto = chatPhoto;
    }

    public TLPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(TLPeerNotifySettings notifySettings) {
        this.notifySettings = notifySettings;
    }

    public TLChatInviteExported getExportedInvite() {
        return exportedInvite;
    }

    public void setExportedInvite(TLChatInviteExported exportedInvite) {
        this.exportedInvite = exportedInvite;
    }

    public TLVector<TLBotInfo> getBotInfo() {
        return botInfo;
    }

    public void setBotInfo(TLVector<TLBotInfo> botInfo) {
        this.botInfo = botInfo;
    }

    public Integer getPinnedMsgId() {
        return pinnedMsgId;
    }

    public void setPinnedMsgId(Integer pinnedMsgId) {
        this.pinnedMsgId = pinnedMsgId;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public TLInputGroupCall getCall() {
        return call;
    }

    public void setCall(TLInputGroupCall call) {
        this.call = call;
    }

    public Integer getTtlPeriod() {
        return ttlPeriod;
    }

    public void setTtlPeriod(Integer ttlPeriod) {
        this.ttlPeriod = ttlPeriod;
    }

    public TLAbsPeer getGroupcallDefaultJoinAs() {
        return groupcallDefaultJoinAs;
    }

    public void setGroupcallDefaultJoinAs(TLAbsPeer groupcallDefaultJoinAs) {
        this.groupcallDefaultJoinAs = groupcallDefaultJoinAs;
    }

    public String getThemeEmoticon() {
        return themeEmoticon;
    }

    public void setThemeEmoticon(String themeEmoticon) {
        this.themeEmoticon = themeEmoticon;
    }
}
