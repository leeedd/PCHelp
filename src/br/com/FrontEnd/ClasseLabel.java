package br.com.FrontEnd;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class ClasseLabel extends ClasseTela {

	public void JTableEdit() {

		JLabel codigo = new JLabel("Registro");
		codigo.setBounds(370, -10, 150, 70);
		codigo.setForeground(Color.WHITE);
		codigo.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpTabela.add(codigo);
		codigo.setVisible(true);

		JLabel nomeEmpresa = new JLabel("Nome da Empresa *");
		nomeEmpresa.setBounds(30, -10, 150, 70);
		nomeEmpresa.setForeground(Color.WHITE);
		nomeEmpresa.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpTabela.add(nomeEmpresa);
		nomeEmpresa.setVisible(true);

		JLabel anyDesk = new JLabel("AnyDesk *");
		anyDesk.setBounds(30, 50, 700, 70);
		anyDesk.setForeground(Color.WHITE);
		anyDesk.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpTabela.add(anyDesk);
		anyDesk.setVisible(true);

		JLabel teamViewer = new JLabel("TeamViewer");
		teamViewer.setBounds(30, 110, 150, 70);
		teamViewer.setForeground(Color.WHITE);
		teamViewer.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		teamViewer.setVisible(true);
		jpTabela.add(teamViewer);

		JLabel telefone = new JLabel("Telefone");
		telefone.setBounds(30, 170, 150, 70);
		telefone.setForeground(Color.WHITE);
		telefone.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpTabela.add(telefone);
		telefone.setVisible(true);

		JLabel celular = new JLabel("Celular");
		celular.setBounds(150, 170, 150, 70);
		celular.setForeground(Color.WHITE);
		celular.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpTabela.add(celular);
		celular.setVisible(true);

		JLabel jlObservacao = new JLabel("Observação");
		jlObservacao.setBounds(30, 270, 100, 25);
		jlObservacao.setForeground(Color.WHITE);
		jlObservacao.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpTabela.add(jlObservacao);
		jlObservacao.setVisible(true);

	}

}
