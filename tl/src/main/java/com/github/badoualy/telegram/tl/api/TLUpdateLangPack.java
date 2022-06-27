package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.langpack.TLLangPackDifference;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

public class TLUpdateLangPack extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x56022f4d;

    protected TLLangPackDifference difference;

    private final String _constructor = "updateLangPack#56022f4d";

    public TLUpdateLangPack() {
    }

    public TLUpdateLangPack(TLLangPackDifference difference) {
        this.difference = difference;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(difference, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        difference = readTLObject(stream, context, TLLangPackDifference.class, TLLangPackDifference.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += difference.computeSerializedSize();
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

    public TLLangPackDifference getDifference() {
        return difference;
    }

    public void setDifference(TLLangPackDifference difference) {
        this.difference = difference;
    }
}
