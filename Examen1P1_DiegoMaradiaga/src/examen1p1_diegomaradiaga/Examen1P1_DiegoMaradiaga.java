
package examen1p1_diegomaradiaga;

import java.util.Scanner;
import java.util.Random;

public class Examen1P1_DiegoMaradiaga {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("-----------------------------------------");
            System.out.println("              >>>> MENU <<<<             ");
            System.out.println(" ");
            System.out.println("1) Divisores primos               ");
            System.out.println("2) Contorno de Pirámide           ");
            System.out.println("3) Vecinos                        ");
            System.out.println("4) Triangulo de Pascal            ");
            System.out.println("5) Salir                          ");
            System.out.print("Ingrese su opcion: ");
            opcion = leer.nextInt();
            System.out.println("");

            switch (opcion) {
                case 1: {
                    System.out.println("Divisores Primos");
                    System.out.print("Inserte un numero: ");
                    int N = leer.nextInt();

                    while (N == 0 || N < 0) {
                        System.out.println("Error: Numero igual o menor de 0");
                        System.out.print("Inserte un numero: ");
                        N = leer.nextInt();
                    }//Fin while

                    System.out.println("Los numeros primos que dividen el numero " + N + " son: " + primos(N));
                }//Fin case 1 
                break;
                case 2: {
                    System.out.println("Contorno de Piramide");
                    int tamano;
                    System.out.print("Ingrese un tamaño IMPAR: ");
                    tamano = leer.nextInt();
                    int Par;
                    Par = tamano % 2;

                    while (Par == 0) {
                        System.out.println("Error: Numero PAR");
                        System.out.print("Ingrese un tamaño IMPAR: ");
                        tamano = leer.nextInt();
                        Par = tamano % 2;
                    }//Fin while 
                    contorno(tamano);

                }//Fin case 2
                break;
                case 3: {
                    System.out.println("Vecinos");
                    System.out.print("Ingrese una cadena: ");
                    String cadena = leer.next();
                    int cont = 0;

                    for (int i = 0; i < cadena.length(); i++) {
                        char letra = cadena.charAt(i);
                        int n = (int) letra;
                        if ((n < 65 || n > 90) && (n < 97 || n > 122)) {
                            cont = cont + 1;
                        }//Fin if     
                    }//Fin for

                    while (cont > 0) {
                        System.out.println("OJO: Es obligatorio que el usuario ingrese unicamente letras");
                        System.out.print("Ingrese una cadena: ");
                        cadena = leer.next();
                        cont = 0;
                        for (int i = 0; i < cadena.length(); i++) {
                            char letra = cadena.charAt(i);
                            int n = (int) letra;
                            if ((n < 65 || n > 90) && (n < 97 || n > 122)) {
                                cont = cont + 1;
                            }//Fin if     
                        }//Fin for
                    }//Fin while

                    System.out.println("Cadena resultante: " + vecinos(cadena));

                }//Fin case 3
                break;
                case 4: {
                    System.out.println("Triangulo de Pascal");
                    System.out.println("Ingrese un tamano: ");
                    int N = leer.nextInt();
                    
                    while ( N <= 0){
                        System.out.println("Error: Numero menor o igual a 0");
                        System.out.println("Ingrese un tamano: ");
                        N = leer.nextInt();
                    }
                    pascal(N);
                }
                break;//Fin case 4
                default: {
                    System.out.println("Saliendo...");
                }
                break;
            }//Fin switch  
        } while (opcion != 5);

    }//Fin de main
    public static String primos (int N){
        int primo;
        String acum = "";
        String cadena = "";

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                primo = i;

                if (primo % 2 != 0 || primo==2) {
                    acum += primo+", ";
                }//Fin while
            }
        }//Fin for
        cadena = ""+acum;        
        return cadena ;
    }//Fin metodo primos
    public static void contorno(int tamano){
        int T1 = (tamano +1)/2;
        
        for (int i = 0; i < T1; i++) {
            for (int j = T1-i-1; j > 0; j--) {
                System.out.print("*");
            }//Primer triangulo
            for (int j = 0; j <= i; j++) {
                if (j == 0 && i!=T1-1){
                System.out.print("+");
                }else if (i == T1 - 2){
                System.out.print("+"); 
                }
                else if(i == T1-1){
                System.out.print("*");
                }else{
                 System.out.print(" ");
                }
            }//Segundo triangulo
            for (int j = 0; j < i; j++) {
                if (j == i-1 && i!=T1-1){
                System.out.print("+");
                }else if (i == T1 - 2){
                System.out.print("+"); 
                }else if (i == T1-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }//Tercer triangulo
            for (int j = T1 - i-1; j > 0; j--) {
                if (j == T1 - i){
                    System.out.print("*");
                }
                else{
                    System.out.print("*");
                }
            }//Cuarto triangulo
            System.out.println("");
        }//Fin for             
    }
    public static String vecinos(String cadena){
        
        Random aleatorio = new Random();
        int numR = 0 + aleatorio.nextInt(2);

        System.out.println("Numero generado: " + numR);
        String acum = "";

        if (numR == 0) {
            for (int i = 0; i < cadena.length(); i++) {
                char caracter = cadena.charAt(i);
                int valor = (int) caracter;
                int conversion = valor - 1;
                char conversion2 = (char) conversion;
                acum += conversion2;
            }
        }

        if (numR == 1) {
            for (int i = 0; i < cadena.length(); i++) {
                char caracter = cadena.charAt(i);
                int valor = (int) caracter;
                int conversion = valor + 1;
                char conversion2 = (char) conversion;
                acum += conversion2;
            }
        }

        return acum;
    }
    public static int factorial (int N){
        int facto = 1;
        for (int i = 1; i <= N; i++) {
            facto = facto * i;
        }
    return facto;
    }//Fin metodo factorial
    public static int permutacion (int n, int r){
        int permu = 0;
        permu = factorial(n)/factorial(n-r);
        
    return permu;
    }//Fin metodo permutacion
    public static int combinacion (int n, int r){
        int combi = 0;
        combi = permutacion(n,r)/factorial(r);
        
    return combi;
    
    }//Fin metodo combinacion
    public static void pascal (int N){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                int n = i;
                int r = j;
                System.out.print("["+combinacion(n,r)+"]");
            }
            System.out.println("");
        }
    }//Fin metodo pascal  
   
}//Fin de clase
