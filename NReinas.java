import java.lang.Math; // headers MUST be above the first class

// one class needs to have a main() method
public class NReinas
{
  public static boolean Reject(int [] x,int l)
  {
  	for(int i=0;i<l+1;i++)
      for(int j=0;j<l+1;j++)
        if(i!=j && (x[i]==x[j] || x[i]==(x[j]+(j-i)) || x[i]==(x[j]+(i-j)))) 
        {
          System.out.println("Rejected at i=" + i + ", j=" + j + ", x[i]=" + x[i] + ", x[j]=" + x[j]);
        return true;
        }
      System.out.println("Not rejected");
    return false;
  }

  public static boolean Accept(int [] x, int l)
  {
    if(l<x.length-1) 
    {
      System.out.println("Not accepted");
      return false;
    }
    System.out.println("Accepted..?");
    return !Reject(x,x.length-1);
  }

  public static boolean First(int [] x, int l)
  {
    if(l<x.length-1)
    {
      x[l+1]=1;
      System.out.println("First = true");
      return true;
    }
    System.out.println("First = false");
    return false;
  }

  public static boolean Next(int [] x, int l)
  {
    if(x[l]<x.length)
    {
      x[l]=x[l]+1;
      System.out.println("Next = true");
      return true;
    }
    System.out.println("Next = false");
    return false;
  }

  public static void backtracking(int [] x,int l)
  {
    System.out.println("\nBacktracking (L=" + l + ")\nActual candidate:");
    printMatrix(x);
  	if(Reject(x,l)) return;
    if(Accept(x,l)) output(x);
    System.out.println();
    printMatrix(x);
    if(First(x,l)) do 
    {
      
        backtracking(x,l+1);
      } while(Next(x,l+1));
	}
  public static void output(int [] x)
  {
    for(int i=0;i<x.length;i++) System.out.println(x[i]);
    System.exit(0);
  }
  
  public static void main(String[] args)
  {
    int N = 4;
    int [] x = new int[N];
    for(int i=0;i<N;i++) x[i]=0;
    backtracking(x,-1);
    System.out.println("No existe solucion.");
  }

  static void printMatrix(int [] x)
  {
    String str="";
    for(int i=0;i<x.length;i++) str+= x[i] + ", ";
    
    System.out.println(str + "\n");

  }

}