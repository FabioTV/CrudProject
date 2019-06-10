package br.com.fabio.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabio.servlet.modelo.Banco;

public class RemoveExames implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
	String paramId = request.getParameter("id");
	Integer id = Integer.valueOf(paramId);
	
	System.out.println(id);
	
	Banco banco = new Banco();
	banco.removeExame(id);
	
	return "redirect:entrada?acao=ListaExames";
	
	}
}
