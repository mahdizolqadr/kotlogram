package com.github.badoualy.telegram.tl.api.help;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsDocument;
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLPremiumSubscriptionOption;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLStringVector;
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
public class TLPremiumPromo extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String statusText;

    protected TLVector<TLAbsMessageEntity> statusEntities;

    protected TLStringVector videoSections;

    protected TLVector<TLAbsDocument> videos;

    protected TLVector<TLPremiumSubscriptionOption> periodOptions;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "help.premiumPromo#0";

    public TLPremiumPromo() {
    }

    public TLPremiumPromo(String statusText, TLVector<TLAbsMessageEntity> statusEntities, TLStringVector videoSections, TLVector<TLAbsDocument> videos, TLVector<TLPremiumSubscriptionOption> periodOptions, TLVector<TLAbsUser> users) {
        this.statusText = statusText;
        this.statusEntities = statusEntities;
        this.videoSections = videoSections;
        this.videos = videos;
        this.periodOptions = periodOptions;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(statusText, stream);
        writeTLVector(statusEntities, stream);
        writeTLVector(videoSections, stream);
        writeTLVector(videos, stream);
        writeTLVector(periodOptions, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        statusText = readTLString(stream);
        statusEntities = readTLVector(stream, context);
        videoSections = readTLStringVector(stream, context);
        videos = readTLVector(stream, context);
        periodOptions = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(statusText);
        size += statusEntities.computeSerializedSize();
        size += videoSections.computeSerializedSize();
        size += videos.computeSerializedSize();
        size += periodOptions.computeSerializedSize();
        size += users.computeSerializedSize();
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

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public TLVector<TLAbsMessageEntity> getStatusEntities() {
        return statusEntities;
    }

    public void setStatusEntities(TLVector<TLAbsMessageEntity> statusEntities) {
        this.statusEntities = statusEntities;
    }

    public TLStringVector getVideoSections() {
        return videoSections;
    }

    public void setVideoSections(TLStringVector videoSections) {
        this.videoSections = videoSections;
    }

    public TLVector<TLAbsDocument> getVideos() {
        return videos;
    }

    public void setVideos(TLVector<TLAbsDocument> videos) {
        this.videos = videos;
    }

    public TLVector<TLPremiumSubscriptionOption> getPeriodOptions() {
        return periodOptions;
    }

    public void setPeriodOptions(TLVector<TLPremiumSubscriptionOption> periodOptions) {
        this.periodOptions = periodOptions;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
