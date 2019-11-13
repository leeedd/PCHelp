package br.com.FrontEnd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class ClasseTela {

	static JPanel jpanelPrincipal;

	public static void TelaPrincipal() {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// erro
		}

		JFrame jframePrincipal = new JFrame();
		jframePrincipal.setSize(1040, 800);
		jframePrincipal.setTitle("PC Help Conexão");
		jframePrincipal.setResizable(false);
		jframePrincipal.setLocationRelativeTo(null);
		
		JFrame tabela = new JFrame();
		tabela.setSize(1024, 800);
		tabela.setResizable(false);
		tabela.setLocationRelativeTo(null);

		jpanelPrincipal = new JPanel();
		jpanelPrincipal.setBackground(new java.awt.Color(55, 79, 79));
		jpanelPrincipal.setLayout(null);
		jframePrincipal.add(jpanelPrincipal);

		jpanelPrincipal.setVisible(true);
		jframePrincipal.setVisible(true);

		InstanciarClasse();
	}

	@SuppressWarnings("static-access")
	public static void InstanciarClasse() {

		ClasseButton botao = new ClasseButton();
		botao.Botao();
		botao.CampoEmpresa();
		botao.Table();

		ClasseLabel label = new ClasseLabel();
		label.LabelNomeEmpresa();

	}
}
