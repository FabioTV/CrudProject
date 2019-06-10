package br.com.fabio.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.fabio.servlet.modelo.Banco;
import br.com.fabio.servlet.modelo.Exame;

/**
 * Servlet implementation class ListaExamesService
 */
@WebServlet("/exames")
public class ListaExamesService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Exame> exames = null;
		try {
			exames = new Banco().getExames();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String tipo = request.getHeader("Accept");

		if (tipo.endsWith("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(exames);

			response.setContentType("application/json");
			response.getWriter().print(json);
		} else if (tipo.endsWith("xml")) {
			XStream xstream = new XStream();
			xstream.alias("exame", Exame.class);
			String xml = xstream.toXML(exames);

			response.setContentType("application/xml");
			response.getWriter().print(xml);
		}
	}

}
