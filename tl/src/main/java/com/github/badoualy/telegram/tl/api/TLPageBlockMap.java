package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLPageBlockMap extends TLAbsPageBlock {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsGeoPoint geo;

    protected int zoom;

    protected int w;

    protected int h;

    protected TLPageCaption caption;

    private final String _constructor = "pageBlockMap#0";

    public TLPageBlockMap() {
    }

    public TLPageBlockMap(TLAbsGeoPoint geo, int zoom, int w, int h, TLPageCaption caption) {
        this.geo = geo;
        this.zoom = zoom;
        this.w = w;
        this.h = h;
        this.caption = caption;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(geo, stream);
        writeInt(zoom, stream);
        writeInt(w, stream);
        writeInt(h, stream);
        writeTLObject(caption, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        geo = readTLObject(stream, context, TLAbsGeoPoint.class, -1);
        zoom = readInt(stream);
        w = readInt(stream);
        h = readInt(stream);
        caption = readTLObject(stream, context, TLPageCaption.class, TLPageCaption.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += geo.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += caption.computeSerializedSize();
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

    public TLAbsGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(TLAbsGeoPoint geo) {
        this.geo = geo;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public TLPageCaption getCaption() {
        return caption;
    }

    public void setCaption(TLPageCaption caption) {
        this.caption = caption;
    }
}
