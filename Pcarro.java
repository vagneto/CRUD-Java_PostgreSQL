package model.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entidade.Carro;

public class Pcarro {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private String driver, url, user, password, sql = null;
	private ResultSet rs = null;

	private boolean createConexao() { // Início do método para criar conexão com SGBD

		try {

			driver = "org.mariadb.jdbc.Driver";
			Class.forName(driver);

			url = "jdbc:mariadb://localhost:3306/bdfabrica";
			user = "root";
			password = "";

			conn = DriverManager.getConnection(url, user, password);

			if (conn != null)
				return true;
			else
				return false;

		} catch (SQLException e) {
			System.err.println("Erro ao conectar ao banco de dados. " + e.toString());
			return false;

		} catch (ClassNotFoundException e) {
			System.err.println("Driver especificado n�o foi encontrado. " + e.toString());
			return false;
		}

	} // Fim do método para criar conexão com SGBD
//=======================================================================================================	

	private void fecharConexao() { // Início do método para fechar conexão com SGBD

		try {

			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			System.err.println("Erro ao fechar conexãoo com banco de dados. " + e.toString());
		}

	} // Fim do método para fechar conexão com SGBD

//=======================================================================================================

	public boolean salvar(Carro c) { // Início do método para inserir registro

		boolean registrado = false;

		try {

			createConexao();

			if (conn != null && !conn.isClosed()) {

				sql = "INSERT INTO carros (nome, marca, placa, ano) VALUES (?,?,?,?);";

				ps = conn.prepareStatement(sql);

				ps.setString(1, c.getNome());
				ps.setString(2, c.getMarca());
				ps.setString(3, c.getPlaca());
				ps.setString(4, c.getAno());
				int i = ps.executeUpdate();

				if (i == 1) {
					registrado = true;
				} else {
					registrado = false;
				}

			}

		} catch (SQLException e) {
			System.err.println("Erro ao conectar ao banco de dados. " + e.toString());
		}

		fecharConexao();
		return registrado;

	} // Fim do método para inserir registro
//===========================================================================================================	

	public boolean localizarUsuario(Carro c) { // Início do método para localizar um usuário

		boolean encontrado = false;

		try {

			createConexao();

			if (conn != null && !conn.isClosed()) {

				sql = "select cpf, senha from usuarios where cpf = ? and senha = ?";

				ps = conn.prepareStatement(sql);
				ps.setString(1, c.getCpf());
				ps.setString(2, c.getSenha());
				rs = ps.executeQuery();

				while (rs.next()) {

					if (rs.getString(1).equals(c.getCpf()) && rs.getString(2).equals(c.getSenha())) {
						c.setCpf(rs.getString(1));
						c.setSenha(rs.getString(2));
						encontrado = true;
					} else {
						encontrado = false;
					}
				}

			}

		} catch (SQLException e) {
			System.err.println("Erro ao conectar ao banco de dados. " + e.toString());
			
		}

		fecharConexao();
		return encontrado;

	} // fim do método para localizar um usuário
//===================================================================================================

	public boolean localizarCarro(Carro c) { // Início do método para localizar um veículo

		boolean encontrado = false;

		try {

			createConexao();

			if (conn != null && !conn.isClosed()) {

				sql = "select placa, nome, marca, ano from carros where placa = ?";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, c.getPlaca());
				rs = ps.executeQuery();

				while (rs != null && rs.next()) {
					if (rs.getString(1).equals(c.getPlaca())) {
						c.setPlaca(rs.getString(1));
						c.setNome(rs.getString(2));
						c.setMarca(rs.getString(3));
						c.setAno(rs.getString(4));
						encontrado = true;
					} else {
						encontrado = false;
					}
				}
			}

		} catch (SQLException e) {
			System.err.println("Erro ao conectar ao banco de dados. " + e.toString());
		}

		fecharConexao();
		return encontrado;

	} // fim do método para localizar um veículo
//===================================================================================================
	
	public boolean deleteRegistro(Carro c) { // in�cio do m�todo para apagar um registro DAO

		boolean deletado = false;
		
		try {

			createConexao();
			
			if (conn != null && !conn.isClosed()) {
				
				sql = "select ano, nome, marca, placa from carros";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					if (rs.getString(4).equals(c.getPlaca())) {
						sql = "delete from carros where placa = ?";
						ps = conn.prepareStatement(sql);
						ps.setString(1, c.getPlaca());
						ps.executeUpdate();
						deletado = true;
					}
					else {
						deletado = false;
					}
				}
			}

		} catch (SQLException e) {
			System.err.println("Erro ao conectar ao banco de dados. " + e.toString());
		}
		
		fecharConexao();
		return deletado;

	} // fim do m�todo para apagar um registro DAO
//===============================================================================================
	
	public boolean updateCarro(Carro c){ // início do método para alterar a marca localizada pelo nome do carro

		boolean atualizado = false;
		
		try {
		
			createConexao();
			
			if (conn != null && !conn.isClosed()) {

				sql = "select ano, nome, marca, placa from carros";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
		
				while (rs != null && rs.next()) {
					if (!rs.getString(4).equals(c.getPlaca()))
						atualizado = false;
					else {
						sql = "update carros set ano = ?, nome = ?, marca = ?, placa = ? where placa = ?";
						ps = conn.prepareStatement(sql);
						ps.setString(1, c.getAno());
						ps.setString(2, c.getNome());
						ps.setString(3, c.getMarca());
						ps.setString(4, c.getPlaca());
						ps.setString(5, c.getPlaca());
						ps.executeUpdate();
						atualizado = true;
					}
				}
			}
			
		} catch (SQLException e) {
			System.err.println("Erro ao conectar ao banco de dados. " + e.toString());
		}
		
		fecharConexao();
		return atualizado;
		
	} // fim do método para alterar a marca localizada pelo nome do carro
//====================================================================================================
	
}
