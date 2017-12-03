import java.util.Scanner;
public class Mochila
{

    static int[] arrAprox;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int [] pesos = new int[] {200, 150, 100, 50, 280, 15}, arr = new int[buscarMaximo(pesos)+1];
        for (int i: pesos) arr[i] = 1;
        System.out.println("Ingrese espacio de la mochila");
        int N = sc.nextInt();
        sc.close();

        if (N >= 550)
        {
            arr[100] = 2; //1 unidad de agua
            arr[50] = 3; //2 unidades de té
            arr[280] = 2; //1 unidad de pan
            arrAprox = new int[arr.length];
            llenarMochila(pesos, arr, N, arr.length-1);
            System.out.println("No se puede ocupar el espacio totalmente.\nResultado más cercano:");
            output(pesos, arrAprox);
        }
        else System.out.println("Espacio insuficiente.");
    }

    static void llenarMochila(int[] pesos, int[] arr, int N, int aux)
    //VorazTracking®
    {
        int sumaArr = sumaArr(pesos, arr);
        if (sumaArr > N) return; //Reject
        if (sumaArr == N) output(pesos, arr); //Accept

        if (sumaArr > sumaArr(pesos, arrAprox)) arrAprox = copiarArreglo(arr);

        for (int i=aux; i>0; i--) if (arr[i] != 0) //First: aux, Next: i--
        {
            arr[i]++;
            llenarMochila(pesos, arr, N, i);
            arr[i]--;
        }
    }

    static int buscarMaximo(int[] arr)
    {
        int mayor = arr[0];
        for (int i: arr) if (i>mayor) mayor = i;
        return mayor;
    }

    static int sumaArr(int[] pesos, int[] arr)
    {
        int suma = 0;
        for (int i: pesos) suma += (arr[i]-1)*i;
        return suma;
    }

    static void output(int[] pesos, int[] arr)
    {
        System.out.println("Peso en la mochila: " + sumaArr(pesos, arr));
        System.out.println("Cosas en la mochila:");
        for (int i: pesos)
        {
            String nombreCosa = "";
            switch (i)
            {
                case 200: nombreCosa = "Leche"; break;
                case 150: nombreCosa = "Café"; break;
                case 100: nombreCosa = "Agua"; break;
                case 50: nombreCosa = "Té"; break;
                case 280: nombreCosa = "Pan"; break;
                case 15: nombreCosa = "Join"; break;
                default: nombreCosa = "Algo desconocido"; break;
            }
            System.out.println((arr[i]-1) + "x " + nombreCosa + " (Peso " + i + ") \t= " + (arr[i]-1) * i);
        }
            
        System.exit(0);
    }

    static int[] copiarArreglo(int[] arr)
    {
        int[] newArr = new int[arr.length];
        for (int i=0; i<arr.length; i++) newArr[i] = arr[i];
        return newArr;
    }
}