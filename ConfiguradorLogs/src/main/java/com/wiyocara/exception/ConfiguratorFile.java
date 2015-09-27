package com.wiyocara.exception;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Clase para configuraci�n de archivos
 * 
 * @author wcahuaya
 * 
 */
public class ConfiguratorFile {

	public static int proceso = 0;
	
	private static final String RUTA_PROPERTIES_LOG4J = "file/log4j.properties";
	private static final String RUTA_PROPERTIES_EXCEPTION = "file/exceptions.properties";
	private static final String RUTA_PROPERTIES_EXCEPTION_SET = "file/exceptions_set.properties";
	private static final String NO_CIERRA_INSTANCE_IS = "No se cerró la instance de InputStream";
	private static final String NO_INSTANCE_FIS = "Error al instanciar la Clase FileInputStream";
	
	private static Properties properties;
	

	private ConfiguratorFile() {

	}

	/**
	 * Metodo para obtener valores del properties
	 * 
	 * @param nameException
	 *            Cadena del atributo del properties
	 * @return
	 * @throws CustomException
	 */
	public static String getException(String nameException)
			throws CustomException {
		return getProperties(nameException, RUTA_PROPERTIES_EXCEPTION);
	}

	/**
	 * Metodo para cambiar valores del properties
	 * 
	 * @param idException
	 *            Identificador del atribtuto de properties
	 * @param nameException
	 *            Valor para el atributo del properties
	 * @throws CustomException
	 */
	public static void setException(String idException, String nameException)
			throws CustomException {
		setProperties(idException, nameException, RUTA_PROPERTIES_EXCEPTION_SET);
	}

	/**
	 * Sólo es para capturar la ruta del properties Log4j
	 * 
	 * @return
	 * @throws CustomException
	 */
	public static String getLog4j() throws CustomException {
		proceso = 1;
		return RUTA_PROPERTIES_LOG4J;
	}

	private static String getProperties(String nameException,
			String rutaProperties) throws CustomException {
		if (properties == null) {
			properties = new Properties();
		}
		InputStream inStream = null;
		String respuesta;
		try {
			inStream = new FileInputStream(rutaProperties);
			properties.load(inStream);
			respuesta = properties.getProperty(nameException);
		} catch (IOException ioe) {
			respuesta = "1001";
			throw new CustomException(NO_INSTANCE_FIS);
		} finally {
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException io) {
					respuesta = "1002";
					throw new CustomException(NO_CIERRA_INSTANCE_IS);
				}
			}
		}
		return respuesta;
	}

	private static void setProperties(String idException, String nameException,
			String rutaProperties) throws CustomException {
		if (properties == null) {
			properties = new Properties();
		}
		OutputStream outStream = null;
		try {
			outStream = new FileOutputStream(rutaProperties);

			properties.setProperty(idException, nameException);
			properties.store(outStream, null);
		} catch (IOException ioe) {
			throw new CustomException(NO_INSTANCE_FIS);
		} finally {
			if (outStream != null) {
				try {
					outStream.close();
				} catch (IOException io) {
					throw new CustomException(NO_CIERRA_INSTANCE_IS);
				}
			}
		}
	}

}
