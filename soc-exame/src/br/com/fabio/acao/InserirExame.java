package br.com.fabio.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabio.servlet.modelo.Banco;
import br.com.fabio.servlet.modelo.Exame;

public class InserirExame implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Cadastrando Exame");
		

		String nomePaciente = request.getParameter("nomePaciente");
		String tipoExame = request.getParameter("tipo");
		String nomeMedico = request.getParameter("nomeMedico");
		String tipoDoPlano = request.getParameter("plano");

		if (nomePaciente == "" || nomeMedico == "" || tipoExame == "" || tipoDoPlano == "") {
			return "forward:cadastro.jsp";
			


		} else {
			Exame exame  = new Exame();
			AdicionaInformacao.setInformation(exame,nomePaciente, tipoExame, nomeMedico, tipoDoPlano);
//			Exame exame = new Exame();
//			exame.setNomePaciente(nomePaciente.toUpperCase());
//			exame.setTipoExame(tipoExame.toUpperCase());
//			exame.setNomeMedico(nomeMedico.toUpperCase());
//			exame.setTipoDoPlano(tipoDoPlano.toUpperCase());
			
			Banco banco = new Banco();
			try {
				banco.adiciona(exame);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "redirect:entrada?acao=ListaExames";
			
			// chamar o JSP
//			RequestDispatcher rd = request.getRequestDispatcher("/listaExames");
//			request.setAttribute("paciente", exame.getNomePaciente());
//			request.setAttribute("exame", exame.getTipoExame());
//			request.setAttribute("medico", exame.getNomeMedico());
//			request.setAttribute("plano", exame.getTipoDoPlano());
//			rd.forward(request, response);
			
			
		}

	}
}
