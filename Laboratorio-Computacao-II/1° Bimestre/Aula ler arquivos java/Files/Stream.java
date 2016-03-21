/**Le byte*/
import java.io.FileInputStream;
import java.io.FileOutputStream;

/** Lê um caracter por vez*/
import java.io.FileReader;
import java.io.FileWriter; 

/** lê mais facil*/
import java.io.BufferedReader;
import java.io.PrintWriter;

import java.io.IOException;
/**
 * Stream.java
 * 
 * @author Thelokys
 * @version 03/31/2015
 */
public class Stream
{
   public static void byteStreams()
   {   
       FileInputStream entrada = null;
       FileOutputStream saida = null;
       try
       {
           entrada = new FileInputStream("dados.txt");
           saida = new FileOutputStream("copia_dados.txt");
           int lido = entrada.read();
           while( lido != -1 )
           {
               saida.write(lido);
               lido = entrada.read();
               
           }
       }catch(IOException e)
       {
           System.out.println(e.toString());
       } finally
       {
           try{
                if( entrada != null  ){
                   entrada.close();
                }
                if( saida != null ){
                   saida.close();
                }
            }catch (IOException e)
            {
            
            }
        
       }
   }

   public static void charStreams()
   {   
       FileReader entrada = null;
       FileWriter saida = null;
       try
       {
           entrada = new FileReader("dados.txt");
           saida = new FileWriter("copia_dados.txt"); 
           int lido = entrada.read();
          
         
           while( lido != -1 )
           {
               char c = (char) lido;
               
               saida.write(lido);
               
               System.out.println(lido);
               System.out.println(c);
               
               lido = entrada.read();
               
           }
       }catch(IOException e)
       {
           System.out.println(e.toString());
       } finally
       {
           try{
                if( entrada != null  ){
                   entrada.close();
                }
                if( saida != null ){
                   saida.close();
                }
            }catch (IOException e)
            {
            
            }
        
       }
   }  
   
   public static void bufferedStreams()
   {   
          BufferedReader entrada = null;
          PrintWriter saida = null;
       try
       {
           entrada = new BufferedReader( new FileReader("dados.txt"));
           saida = new PrintWriter(new FileWriter("copia_dados.txt")); 
           int lido = entrada.read();
           String linha = entrada.readLine();
           int nlinha = 1;
           while( linha != null )
           {
               //saida.printf("%d - %s\n", nlinha, linha);
               //nlinha += 1;
               String separado[] = linha.split(" ");
               String operacao = separado[0];
               int resultado;
               switch(operacao)
               {
                 case "soma":
                    resultado = somar(separado);   
                   break;
//                  case "sub":
//                     resultado = subtrair(separado);   
//                    break;
                 default:
                    resultado = 0;
               }
               System.out.printf("%d\n",resultado);
               saida.println(resultado); 
               linha = entrada.readLine();
           }
       }catch(IOException e)
       {
           System.out.println(e.toString());
       } finally
       {
           try{
                if( entrada != null  ){
                   entrada.close();
                }
                if( saida != null ){
                   saida.close();
                }
            }catch (IOException e)
            {
            
            }
        
       }
   }
   
    public static int somar(String nums[])
    {
       int res = 0;
        for(int i = 1; i<nums.length ; i++)
        {
            int num = Integer.parseInt(nums[i]);
            res += num;
        }
        return res;
    }
    
    public static int subtrair(String nums[])
    {
        int res = 0;
        for(int i = 1; i<nums.length ; i++)
        {
            int num = Integer.parseInt(nums[i]);
            res -= num;
        }
        return res;
    }
    
   
}

