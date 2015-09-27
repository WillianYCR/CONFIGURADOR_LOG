package com.wiyocara.test;

import com.wiyocara.example.Calculo;
import com.wiyocara.exception.ConfiguratorFile;
import com.wiyocara.exception.CustomException;

import org.apache.log4j.PropertyConfigurator;

public class PruebaTest {

	public static void main(String[] args) throws CustomException {
		PropertyConfigurator.configure(ConfiguratorFile.getLog4j());
		Calculo calculo = new Calculo();
		calculo.sumar("8", "9");
		calculo.multiplicar("8", "6");
		calculo.cambiarValorProperties("VALOR_ONE", "Hola");
		calculo.cambiarValorProperties("VALOR_DOS", "Hola1");
		calculo.cambiarValorProperties("VALOR_TRES", "Hola2");
	}

	
}
