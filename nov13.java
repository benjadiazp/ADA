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
        output(arr);
        backtracking(cortarArreglo(arr, n), new LinkedList<Integer>(), n, 0);
    }

    static void backtracking(int[] arr, LinkedList<Integer> c, int n, int cont) //La función que importa.
    {
        if (reject(arr, c, n)) return;
        if (accept(arr, c, n)) return;
        if (first(arr, c, cont)) do
        {
            siguienteCandidato(arr, c, ++cont);
            backtracking(arr, c, n, cont);
        } while (next(arr, n, c, cont));
    }

    static boolean reject(int[] a, LinkedList<Integer> c, int n)
    { if (suma(c)>n) return true; else return false; }

    static boolean accept(int[] a, LinkedList<Integer> c, int n)
    { if (suma(c)==n) { output(c); return true; } else return false; }
    
    static boolean first(int[] a, LinkedList<Integer> c,  int cont)
    { return cont <= a.length; }

    static boolean next(int[] a, int n, LinkedList<Integer> c, int cont)
    { if (!c.isEmpty()) c.pop(); return cont<a.length; }
    
    static LinkedList<Integer> siguienteCandidato(int [] arr, LinkedList<Integer> c, int cont)
    { if (arr.length - cont >= 0) c.push(arr[arr.length - cont]); else c=null; return c; }

    static int suma(LinkedList<Integer> p)
    {
        int suma=0;
        for (int i=0; i<p.size(); i++) suma+=p.get(i);
        return suma;
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
        System.out.print("{");
        for (int i: c) System.out.print(i + " ");
        System.out.println("}");
    }
    
    static int[] input(Scanner sc)
    {
        System.out.println("Ingrese tamaño del arreglo.");
        int [] arr = new int[sc.nextInt()];
        for (int i=0; i<arr.length; i++) arr[i] = (int)(Math.random()*20) + 1; //Rellena con números del 1 al 20.
        Arrays.sort(arr);
        return arr;
    }

    static int[] cortarArreglo(int[] arr , int n) //Se quitan los números mayores a n y se convierte a un arreglo más pequeño.
    {
        int[] arr2 = new int[arr.length]; int cont=0;
        for (int i : arr) if (i <= n) arr2[cont++]=i;
        arr = new int[cont];
        for (int i=0; i<cont; i++) arr[i] = arr2[i];
        output(arr);
        return arr;
    }
}