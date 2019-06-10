package br.com.fabio.servlet.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TesteConecao {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/soc-exame", "SA", "");
		List<Exame> listaExames = new ArrayList<Exame>();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("select * from Exames");
		ResultSet resultSet = statement.getResultSet();
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String paciente = resultSet.getString("paciente");
			String exame = resultSet.getString("exame");
			String medico = resultSet.getString("medico");
			String plano = resultSet.getString("plano");
			Exame obj_exame = new Exame();
			obj_exame.setId(id);
			obj_exame.setNomePaciente(paciente);
			obj_exame.setTipoExame(exame);
			obj_exame.setNomeMedico(medico);
			obj_exame.setTipoDoPlano(plano);
			listaExames.add(obj_exame);
		}
		for (Exame exame : listaExames) {
			System.out.println(exame.getNomeMedico());
		}
		resultSet.close();
		statement.close();
		connection.close();
	}

}
