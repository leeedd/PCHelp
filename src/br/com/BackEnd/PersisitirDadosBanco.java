package br.com.BackEnd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PersisitirDadosBanco {

	ConexaoDB conectar = new ConexaoDB();

	public void IncluirDB(ClasseIncluirCliente persistir) {

		Connection inserir = ConexaoDB.conectar();
		PreparedStatement sql = null;

		try {

			sql = inserir.prepareStatement(
					"insert into pchelp (nome_empresa, anydesk, teamviewer, telefone, celular) values (?,?,?,?,?)");
			sql.setString(1, persistir.getNomeEmpresa());
			sql.setString(2, persistir.getAnyDesk());
			sql.setString(3, persistir.getTeamViewer());
			sql.setString(4, persistir.getTelefone());
			sql.setString(5, persistir.getCelular());
			sql.executeUpdate();
			sql.close();

			JOptionPane.showMessageDialog(null, "Dados Inseridos", "Informação", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Dados não inseridos", "Erro", JOptionPane.ERROR_MESSAGE);

			e.printStackTrace();
		}

	}

	public static List<ClasseIncluirCliente> ConsultaDB(String consulta) {

		Connection buscar = ConexaoDB.conectar();
		PreparedStatement consultaSQL = null;

		List<ClasseIncluirCliente> clientes = new ArrayList<>();

		try {
			consultaSQL = buscar.prepareStatement("select * from pchelp ");

			ResultSet rs = consultaSQL.executeQuery();

			while (rs.next()) {

				ClasseIncluirCliente buscarDados = new ClasseIncluirCliente();

				buscarDados.setNomeEmpresa(rs.getString("nome_empresa"));
				buscarDados.setAnyDesk(rs.getString("anydesk"));
				buscarDados.setTeamViewer(rs.getString("teamviewer"));
				buscarDados.setTelefone(rs.getString("telefone"));
				buscarDados.setCelular(rs.getString("celular"));
				clientes.add(buscarDados);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;

	}

	public void ExcluirDB(ClasseIncluirCliente deletar) {

		Connection excluir = ConexaoDB.conectar();
		PreparedStatement excluirSQL = null;

		try {
			excluirSQL = excluir.prepareStatement("delete from pchelp");

			ResultSet deleteRS = excluirSQL.executeQuery();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
