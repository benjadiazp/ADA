import java.util.Scanner;

public class SudokuFinal 
{

/****************************
*   Integrantes:            *
*                           *
*   Benjamín Díaz           *
*   Gastón Lara             *
*   Juan Muñoz              *
*   Francisca Palma         *
*   Camila Pinto            *
****************************/

    public static void main(String[] args) 
    {
        int matriz[][];
        System.out.println("Ingrese Sudoku.\n");
        matriz = leerMatriz();
    
        if (siguienteCelda(matriz, new int[] { 0, -1 }) != null)
        {
            backtracking(matriz, new int[] { 0, -1 });
            System.out.println("\n\nNo hay solución.\n");
            imprimirMatriz(new int[9][9]);
        }
        else
        {
            System.out.println("Sudoku lleno.");
        }
    }

    public static void backtracking(int[][] m, int[] cell)
    {
        if (Reject(m, cell)) return;
        if (Accept(m, cell)) output(m);
        int[] nC = siguienteCelda(m, cell);
        if (First(m, cell))
            do backtracking(m, nC);
        while (Next(m , nC));
    }

    static boolean Reject(int[][] m, int[] c) 
    {
        int x=c[0], y=c[1];
        if (y>=0)
        {
            if (m[x][y] > 0) {
            for (int i = 0; i < 9; i++) 
            {
                if (i != x && (m[i][y] == m[x][y]))
                {
                    return true;
                }

                if (i != y && (m[x][i] == m[x][y])) 
                {
                    return true;
                }
            }
            int primerX = x / 3 * 3, primerY = y / 3 * 3;

            for (int i = primerX; i < primerX + 3; i++)
                for (int j = primerY; j < primerY + 3; j++) 
                {
                    if (x != i && y != j && m[x][y] == m[i][j]) 
                    {
                        return true;
                    }

                }
            }
        }
        
        return false;
    }

    static boolean Accept(int[][] m, int[] c) 
    {
        if (siguienteCelda(m, c) == null) 
        {
            return true;
        }
        return false;

    }

    static void imprimirMatriz(int[][] matriz) 
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
                System.out.print(matriz[i][j] + " ");
            System.out.println();
        }
    }


    static void output(int[][] matriz) 
    {
        System.out.println("\n\nSudoku terminado:\n");
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
                System.out.print(matriz[i][j] + " ");
            System.out.println();
        }
        System.exit(0);

    }

    static boolean First(int[][] m, int[] c) 
    {
        int[] nC = siguienteCelda(m, c);
        if (nC != null)
        {
            m[nC[0]][nC[1]] = 1;
            return true;
        }
        return false;
    }

    static boolean Next(int m[][], int cell[]) 
    {
        if (m[cell[0]][cell[1]] < 9) 
        {
            m[cell[0]][cell[1]]++;
            return true;
        }
        m[cell[0]][cell[1]] = 0;
        return false;
    }

    static int[][] leerMatriz() 
    {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                matriz[i][j] = sc.nextInt();
        sc.close();
        return matriz;
    }

    static int[] siguienteCelda(int[][] m, int[] c) 
    {
        int x = c[0], y = c[1];
        while (x != 8 || y != 8) 
        {
            if (y < 8) 
            {
                y++;
            } else if (x < 8) 
            {
                y = 0;
                x++;
            }
            if (m[x][y] == 0) 
            {
                return (new int[] { x, y });
            }
        }
        return null;
    }

}