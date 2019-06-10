package br.com.fabio.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabio.servlet.modelo.Banco;
import br.com.fabio.servlet.modelo.Exame;

public class FormularioInserirExame implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Cadastrando Exame");
	
			return "forward:cadastro.jsp";

	}
}
