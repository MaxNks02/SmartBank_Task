package com.example.smartbank_task.exeption.handling;


public class ApiMessages {

    public static final String BAD_REQUEST = "Invalid request. Please check request once more. ";
    public static final String NOT_FOUND = "Could not find requesting data ";
    public static final String INTERNAL_SERVER_ERROR = "Error occurs while exchange data with database. Please try again later, after checking given error details. ";
    public static final String UNSUPPORTED_MEDIA_TYPE = "Error occurs cause coming unsupported media type. Please send shown body only. ";
    public static final String METHOD_NOT_ALLOWED = "Used not valid http method. Please check it. ";
    public static final String ACCESS_DENIED = "This resource is forbidden for this credentials! ";
    public static final String UNAUTHORIZED = "Please login first in order to access the resource! ";
    public static final String ERROR_WHILE_CALLING_NIBBD = "Error Occurred while calling NIBBD API ";
    public static final String ERROR_WHILE_CALLING_PLEDGE_REGISTRY = "Error Occurred while calling Pledge Registry API ";
    public static final String OTP_SERVICE_UNAVAILABLE = "OTP service is unavailable";
    public static final String SERVICE_UNAVAILABLE = "Third Party service is unavailable ";
    public static final String OTP_SUCCESS = "Entered code is valid";
    public static final String OTP_FAIL = "Entered code is not valid";
    public static final String PASSWORD_INCORRECT = "Password is incorrect!";
    public static final String USER_NOT_FOUND = "User not found!";
    public static final String OTP_GENERATED = "Otp code generated successfully, it expires in %s minutes";
    public static final String INVALID_PHONE_NUMBER = "Client phone number is not valid!";

    private ApiMessages() {
    }
}
