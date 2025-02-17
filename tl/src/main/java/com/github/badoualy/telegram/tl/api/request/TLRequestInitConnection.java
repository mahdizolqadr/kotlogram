package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsJSONValue;
import com.github.badoualy.telegram.tl.api.TLInputClientProxy;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestInitConnection<T extends TLObject> extends TLMethod<T> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected int apiId;

    protected String deviceModel;

    protected String systemVersion;

    protected String appVersion;

    protected String systemLangCode;

    protected String langPack;

    protected String langCode;

    protected TLInputClientProxy proxy;

    protected TLAbsJSONValue params;

    protected TLMethod<T> query;

    private final String _constructor = "initConnection#0";

    public TLRequestInitConnection() {
    }

    public TLRequestInitConnection(int apiId, String deviceModel, String systemVersion, String appVersion, String systemLangCode, String langPack, String langCode, TLInputClientProxy proxy, TLAbsJSONValue params, TLMethod<T> query) {
        this.apiId = apiId;
        this.deviceModel = deviceModel;
        this.systemVersion = systemVersion;
        this.appVersion = appVersion;
        this.systemLangCode = systemLangCode;
        this.langPack = langPack;
        this.langCode = langCode;
        this.proxy = proxy;
        this.params = params;
        this.query = query;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public T deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return query.deserializeResponse(stream, context);
    }

    private void computeFlags() {
        flags = 0;
        flags = proxy != null ? (flags | 1) : (flags & ~1);
        flags = params != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(apiId, stream);
        writeString(deviceModel, stream);
        writeString(systemVersion, stream);
        writeString(appVersion, stream);
        writeString(systemLangCode, stream);
        writeString(langPack, stream);
        writeString(langCode, stream);
        if ((flags & 1) != 0) {
            if (proxy == null) throwNullFieldException("proxy", flags);
            writeTLObject(proxy, stream);
        }
        if ((flags & 2) != 0) {
            if (params == null) throwNullFieldException("params", flags);
            writeTLObject(params, stream);
        }
        writeTLMethod(query, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        apiId = readInt(stream);
        deviceModel = readTLString(stream);
        systemVersion = readTLString(stream);
        appVersion = readTLString(stream);
        systemLangCode = readTLString(stream);
        langPack = readTLString(stream);
        langCode = readTLString(stream);
        proxy = (flags & 1) != 0 ? readTLObject(stream, context, TLInputClientProxy.class, TLInputClientProxy.CONSTRUCTOR_ID) : null;
        params = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsJSONValue.class, -1) : null;
        query = readTLMethod(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(deviceModel);
        size += computeTLStringSerializedSize(systemVersion);
        size += computeTLStringSerializedSize(appVersion);
        size += computeTLStringSerializedSize(systemLangCode);
        size += computeTLStringSerializedSize(langPack);
        size += computeTLStringSerializedSize(langCode);
        if ((flags & 1) != 0) {
            if (proxy == null) throwNullFieldException("proxy", flags);
            size += proxy.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (params == null) throwNullFieldException("params", flags);
            size += params.computeSerializedSize();
        }
        size += query.computeSerializedSize();
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

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getSystemLangCode() {
        return systemLangCode;
    }

    public void setSystemLangCode(String systemLangCode) {
        this.systemLangCode = systemLangCode;
    }

    public String getLangPack() {
        return langPack;
    }

    public void setLangPack(String langPack) {
        this.langPack = langPack;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public TLInputClientProxy getProxy() {
        return proxy;
    }

    public void setProxy(TLInputClientProxy proxy) {
        this.proxy = proxy;
    }

    public TLAbsJSONValue getParams() {
        return params;
    }

    public void setParams(TLAbsJSONValue params) {
        this.params = params;
    }

    public TLMethod<T> getQuery() {
        return query;
    }

    public void setQuery(TLMethod<T> query) {
        this.query = query;
    }
}
