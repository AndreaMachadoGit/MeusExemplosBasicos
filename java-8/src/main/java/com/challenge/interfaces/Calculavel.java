package com.challenge.interfaces;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public interface Calculavel {

    public BigDecimal somar(Object nomeClasse);

    public BigDecimal subtrair(Object nomeClasse);

    public BigDecimal totalizar(Object nomeClasse);

}
