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
		    
		    String query = "INSERT INTO seguros(descripcion, idTipo, costoContratacion, costoAsegurado) "
		            + "VALUES('" + seguro.getDescripcion() + "','" + seguro.getIdTipo() + "','" 
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
			ArrayList<Seguro> Seguros = new ArrayList<Seguro>();
			
			Connection cn = null;
			try {
				cn = DriverManager.getConnection(host + dbName, user, pass);
				Statement st = cn.createStatement();
				String query = "SELECT * FROM seguros";
				ResultSet rs = st.executeQuery(query);
				
				while(rs.next()) {
					Seguro Seguro = new Seguro();
					Seguro.setIdSeguro(rs.getInt("idSeguro"));
					Seguro.setIdtipo(rs.getInt("idTipo"));
					Seguro.setDescripcion(rs.getString("descripcion"));
					Seguro.setCostoContratacion(rs.getDouble("CostoContratacion"));	
					Seguro.setCostoAsegurado(rs.getDouble("costoAsegurado"));
					
					Seguros.add(Seguro);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return Seguros;
		}
}
