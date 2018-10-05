package com.dto;

public enum ResultState {
    SECCESS(0),Fail(1);


    private int stateNum;
    ResultState(int i) {
        this.stateNum  = i;
    }

    public int getState() {
        return stateNum;
    }

}
