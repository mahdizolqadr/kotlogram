package com.github.badoualy.telegram.tl.api.wallpaper;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLWallPaper}: wallPaper#a437c3ed</li>
 * <li>{@link TLWallPaperNoFile}: wallPaperSolid#e0804116</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsWallPaper extends TLObject {

    protected long id;
    protected int flags;
    protected boolean isDefault;
    protected boolean dark;
    protected TLWallPaperSettings settings;

    protected TLAbsWallPaper() {
    }

    protected TLAbsWallPaper(long id, boolean isDefault, boolean dark, TLWallPaperSettings settings) {
        this.id = id;
        this.isDefault = isDefault;
        this.dark = dark;
        this.settings = settings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public boolean isDark() {
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
