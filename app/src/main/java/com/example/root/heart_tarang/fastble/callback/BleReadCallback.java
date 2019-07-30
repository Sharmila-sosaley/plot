package com.example.root.heart_tarang.fastble.callback;

        import com.example.root.heart_tarang.fastble.exception.BleException;

public abstract class BleReadCallback extends BleBaseCallback {

    public abstract void onReadSuccess(byte[] data);

    public abstract void onReadFailure(BleException exception);

}
