package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TipoSeguroDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "SegurosGroup";
	
	public TipoSeguroDao() {};
	
	public ArrayList<TipoSeguro> obtenerTiposSeguro() {
		
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
		
		ArrayList<TipoSeguro> tiposSeguro = new ArrayList<TipoSeguro>();
		
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();
			String query = "SELECT * FROM tiposeguros";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				TipoSeguro tipoSeguro = new TipoSeguro();
				tipoSeguro.setIdTipo(rs.getInt("idTipo"));
				tipoSeguro.setDescripcion(rs.getString("descripcion"));
				
				tiposSeguro.add(tipoSeguro);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tiposSeguro;
	}
}
