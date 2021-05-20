package br.com.luxfacta;

/*******************************************************************************
  A classe LuxFacta recebe um parâmetro no seu construtor que é sempre um número
   inteiro.
  Com base nesse numero n, escreva o corpo do método say, de forma que:
    - Se o número n for divisível por 3, o retorno deve ser "Lux"
    - Se o número n for divisível por 5, o retorno deve ser "Facta"
    - Se o número n for divisível por 3 e por 5, o retorno deve ser "LuxFacta"
    - Qualquer outra condição o retorno deve ser o próprio número n;
*******************************************************************************/

public class Luxfacta {
  private int n;

  public Luxfacta(int n) {
      this.n = n;
  }

  public String say() {
      if (n % 3 == 0 && n % 5 == 0) return "LuxFacta";
      if (n % 3 == 0) return "Lux";
      if (n % 5 == 0) return "Facta";
      return String.valueOf(n);
  }
}
