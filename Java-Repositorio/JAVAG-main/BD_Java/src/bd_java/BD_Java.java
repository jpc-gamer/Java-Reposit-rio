/**
 *
 * @author Arturo,  JPC e FabricinTop;
 * Criando uma conexão Java e MYSQL; 
 * 
 */

package bd_java;
import java.util.Scanner;

public class BD_Java {
    public static void main(String[] args) {
        
        var pesquisar = new pesquisar();
            
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Para efetuar a pesquisa siga o passo a passo a baixo de acordo com o que gostaria de pesquisar");
        System.out.println("Digite 1 para pesquisar ID");
        System.out.println("Digite 2 para pesquisar CPF");
        System.out.println("Digite 3 para pesquisar NOME");
        String metodoBusca = sc.nextLine();
        
        while(!metodoBusca.contentEquals("1") && !metodoBusca.contentEquals("2") && !metodoBusca.contentEquals("3")) {
            System.out.println("Erro, tente novamente");
            System.out.println("Digite 1 para pesquisar ID");
            System.out.println("Digite 2 para pesquisar CPF");
            System.out.println("Digite 3 para pesquisar NOME");
            metodoBusca = sc.nextLine();
        }
        switch (metodoBusca) {
            case "1" -> metodoBusca = "id";
            case "2" -> metodoBusca = "cpf";
            case "3" -> metodoBusca = "nome";
        }
        
        System.out.println("Qual " + metodoBusca +  " Gostaria de pesquisar?");
        String itemBusca = sc.nextLine();
        
        
        String resultadoPesquisa = pesquisar.pesquisar_tabela(metodoBusca, itemBusca);
        
        System.out.println(resultadoPesquisa);
    }
}