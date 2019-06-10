package br.com.fabio.acao;

import br.com.fabio.servlet.modelo.Exame;

public class AdicionaInformacao {
	
	
	static void setInformation(Exame exame, String nomePaciente, String tipoExame, String nomeMedico, String tipoDoPlano) {
	//Exame exame = new Exame();
	exame.setNomePaciente(nomePaciente.toUpperCase());
	exame.setTipoExame(tipoExame.toUpperCase());
	exame.setNomeMedico(nomeMedico.toUpperCase());
	exame.setTipoDoPlano(tipoDoPlano.toUpperCase());
	//return exame;
	}
}
