/** 
 * A classe RegistroAcademicoSemConstrutor contém campos para representar
 * dados simples sobre um registro acadêmico.
 */
class RegistroAcademico // declaração da classe 
  {
    /**
    * Declaração dos campos da classe
    */
    private String nomeDoAluno; // O nome do aluno 
    private static int númeroDeMatrícula = 20151000; // O número de matrícula estático
    private byte códigoDoCurso; // O código do curso do aluno (1..4)
    private double percentualDeCobrança; // O percentual a ser cobrado do aluno, 0 a 100%
  
    public RegistroAcademico(String n,byte c,double p){
        númeroDeMatrícula += 1;
        nomeDoAluno = n; 
        códigoDoCurso = c; 
        percentualDeCobrança = p;
    }

    /**
    * O método calculaMensalidade calcula e retorna a mensalidade do aluno usando
    * o código do seu curso e o percentual de cobrança.
    * @return o valor da mensalidade do aluno
    */
    public double calculaMensalidade()
    {
        double mensalidade = 0; // valor deve ser inicializado 
        // Primeiro, dependendo do curso do aluno, determina a mensalidade básica
        if (códigoDoCurso == 1) // Arquitetura
        mensalidade = 450.00;
        if (códigoDoCurso == 2) // Ciência da Computação
        mensalidade = 500.00;
        if (códigoDoCurso == 3) // Engenharia da Computação
        mensalidade = 550.00;
        if (códigoDoCurso == 4) // Zootecnia
        mensalidade = 380.00;
        // Agora calcula o desconto com o percentual de cobrança. Se o percentual de
        // cobrança for zero, a mensalidade também o será.
        if (percentualDeCobrança == 0) mensalidade = 0; 
        // Senão, calculamos com uma fórmula simples.
        else mensalidade = mensalidade * 100.0 / percentualDeCobrança;
        return mensalidade;
    } // fim do método calculaMensalidade
    
    public String toString(){
        String resultado = "Nome do aluno: "+nomeDoAluno;
        resultado += "\nMatrícula: "+númeroDeMatrícula;
        resultado +="\nCódigo do curso: "+códigoDoCurso;
        resultado += "\nPercentual de cobrança: "+percentualDeCobrança;
        return resultado;
    }
    
} // fim da classe RegistroAcademicoSemConstrutor
