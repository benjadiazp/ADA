/****************************
*   Integrantes:            *
*                           *
*   Benjamín Díaz           *
*   Gastón Lara             *
*   Juan Muñoz              *
*   Francisca Palma         *
*   Camila Pinto            *
****************************/

public class Algoritmo
{
    public static int[] sort(int[] a) {

        if (arregloOrdenado(a))
        {
            return a;
        }
        else if (arrInv(a))
        {
            invArr(a);
            return a;
        }
        int[] auxArr = new int[buscarValorMax(a) + 1];

        for (int i=0; i<a.length; i++)
            auxArr[a[i]]++;

        int auxVar=0;
        for (int i=0; i<auxArr.length; i++)
            for (int j=0; j<auxArr[i]; j++)
                a[auxVar++] = i;


        return a;
    }

    static int buscarValorMax(int[] a)
    {
        int max = a[0];
        for (int i=0; i<a.length;i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }

    static boolean arregloOrdenado(int[] a)
    {
        for (int i=1; i<a.length; i++)
            if (a[i] < a[i-1])
                return false;
        return true;
    }


    static boolean arrInv(int[] a)
    {
        for (int i=1; i<a.length; i++)
        {
            if (a[i] > a[i-1])
                return false;
        }
        return true;
    }

    static int[] invArr(int[] a)
    {
        int[] array = new int[a.length];
        for (int i=0; i<array.length; i++)
        {
            array[i] = a[a.length-i-1];
        }
        return array;
    }
}
