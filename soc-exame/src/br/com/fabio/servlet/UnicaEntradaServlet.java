package br.com.fabio.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabio.acao.Acao;
import br.com.fabio.acao.AlteraExames;
import br.com.fabio.acao.EditaExame;
import br.com.fabio.acao.FormularioInserirExame;
import br.com.fabio.acao.InserirExame;
import br.com.fabio.acao.ListaExames;
import br.com.fabio.acao.RemoveExames;

@WebServlet({ "/entrada" })
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		
		String nomeDaClasse= "br.com.fabio.acao."+ paramAcao;
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEEndereco = nome.split(":");
		if (tipoEEndereco[0].equals("forward")) {
			System.out.println("FORWARD");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			System.out.println("REDIRECT");

			response.sendRedirect(tipoEEndereco[1]);

		}
		
//		String nome = null;
//
//		if (paramAcao.equals("ListaExames")) {
//			System.out.println("listando  exame");
//
//			ListaExames acao = new ListaExames();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals("RemoveExames")) {
//
//			RemoveExames acao = new RemoveExames();
//			nome = acao.executa(request, response);
//
//			System.out.println("removendo  exames");
//
//		} else if (paramAcao.equals("EditaExame")) {
//
//			EditaExame acao = new EditaExame();
//			nome = acao.executa(request, response);
//
//			System.out.println("editando  exames");
//
//		} else if (paramAcao.equals("AlteraExames")) {
//
//			AlteraExames acao = new AlteraExames();
//			nome = acao.executa(request, response);
//
//			System.out.println("editando LLLLLL exames");
//
//		} else if (paramAcao.equals("InserirExame")) {
//
//			InserirExame acao = new InserirExame();
//			nome = acao.executa(request, response);
//
//			System.out.println("Inserir  exames");
//
//		}
//		else if (paramAcao.equals("FormularioInserirExame")) {
//
//			FormularioInserirExame acao = new FormularioInserirExame();
//			nome = acao.executa(request, response);
//
//			System.out.println("Inserir  exames");
//
//		}

		

	}
}
