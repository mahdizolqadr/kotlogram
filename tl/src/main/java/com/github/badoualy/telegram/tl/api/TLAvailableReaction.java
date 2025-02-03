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
public class TLAvailableReaction extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean inactive;

    protected boolean premium;

    protected String reaction;

    protected String title;

    protected TLAbsDocument staticIcon;

    protected TLAbsDocument appearAnimation;

    protected TLAbsDocument selectAnimation;

    protected TLAbsDocument activateAnimation;

    protected TLAbsDocument effectAnimation;

    protected TLAbsDocument aroundAnimation;

    protected TLAbsDocument centerIcon;

    private final String _constructor = "availableReaction#0";

    public TLAvailableReaction() {
    }

    public TLAvailableReaction(boolean inactive, boolean premium, String reaction, String title, TLAbsDocument staticIcon, TLAbsDocument appearAnimation, TLAbsDocument selectAnimation, TLAbsDocument activateAnimation, TLAbsDocument effectAnimation, TLAbsDocument aroundAnimation, TLAbsDocument centerIcon) {
        this.inactive = inactive;
        this.premium = premium;
        this.reaction = reaction;
        this.title = title;
        this.staticIcon = staticIcon;
        this.appearAnimation = appearAnimation;
        this.selectAnimation = selectAnimation;
        this.activateAnimation = activateAnimation;
        this.effectAnimation = effectAnimation;
        this.aroundAnimation = aroundAnimation;
        this.centerIcon = centerIcon;
    }

    private void computeFlags() {
        flags = 0;
        flags = inactive ? (flags | 1) : (flags & ~1);
        flags = premium ? (flags | 4) : (flags & ~4);
        flags = aroundAnimation != null ? (flags | 2) : (flags & ~2);
        flags = centerIcon != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(reaction, stream);
        writeString(title, stream);
        writeTLObject(staticIcon, stream);
        writeTLObject(appearAnimation, stream);
        writeTLObject(selectAnimation, stream);
        writeTLObject(activateAnimation, stream);
        writeTLObject(effectAnimation, stream);
        if ((flags & 2) != 0) {
            if (aroundAnimation == null) throwNullFieldException("aroundAnimation", flags);
            writeTLObject(aroundAnimation, stream);
        }
        if ((flags & 2) != 0) {
            if (centerIcon == null) throwNullFieldException("centerIcon", flags);
            writeTLObject(centerIcon, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        inactive = (flags & 1) != 0;
        premium = (flags & 4) != 0;
        reaction = readTLString(stream);
        title = readTLString(stream);
        staticIcon = readTLObject(stream, context, TLAbsDocument.class, -1);
        appearAnimation = readTLObject(stream, context, TLAbsDocument.class, -1);
        selectAnimation = readTLObject(stream, context, TLAbsDocument.class, -1);
        activateAnimation = readTLObject(stream, context, TLAbsDocument.class, -1);
        effectAnimation = readTLObject(stream, context, TLAbsDocument.class, -1);
        aroundAnimation = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsDocument.class, -1) : null;
        centerIcon = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsDocument.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(reaction);
        size += computeTLStringSerializedSize(title);
        size += staticIcon.computeSerializedSize();
        size += appearAnimation.computeSerializedSize();
        size += selectAnimation.computeSerializedSize();
        size += activateAnimation.computeSerializedSize();
        size += effectAnimation.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (aroundAnimation == null) throwNullFieldException("aroundAnimation", flags);
            size += aroundAnimation.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (centerIcon == null) throwNullFieldException("centerIcon", flags);
            size += centerIcon.computeSerializedSize();
        }
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

    public boolean getInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public boolean getPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TLAbsDocument getStaticIcon() {
        return staticIcon;
    }

    public void setStaticIcon(TLAbsDocument staticIcon) {
        this.staticIcon = staticIcon;
    }

    public TLAbsDocument getAppearAnimation() {
        return appearAnimation;
    }

    public void setAppearAnimation(TLAbsDocument appearAnimation) {
        this.appearAnimation = appearAnimation;
    }

    public TLAbsDocument getSelectAnimation() {
        return selectAnimation;
    }

    public void setSelectAnimation(TLAbsDocument selectAnimation) {
        this.selectAnimation = selectAnimation;
    }

    public TLAbsDocument getActivateAnimation() {
        return activateAnimation;
    }

    public void setActivateAnimation(TLAbsDocument activateAnimation) {
        this.activateAnimation = activateAnimation;
    }

    public TLAbsDocument getEffectAnimation() {
        return effectAnimation;
    }

    public void setEffectAnimation(TLAbsDocument effectAnimation) {
        this.effectAnimation = effectAnimation;
    }

    public TLAbsDocument getAroundAnimation() {
        return aroundAnimation;
    }

    public void setAroundAnimation(TLAbsDocument aroundAnimation) {
        this.aroundAnimation = aroundAnimation;
    }

    public TLAbsDocument getCenterIcon() {
        return centerIcon;
    }

    public void setCenterIcon(TLAbsDocument centerIcon) {
        this.centerIcon = centerIcon;
    }
}
