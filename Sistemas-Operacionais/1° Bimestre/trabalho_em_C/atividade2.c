////////////////////////////////////////
//Exercicio2.c
//
//@Author  Thelokys
//@Version 28/02/2014
//
///////////////////////////////////////
#include <stdio.h>

double doMath(double*v1, double*v2,char*op)
{
	double result;
		switch(*op)
		{			
			case '+':
		 		result = *v1 +  *v2;
		 	        break;	
			
			case '-':
				result = *v1 - *v2;
			        break;
		
			case '*':
				result = *v1 * *v2;
		 	        break;
		
			case '/':
				result = *v1 / *v2;
			        break;
		}	
	return result;
}

int main(int argc, char*charv[])
{
	double v1, v2;
	char op;
		printf("\nInsira uma conta matematica [ex: 2+2] \n");
		scanf("%lf", &v1);
		scanf("%c", &op);
		scanf("%lf", &v2);
		
		if((v2 != 0) && (op != '/'))
		{
			printf("= %lf\n",doMath(&v1,&v2, &op));
		}
		else if((v2 == 0 )&&(op == '/'))
		{
			printf("Nao existe divisao por zero !\n");
		}else{
			printf("= %lf\n",doMath(&v1,&v2, &op));
		}

	return 0;
}






