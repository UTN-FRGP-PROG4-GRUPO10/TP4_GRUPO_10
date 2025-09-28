package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SeguroDao;
import dominio.TipoSeguroDao;


@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletSeguro() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("action");
		
		if ("nuevo".equals(action)){
			SeguroDao sdao = new SeguroDao();
			TipoSeguroDao tsdao = new TipoSeguroDao();
			request.setAttribute("siguienteId", sdao.ObtenerSiguienteID());
			request.setAttribute("tiposSeguro", tsdao.obtenerTiposSeguro());
			request.getRequestDispatcher("AgregarSeguro.jsp").forward(request, response);
			return;
		}
		
		if("listar".equals(action)) {
			SeguroDao sdao = new SeguroDao();
			ArrayList<Seguro> lista = sdao.obtenerSeguros();
			
			request.setAttribute("listaSeguros", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);
			return;
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnAgregar") != null) {
			SeguroDao sdao = new SeguroDao();
			TipoSeguroDao tsdao = new TipoSeguroDao();
			
			try {
				String descripcion = request.getParameter("txtDescripcion");
				int idTipo = Integer.parseInt(request.getParameter("ddlTipoSeguro"));
				double costoContratacion = Double.parseDouble(request.getParameter("txtCostoContratacion"));
				double costoMax = Double.parseDouble(request.getParameter("txtCostoMax"));
				
				Seguro nuevoSeguro = new Seguro();
				nuevoSeguro.setDescripcion(descripcion);
				nuevoSeguro.setIdtipo(idTipo);
				nuevoSeguro.setCostoContratacion(costoContratacion);
				nuevoSeguro.setCostoAsegurado(costoMax);
				
				request.setAttribute("filas", sdao.agregarSeguro(nuevoSeguro));
			} catch (Exception e) {
				request.setAttribute("filas", 0);
				e.printStackTrace();
			} finally {				
				request.setAttribute("siguienteId", sdao.ObtenerSiguienteID());
				request.setAttribute("tiposSeguro", tsdao.obtenerTiposSeguro());
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("param")!= null)
		{
			SeguroDao sdao = new SeguroDao();
			ArrayList<Seguro> lista = sdao.obtenerSeguros();
			
			request.setAttribute("listaSeguros", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);
			
		}
	}

}
