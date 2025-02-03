package com.github.badoualy.telegram.tl.api.smsjobs;

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
public class TLStatus extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean allowInternational;

    protected int recentSent;

    protected int recentSince;

    protected int recentRemains;

    protected int totalSent;

    protected int totalSince;

    protected String lastGiftSlug;

    protected String termsUrl;

    private final String _constructor = "smsjobs.status#0";

    public TLStatus() {
    }

    public TLStatus(boolean allowInternational, int recentSent, int recentSince, int recentRemains, int totalSent, int totalSince, String lastGiftSlug, String termsUrl) {
        this.allowInternational = allowInternational;
        this.recentSent = recentSent;
        this.recentSince = recentSince;
        this.recentRemains = recentRemains;
        this.totalSent = totalSent;
        this.totalSince = totalSince;
        this.lastGiftSlug = lastGiftSlug;
        this.termsUrl = termsUrl;
    }

    private void computeFlags() {
        flags = 0;
        flags = allowInternational ? (flags | 1) : (flags & ~1);
        flags = lastGiftSlug != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(recentSent, stream);
        writeInt(recentSince, stream);
        writeInt(recentRemains, stream);
        writeInt(totalSent, stream);
        writeInt(totalSince, stream);
        if ((flags & 2) != 0) {
            if (lastGiftSlug == null) throwNullFieldException("lastGiftSlug", flags);
            writeString(lastGiftSlug, stream);
        }
        writeString(termsUrl, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        allowInternational = (flags & 1) != 0;
        recentSent = readInt(stream);
        recentSince = readInt(stream);
        recentRemains = readInt(stream);
        totalSent = readInt(stream);
        totalSince = readInt(stream);
        lastGiftSlug = (flags & 2) != 0 ? readTLString(stream) : null;
        termsUrl = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (lastGiftSlug == null) throwNullFieldException("lastGiftSlug", flags);
            size += computeTLStringSerializedSize(lastGiftSlug);
        }
        size += computeTLStringSerializedSize(termsUrl);
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

    public boolean getAllowInternational() {
        return allowInternational;
    }

    public void setAllowInternational(boolean allowInternational) {
        this.allowInternational = allowInternational;
    }

    public int getRecentSent() {
        return recentSent;
    }

    public void setRecentSent(int recentSent) {
        this.recentSent = recentSent;
    }

    public int getRecentSince() {
        return recentSince;
    }

    public void setRecentSince(int recentSince) {
        this.recentSince = recentSince;
    }

    public int getRecentRemains() {
        return recentRemains;
    }

    public void setRecentRemains(int recentRemains) {
        this.recentRemains = recentRemains;
    }

    public int getTotalSent() {
        return totalSent;
    }

    public void setTotalSent(int totalSent) {
        this.totalSent = totalSent;
    }

    public int getTotalSince() {
        return totalSince;
    }

    public void setTotalSince(int totalSince) {
        this.totalSince = totalSince;
    }

    public String getLastGiftSlug() {
        return lastGiftSlug;
    }

    public void setLastGiftSlug(String lastGiftSlug) {
        this.lastGiftSlug = lastGiftSlug;
    }

    public String getTermsUrl() {
        return termsUrl;
    }

    public void setTermsUrl(String termsUrl) {
        this.termsUrl = termsUrl;
    }
}
