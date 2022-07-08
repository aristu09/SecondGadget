package com.app.SecondGadgetApp.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseDTO
{
    private String status;
    private String message;
    private Object data;

    public ResponseDTO(String status, String message, Object data)
    {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(String status, String message)
    {
        this.status = status;
        this.message = message;
    }

    public ResponseDTO()
    {}
}
