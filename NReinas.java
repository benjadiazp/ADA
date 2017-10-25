import java.lang.Math; // headers MUST be above the first class

// one class needs to have a main() method
public class NReinas
{
  public static boolean Reject(int [] x,int l){
  	for(int i=0;i<l+1;i++)
      for(int j=0;j<l+1;j++)
      	if(i!=j && (x[i]==x[j] || x[i]==(x[j]+(j-i)) || x[i]==(x[j]+(i-j)))) return true;
    return false;
  }
  public static boolean Accept(int [] x, int l){
    if(l<x.length-1) return false;
    return !Reject(x,x.length-1);
  }
  public static boolean First(int [] x, int l){
    if(l<x.length-1){
      x[l+1]=1;
      return true;
    }
    return false;
  }
  public static boolean Next(int [] x, int l){
    if(x[l]<x.length){
      x[l]=x[l]+1;
      return true;
    }
    return false;
  }
  public static void backtracking(int [] x,int l){
  	if(Reject(x,l)) return;
    if(Accept(x,l)) output(x);
    if(First(x,l)) do {
      	backtracking(x,l+1);
      } while(Next(x,l+1));
	}
  public static void output(int [] x){
    for(int i=0;i<x.length;i++) System.out.println(x[i]);
    System.exit(0);
  }            
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    int N = 20;
    int [] x = new int[N];
    for(int i=0;i<N;i++) x[i]=0;
    backtracking(x,-1);
    System.out.println("No existe solucion.");
  }
}