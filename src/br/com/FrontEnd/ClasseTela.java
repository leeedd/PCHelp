package br.com.FrontEnd;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ClasseTela {

	static JFrame jframeInicial;
	static JFrame jframePrincipal;
	static JFrame jfTelaEditar;

	static JPanel jBarP;
	static JPanel jpTabela;
	static JPanel jpanelPrincipal;

	static JProgressBar jBProgress;

	public static void TelaPrincipal() {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// erro
		}

		jframePrincipal = new JFrame();
		jframePrincipal.setSize(1040, 800);
		jframePrincipal.setTitle("PC Help Conexão");
		jframePrincipal.setResizable(false);
		jframePrincipal.setLocationRelativeTo(null);

		jpanelPrincipal = new JPanel();
		jpanelPrincipal.setBackground(new java.awt.Color(55, 79, 79));
		jpanelPrincipal.setLayout(null);
		jframePrincipal.add(jpanelPrincipal);

		jpanelPrincipal.setVisible(true);
		jframePrincipal.setVisible(true);

		InstanciarClasse();

	}

	public static void InstanciarClasse() {

		ClasseButton botao = new ClasseButton();
		botao.Botao();
		botao.CampoEmpresa();
		botao.Table();

	}

	public static void TelaTable() {

		jfTelaEditar = new JFrame();
		jfTelaEditar.setSize(560, 600);
		jfTelaEditar.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jfTelaEditar.setTitle("PC Help Conexão");
		jfTelaEditar.setResizable(false);
		jfTelaEditar.setLocationRelativeTo(null);

		jpTabela = new JPanel();
		jpTabela.setBackground(new java.awt.Color(55, 79, 79));
		jpTabela.setLayout(null);
		jfTelaEditar.add(jpTabela);

		jpTabela.setVisible(true);
		jfTelaEditar.setVisible(true);

	}

	public static void TelaInicial() {

		jframeInicial = new JFrame();
		jframeInicial.setBounds(0, 0, 494, 275); // setBounds(posição x, posição y, largura, altura);
		jframeInicial.setUndecorated(true);
		jframeInicial.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jframeInicial.setLocationRelativeTo(null);

		ImageIcon imageIcon = new ImageIcon("PcHelp\\Logo.png");

		JLabel label = new JLabel(imageIcon);
		label.setBounds(-26, -41, 550, 315);

		jBarP = new JPanel();
		jBarP.setBackground(new java.awt.Color(0, 100, 0));
		jBarP.setBorder(new EmptyBorder(5, 5, 5, 5));
		jBarP.setLayout(null);

		jframeInicial.add(jBarP);
		jBarP.add(label);

		jBarP.setVisible(true);
		jframeInicial.setVisible(true);

		CarregarBarra(jBProgress);

	}

	static void CarregarBarra(JProgressBar jBProgress2) {

		UIManager.put("nimbusOrange", new Color(0, 204, 0));

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// erro
		}

		jBProgress = new JProgressBar();
		jBProgress.setBounds(-2, 265, 497, 15);
		jBProgress.setForeground(Color.green);
		jBProgress.setIndeterminate(false);
		jBarP.add(jBProgress);
		jBProgress.setVisible(true);

		TelaCarregamento();

	}

	static void TelaCarregamento() {

		for (int i = 0; i <= 100; i++) {
			jBProgress.setValue(i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			if (i == 100) {

				jframeInicial.dispose();
				TelaPrincipal();

			}
		}
	}
}
