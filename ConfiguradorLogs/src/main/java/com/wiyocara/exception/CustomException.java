package com.wiyocara.exception;

/**
 * Clase de manejo de excepciones personalizadas
 * @author wcahuaya
 */
public class CustomException extends Exception{
	
	private static final long serialVersionUID = 700L;
	
	public CustomException(String mensaje){
		super(mensaje);
	}
}
