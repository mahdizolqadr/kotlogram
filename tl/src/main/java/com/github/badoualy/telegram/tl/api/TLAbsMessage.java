package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLMessage}: message#85d6cbe2</li>
 * <li>{@link TLMessageEmpty}: messageEmpty#90a6ca84</li>
 * <li>{@link TLMessageService}: messageService#2b085862</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsMessage extends TLObject {

    protected int id;

    public TLAbsMessage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
