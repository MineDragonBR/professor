package aula20190603.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class App {
	
	public static void main(String[] args) {

		try {
			Connection conex�o = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/3sadsis2019",
					"postgres",
					"unicesumar");

			criarTabelaCliente(conex�o);
			
			excluirTudo(conex�o);
			
			inserirCliente(conex�o, 1, "Fulano de Tal", new Date());
			
			Calendar calendario = Calendar.getInstance();
			calendario.set(Calendar.YEAR, 1975);
			calendario.set(Calendar.MONTH, 1);
			calendario.set(Calendar.DAY_OF_MONTH, 26);
			Date nascimentoNelson = calendario.getTime();
			
			inserirCliente(conex�o, 2, "Nelson Tenorio Junior", nascimentoNelson);
			
			//alterar nascimentoNelson para 11/11/1975
			calendario.set(Calendar.YEAR, 1975);
			calendario.set(Calendar.MONTH, 10);
			calendario.set(Calendar.DAY_OF_MONTH, 11);
			nascimentoNelson = calendario.getTime();
			atualizarCliente(conex�o, 2, "Nelson Tenorio Junior", nascimentoNelson);
			
			System.out.println("Listando os dados gravados no banco...");
			for (Cliente c : obterTodosOsClientes(conex�o)) {
				System.out.println(c.getId() + ", " + c.getNome() + ", " + c.getNascimento().toLocaleString());
			}
						
			System.out.println("Conectou!");
			conex�o.close();
			System.out.println("Fechou!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fim.");
	}
	public static List<Cliente> obterTodosOsClientes(Connection conex�o) throws Exception {
		List<Cliente> clientes = new ArrayList<>();
		
		String sql = "select id, nome, nascimento from cliente";
		Statement statement = conex�o.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			Integer id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			Date nascimento = new java.util.Date(resultSet.getDate("nascimento").getTime());
			
			Cliente recuperado = new Cliente(id, nome, nascimento);
			clientes.add(recuperado);
		}
		resultSet.close();
		statement.close();
		
		return clientes;
	}
	
	
	public static void atualizarCliente(Connection conex�o, Integer id, String nome, Date nascimento) throws Exception {
		String sql = "update cliente "
				+ "set nome = ?, "
				+ "nascimento = ? "
				+ "where id = ?";
		PreparedStatement statement = conex�o.prepareStatement(sql);
		
		statement.setInt(3, id);
		statement.setString(1, nome);
		statement.setDate(2, new java.sql.Date(nascimento.getTime()));
		
		statement.execute();
		statement.close();
		
	}
	
	public static void excluirTudo(Connection conex�o) throws Exception {
		String sql = "delete from cliente";		
		Statement statement = conex�o.createStatement();
		statement.execute(sql);
		statement.close();
	}
	
	public static void inserirCliente(Connection conex�o, Integer id, String nome, Date nascimento) throws Exception {
		String sql = "insert into cliente (id, nome, nascimento) values (?,?,?)";
		PreparedStatement statement = conex�o.prepareStatement(sql);
		
		statement.setInt(1, id);
		statement.setString(2, nome);
		statement.setDate(3, new java.sql.Date(nascimento.getTime()));
		
		statement.execute();
		statement.close();
		
	}
	
	public static void criarTabelaCliente(Connection conex�o) throws Exception {
		String sql = "create table if not exists cliente ( "
				+ "id integer not null primary key, " 
				+ "nome varchar(255) not null unique, "
				+ "nascimento date not null "
				+ ")";		
		Statement statement = conex�o.createStatement();
		statement.execute(sql);
		statement.close();
		
	}

}






