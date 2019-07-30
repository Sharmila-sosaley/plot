package com.example.root.heart_tarang.fastble.callback;


        import com.example.root.heart_tarang.fastble.exception.BleException;

public abstract class BleRssiCallback extends BleBaseCallback{

    public abstract void onRssiFailure(BleException exception);

    public abstract void onRssiSuccess(int rssi);

}
