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
        System.out.print("Ingrese tamaño del arreglo.");
        int tam = sc.nextInt();
        
        int [] arr = new int[tam];
        for (int i=0; i<arr.length; i++) arr[i] = (int)(Math.random()*20) + 1; //Rellena con números del 1 al 20.
        Arrays.sort(arr);
        System.out.println("Ingrese EL número");
        int n = sc.nextInt(), cont = 0;
        
        sc.close();
        int[] arr2 = new int[tam];

        for (int i : arr) if (i <= n) arr2[cont++]=i;
        arr = new int[cont];
        for (int i=0; i<cont; i++) arr[i] = arr2[i];
        output(arr);
        backtracking(arr, new LinkedList<Integer>(), n, -1);
        output(arr);
    }

    static void backtracking(int[] a, LinkedList<Integer> c, int n, int cont)
    {
        if (reject(a, c, n)) return;
        if (accept(a, c, n)) output(a);
        c = siguienteCandidato(a, c, ++cont);
        if (first(a, c, n, cont))
        do backtracking(a, c, n, cont); while (next(a, c, n, cont));
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
        if (suma(c)==n)
        return true;
        return false;
    }

    static void output(int [] arr)
    {
        System.out.print("{");
        for (int i: arr)
        {
            System.out.print(i + ", ");
        }
        System.out.print("}");
    }

    static boolean first(int[] a, LinkedList<Integer> c, int n, int cont)
    {
        if (cont < a.length)
        return true;
        return false;
    }

    static boolean next(int[] a, LinkedList<Integer> c, int n, int cont)
    {
        
        return true;
    }

    static LinkedList siguienteCandidato(int [] arr, LinkedList<Integer> c, int cont)
    {
        if (cont < arr.length)
        c.add(arr[cont]);
        return c;
    }
}