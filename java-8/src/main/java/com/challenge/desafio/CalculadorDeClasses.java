package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;
import com.sun.javafx.css.CssError;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object objClasse) {
        return somarTotal(objClasse, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object objClasse) {
        return somarTotal(objClasse, Subtrair.class);
    }

    private BigDecimal somarTotal(Object objClasse, Class anotacao) {
        BigDecimal valorAtributosBigDecimal = new BigDecimal(0);

        //System.out.println("Os campos da classe são : ");
        //for(Field f : objClasse.getClass().getDeclaredFields()) {
        //    System.out.print(f.getName() + ", ");
        //}

        for (Field f : objClasse.getClass().getDeclaredFields()) {
            if (f.getType().isAssignableFrom(BigDecimal.class)) {
                if (f.isAnnotationPresent(anotacao)) {
                    try {
                        //System.out.println("Valor Atributos para : " + " " + anotacao +  " "  + (BigDecimal) f.get(objClasse));
                        valorAtributosBigDecimal = valorAtributosBigDecimal.add((BigDecimal) f.get(objClasse));
                    } catch (IllegalAccessException e){
                        valorAtributosBigDecimal = valorAtributosBigDecimal.add(obterValorAtributo(objClasse,f.getName()));
                    }
                }
            }
        }
        return valorAtributosBigDecimal;
    }

    private BigDecimal obterValorAtributo(Object objClasse, String atributo) {
        PropertyDescriptor prop;
        try {
            prop = new PropertyDescriptor(atributo,objClasse.getClass());
            return (BigDecimal) prop.getReadMethod().invoke(objClasse);
        } catch (IllegalAccessException | InvocationTargetException | IntrospectionException e){
            return  new BigDecimal(0);
        }

    }

    @Override
    public BigDecimal totalizar(Object objClasse) {
        BigDecimal valorSomar = somar(objClasse);
        BigDecimal valorDiminuir = subtrair(objClasse);
        return valorSomar.subtract(valorDiminuir);
      }

}
