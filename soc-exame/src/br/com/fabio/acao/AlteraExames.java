package br.com.fabio.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabio.servlet.modelo.Banco;
import br.com.fabio.servlet.modelo.Exame;

public class AlteraExames implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		String nomePaciente = request.getParameter("nomePaciente");
		String tipoExame = request.getParameter("tipo");
		String nomeMedico = request.getParameter("nomeMedico");
		String tipoDoPlano = request.getParameter("plano");
		String paramId = request.getParameter("id"); 
		Integer idExame = Integer.valueOf(paramId);
		
		System.out.println(idExame);

		if (nomePaciente == "" || nomeMedico == "" || tipoExame == "" || tipoDoPlano == "") {
//			RequestDispatcher rd = request.getRequestDispatcher("/editarExame.jsp");
//			rd.forward(request, response);
			Integer id = Integer.valueOf(paramId);
			
			Banco banco = null;
			try {
				banco = new Banco();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Exame exame = banco.buscaExamePeloId(id);
			
			System.out.println(exame.getNomePaciente());
			
			
			request.setAttribute("exame", exame);
			return "forward:editarExame.jsp";


		} else {
			Banco banco = new Banco();
			Exame exame = banco.buscaExamePeloId(idExame);
			AdicionaInformacao.setInformation(exame,nomePaciente, tipoExame, nomeMedico, tipoDoPlano);
//			exame.setNomePaciente(nomePaciente.toUpperCase());
//			exame.setTipoExame(tipoExame.toUpperCase());
//			exame.setNomeMedico(nomeMedico.toUpperCase());
//			exame.setTipoDoPlano(tipoDoPlano.toUpperCase());
			
			banco.altera(exame);
			
			
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
