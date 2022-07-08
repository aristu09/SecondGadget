package com.app.SecondGadgetApp.Status;

public class ResultStatus {
    private  boolean success;

    private String message;

    public ResultStatus(boolean success){
        this.success = success;
    }

    public ResultStatus(boolean success, String message){
        this(success);
        this.message = message;
    }

    public boolean isSuccess(){
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }

}
