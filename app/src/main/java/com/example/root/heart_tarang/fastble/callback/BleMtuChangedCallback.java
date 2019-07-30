package com.example.root.heart_tarang.fastble.callback;

        import com.example.root.heart_tarang.fastble.exception.BleException;

public abstract class BleMtuChangedCallback extends BleBaseCallback {

    public abstract void onSetMTUFailure(BleException exception);

    public abstract void onMtuChanged(int mtu);

}