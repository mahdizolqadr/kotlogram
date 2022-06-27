package com.github.badoualy.telegram.tl.api.langpack;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLLangPackString}: langPackString#cad181f6</li>
 * <li>{@link TLLangPackStringDeleted}: langPackStringDeleted#2979eeb2</li>
 * <li>{@link TLLangPackStringPluralized}: langPackStringPluralized#6c47ac9f</li>
 * </ul>
 */
public abstract class TLAbsLangPackString extends TLObject {

    protected String key;

    protected TLAbsLangPackString() {
    }

    protected TLAbsLangPackString(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
