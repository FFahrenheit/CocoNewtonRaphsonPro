package coconewtonraphsonpro;

import java.util.Scanner;

/**
 * Este programa sirve como interfaz para resolver ecuaciones de
 * n grado (con n<=100) mediante el método Newton Raphson 
 * Pide los valores y regresa el resultado en consola.
 * @author ivxn
 */
public class CocoNewtonRaphsonPro {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int actualCoef, actualExp;
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de miembros en la ecuación: ");
        int count = input.nextInt();
        Equation myEquation = new Equation(count);
        for(int i=0; i<count; i++)
        {
            System.out.print("Ingrese el coeficiente del miembro "+(i+1)+": ");
            actualCoef = input.nextInt();
            System.out.print("Ingrese el exponente del miembro "+(i+1)+": ");
            actualExp = input.nextInt();
            myEquation.setMember((double)actualCoef, (double)actualExp, i);
        }
        System.out.print("Ingrese el numero con qué empezar las iteraciones: ");
        double begin = input.nextDouble();
        System.out.print("Ingrese sigma (margen de error): ");
        double error = input.nextDouble();
        double answer = myEquation.newtonRaphson(begin,error);
        System.out.println("Solucion: "+answer+" (en "+myEquation.iterations+" iteraciones)");
    }
}