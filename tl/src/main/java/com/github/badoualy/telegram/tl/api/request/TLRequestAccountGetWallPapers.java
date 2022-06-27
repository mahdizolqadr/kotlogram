package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.account.TLAbsAccountWallPapers;
import com.github.badoualy.telegram.tl.api.wallpaper.TLAbsWallPaper;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAccountGetWallPapers extends TLMethod<TLVector<TLAbsAccountWallPapers>> {

    public static final int CONSTRUCTOR_ID = 0x7967d36;

    private final String _constructor = "account.getWallPapers#7967d36";

    @Override
    @SuppressWarnings({"unchecked"})
    public TLVector<TLAbsAccountWallPapers> deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
