/**
 * 
 * ConversaoDeUnidadesDeTempo.java<br/>
 *<p>Nessa classe contem metodos estaticos que neles sao realizados conversoes de Unidades de tempo.</p>
 *<p>Segue abaixo o padrao das Unidades de tempo que os metodos estao seguindo</p>
 *
 *
 * <ul>
 *  <li>1 minuto = 60 segundos </li>
 *  <li>1 hora = 60 minutos</li>
 *  <li>1 dia = 24 horas</li>
 *  <li>1 semana = 7 dias</li>
 *  <li>1 mês = 30 dias</li>
 *  <li>1 ano = 365.25 dias</li>
 * </ul>
 *
 * @Author Thelokys
 * @Version 04/27/2015
 */
public class ConversaoDeUnidadesDeTempo //Declaracao da Classe
{
  private int minuto;
  private int hora;
  private int day;
  private int semana;
  private int mes;
  private int ano;

	/**
	* O metodo conveterMinutoParaSegundo recebe um argumento minuto para 
	* ser convertido em segundo.
	*
	* @Param m - O minutos.
	* 
	* @Return Int  - Minuto convertido para segundo.
	* 
	*/
    public static int conveterMinutoParaSegundo(int m)
    {
        return m * SEGUNDOS;
    }

	/**
	* O metodo conveterHoraParaMinuto recebe um argumento Hora para 
	* ser convertido em minuto.
	*
	* @Param h - horas.
	* 
	* @Return Int  - Hora convertido para minuto.
	* 
	*/ 
    public static int conveterHoraParaMinuto(int h)
    {
        return h * MINUTOS;
    }

	/**
	* O metodo conveterDiaParaHora recebe um argumento dia para 
	* ser convertido em hora.
	*
	* @Param d - dias.
	* 
	* @Return Int  - Dias convertido em horas.
	* 
	*/ 
    public static int conveterDiaParaHora(int d)
    {
        return d * HORAS;
    }

	/**
	* O metodo conveterSemanaParaDia recebe um argumento quantidades de Semana para 
	* ser convertido em dias.
	*
	* @Param s - Semana.
	*
	* @Return Int  - Quantidades de semanas convertido em dias.
	* 
	*/
    public static int conveterSemanaParaDia(int s)
    {
        return s * DIAS_SEMANAL;
    }

	/**
	  * O metodo conveterMesParaDia recebe um argumento quantidades de meses para 
	  * ser convertido em dias.
	  *
	  * @Param m - Meses.
	  * 
	  * @Return Int  - Meses convertido em dias.
	  * 
	  */
    public static int conveterMesParaDia(int m)
    {
        return m * DIAS_MENSAL;
    }

	/**
	  * O metodo conveterAnoParaDia recebe um argumento quantidades de anos para 
	  * ser convertido em dias.
	  *
	  * @Param a - Ano.
	  * 
	  * @Return Int  - Ano convertido em dias.
	  * 
	  */
    public static double conveterAnoParaDia(int a)
    {
        return a * DIAS_ANUAL;
    }
    

    /* Constantes */
    private static final int SEGUNDOS = 60;
    private static final int MINUTOS  = 60;
    private static final int HORAS    = 24;
    
    private static final int    DIAS_SEMANAL = 7;
    private static final int    DIAS_MENSAL  = 60;
    private static final double DIAS_ANUAL   = 365.25;    
}