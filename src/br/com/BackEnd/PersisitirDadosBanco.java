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

	public void IncluirDB(ClasseIncluirCliente inserirDB) {

		Connection inserir = ConexaoDB.conectar();
		PreparedStatement inserirSQL = null;

		try {

			inserirSQL = inserir.prepareStatement(
					"insert into pchelp (nome_empresa, anydesk, teamviewer, telefone, celular, observacao) values (?,?,?,?,?,?)");

			inserirSQL.setString(1, inserirDB.getNomeEmpresa());
			inserirSQL.setString(2, inserirDB.getAnyDesk());
			inserirSQL.setString(3, inserirDB.getTeamViewer());
			inserirSQL.setString(4, inserirDB.getTelefone());
			inserirSQL.setString(5, inserirDB.getCelular());
			inserirSQL.setString(6, inserirDB.getObservacao());
			inserirSQL.executeUpdate();
			inserirSQL.close();

			JOptionPane.showMessageDialog(null, "Dados Inseridos", "Informação", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Dados não inseridos", "Erro", JOptionPane.ERROR_MESSAGE);

			e.printStackTrace();
		}

	}

	public static ClasseIncluirCliente SelecionarID(Integer selecionaID) {

		ClasseIncluirCliente selecionado = new ClasseIncluirCliente();

		Connection selecaoID = ConexaoDB.conectar();
		PreparedStatement selecionarSQL = null;

		try {

			selecionarSQL = selecaoID.prepareStatement("select * from pchelp where id = ?");

			selecionarSQL.setInt(1, selecionaID);

			ResultSet selecaoRS = selecionarSQL.executeQuery();

			while (selecaoRS.next()) {

				selecionado.setCodigo(selecaoRS.getString("id"));
				selecionado.setNomeEmpresa(selecaoRS.getString("nome_empresa"));
				selecionado.setAnyDesk(selecaoRS.getString("anydesk"));
				selecionado.setTeamViewer(selecaoRS.getString("teamviewer"));
				selecionado.setTelefone(selecaoRS.getString("telefone"));
				selecionado.setCelular(selecaoRS.getString("celular"));
				selecionado.setObservacao(selecaoRS.getString("observacao"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selecionado;
	}

	public void SalvarDB(ClasseIncluirCliente salvarDB) {

		Connection salvar = ConexaoDB.conectar();
		PreparedStatement salvarSQL = null;

		try {
			salvarSQL = salvar.prepareStatement(
					"update pchelp set nome_empresa = ?, anydesk = ?, teamviewer = ?, telefone = ?, celular = ?, observacao = ? where id =?");


			salvarSQL.setString(1, salvarDB.getNomeEmpresa());
			salvarSQL.setString(2, salvarDB.getAnyDesk());
			salvarSQL.setString(3, salvarDB.getTeamViewer());
			salvarSQL.setString(4, salvarDB.getTelefone());
			salvarSQL.setString(5, salvarDB.getCelular());
			salvarSQL.setString(6, salvarDB.getObservacao());
			salvarSQL.setInt(7, Integer.parseInt(salvarDB.getCodigo()));
			
			salvarSQL.executeUpdate();
			salvarSQL.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static List<ClasseIncluirCliente> ConsultaDB(String consulta) {

		Connection buscar = ConexaoDB.conectar();
		PreparedStatement consultaSQL = null;

		List<ClasseIncluirCliente> clientes = new ArrayList<>();

		try {
			consultaSQL = buscar.prepareStatement("select * from pchelp order by id desc");

			ResultSet rs = consultaSQL.executeQuery();

			while (rs.next()) {

				ClasseIncluirCliente buscarDados = new ClasseIncluirCliente();

				buscarDados.setCodigo(rs.getString("id"));
				buscarDados.setNomeEmpresa(rs.getString("nome_empresa"));
				buscarDados.setAnyDesk(rs.getString("anydesk"));
				buscarDados.setTeamViewer(rs.getString("teamviewer"));
				buscarDados.setTelefone(rs.getString("telefone"));
				buscarDados.setCelular(rs.getString("celular"));
				buscarDados.setObservacao(rs.getString("observacao"));
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
			excluirSQL = excluir.prepareStatement("delete from pchelp where id = ?");

			excluirSQL.setInt(1, Integer.parseInt(deletar.getCodigo()));
			excluirSQL.executeUpdate();
			excluirSQL.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
