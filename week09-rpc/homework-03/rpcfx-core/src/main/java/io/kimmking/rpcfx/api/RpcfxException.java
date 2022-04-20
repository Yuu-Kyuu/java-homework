package io.kimmking.rpcfx.api;

public class RpcfxException extends Exception {

    public static final String RPCFX_EXCEPTION = "RpcfxException";

    public RpcfxException() {
        super(RPCFX_EXCEPTION);
    }
}
