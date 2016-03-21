#ifndef SWAPPING_H
#define SWAPPING_H

struct reg_nos {
  void * rascunho; /* REMOVA ME */
};

void nos_novo(struct reg_nos* reg, int total_mem);
int  nos_nextfit_proc(struct reg_nos* reg, int tamanho);
void nos_registrar_espaco(struct reg_nos* reg, int pos_ini, int pos_fim);
void nos_println(struct reg_nos* reg);

#endif
