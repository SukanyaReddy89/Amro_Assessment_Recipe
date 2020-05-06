package com.abnamro.recipe.api;

@javax.annotation.Generated(value = "com.abnamro.recipe.codegen.languages.SpringCodegen", date = "2020-05-03T11:05:49.409Z")

public class ApiException extends Exception{
   
	private static final long serialVersionUID = 1L;
	private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
