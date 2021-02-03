import java.util.Scanner;

import java.io.*;

public class Calculadora implements ICalculadora {

    Scanner sc = new Scanner(System.in);

    StackArrayList<Integer> auxList = new StackArrayList<>();

    File file = null;
    FileReader fr = null;
    BufferedReader br = null;

    public void readFile() {
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
                
                Integer result = 0;
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
                            System.out.println("");
                        }

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

                System.out.println("Resultado: " + result);

            }

            

        } catch (Exception e) {
            System.out.println("[!] No se encontro el archivo");
        }
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

    @Override
    public int multiplicacion(int x, int y) {
        return x * y;
    }

    @Override
    public int resta(int x, int y) {
        return x - y;
    }

    @Override
    public int suma(int x, int y) {
        return x + y;
    }

    @Override
    public int division(int x, int y) {
        int result;
        try {
            result =  x / y;
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
