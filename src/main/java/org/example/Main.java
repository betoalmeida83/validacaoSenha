package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Digite a senha: ");
            String senha = scanner.nextLine();

            String resultadoValidacao = validarSenha(senha);

            if (resultadoValidacao.isEmpty()) {
                System.out.println("\nSenha cadastrada!\n");
                break;
            } else {
                System.out.println("Senha inválida devido aos seguintes erros:");
                System.out.println(resultadoValidacao);
            }

        }

        scanner.close();

    }

    public static String validarSenha(String senha) {

        StringBuilder erros = new StringBuilder();

        if (!temTamanhoValido(senha)) {
            erros.append("- A senha deve ter no mínimo 8 caracteres\n");
        }

        if (!temLetraMaiuscula(senha)) {
            erros.append("- A senha deve conter pelo menos uma letra maiúscula\n");
        }

        if (!temNumero(senha)) {
            erros.append("- A senha deve conter pelo menos um número\n");
        }

        if (!temCaractereEspecial(senha)) {
            erros.append("- A senha deve conter pelo menos um caractere especial\n");
        }

        return erros.toString();
    }

    public static boolean temTamanhoValido(String senha) {
        return senha.length() >= 8;
    }

    public static boolean temLetraMaiuscula(String senha) {
        return senha.matches(".*[A-Z].*");
    }

    public static boolean temNumero(String senha) {
        return senha.matches(".*[0-9].*");
    }

    public static boolean temCaractereEspecial(String senha) {
        return senha.matches(".*[!@#$%^&*()_\\-+=\\[\\]{}|:~,.<>/?'´`].*");
    }

}