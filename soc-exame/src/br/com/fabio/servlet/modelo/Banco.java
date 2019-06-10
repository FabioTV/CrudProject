package br.com.fabio.servlet.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

//	private static List<Exame> listaExames = new ArrayList<Exame>();
//	private static Integer chaveSequencial = 1;
//
//	static {
//
//		Exame exame1 = new Exame();
//		exame1.setId(chaveSequencial++);
//		exame1.setNomePaciente("Fabio");
//		exame1.setTipoExame("Raio-X");
//		exame1.setNomeMedico("Dr. Joao");
//		exame1.setTipoDoPlano("Unimed");
//
//		Exame exame2 = new Exame();
//		exame2.setId(chaveSequencial++);
//		exame2.setNomePaciente("Maria");
//		exame2.setTipoExame("Ultrasom");
//		exame2.setNomeMedico("Dr. Pedro");
//		exame2.setTipoDoPlano("Santa Casa");
//
//		listaExames.add(exame1);
//		listaExames.add(exame2);
//
//	}

	private Connection iniciaConexao() throws SQLException {
		//Registering the HSQLDB JDBC driver
		System.out.println("Chegou aqui");
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/soc-exame", "SA", "");
		System.out.println("Chegou aqui");

		// connection.close();
		return connection;
	}

	public void adiciona(Exame exame) throws SQLException {
		Connection connection = iniciaConexao();
		
		
		String paciente = exame.getNomePaciente();
		String tipoExame = exame.getTipoExame();
		String medico = exame.getNomeMedico();
		String plano = exame.getTipoDoPlano();
		
		String sql = "insert into Exames (paciente, exame, medico ,plano) values (?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, paciente);
		statement.setString(2, tipoExame);
		statement.setString(3, medico);
		statement.setString(4, plano);

		boolean resultado = statement.execute();
		ResultSet resultSet = statement.getGeneratedKeys();
		while(resultSet.next()) {
			String id = resultSet.getString("id");
			System.out.println(id + "gerado");
		}
		statement.close();
		resultSet.close();
		// Retirar do Codigo
//		exame.setId(chaveSequencial++);
//		Banco.listaExames.add(exame);
		
		
		connection.close();

	}

	public List<Exame> getExames() throws SQLException {
		List<Exame> listaExames = new ArrayList<Exame>();
		Connection connection = iniciaConexao();
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
		resultSet.close();
		statement.close();
		connection.close();

		return listaExames;
	}

	public void removeExame(Integer id) throws SQLException {
		
		Connection connection = iniciaConexao();
		Statement stmt = connection.createStatement();
		stmt.execute("delete from exames where id="+id);
		int count = stmt.getUpdateCount();
		System.out.println("Linhas removidas" + count);
		
		connection.close();
		stmt.close();

//		Iterator<Exame> it = listaExames.iterator();
//
//		while (it.hasNext()) {
//			Exame exame = it.next();
//			if (exame.getId() == id) {
//				it.remove();
//			}
//		}

	}

	public Exame buscaExamePeloId(Integer id) throws SQLException {
		List<Exame> listSQL = getExames();
		for (Exame exame : listSQL) {
			if (exame.getId() == id) {
				return exame;
			}
		}
		return null;
	}

	public void altera(Exame exame) throws SQLException {
Connection connection = iniciaConexao();
		
		int id = exame.getId();
		String paciente = exame.getNomePaciente();
		String tipoExame = exame.getTipoExame();
		String medico = exame.getNomeMedico();
		String plano = exame.getTipoDoPlano();
		
		String sql = "update Exames set paciente = ?, exame = ?, medico = ? ,plano = ? where id="+id;
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, paciente);
		statement.setString(2, tipoExame);
		statement.setString(3, medico);
		statement.setString(4, plano);

		boolean resultado = statement.execute();
		
		statement.close();
		
		connection.close();
		
	}

}
