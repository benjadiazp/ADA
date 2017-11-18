import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;

/****************************
*                           *
*   Integrantes:            *
*                           *
*   Matías Chávez           *
*   Constanza Conejeros     *
*   Benjamín Díaz           *
*   Gastón Lara             *
*   Juan Muñoz              *
*   Francisca Palma         *
*   Camila Pinto            *
*                           *
****************************/

public class Nov13
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int [] arr = input(sc);
        System.out.println("Ingrese EL número");
        int n = sc.nextInt(); sc.close();
        backtracking(cortarArreglo(arr, n), new LinkedList<Integer>(), n, -1);
    }

    static int[] input(Scanner sc)
    {
        System.out.print("Ingrese tamaño del arreglo.");
        int [] arr = new int[sc.nextInt()];
        for (int i=0; i<arr.length; i++) arr[i] = (int)(Math.random()*20) + 1; //Rellena con números del 1 al 20.
        Arrays.sort(arr);
        return arr;
    }

    static int[] cortarArreglo(int[] arr , int n)
    {
        int[] arr2 = new int[arr.length]; int cont=0;
        for (int i : arr) if (i <= n) arr2[cont++]=i;
        arr = new int[cont];
        for (int i=0; i<cont; i++) arr[i] = arr2[i];
        output(arr);
        return arr;
    }

    static void backtracking(int[] a, LinkedList<Integer> c, int n, int cont)
    {
        output(c);
        if (reject(a, c, n)) return;
        System.out.println("Not rejected.");
        if (accept(a, c, n)) output(c);
        c = siguienteCandidato(a, c, ++cont);
        if (first(a, c, n, cont))
        do backtracking(a, c, n, cont); while (next(a, c, n, ++cont));
    }
    static boolean reject(int[] a, LinkedList<Integer> c, int n)
    {
        if (suma(c)>n)
        return true;
        return false;
    }

    static int suma(LinkedList<Integer> p)
    {
        int suma=0;
        for (int i=0; i<p.size(); i++) suma+=p.get(i);
        return suma;
    }

    static boolean accept(int[] a, LinkedList<Integer> c, int n)
    {
        if (suma(c)==n) return true;
        System.out.println("Not accepted.");
        return false;
    }

    static void output(int [] arr)
    {
        System.out.println("Arreglo:");
        System.out.print("{");
        for (int i: arr) System.out.print(i + " ");
        System.out.println("}");
    }

    static void output(LinkedList<Integer> c)
    {
        System.out.println("Candidato:");
        System.out.print("{");
        for (int i: c) System.out.print(i + " ");
        System.out.println("}");
    }

    static boolean first(int[] a, LinkedList<Integer> c, int n, int cont)
    {
        if (cont < a.length) return true;
        return false;
    }

    static boolean next(int[] a, LinkedList<Integer> c, int n, int cont)
    {
        if (cont >= a.length) return false;
        System.out.println("Next, cont: " + cont);
        return true;
    }

    static LinkedList siguienteCandidato(int [] arr, LinkedList<Integer> c, int cont)
    {
        if (cont < arr.length)
        c.add(arr[cont]);
        return c;
    }
}