package com.app.SecondGadgetApp.Status;

public class ErrorDataResult<A> extends DataResult<A> {
    public ErrorDataResult(A data) {
        super(data, false);
    }

    public ErrorDataResult(A data, String message){
        super(data, false, message);
    }

    public ErrorDataResult(){
        super(null, false);
    }

    public ErrorDataResult(String message){
        super(null, false, message);
    }
}
