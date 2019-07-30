package com.example.root.heart_tarang.blesample.comm;



import com.example.root.heart_tarang.fastble.data.BleDevice;

public interface Observable {

    void addObserver(Observer obj);

    void deleteObserver(Observer obj);

    void notifyObserver(BleDevice bleDevice);
}
