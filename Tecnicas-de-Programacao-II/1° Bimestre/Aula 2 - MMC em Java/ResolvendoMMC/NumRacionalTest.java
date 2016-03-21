import static org.junit.Assert.*;
import org.junit.*;

/**
 * The test class NumRacionalTest.
 *
 * @author  Mario H. Adaniya
 * @version February 24, 2015
 */

public class NumRacionalTest
{
    /**
     * Default constructor for test class NumRacionalTest
     */
    public NumRacionalTest()
    {
    }

    /**
     * Testar o construtor 
     */
    @Test 
    public void testDefaultConstructor1(){
        int x = 1;
        int y = 1;
        NumRacional num = new NumRacional(x,y);
        Assert.assertEquals("NumRacional(): numerador not properly initialized", 
            num.getNumerador(), y); 
        Assert.assertEquals("NumRacional(): denominador not properly initialized", 
            num.getDenominador(), x);       
       
    } 
    
    /**
     * Testar a função de soma
     */
    @Test 
    public void testSomar(){
        NumRacional a = new NumRacional(1,1);
        NumRacional b = new NumRacional(1,2);
        NumRacional c = a.somar(b);
        Assert.assertEquals("NumRacional(): numerador not properly initialized", 
            c.getNumerador(), 3);
        Assert.assertEquals("NumRacional(): denominador not properly initialized", 
            c.getDenominador(), 2);
    } 
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
