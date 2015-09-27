package com.wiyocara.util;

import org.apache.log4j.Logger;

import com.wiyocara.exception.ConfiguratorFile;
import com.wiyocara.exception.CustomException;

/**
 * Class validate only to input of numbers
 * 
 * @version 1.0.1
 * @author wcahuaya
 */
public class Validation {

	private final static Logger log = Logger.getLogger(Validation.class);

	public Validation() {

	}

	/**
	 * Solo se permite calcular el número de un solo d�gito
	 * 
	 * @param numA
	 *            cadena del primer numero
	 * @param numB
	 *            cadena del segundo numero
	 * @return valor booleano
	 */
	public static boolean validarNumero(String numA, String numB)
			throws CustomException {

		boolean retorno = false;

		if (numA.length() != 1 || numB.length() != 1) {
			String mensaje = ConfiguratorFile.getException("DIGITO_UNO");
			log.info(mensaje);
			throw new CustomException(mensaje);
		}
		try {
			Integer.parseInt(numA);
			Integer.parseInt(numB);
			retorno = true;
		} catch (NumberFormatException ce) {
			String mensaje = ConfiguratorFile.getException("SOLO_NUMERO");
			log.warn(mensaje);
			throw new CustomException(mensaje);
		}
		return retorno;
	}

}
