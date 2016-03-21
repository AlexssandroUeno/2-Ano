#ifndef REG_BITMAPPED_H
#define REG_BITMAPPED_H

struct reg_bitmapped {
  void * rascunho; /* REMOVA ME */
};

void bitmapped_novo(struct reg_bitmapped* reg, int total_mem, int tam_pedaco);
int  bitmapped_firstfit_proc(struct reg_bitmapped* reg, int tamanho);
void bitmapped_registrar_espaco(struct reg_bitmapped* reg, int pos_ini, int pos_fim);
void bitmapped_println(struct reg_bitmapped* reg);

#endif
