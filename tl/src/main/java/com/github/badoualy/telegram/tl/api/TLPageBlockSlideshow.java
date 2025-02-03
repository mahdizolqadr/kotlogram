package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLPageBlockSlideshow extends TLAbsPageBlock {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLVector<TLAbsPageBlock> items;

    protected TLPageCaption caption;

    private final String _constructor = "pageBlockSlideshow#0";

    public TLPageBlockSlideshow() {
    }

    public TLPageBlockSlideshow(TLVector<TLAbsPageBlock> items, TLPageCaption caption) {
        this.items = items;
        this.caption = caption;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(items, stream);
        writeTLObject(caption, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        items = readTLVector(stream, context);
        caption = readTLObject(stream, context, TLPageCaption.class, TLPageCaption.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += items.computeSerializedSize();
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

    public TLVector<TLAbsPageBlock> getItems() {
        return items;
    }

    public void setItems(TLVector<TLAbsPageBlock> items) {
        this.items = items;
    }

    public TLPageCaption getCaption() {
        return caption;
    }

    public void setCaption(TLPageCaption caption) {
        this.caption = caption;
    }
}
