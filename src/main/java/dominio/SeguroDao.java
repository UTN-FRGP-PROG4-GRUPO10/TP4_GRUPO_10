package dominio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class SeguroDao  {
		private String host = "jdbc:mysql://localhost:3306/";
		private String user = "root";
		private String pass = "root";
		private String dbName = "SegurosGroup";
		
		public SeguroDao()
		{
			
		}
		
		public int agregarSeguro(Seguro seguro) {
			
			try {
			    Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
			    e.printStackTrace();
			}
		    
		    String query = "INSERT INTO seguros(descripcion, idTipo, costoContratacion, costoAsegurado) "
		            + "VALUES('" + seguro.getDescripcion() + "','" + seguro.getTipoSeguro().getIdTipo() + "','" 
		            + seguro.getCostoContratacion() + "','" + seguro.getCostoAsegurado() + "')";
		    
		    Connection cn = null;
		    int filas = 0;

		    try {
		        cn = DriverManager.getConnection(host + dbName, user, pass);
		        Statement st = cn.createStatement();
		        filas = st.executeUpdate(query);

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return filas;
		}
		
		
		public ArrayList<Seguro> obtenerSeguros() {
			
			try {
			    Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
			    e.printStackTrace();
			}
			
			ArrayList<Seguro> Seguros = new ArrayList<Seguro>();
			
			Connection cn = null;
			try {
				cn = DriverManager.getConnection(host + dbName, user, pass);
				Statement st = cn.createStatement();
				String query = "SELECT s.*, t.descripcion AS descripcionTipo FROM seguros s INNER JOIN tiposeguros t ON s.idTipo = t.idTipo";
				ResultSet rs = st.executeQuery(query);
				
				while(rs.next()) {
					Seguro Seguro = new Seguro();
					TipoSeguro tipoSeguro = new TipoSeguro();
					
					tipoSeguro.setIdTipo(rs.getInt("idTipo"));
					tipoSeguro.setDescripcion(rs.getString("descripcionTipo"));
					
					Seguro.setIdSeguro(rs.getInt("idSeguro"));
					//Seguro.setIdtipo(rs.getInt("idTipo"));
					Seguro.setDescripcion(rs.getString("descripcion"));
					Seguro.setCostoContratacion(rs.getDouble("CostoContratacion"));	
					Seguro.setCostoAsegurado(rs.getDouble("costoAsegurado"));
					
					Seguro.setTipoSeguro(tipoSeguro);
					
					Seguros.add(Seguro);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return Seguros;
		}
		
		
		public int ObtenerSiguienteID() {
			
			try {
			    Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
			    e.printStackTrace();
			}
			
			int nextId = 1;
			String sql = "SELECT COALESCE(MAX(idSeguro), 0) + 1 AS nextId FROM seguros";
			try (Connection cn = DriverManager.getConnection(host + dbName, user, pass);
					Statement st = cn.createStatement();
					ResultSet rs = st.executeQuery(sql)) {
				
				if (rs.next()) {
					nextId = rs.getInt("nextId");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return nextId;
		}
		
		
}
