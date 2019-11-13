package br.com.BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class ConexaoDB {

	public static Connection conectar() {
		Connection conectar = null;

		try {

			Class.forName("org.postgresql.Driver");
			conectar = DriverManager.getConnection("jdbc:postgresql://10.0.0.141:5499/conexaoPCHelp", "admin_bd", "12345");

		} catch (SQLException e) {
			Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(null, "Problemas com a conexão\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			return null;

		} catch (ClassNotFoundException e) {
			Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(null, "O driver não foi encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return conectar;
	}
	
}