/**
 *
 * @author Arturo, JPC e FabricinTop; 
 * Criando uma conexão Java e MYSQL; 
 * 
 */

package bd_java;

import java.sql.*;



public class pesquisar {
    public static String pesquisar_tabela(String metodoBusca, String itemBusca) {
        
        String url = "jdbc:mysql://localhost:3306/Restaurante";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection(url, username, password);
            
            Statement st = con.createStatement();
            
            ResultSet resultSet = st.executeQuery( "select * from Clientes");
            
            String mensagemErro = "Desculpe não achamos o usuario";
            
            String metodoBuscaValor = "";
            
            boolean busca = false;
            
            while(resultSet.next()){
                
                String id = resultSet.getString(1);
                String cpf = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String sexo = resultSet.getString(4);
                String idade = resultSet.getString(5);
                String endereco = resultSet.getString(6);
                String email = resultSet.getString(7);
                String tel = resultSet.getString(8);
                
                switch (metodoBusca) {
                    case "id" -> metodoBuscaValor = id;
                    case "cpf" -> metodoBuscaValor = cpf;
                    case "nome" -> metodoBuscaValor = nome;
                }
                
              if(itemBusca.equals(metodoBuscaValor)) {
                 return "ID: " + id + "\n" +
                        "CPF: " + cpf +
                        "\n" + "NOME: " + nome +
                        "\n" + "IDADE: " + idade +
                        "\n" + "SEXO: " + sexo +
                        "\n" + "ENDERECO: " + endereco +
                        "\n" + "EMAIL: " + email +
                        "\n" + "TELEFONE: " + tel;
             }else {
                  busca = false;
              }
            }
            if(busca == false){
               return mensagemErro;
            }
            con.close();
            
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return "";
    }
}
