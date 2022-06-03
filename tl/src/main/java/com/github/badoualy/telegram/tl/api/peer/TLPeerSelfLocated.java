package com.github.badoualy.telegram.tl.api.peer;

public class TLPeerSelfLocated extends TLAbsPeerLocated {

    public static final int CONSTRUCTOR_ID = 0xf8ec284b;

    private final String _constructor = "peerSelfLocated#f8ec284b";

    public TLPeerSelfLocated() {
    }

    public TLPeerSelfLocated(int expires) {
        this.expires = expires;
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
