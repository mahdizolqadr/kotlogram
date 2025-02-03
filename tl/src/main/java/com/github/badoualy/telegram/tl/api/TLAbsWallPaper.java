package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLWallPaper}: wallPaper#0</li>
 * <li>{@link TLWallPaperNoFile}: wallPaperNoFile#0</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsWallPaper extends TLObject {
    protected long id;

    protected int flags;

    protected boolean ddefault;

    protected boolean dark;

    protected TLWallPaperSettings settings;

    public TLAbsWallPaper() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getDdefault() {
        return ddefault;
    }

    public void setDdefault(boolean ddefault) {
        this.ddefault = ddefault;
    }

    public boolean getDark() {
        return dark;
    }

    public void setDark(boolean dark) {
        this.dark = dark;
    }

    public TLWallPaperSettings getSettings() {
        return settings;
    }

    public void setSettings(TLWallPaperSettings settings) {
        this.settings = settings;
    }
}
