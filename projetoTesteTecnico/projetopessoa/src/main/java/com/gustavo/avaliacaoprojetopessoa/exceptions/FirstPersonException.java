package com.gustavo.avaliacaoprojetopessoa.exceptions;

public class FirstPersonException extends Exception {

    public FirstPersonException() {
        super("Já existe endereço principal ou 'isPrincipal' está nulo! " +
                "\nPor favor, altere 'isPrincipal' para False ou altere o endereço principal cadastrado!");
    }
}
