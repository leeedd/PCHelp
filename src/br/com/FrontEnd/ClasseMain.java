package br.com.FrontEnd;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.BackEnd.ConexaoDB;

public class ClasseMain extends ClasseTela {

	public static void main(String[] args) {
	
		TelaPrincipal();

		TestarBanco();
		
	}
	public static void TestarBanco() {
		
		
		ConexaoDB testar = new ConexaoDB();
		Connection c = testar.conectar();
		
		JOptionPane.showMessageDialog(null, "Conexão Efetuada");
	}
}
