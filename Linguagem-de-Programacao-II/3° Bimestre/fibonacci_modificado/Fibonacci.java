
import java.math.BigInteger; 

public class Fibonacci
{
    
    /**
     * a= 0
     * b= 1
     * n= 5
     * result: 5
     * Tn+2 = (Tn+1)² + Tn
     */
    public static void iterativo(int  a, int  b, int  n) {
        BigInteger c = BigInteger.ZERO;
        BigInteger  aux = BigInteger.ZERO;
        BigInteger a_aux = BigInteger.valueOf(a);
        BigInteger b_aux = BigInteger.valueOf(b);
        int  i = 0;
        n = n - 2;
         for (i = 1; i <= n; i++) {
             aux = b_aux;
             c = a_aux.add((b_aux.multiply(b_aux))) ;
             a_aux = aux;
             b_aux = c;
             
         }  
         System.out.println(c);
     }
     
    public static String recursivo(int a, int b, int n) {
        return auxiliar(BigInteger.valueOf(a), BigInteger.valueOf(b), n-2, 1);
    }
    /**    Tn+2 = (Tn+1)² + Tn */
    private static String auxiliar(BigInteger a, BigInteger b, int n, int i){
        BigInteger aux = b;
        if(i <= n) {
            b = a.add((b.multiply(b)));
            return auxiliar(aux,b,n,i+1);
        }else{
            return b.toString();
        }
    }
}
