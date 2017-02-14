package factory;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;
public class ConnectionFactory {
	// Obtém conexão com o banco de dados
	
	static {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}
	
	
	public static Connection obtemConexao()throws SQLException{
		return DriverManager
				.getConnection("jdbc:mysql://localhost/basemercadorias?user=root&password=Guizao#19");
	}	
}
