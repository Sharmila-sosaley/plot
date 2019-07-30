package com.example.root.heart_tarang.fastble.callback;

import com.example.root.heart_tarang.fastble.data.BleDevice;

public interface BleScanPresenterImp {

    void onScanStarted(boolean success);

    void onScanning(BleDevice bleDevice);

}
