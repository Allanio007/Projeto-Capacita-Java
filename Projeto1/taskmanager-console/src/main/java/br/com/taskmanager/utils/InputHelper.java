package br.com.taskmanager.utils;

import br.com.taskmanager.exceptions.EntradaInvalidaException;

import java.util.Scanner;

public class InputHelper {
    private final Scanner scanner;

    public InputHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public String lerTextoObrigatorio(String label) {
        System.out.print(label);
        String valor = scanner.nextLine();
        if (valor == null || valor.trim().isEmpty()) {
            throw new EntradaInvalidaException("Entrada de texto obrigatoria.");
        }
        return valor.trim();
    }

    public int lerInteiro(String label) {
        System.out.print(label);
        String valor = scanner.nextLine();
        try {
            return Integer.parseInt(valor.trim());
        } catch (NumberFormatException ex) {
            throw new EntradaInvalidaException("Digite um numero inteiro valido.");
        }
    }
}
