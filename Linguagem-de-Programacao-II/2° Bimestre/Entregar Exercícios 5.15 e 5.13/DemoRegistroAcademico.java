/** 
 * A classe DemoRegistroAcademicoSemConstrutor demonstra o uso de instâncias da 
 * classe RegistroAcademicoSemConstrutor.
 */
class DemoRegistroAcademico // declaração da classe 
{
    public static void main(String[] args)
    {      
        RegistroAcademico jose = new RegistroAcademico("Jose Ricardo",(byte)2,50.0);
        System.out.println(jose);
        System.out.println("___________________________________");
        RegistroAcademico michael = new RegistroAcademico("Michael Goodrich",(byte)2,100.0);                                              
        System.out.println(michael);     
    } 
} 
