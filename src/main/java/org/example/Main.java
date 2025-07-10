package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println("Digite a senha: ");
            String senha = scanner.nextLine();

            StringBuilder erros = new StringBuilder();

            if (senha.length() < 8) {
                erros.append("A senha deve ter no mínimo 8 caracteres\n");
            }

            boolean temLetraMaiuscula = false;
            for (char c : senha.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    temLetraMaiuscula = true;
                    break;
                }
            }
            if (!temLetraMaiuscula) {
                erros.append("A senha deve conter pelo menos uma letra maiúscula\n");
            }

            boolean temNumero = false;
            for (char c : senha.toCharArray()) {
                if (Character.isDigit(c)) {
                    temNumero = true;
                    break;
                }
            }
            if (!temNumero) {
                erros.append("A senha deve conter pelo menos um número\n");
            }

            boolean temCaractereEspecial = false;
            String caractereEspecial = "!@#$%^&*()_-+=[]{}|:~,.<>/?'´`";
            for (char c : senha.toCharArray()) {
                if (caractereEspecial.indexOf(c) != -1) {
                    temCaractereEspecial = true;
                    break;
                }
            }
            if (!temCaractereEspecial) {
                erros.append("A senha deve conter pelo menos um caractere especial\n");
            }

            if (erros.length() == 0) {
                System.out.println("Senha cadastrada!\n");
                break;
            } else {
                System.out.println("Senha inválida devido aos seguintes erros: \n");
                System.out.println(erros);
            }

        }

        scanner.close();
    }

}