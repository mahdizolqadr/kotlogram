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
public class TLAuthorization extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean current;

    protected boolean officialApp;

    protected boolean passwordPending;

    protected boolean encryptedRequestsDisabled;

    protected boolean callRequestsDisabled;

    protected boolean unconfirmed;

    protected long hash;

    protected String deviceModel;

    protected String platform;

    protected String systemVersion;

    protected int apiId;

    protected String appName;

    protected String appVersion;

    protected int dateCreated;

    protected int dateActive;

    protected String ip;

    protected String country;

    protected String region;

    private final String _constructor = "authorization#0";

    public TLAuthorization() {
    }

    public TLAuthorization(boolean current, boolean officialApp, boolean passwordPending, boolean encryptedRequestsDisabled, boolean callRequestsDisabled, boolean unconfirmed, long hash, String deviceModel, String platform, String systemVersion, int apiId, String appName, String appVersion, int dateCreated, int dateActive, String ip, String country, String region) {
        this.current = current;
        this.officialApp = officialApp;
        this.passwordPending = passwordPending;
        this.encryptedRequestsDisabled = encryptedRequestsDisabled;
        this.callRequestsDisabled = callRequestsDisabled;
        this.unconfirmed = unconfirmed;
        this.hash = hash;
        this.deviceModel = deviceModel;
        this.platform = platform;
        this.systemVersion = systemVersion;
        this.apiId = apiId;
        this.appName = appName;
        this.appVersion = appVersion;
        this.dateCreated = dateCreated;
        this.dateActive = dateActive;
        this.ip = ip;
        this.country = country;
        this.region = region;
    }

    private void computeFlags() {
        flags = 0;
        flags = current ? (flags | 1) : (flags & ~1);
        flags = officialApp ? (flags | 2) : (flags & ~2);
        flags = passwordPending ? (flags | 4) : (flags & ~4);
        flags = encryptedRequestsDisabled ? (flags | 8) : (flags & ~8);
        flags = callRequestsDisabled ? (flags | 16) : (flags & ~16);
        flags = unconfirmed ? (flags | 32) : (flags & ~32);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(hash, stream);
        writeString(deviceModel, stream);
        writeString(platform, stream);
        writeString(systemVersion, stream);
        writeInt(apiId, stream);
        writeString(appName, stream);
        writeString(appVersion, stream);
        writeInt(dateCreated, stream);
        writeInt(dateActive, stream);
        writeString(ip, stream);
        writeString(country, stream);
        writeString(region, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        current = (flags & 1) != 0;
        officialApp = (flags & 2) != 0;
        passwordPending = (flags & 4) != 0;
        encryptedRequestsDisabled = (flags & 8) != 0;
        callRequestsDisabled = (flags & 16) != 0;
        unconfirmed = (flags & 32) != 0;
        hash = readLong(stream);
        deviceModel = readTLString(stream);
        platform = readTLString(stream);
        systemVersion = readTLString(stream);
        apiId = readInt(stream);
        appName = readTLString(stream);
        appVersion = readTLString(stream);
        dateCreated = readInt(stream);
        dateActive = readInt(stream);
        ip = readTLString(stream);
        country = readTLString(stream);
        region = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(deviceModel);
        size += computeTLStringSerializedSize(platform);
        size += computeTLStringSerializedSize(systemVersion);
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(appName);
        size += computeTLStringSerializedSize(appVersion);
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(ip);
        size += computeTLStringSerializedSize(country);
        size += computeTLStringSerializedSize(region);
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

    public boolean getCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public boolean getOfficialApp() {
        return officialApp;
    }

    public void setOfficialApp(boolean officialApp) {
        this.officialApp = officialApp;
    }

    public boolean getPasswordPending() {
        return passwordPending;
    }

    public void setPasswordPending(boolean passwordPending) {
        this.passwordPending = passwordPending;
    }

    public boolean getEncryptedRequestsDisabled() {
        return encryptedRequestsDisabled;
    }

    public void setEncryptedRequestsDisabled(boolean encryptedRequestsDisabled) {
        this.encryptedRequestsDisabled = encryptedRequestsDisabled;
    }

    public boolean getCallRequestsDisabled() {
        return callRequestsDisabled;
    }

    public void setCallRequestsDisabled(boolean callRequestsDisabled) {
        this.callRequestsDisabled = callRequestsDisabled;
    }

    public boolean getUnconfirmed() {
        return unconfirmed;
    }

    public void setUnconfirmed(boolean unconfirmed) {
        this.unconfirmed = unconfirmed;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public int getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(int dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getDateActive() {
        return dateActive;
    }

    public void setDateActive(int dateActive) {
        this.dateActive = dateActive;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
