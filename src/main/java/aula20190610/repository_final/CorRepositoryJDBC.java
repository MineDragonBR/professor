package aula20190610.repository_final;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CorRepositoryJDBC implements CorRepository {
	private Connection conexão;

	public CorRepositoryJDBC(Connection conexão) throws Exception {
		System.out.println("Inicializando CorRepositoryJDBC...");
		
		this.conexão = conexão;
		
		//	conexão.createStatement().executeUpdate("drop table cor");
		String sql = "create table if not exists cor ("
				+ "id integer not null primary key,"
				+ "nome varchar(255) not null unique"
				+ ")";
		conexão.createStatement().executeUpdate(sql);
	}

	@Override
	public void incluir(Cor c) throws Exception {
		String sql = "insert into cor (id, nome) values (?,?)";
		PreparedStatement statement = conexão.prepareStatement(sql);
		statement.setInt(1, c.getId());
		statement.setString(2, c.getNome());
		
		statement.execute();
		statement.close();
	}

	@Override
	public void excluir(Integer id) throws Exception {
		String sql = "delete from cor where id = ?";
		PreparedStatement statement = conexão.prepareStatement(sql);
		statement.setInt(1, id);
		
		statement.execute();
		statement.close();
	}

	@Override
	public void atualizar(Cor c) throws Exception {
		String sql = "update cor set nome = ? where id = ?";
		PreparedStatement statement = conexão.prepareStatement(sql);
		statement.setString(1, c.getNome());
		statement.setInt(2, c.getId());
		
		statement.execute();
		statement.close();
	}

	@Override
	public List<Cor> obterTodas() throws Exception {
		String sql = "select id, nome from cor";
		Statement statement = conexão.createStatement();
		List<Cor> todasAsCores = new ArrayList<>();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			String nome = resultSet.getString("nome");
			int id = resultSet.getInt("id");
			
			todasAsCores.add(new Cor(id, nome));
		}
		resultSet.close();
		statement.close();
		
		return todasAsCores;
	}

}
