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
public class TLWebAuthorization extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long hash;

    protected long botId;

    protected String domain;

    protected String browser;

    protected String platform;

    protected int dateCreated;

    protected int dateActive;

    protected String ip;

    protected String region;

    private final String _constructor = "webAuthorization#0";

    public TLWebAuthorization() {
    }

    public TLWebAuthorization(long hash, long botId, String domain, String browser, String platform, int dateCreated, int dateActive, String ip, String region) {
        this.hash = hash;
        this.botId = botId;
        this.domain = domain;
        this.browser = browser;
        this.platform = platform;
        this.dateCreated = dateCreated;
        this.dateActive = dateActive;
        this.ip = ip;
        this.region = region;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(hash, stream);
        writeLong(botId, stream);
        writeString(domain, stream);
        writeString(browser, stream);
        writeString(platform, stream);
        writeInt(dateCreated, stream);
        writeInt(dateActive, stream);
        writeString(ip, stream);
        writeString(region, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readLong(stream);
        botId = readLong(stream);
        domain = readTLString(stream);
        browser = readTLString(stream);
        platform = readTLString(stream);
        dateCreated = readInt(stream);
        dateActive = readInt(stream);
        ip = readTLString(stream);
        region = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(domain);
        size += computeTLStringSerializedSize(browser);
        size += computeTLStringSerializedSize(platform);
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(ip);
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

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public long getBotId() {
        return botId;
    }

    public void setBotId(long botId) {
        this.botId = botId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
