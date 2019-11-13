package br.com.FrontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.com.BackEnd.ClasseIncluirCliente;
import br.com.BackEnd.ClasseJTable;
import br.com.BackEnd.PersisitirDadosBanco;

public class ClasseButton extends ClasseTela {

	static JButton jbIncluir;
	static JButton jbEditar;
	static JButton jbExcluir;

	static JTextField jtfNomeEmpresa;
	static JTextField jtfAnyDesk;
	static JTextField jtfTeamViewer;
	static JTextField jtfPesquisa;
	static JTextField jtfObservacao;
	static JFormattedTextField jtfTelefone;
	static JFormattedTextField jtfCelular;
	static JTable table;

	public void Botao() {

		jbIncluir = new JButton("Incluir");
		jbIncluir.setBounds(30, 260, 500, 20);
		jbIncluir.setBackground(new java.awt.Color(55, 100, 79));
		jbIncluir.setVisible(true);
		jpanelPrincipal.add(jbIncluir);

		jbEditar = new JButton("Editar");
		jbEditar.setBounds(110, 700, 65, 20);
		jbEditar.setBackground(new java.awt.Color(255, 165, 0));
		jbEditar.setVisible(true);
		jpanelPrincipal.add(jbEditar);

		jbExcluir = new JButton("Excluir");
		jbExcluir.setBounds(175, 700, 65, 20);
		jbExcluir.setBackground(new java.awt.Color(205, 0, 0));
		jbExcluir.setVisible(true);
		jpanelPrincipal.add(jbExcluir);

	}

	public void CampoEmpresa() {

		jtfNomeEmpresa = new JTextField();
		jtfNomeEmpresa.setBounds(30, 40, 500, 25);
		jtfNomeEmpresa.setBackground(new java.awt.Color(205, 183, 181));
		jtfNomeEmpresa.setVisible(true);
		jpanelPrincipal.add(jtfNomeEmpresa);

		jtfAnyDesk = new JTextField();
		jtfAnyDesk.setBounds(30, 100, 500, 25);
		jtfAnyDesk.setBackground(new java.awt.Color(205, 183, 181));
		jtfAnyDesk.setVisible(true);
		jpanelPrincipal.add(jtfAnyDesk);

		jtfTeamViewer = new JTextField();
		jtfTeamViewer.setBounds(30, 160, 500, 25);
		jtfTeamViewer.setBackground(new java.awt.Color(205, 183, 181));
		jtfTeamViewer.setVisible(true);
		jpanelPrincipal.add(jtfTeamViewer);
		
		jtfObservacao = new JTextField();
		jtfObservacao.setBounds(550, 160, 460, 150);
		jtfObservacao.setBackground(new java.awt.Color(205, 183, 181));
		jtfObservacao.setVisible(true);
		jpanelPrincipal.add(jtfObservacao);

		MaskFormatter telefone = new MaskFormatter();
		try {
			telefone = new MaskFormatter("(##)####-####");
			telefone.setPlaceholderCharacter('_');
		} catch (ParseException excp) {
			System.err.println(excp.getMessage());

		}

		jtfTelefone = new JFormattedTextField(telefone);
		jtfTelefone.setBounds(30, 220, 100, 25);
		jtfTelefone.setBackground(new java.awt.Color(205, 183, 181));
		jtfTelefone.setVisible(true);
		jpanelPrincipal.add(jtfTelefone);

		MaskFormatter celular = new MaskFormatter();
		try {
			celular = new MaskFormatter("(##)#####-####");
			celular.setPlaceholderCharacter('_');
		} catch (ParseException excp) {
			System.err.println(excp.getMessage());

		}

		jtfCelular = new JFormattedTextField(celular);
		jtfCelular.setBounds(150, 220, 110, 25);
		jtfCelular.setBackground(new java.awt.Color(205, 183, 181));
		jtfCelular.setVisible(true);
		jpanelPrincipal.add(jtfCelular);

		jtfPesquisa = new JTextField();
		jtfPesquisa.setBounds(290, 220, 240, 25);
		jtfPesquisa.setBackground(new java.awt.Color(205, 183, 181));
		jtfPesquisa.setVisible(true);
		jpanelPrincipal.add(jtfPesquisa);

		ExecutarBotoes();

	}

	public void ExecutarBotoes() {

		jbIncluir.addActionListener(new ActionListener() {

			ClasseIncluirCliente cliente = new ClasseIncluirCliente();
			PersisitirDadosBanco persisti = new PersisitirDadosBanco();

			@Override
			public void actionPerformed(ActionEvent e) {

				if (jtfNomeEmpresa.getText().isEmpty() || jtfAnyDesk.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null,
							"Ops,você não inseriru dados da Empresa e do AnyDesk! \nPor favor Verifique!", "Aviso",
							JOptionPane.WARNING_MESSAGE);

				} else {

					cliente.setNomeEmpresa(jtfNomeEmpresa.getText());
					cliente.setAnyDesk(jtfAnyDesk.getText());
					cliente.setTeamViewer(jtfTeamViewer.getText());
					cliente.setTelefone(jtfTelefone.getText());
					cliente.setCelular(jtfCelular.getText());

					jtfNomeEmpresa.setText("");
					jtfAnyDesk.setText("");
					jtfTeamViewer.setText("");
					jtfTelefone.setText("");
					jtfCelular.setText("");

					persisti.IncluirDB(cliente);

					List<ClasseIncluirCliente> buscarTable = PersisitirDadosBanco.ConsultaDB("");

					ClasseJTable modelo = new ClasseJTable(buscarTable);
					table.setModel(modelo);
				}
			}
		});

	}

	public void Table() {

		List<ClasseIncluirCliente> buscarTable = PersisitirDadosBanco.ConsultaDB("");

		ClasseJTable modelo = new ClasseJTable(buscarTable);

		table = new JTable();
		table.setModel(modelo);

		JScrollPane scrollPanel = new JScrollPane(table);
		scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanel.setBounds(20, 300, 1000, 400);
		scrollPanel.setBackground(new java.awt.Color(55, 79, 79));
		scrollPanel.setViewportView(table);
		jpanelPrincipal.add(scrollPanel);
		scrollPanel.setVisible(true);

	}

}
