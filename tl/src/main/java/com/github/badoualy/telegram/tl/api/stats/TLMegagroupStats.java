package com.github.badoualy.telegram.tl.api.stats;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsStatsGraph;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLStatsAbsValueAndPrev;
import com.github.badoualy.telegram.tl.api.TLStatsDateRangeDays;
import com.github.badoualy.telegram.tl.api.TLStatsGroupTopAdmin;
import com.github.badoualy.telegram.tl.api.TLStatsGroupTopInviter;
import com.github.badoualy.telegram.tl.api.TLStatsGroupTopPoster;
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
public class TLMegagroupStats extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLStatsDateRangeDays period;

    protected TLStatsAbsValueAndPrev members;

    protected TLStatsAbsValueAndPrev messages;

    protected TLStatsAbsValueAndPrev viewers;

    protected TLStatsAbsValueAndPrev posters;

    protected TLAbsStatsGraph growthGraph;

    protected TLAbsStatsGraph membersGraph;

    protected TLAbsStatsGraph newMembersBySourceGraph;

    protected TLAbsStatsGraph languagesGraph;

    protected TLAbsStatsGraph messagesGraph;

    protected TLAbsStatsGraph actionsGraph;

    protected TLAbsStatsGraph topHoursGraph;

    protected TLAbsStatsGraph weekdaysGraph;

    protected TLVector<TLStatsGroupTopPoster> topPosters;

    protected TLVector<TLStatsGroupTopAdmin> topAdmins;

    protected TLVector<TLStatsGroupTopInviter> topInviters;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "stats.megagroupStats#0";

    public TLMegagroupStats() {
    }

    public TLMegagroupStats(TLStatsDateRangeDays period, TLStatsAbsValueAndPrev members, TLStatsAbsValueAndPrev messages, TLStatsAbsValueAndPrev viewers, TLStatsAbsValueAndPrev posters, TLAbsStatsGraph growthGraph, TLAbsStatsGraph membersGraph, TLAbsStatsGraph newMembersBySourceGraph, TLAbsStatsGraph languagesGraph, TLAbsStatsGraph messagesGraph, TLAbsStatsGraph actionsGraph, TLAbsStatsGraph topHoursGraph, TLAbsStatsGraph weekdaysGraph, TLVector<TLStatsGroupTopPoster> topPosters, TLVector<TLStatsGroupTopAdmin> topAdmins, TLVector<TLStatsGroupTopInviter> topInviters, TLVector<TLAbsUser> users) {
        this.period = period;
        this.members = members;
        this.messages = messages;
        this.viewers = viewers;
        this.posters = posters;
        this.growthGraph = growthGraph;
        this.membersGraph = membersGraph;
        this.newMembersBySourceGraph = newMembersBySourceGraph;
        this.languagesGraph = languagesGraph;
        this.messagesGraph = messagesGraph;
        this.actionsGraph = actionsGraph;
        this.topHoursGraph = topHoursGraph;
        this.weekdaysGraph = weekdaysGraph;
        this.topPosters = topPosters;
        this.topAdmins = topAdmins;
        this.topInviters = topInviters;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(period, stream);
        writeTLObject(members, stream);
        writeTLObject(messages, stream);
        writeTLObject(viewers, stream);
        writeTLObject(posters, stream);
        writeTLObject(growthGraph, stream);
        writeTLObject(membersGraph, stream);
        writeTLObject(newMembersBySourceGraph, stream);
        writeTLObject(languagesGraph, stream);
        writeTLObject(messagesGraph, stream);
        writeTLObject(actionsGraph, stream);
        writeTLObject(topHoursGraph, stream);
        writeTLObject(weekdaysGraph, stream);
        writeTLVector(topPosters, stream);
        writeTLVector(topAdmins, stream);
        writeTLVector(topInviters, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        period = readTLObject(stream, context, TLStatsDateRangeDays.class, TLStatsDateRangeDays.CONSTRUCTOR_ID);
        members = readTLObject(stream, context, TLStatsAbsValueAndPrev.class, TLStatsAbsValueAndPrev.CONSTRUCTOR_ID);
        messages = readTLObject(stream, context, TLStatsAbsValueAndPrev.class, TLStatsAbsValueAndPrev.CONSTRUCTOR_ID);
        viewers = readTLObject(stream, context, TLStatsAbsValueAndPrev.class, TLStatsAbsValueAndPrev.CONSTRUCTOR_ID);
        posters = readTLObject(stream, context, TLStatsAbsValueAndPrev.class, TLStatsAbsValueAndPrev.CONSTRUCTOR_ID);
        growthGraph = readTLObject(stream, context, TLAbsStatsGraph.class, -1);
        membersGraph = readTLObject(stream, context, TLAbsStatsGraph.class, -1);
        newMembersBySourceGraph = readTLObject(stream, context, TLAbsStatsGraph.class, -1);
        languagesGraph = readTLObject(stream, context, TLAbsStatsGraph.class, -1);
        messagesGraph = readTLObject(stream, context, TLAbsStatsGraph.class, -1);
        actionsGraph = readTLObject(stream, context, TLAbsStatsGraph.class, -1);
        topHoursGraph = readTLObject(stream, context, TLAbsStatsGraph.class, -1);
        weekdaysGraph = readTLObject(stream, context, TLAbsStatsGraph.class, -1);
        topPosters = readTLVector(stream, context);
        topAdmins = readTLVector(stream, context);
        topInviters = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += period.computeSerializedSize();
        size += members.computeSerializedSize();
        size += messages.computeSerializedSize();
        size += viewers.computeSerializedSize();
        size += posters.computeSerializedSize();
        size += growthGraph.computeSerializedSize();
        size += membersGraph.computeSerializedSize();
        size += newMembersBySourceGraph.computeSerializedSize();
        size += languagesGraph.computeSerializedSize();
        size += messagesGraph.computeSerializedSize();
        size += actionsGraph.computeSerializedSize();
        size += topHoursGraph.computeSerializedSize();
        size += weekdaysGraph.computeSerializedSize();
        size += topPosters.computeSerializedSize();
        size += topAdmins.computeSerializedSize();
        size += topInviters.computeSerializedSize();
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

    public TLStatsDateRangeDays getPeriod() {
        return period;
    }

    public void setPeriod(TLStatsDateRangeDays period) {
        this.period = period;
    }

    public TLStatsAbsValueAndPrev getMembers() {
        return members;
    }

    public void setMembers(TLStatsAbsValueAndPrev members) {
        this.members = members;
    }

    public TLStatsAbsValueAndPrev getMessages() {
        return messages;
    }

    public void setMessages(TLStatsAbsValueAndPrev messages) {
        this.messages = messages;
    }

    public TLStatsAbsValueAndPrev getViewers() {
        return viewers;
    }

    public void setViewers(TLStatsAbsValueAndPrev viewers) {
        this.viewers = viewers;
    }

    public TLStatsAbsValueAndPrev getPosters() {
        return posters;
    }

    public void setPosters(TLStatsAbsValueAndPrev posters) {
        this.posters = posters;
    }

    public TLAbsStatsGraph getGrowthGraph() {
        return growthGraph;
    }

    public void setGrowthGraph(TLAbsStatsGraph growthGraph) {
        this.growthGraph = growthGraph;
    }

    public TLAbsStatsGraph getMembersGraph() {
        return membersGraph;
    }

    public void setMembersGraph(TLAbsStatsGraph membersGraph) {
        this.membersGraph = membersGraph;
    }

    public TLAbsStatsGraph getNewMembersBySourceGraph() {
        return newMembersBySourceGraph;
    }

    public void setNewMembersBySourceGraph(TLAbsStatsGraph newMembersBySourceGraph) {
        this.newMembersBySourceGraph = newMembersBySourceGraph;
    }

    public TLAbsStatsGraph getLanguagesGraph() {
        return languagesGraph;
    }

    public void setLanguagesGraph(TLAbsStatsGraph languagesGraph) {
        this.languagesGraph = languagesGraph;
    }

    public TLAbsStatsGraph getMessagesGraph() {
        return messagesGraph;
    }

    public void setMessagesGraph(TLAbsStatsGraph messagesGraph) {
        this.messagesGraph = messagesGraph;
    }

    public TLAbsStatsGraph getActionsGraph() {
        return actionsGraph;
    }

    public void setActionsGraph(TLAbsStatsGraph actionsGraph) {
        this.actionsGraph = actionsGraph;
    }

    public TLAbsStatsGraph getTopHoursGraph() {
        return topHoursGraph;
    }

    public void setTopHoursGraph(TLAbsStatsGraph topHoursGraph) {
        this.topHoursGraph = topHoursGraph;
    }

    public TLAbsStatsGraph getWeekdaysGraph() {
        return weekdaysGraph;
    }

    public void setWeekdaysGraph(TLAbsStatsGraph weekdaysGraph) {
        this.weekdaysGraph = weekdaysGraph;
    }

    public TLVector<TLStatsGroupTopPoster> getTopPosters() {
        return topPosters;
    }

    public void setTopPosters(TLVector<TLStatsGroupTopPoster> topPosters) {
        this.topPosters = topPosters;
    }

    public TLVector<TLStatsGroupTopAdmin> getTopAdmins() {
        return topAdmins;
    }

    public void setTopAdmins(TLVector<TLStatsGroupTopAdmin> topAdmins) {
        this.topAdmins = topAdmins;
    }

    public TLVector<TLStatsGroupTopInviter> getTopInviters() {
        return topInviters;
    }

    public void setTopInviters(TLVector<TLStatsGroupTopInviter> topInviters) {
        this.topInviters = topInviters;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
