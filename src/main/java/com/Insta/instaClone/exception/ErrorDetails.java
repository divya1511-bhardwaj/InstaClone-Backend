package com.Insta.instaClone.exception;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ErrorDetails {

    private String message;
    private  String details;
    private LocalDateTime timeStamp;
}
