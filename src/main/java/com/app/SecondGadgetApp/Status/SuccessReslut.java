package com.app.SecondGadgetApp.Status;

public class SuccessReslut extends ResultStatus{

    public SuccessReslut(boolean success){
        super(success);
    }

    public SuccessReslut(String message){
        super(true, message);
    }
}
