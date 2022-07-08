package com.app.SecondGadgetApp.Status;

public class SuccessDataReslut<A> extends DataResult<A>{
    public SuccessDataReslut(A data){
        super(data, true);
    }

    public SuccessDataReslut(A data, String message){
        super(data, true, message);
    }

    public SuccessDataReslut(){
        super(null, true);
    }

    public SuccessDataReslut(String message){
        super(null, true, message);
    }
}
