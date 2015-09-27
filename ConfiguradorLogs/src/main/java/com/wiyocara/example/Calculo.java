package com.wiyocara.example;

import org.apache.log4j.Logger;

import com.wiyocara.exception.ConfiguratorFile;
import com.wiyocara.exception.CustomException;
import com.wiyocara.util.Validation;

/**
 * 
 * @author wcahuaya
 * 
 */
public class Calculo {

	private final static Logger log = Logger.getLogger(Calculo.class);

	public Calculo() {

	}

	/**
	 * Calcula la suma de dos numeros enteros
	 * 
	 * @param numA
	 * @param numB
	 * @return entero, suma de numA y numB
	 * @throws CustomException
	 */
	public int sumar(String numA, String numB) throws CustomException {
		if (!Validation.validarNumero(numA, numB))
			return 0;
		int respuesta = Integer.parseInt(numA) + Integer.parseInt(numB);
		log.info("suma: " + numA + " + " + numB + " = " + respuesta);
		return respuesta;
	}

	/**
	 * Calcula el multiplo de dos numeros enteros
	 * 
	 * @param numA
	 * @param numB
	 * @return entero, multiplicacion de numA y numB
	 * @throws CustomException
	 */
	public int multiplicar(String numA, String numB) throws CustomException {
		if (!Validation.validarNumero(numA, numB))
			return 0;
		int respuesta = Integer.parseInt(numA) + Integer.parseInt(numB);
		log.info("multiplicacion: " + numA + " x " + numB + " = " + respuesta);
		return respuesta;
	}

	/**
	 * Realiza cambio de valor en el properties
	 * 
	 * @param idException
	 *            Identificador del atributo del properties
	 * @param nameException
	 *            Valor del atributo del properties
	 * @throws CustomException
	 */
	public void cambiarValorProperties(String idException, String nameException)
			throws CustomException {
		ConfiguratorFile.setException(idException, nameException);
	}
}
