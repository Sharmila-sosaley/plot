package com.example.root.heart_tarang.fastble.callback;



        import com.example.root.heart_tarang.fastble.exception.BleException;

public abstract class BleWriteCallback extends BleBaseCallback{

    public abstract void onWriteSuccess(int current, int total, byte[] justWrite);

    public abstract void onWriteFailure(BleException exception);

}