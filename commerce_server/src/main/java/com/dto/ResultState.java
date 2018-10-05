package com.dto;

public enum ResultState {
    SECCESS(0),Fail(1);
    private final int state;
    ResultState(int i) {
        this.state  = i;
    }

    public int getState() {
        return state;
    }
}
