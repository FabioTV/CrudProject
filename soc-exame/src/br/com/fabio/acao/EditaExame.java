package br.com.fabio.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabio.servlet.modelo.Banco;
import br.com.fabio.servlet.modelo.Exame;

public class EditaExame implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		Exame exame = banco.buscaExamePeloId(id);
		
		System.out.println(exame.getNomePaciente());
		
		
		request.setAttribute("exame", exame);
		return "forward:editarExame.jsp";
	}
}
