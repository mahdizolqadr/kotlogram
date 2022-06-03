package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputMessageEntityMentionName}: inputMessageEntityMentionName#208e68c9</li>
 * <li>{@link TLMessageEntityBankCard}: messageEntityBankCard#761e6af4</li>
 * <li>{@link TLMessageEntityBlockquote}: messageEntityBlockquote#20df5d0</li>
 * <li>{@link TLMessageEntityBold}: messageEntityBold#bd610bc9</li>
 * <li>{@link TLMessageEntityBotCommand}: messageEntityBotCommand#6cef8ac7</li>
 * <li>{@link TLMessageEntityCashtag}: messageEntityCashtag#4c4e743f</li>
 * <li>{@link TLMessageEntityCode}: messageEntityCode#28a20571</li>
 * <li>{@link TLMessageEntityEmail}: messageEntityEmail#64e475c2</li>
 * <li>{@link TLMessageEntityHashtag}: messageEntityHashtag#6f635b0d</li>
 * <li>{@link TLMessageEntityItalic}: messageEntityItalic#826f8b60</li>
 * <li>{@link TLMessageEntityMention}: messageEntityMention#fa04579d</li>
 * <li>{@link TLMessageEntityMentionName}: messageEntityMentionName#dc7b1140</li>
 * <li>{@link TLMessageEntityPhone}: messageEntityPhone#9b69e34b</li>
 * <li>{@link TLMessageEntityPre}: messageEntityPre#73924be0</li>
 * <li>{@link TLMessageEntityStrike}: messageEntityStrike#bf0693d4</li>
 * <li>{@link TLMessageEntityTextUrl}: messageEntityTextUrl#76a6d327</li>
 * <li>{@link TLMessageEntityUnderline}: messageEntityUnderline#9c4e7e8b</li>
 * <li>{@link TLMessageEntityUnknown}: messageEntityUnknown#bb92ba95</li>
 * <li>{@link TLMessageEntityUrl}: messageEntityUrl#6ed02538</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsMessageEntity extends TLObject {

    protected int offset;

    protected int length;

    public TLAbsMessageEntity() {
    }

    public TLAbsMessageEntity(int offset, int length) {
        this.offset = offset;
        this.length = length;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(offset, stream);
        writeInt(length, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        offset = readInt(stream);
        length = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        return size;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
