package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLConnectedBotStarRef extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean revoked;

    protected String url;

    protected int date;

    protected long botId;

    protected int commissionPermille;

    protected Integer durationMonths;

    protected long participants;

    protected long revenue;

    private final String _constructor = "connectedBotStarRef#0";

    public TLConnectedBotStarRef() {
    }

    public TLConnectedBotStarRef(boolean revoked, String url, int date, long botId, int commissionPermille, Integer durationMonths, long participants, long revenue) {
        this.revoked = revoked;
        this.url = url;
        this.date = date;
        this.botId = botId;
        this.commissionPermille = commissionPermille;
        this.durationMonths = durationMonths;
        this.participants = participants;
        this.revenue = revenue;
    }

    private void computeFlags() {
        flags = 0;
        flags = revoked ? (flags | 2) : (flags & ~2);
        flags = durationMonths != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(url, stream);
        writeInt(date, stream);
        writeLong(botId, stream);
        writeInt(commissionPermille, stream);
        if ((flags & 1) != 0) {
            if (durationMonths == null) throwNullFieldException("durationMonths", flags);
            writeInt(durationMonths, stream);
        }
        writeLong(participants, stream);
        writeLong(revenue, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        revoked = (flags & 2) != 0;
        url = readTLString(stream);
        date = readInt(stream);
        botId = readLong(stream);
        commissionPermille = readInt(stream);
        durationMonths = (flags & 1) != 0 ? readInt(stream) : null;
        participants = readLong(stream);
        revenue = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(url);
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (durationMonths == null) throwNullFieldException("durationMonths", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT64;
        size += SIZE_INT64;
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

    public boolean getRevoked() {
        return revoked;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public long getBotId() {
        return botId;
    }

    public void setBotId(long botId) {
        this.botId = botId;
    }

    public int getCommissionPermille() {
        return commissionPermille;
    }

    public void setCommissionPermille(int commissionPermille) {
        this.commissionPermille = commissionPermille;
    }

    public Integer getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(Integer durationMonths) {
        this.durationMonths = durationMonths;
    }

    public long getParticipants() {
        return participants;
    }

    public void setParticipants(long participants) {
        this.participants = participants;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }
}
