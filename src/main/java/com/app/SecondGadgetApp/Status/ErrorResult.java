package com.app.SecondGadgetApp.Status;

public class ErrorResult extends ResultStatus{

    public ErrorResult(){
        super(false);
    }

    public ErrorResult(String message){
        super(false, message);
    }


}
