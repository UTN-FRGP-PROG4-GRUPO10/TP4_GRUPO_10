package dominio;

public class Seguro {
	private int idSeguro;
    private String descripcion;
    private int idTipo;
    private double costoContratacion;
    private double costoAsegurado;
    
    public Seguro() {}
    

	public Seguro(int idSeguro, String descripcion, int idtipo, double costoContratacion, double costoAsegurado) {
		super();
		this.idSeguro = idSeguro;
		this.descripcion = descripcion;
		idTipo = idtipo;
		this.costoContratacion = costoContratacion;
		this.costoAsegurado = costoAsegurado;
	}


	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdtipo(int idtipo) {
		idTipo = idtipo;
	}

	public double getCostoContratacion() {
		return costoContratacion;
	}

	public void setCostoContratacion(double costoContratacion) {
		this.costoContratacion = costoContratacion;
	}

	public double getCostoAsegurado() {
		return costoAsegurado;
	}

	public void setCostoAsegurado(double costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}
    
    
}
