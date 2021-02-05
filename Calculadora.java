import java.util.Scanner;

import java.io.*;

public class Calculadora implements ICalculadora {

    private Scanner sc = new Scanner(System.in);
    private StackArrayList<Integer> auxList = new StackArrayList<>();

    // Almacenar el archivo de texto
    File file = null;
    FileReader fr = null;
    BufferedReader br = null;

    /*
     * Incia la calculadora  y lee el archivo de texto con las operaciones
     * 
     * @return: void
     */
    public void start() {
        System.out.print("Ingrese la ruta del archivo: ");
        String src = sc.nextLine();
        System.out.print("\n");

        try {
            // Leer el archivo de texto
            file = new File(src);
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {

                // Toma el resultado de la operación y lo muestra en pantalla
                System.out.println("Resultado: " + calculateResult(line));

            }

        } catch (Exception e) {
            System.out.println("[!] No se encontro el archivo");
        }
    }

    /*
     * Realiza la logica correspondiente a la calculadora
     * 
     * @params: Un string con los caracteres a operar
     * 
     * @return: El resultado de la operación
     */

    public int calculateResult(String line) {
        // Separar el contenido en un array
        String[] tempLine = line.split(" ");

        // Recorre el contenido de una linea
        for (int i = 0; i < tempLine.length; i++) {

            // Verifica si es un numero o una instruccion
            if (isNumber(tempLine[i])) {
                auxList.push(Integer.parseInt(tempLine[i]));
            } else {

                int firstNumber = 0;
                int secondNumber = 0;

                // Comprueba que si existan suficientes numeros para operar
                try {
                    firstNumber = auxList.pop();
                    secondNumber = auxList.pop();
                } catch (Exception e) {
                    System.out.println("[!]");
                }

                // Mira el tipo de operador y llama al método correspindiente para realizar la
                // operación
                // Luego guarda el resultado en el Stack
                switch (tempLine[i]) {
                    case "*":
                        auxList.push(multiplicacion(firstNumber, secondNumber));
                        break;
                    case "+":
                        auxList.push(suma(firstNumber, secondNumber));
                        break;
                    case "-":
                        auxList.push(resta(firstNumber, secondNumber));
                        break;
                    case "/":
                        auxList.push(division(firstNumber, secondNumber));
                        break;
                }

            }

        }

        return auxList.peek();

    }

    /*
     * Revisa si el dato ingresado es un numero o no
     * 
     * @params: el caracter a revisar
     * 
     * @return: Si es un numero devuelve True de lo contrario False
     */
    private Boolean isNumber(String txt) {
        Boolean result;
        try {
            Integer.parseInt(txt);
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    /*
     * Realiza una multiplicación entre el número X y Y
     * 
     * @params: Los números a multiplicar
     * 
     * @return: El resultado de la operación
     */
    @Override
    public int multiplicacion(int x, int y) {
        return x * y;
    }

    /*
     * Realiza una resta entre el número X y Y
     * 
     * @params: Los números a restar
     * 
     * @return: El resultado de la operación
     */
    @Override
    public int resta(int x, int y) {
        return x - y;
    }

    /*
     * Realiza una suma entre el número X y Y
     * 
     * @params: Los números a sumar
     * 
     * @return: El resultado de la operación
     */
    @Override
    public int suma(int x, int y) {
        return x + y;
    }

    /*
     * Realiza una división entre el número X y Y
     * 
     * @params: Los números a dividir
     * 
     * @return: El resultado de la operación
     */
    @Override
    public int division(int x, int y) {
        int result;
        try {
            result = x / y;
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    @Override
    public String decode(String a) {
        return null;
    }

    @Override
    public int operar(Stack x) {
        return 0;
    }

}
