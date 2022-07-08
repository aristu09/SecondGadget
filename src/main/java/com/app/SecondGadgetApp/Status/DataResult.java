package com.app.SecondGadgetApp.Status;

public class DataResult<A> extends ResultStatus{

    private A data;

    public DataResult(A data, boolean success){
        super(success);
        this.data = data;
    }

    public DataResult(A data, boolean success, String message){
        super(success, message);
        this.data = data;
    }

    public A getData() {
        return this.data;
    }
}
