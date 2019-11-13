package br.com.FrontEnd;


import java.awt.Font;

import javax.swing.JLabel;

public class ClasseLabel extends ClasseTela {

	public static void LabelNomeEmpresa() {
		
		JLabel observacao = new JLabel("Observação");
		observacao.setBounds(700, 12, 100, 25);
		observacao.setBackground(new java.awt.Color(0, 0, 0));
		observacao.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpanelPrincipal.add(observacao);
		observacao.setVisible(true);
		
		JLabel contCodigo = new JLabel("CÓDIGO");
		contCodigo.setBounds(430, 12, 100, 25);
		contCodigo.setBackground(new java.awt.Color(0, 0, 0));
		contCodigo.setFont(new Font("Arial", Font.BOLD, 15));
		jpanelPrincipal.add(contCodigo);
		contCodigo.setVisible(true);

		JLabel codigo = new JLabel("Registro");
		codigo.setBounds(370, -10, 150, 70);
		codigo.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpanelPrincipal.add(codigo);
		codigo.setVisible(true);
		
		
		JLabel nomeEmpresa = new JLabel("Nome da Empresa *");
		nomeEmpresa.setBounds(30, -10, 150, 70);
		nomeEmpresa.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpanelPrincipal.add(nomeEmpresa);
		nomeEmpresa.setVisible(true);

		JLabel anyDesk = new JLabel("AnyDesk *");
		anyDesk.setBounds(30, 50, 150, 70);
		anyDesk.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpanelPrincipal.add(anyDesk);
		anyDesk.setVisible(true);
		
		JLabel teamViewer = new JLabel("TeamViewer");
		teamViewer.setBounds(30, 110, 150, 70);
		teamViewer.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		teamViewer.setVisible(true);
		jpanelPrincipal.add(teamViewer);
		
		JLabel telefone = new JLabel("Telefone");
		telefone.setBounds(30, 170, 150, 70);
		telefone.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpanelPrincipal.add(telefone);
		telefone.setVisible(true);
	
		JLabel celular = new JLabel("Celular");
		celular.setBounds(150, 170, 150, 70);
		celular.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpanelPrincipal.add(celular);
		celular.setVisible(true);
	
		JLabel pesquisa = new JLabel("Pesquisar");
		pesquisa.setBounds(292, 195, 100, 25);
		pesquisa.setBackground(new java.awt.Color(0, 0, 0));
		pesquisa.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpanelPrincipal.add(pesquisa);
		pesquisa.setVisible(true);
		
	}

}
