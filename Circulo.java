/****************************
*   Integrantes:            *
*                           *
*   Benjamín Díaz           *
*   Gastón Lara             *
*   Juan Muñoz              *
*   Francisca Palma         *
*   Camila Pinto            *
****************************/

import java.util.Scanner;
public class Circulo
{
    static int n, m, posX, posY, r;
    static char[][] matriz;
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        posY = s.nextInt();
        posX = s.nextInt();
        r = s.nextInt();

        matriz = new char[n][m];
        crearMatrix(); //Acá se llena de '.'.
        dibujarCirculo(); //Acá se dibuja con todos sus '#'.
        imprimirMatrix(); //Acá se imprime en consola.

        s.close();
    }

    static void crearMatrix()
    {
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                matriz[i][j] = '.';
    }

    static void dibujarCirculo()
    {
        for (int i=0; i<=r; i++)
        {
            for (int j=0; j<=r; j++)
            {
                if ((i*i + j*j) <= r*r) //Condición para ver si dibujar el # en i,j. Se evita usar raíz cuadrada.
                {
                    //Con todos estos if se verifica que no se escribirá un # fuera del plano.
                    if (posX + i < n && posY + j < m && posX + i >= 0 && posY + j >= 0) 
                        matriz[posX + i][posY + j] = '#';

                    if (posX + i < n && posY - j >=0 && posY - j < m && posX + i >= 0)
                        matriz[posX + i][posY - j] = '#';

                    if (posX - i < n && posY + j < m && posX - i >= 0 && posY + j >= 0)
                        matriz[posX - i][posY + j] = '#';

                    if (posX - i < n && posY - j < m && posX - i >= 0 && posY - j >=0)
                        matriz[posX - i][posY - j] = '#';
                }
            }
        }
    }

    static void imprimirMatrix()
    {
        for (int i=0; i<n; i++)
        {
            System.out.println();
            for (int j=0; j<m; j++)
                System.out.print(matriz[i][j]);
        }
        System.out.println();
    }
}
