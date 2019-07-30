package com.example.root.heart_tarang.fastble.exception;

public class OtherException extends BleException {

    public OtherException(String description) {
        super(ERROR_CODE_OTHER, description);
    }

}
