package br.com.fabio.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabio.servlet.modelo.Banco;
import br.com.fabio.servlet.modelo.Exame;

public class ListaExames implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("listando exames");
		
		Banco banco = new Banco();
		List<Exame> listaExames= null;
		try {
			listaExames = banco.getExames();
		} catch (SQLException e) {
			System.out.println("Erro na LISTA EXAMES");
			e.printStackTrace();
		}
		request.setAttribute("exames", listaExames);
		
		
		return "forward:listaExames.jsp";
	}

}
