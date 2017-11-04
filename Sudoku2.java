import java.util.Scanner;

import javax.net.ssl.ExtendedSSLSession;

public class Sudoku2 
{
    public static void main(String[] args) 
    {
        int matriz[][];
        System.out.println("Ingrese Sudoku.");
        matriz = leerMatriz();
        System.out.println("Sudoku ingresado.");
        //int[] primeraCelda = nextCell(matriz, new int[] { 0, -1 });
        if (nextCell(matriz, new int[] { 0, -1 }) != null)
        {
            backtracking(matriz, new int[] { 0, -1 });
            System.out.println("No hay solución");
        }
        else
        {
            System.out.println("Sudoku lleno.");
        }
    }

    public static void backtracking(int[][] m, int[] cell)
    {
        if (cell[1]>=0)
        {
            System.out.println("Backtracking para (" + cell[0] + "," + cell[1] + "), m[x][y]=" + m[cell[0]][cell[1]] + "\n");
            printMatrix(m);
            if (Reject(m, cell)) return;
            if (Accept(m, cell)) output(m);
        }
        System.out.println("nC");
        int[] nC = nextCell(m, cell);
        if (First(m, cell)) do backtracking(m, nC); while (Next(m , nC));
    }

    static boolean Reject(int[][] m, int[] cell) 
    {
        int x=cell[0], y=cell[1];
        if (m[x][y] > 0) {
            for (int i = 0; i < 9; i++) 
            {
                if (i != x && (m[i][y] == m[x][y]))
                {
                    System.out.println("Rejected at (" + x + "," + y + ") == (" + i + "," + y + ")");
                    return true;
                }

                if (i != y && (m[x][i] == m[x][y])) 
                {
                    System.out.println("Rejected at (" + x + "," + y + ") == (" + x + "," + i + ")");
                    return true;
                }
            }
            int startX = x / 3 * 3, startY = y / 3 * 3;

            for (int i = startX; i < startX + 3; i++)
                for (int j = startY; j < startY + 3; j++) 
                {
                    if (x != i && y != j && m[x][y] == m[i][j]) 
                    {
                        System.out.println("Rejected at (" + x + "," + y + ") == (" + i + "," + j + ")");
                        return true;
                    }

                }
        }

            
        System.out.println("Not rejected (" + x + "," + y + ").");
        return false;
    }

    static boolean Accept(int[][] m, int[] c) 
    {
        System.out.println("Accept? (" + c[0] + "," + c[1] + ")");
        if (nextCell(m, c) == null) 
        {
            System.out.println("Accepted.");
            return true;
        }
        System.out.println("Not accepted.");
        return false;

    }

    static void printMatrix(int[][] matriz) 
    {
        System.out.println("\n\nSudoku actual:\n");
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
        int[] nC = nextCell(m, c);
        if (nC != null)
        {
            m[nC[0]][nC[1]] = 1;
            System.out.println("First: true.");
            return true;
        }
        System.out.println("First: false.");
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

    static int[] nextCell(int[][] m, int[] c) 
    {
        int x = c[0], y = c[1];
        while (!(x == 8 && y == 8)) 
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
                System.out.println("Nextcell = (" + x + "," + y + ")");
                return (new int[] { x, y });
            }
        }
        System.out.println("NextCell = Null");
        return null;
    }

}