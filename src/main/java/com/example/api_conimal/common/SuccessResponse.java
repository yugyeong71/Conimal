package com.example.api_conimal.common;

public class SuccessResponse<T> {
    public int status;

    public String message;

    public T result;

    public SuccessResponse(){
        this.status = 200;
        this.message = "API Call Successful";
    }

    public SuccessResponse(String message){
        this.status = 200;
        this.message = message;
    }

    public SuccessResponse(String message, T result){
        this.status = 200;
        this.message = message;
        this.result = result;
    }

}
