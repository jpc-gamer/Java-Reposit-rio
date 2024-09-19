
import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macar
 */
public class adicionar_cliente {
    
    public static String adicionar_cliente(String[] cliente){
        String sql = "insert into Clientes (CPF, Nome, Sexo, Idade, Endereco, Email, Telefone) values(?,?,?,?,?,?,?)";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Restaurante";
            String username = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, username, password);
            
            Statement st = con.createStatement();
                        
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente[0] /*cpf*/);
            stmt.setString(2, cliente[1] /*nome*/);
            stmt.setString(3, cliente[2] /*sexo*/);
            stmt.setString(4, cliente[3] /*idade*/);
            stmt.setString(5, cliente[4] /*endereco*/);
            stmt.setString(6, cliente[5] /*email*/);
            stmt.setString(7, cliente[6] /*tel*/);
            stmt.execute();
            
            con.close();
            return "Cliente cadastrado com Sucesso !";
         
        }
        catch(Exception e) {
            System.out.println(e);
            return "erro ao cadastrar";
        }
    }
}
