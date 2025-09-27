package dominio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


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
}
