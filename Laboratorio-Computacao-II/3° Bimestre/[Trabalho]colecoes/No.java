
/**
 * No.java
 * Classe para controle de referencia e construcoes de listas encadeadas.
 * 
 * @author Jose Ricardo Guidetti Junior 
 * @version 08/10/2015 08:41
 */
public class No
{
    public No(){}
    
    public No(Object valor)
    {this.valor = valor;    
    }
    
    public Object getValor()
    {return valor;
    }
    
    public void setValor(Object valor)
    {this.valor = valor;
    }
    
    public No getProximo()
    {return proximo;
    }
    
    public void setProximo(No proximo)
    {this.proximo = proximo;
    }
    
    private Object valor;
    private No proximo;
}
