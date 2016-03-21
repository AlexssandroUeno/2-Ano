#include <stdio.h>

void soma (int * parcela1, int parcela2)
{
	*parcela1 += parcela2;
}


int main (int argc, char* argv[] )
{
	int a = 20, b = 30;
	soma (&a,b);
	printf("a-> %x\n", &a);
return (0);
}
