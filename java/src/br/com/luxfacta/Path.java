package br.com.luxfacta;

import br.com.luxfacta.exception.InvalidPathException;

/*******************************************************************************
  A classe “Path” representa um sistema de arquivos abstrato. Escreva o corpo
  do método “cd” (change directory).
  - O diretório raiz é “/”;
  - O separador é “/”;
  - O diretório pai é acessível através de “..”;
  - O nome de um diretório contém apenas letras (A-Za-z);
  - Quando um path for inválido, o método deverá lançar a exceção do tipo InvalidPathException;

  Por exemplo, se o construtor da classe for chamado com o parâmetro “/a/b/c/d”,
  teremos (considerar os comandos chamados em sequencia):
    - “e/f”: deverá retornar “/a/b/c/d/e/f”;
    - “../x”: deverá retornar “a/b/c/d/e/x”;
    - “/d”: deverá retornar “/d”;
    - “/?”: deverá lançar InvalidPathException;
*******************************************************************************/

public class Path {

  Stack<String> stack = new Stack<>();


  Path() {
  }

  Path(String root) {
      boolean matches = rootMatches(root);
      if (!matches || root.isBlank()) {
          throw new InvalidPathException(root, "o caminho está incorreto. Utilize o padrão /a/b ou /a/b/");
      }
      root = root.substring(1);
      String[] split = root.split("/");
      Arrays.stream(split).forEach(s -> {
          stack.add("/");
          stack.add(s);
      });
  }

  public boolean rootMatches(String dir) {
      return dir.matches("(/[a-zA-Z]+([/]?))*");
  }

  public String cd(String dir) {
      if (addDirectoryMatches(dir)) {
          return addDirectory(dir);
      } else if (toFatherMatches(dir)) {
          return returnToFather(dir);
      }
      throw new InvalidPathException(dir, "o caminho está incorreto");
  }

  public boolean toFatherMatches(String dir) {
      return dir.matches("([\\.]{2}/)+([a-zA-Z]*[/]?)*");
  }

  public boolean addDirectoryMatches(String dir) {
      return dir.matches("[/]?([a-zA-Z]+[/]?)+");
  }


  String addDirectory(String dir) {
      String[] split = dir.split("/");
      Arrays.stream(split).forEach(s -> {
          if (s.isBlank()) return;
          stack.add("/");
          stack.add(s);
      });
      return toString();
  }

  String returnToFather(String dir) {
      while (dir.contains("../")) {
          dir = dir.replaceFirst("[\\.]{2}/", "");
          stack.pop();
          stack.pop();
      }
      String[] split = dir.split("/");
      Arrays.stream(split).forEach(s -> {
          if (s.isBlank()) return;
          stack.add("/");
          stack.add(s);
      });
      return toString();
  }

  public String toString() {
      return stack.stream().reduce("", (s, s2) -> s + s2, (s, s2) -> s + s2);
  }
}
