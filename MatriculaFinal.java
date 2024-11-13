package Practica_ejercicios;

import java.util.Scanner;

public class MatriculaFinal {
      public static void main(String[] args) {
        int contador = 0;
        boolean fueraLimites = false;
        @SuppressWarnings("resource")
        Scanner leer = new Scanner(System.in);

        char letra[] = new char[3];
        int numero[] = new int[7];

        do {
            System.out.println("Introduzca matrícula: ");
            String matricula = leer.nextLine().toUpperCase();

            contador = 0;
            fueraLimites = false;
            try{
                for (int i = 0; i < matricula.length(); i++) {
                    char caracter = matricula.charAt(i);
                    if (Character.isLetter(caracter)) {
                        letra[i] = caracter;
                        switch (letra[i]) {
                            case 'A':
                            case 'E':
                            case 'I':
                            case 'O':
                            case 'U':
                                contador++;
                                break;
                        }
                        // System.out.println(i + " letra: " + letra[i]);
                    } else {
                        numero[i] = caracter - '0';
                        // System.out.println(i + "numero: " + numero[i]);
                    }
                }
            } catch(ArrayIndexOutOfBoundsException ex){
                System.err.println("Matrícula mal introducida. ");
                fueraLimites = true;
            }
            if (contador > 0) {
                System.out.println("La matrícula contiene vocales.");
            }
        } while ((contador > 0)||(fueraLimites==true));

        numero[6]++;
        if (numero[6] == 10) {
            numero[6] = 0; 

            numero[5]++;
            if (numero[5] == 10) {
                numero[5] = 0;

                numero[4]++;
                if (numero[4] == 10) {
                    numero[4] = 0;

                    numero[3]++;
                    if (numero[3] == 10) {
                        numero[3] = 0;

                        letra[2]++;
                        switch (letra[2]) {
                            case 'A':
                            case 'E':
                            case 'I':
                            case 'O':
                            case 'U':
                                letra[2]++;
                                break;
                        }
                        if (letra[2] == 91) {
                            letra[2] = 'B';

                            letra[1]++;
                            switch (letra[1]) {
                                case 'A':
                                case 'E':
                                case 'I':
                                case 'O':
                                case 'U':
                                    letra[1]++;
                                    break;
                            }
                            if (letra[1] == 91) {
                                letra[1] = 'B';

                                letra[0]++;
                                switch (letra[0]) {
                                    case 'A':
                                    case 'E':
                                    case 'I':
                                    case 'O':
                                    case 'U':
                                        letra[0]++;
                                        break;
                                }
                                if (letra[0]== 91) {
                                    letra[0]='B';

                                }
                            }
                        }
                    }
                }
            }
        }

        String matriculaFinal=String.valueOf(letra[0]) + String.valueOf(letra[1]) + String.valueOf(letra[2]) + String.valueOf(numero[3]) + String.valueOf(numero[4]) + String.valueOf(numero[5]) + String.valueOf(numero[6]);
        if (matriculaFinal.equals("BBB0000")) {
            System.out.println("No hay más matrículas :(");
        } else {
            System.out.println("La siguiente matrícula es " + matriculaFinal );
        }
    }
}
