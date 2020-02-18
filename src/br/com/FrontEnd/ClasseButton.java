package br.com.FrontEnd;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.com.BackEnd.ClasseIncluirCliente;
import br.com.BackEnd.ClasseJTable;
import br.com.BackEnd.PersisitirDadosBanco;

public class ClasseButton extends ClasseTela {

	static JButton jbIncluir;
	static JButton jbEditar;
	static JButton jbExcluir;
	static JButton jbSalvar;

	static JTextField jtfNomeEmpresaEdit;
	static JTextField jtfAnyDeskEdit;
	static JTextField jtfTeamViewerEdit;
	static JTextArea jtfObservacaoEdit;
	static JTextField jtfTelefoneEdit;
	static JTextField jtfCelularEdit;

	static JTextField jtfNomeEmpresa;
	static JTextField jtfAnyDesk;
	static JTextField jtfTeamViewer;
	static JTextField jtfPesquisa;
	static JTextArea jtfObservacao;
	static JLabel contCodigo;
	static JLabel jlPrincipal;
	static JLabel contID;
	static JFormattedTextField jtfTelefone;
	static JFormattedTextField jtfCelular;
	static JTable table;

	public void Botao() {

		jbIncluir = new JButton("Incluir");
		jbIncluir.setBounds(30, 260, 500, 20);
		jbIncluir.setBackground(new java.awt.Color(55, 100, 79));
		jpanelPrincipal.add(jbIncluir);
		jbIncluir.setVisible(true);

		jbExcluir = new JButton("Excluir");
		jbExcluir.setBounds(175, 700, 65, 20);
		jbExcluir.setBackground(new java.awt.Color(205, 0, 0));
		jpanelPrincipal.add(jbExcluir);
		jbExcluir.setVisible(true);

	}

	public void BotaoSalvar() {

		jbSalvar = new JButton("Salvar");
		jbSalvar.setBounds(30, 520, 100, 20);
		jbSalvar.setBackground(new java.awt.Color(135, 206, 235));
		jbSalvar.setVisible(true);
		jpTabela.add(jbSalvar);

	}

	public void CampoEmpresa() {

		JLabel nomeEmpresa = new JLabel("Nome da Empresa *");
		nomeEmpresa.setBounds(30, -10, 150, 70);
		nomeEmpresa.setForeground(Color.WHITE);
		nomeEmpresa.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpanelPrincipal.add(nomeEmpresa);
		nomeEmpresa.setVisible(true);

		jtfNomeEmpresa = new JTextField();
		jtfNomeEmpresa.setBounds(30, 40, 500, 27);
		jtfNomeEmpresa.setBackground(new java.awt.Color(205, 183, 181));
		jpanelPrincipal.add(jtfNomeEmpresa);
		jtfNomeEmpresa.requestFocusInWindow();
		jtfNomeEmpresa.setVisible(true);

		JLabel anyDesk = new JLabel("AnyDesk *");
		anyDesk.setBounds(30, 50, 150, 70);
		anyDesk.setForeground(Color.WHITE);
		anyDesk.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpanelPrincipal.add(anyDesk);
		anyDesk.setVisible(true);

		jtfAnyDesk = new JTextField();
		jtfAnyDesk.setBounds(30, 100, 500, 25);
		jtfAnyDesk.setBackground(new java.awt.Color(205, 183, 181));
		jpanelPrincipal.add(jtfAnyDesk);
		jtfAnyDesk.setVisible(true);

		JLabel teamViewer = new JLabel("TeamViewer");
		teamViewer.setBounds(30, 110, 150, 70);
		teamViewer.setForeground(Color.WHITE);
		teamViewer.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpanelPrincipal.add(teamViewer);
		teamViewer.setVisible(true);

		jtfTeamViewer = new JTextField();
		jtfTeamViewer.setBounds(30, 160, 500, 25);
		jtfTeamViewer.setBackground(new java.awt.Color(205, 183, 181));
		jpanelPrincipal.add(jtfTeamViewer);
		jtfTeamViewer.setVisible(true);

		JLabel observacao = new JLabel("Observação");
		observacao.setBounds(550, 12, 100, 25);
		observacao.setForeground(Color.WHITE);
		observacao.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpanelPrincipal.add(observacao);
		observacao.setVisible(true);

		jtfObservacao = new JTextArea();
		jtfObservacao.setBackground(new java.awt.Color(205, 183, 181));
		jtfObservacao.setFont(new Font("Arial", Font.PLAIN, 15));

		JScrollPane scroll = new JScrollPane(jtfObservacao);
		// scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(540, 40, 480, 240);
		scroll.setBackground(new java.awt.Color(55, 79, 79));
		jpanelPrincipal.add(scroll);
		scroll.setVisible(true);

		JLabel jlTelefone = new JLabel("Telefone");
		jlTelefone.setBounds(30, 170, 150, 70);
		jlTelefone.setForeground(Color.WHITE);
		jlTelefone.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpanelPrincipal.add(jlTelefone);
		jlTelefone.setVisible(true);

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
		jpanelPrincipal.add(jtfTelefone);
		jtfTelefone.setVisible(true);

		JLabel jlCelular = new JLabel("Celular");
		jlCelular.setBounds(150, 170, 150, 70);
		jlCelular.setForeground(Color.WHITE);
		jlCelular.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpanelPrincipal.add(jlCelular);
		jlCelular.setVisible(true);

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
		jpanelPrincipal.add(jtfCelular);
		jtfCelular.setVisible(true);

		JLabel pesquisa = new JLabel("Pesquisar");
		pesquisa.setBounds(292, 195, 100, 25);
		pesquisa.setForeground(Color.WHITE);
		pesquisa.setBackground(new java.awt.Color(0, 0, 0));
		pesquisa.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 15));
		jpanelPrincipal.add(pesquisa);
		pesquisa.setVisible(true);

		jtfPesquisa = new JTextField();
		jtfPesquisa.setBounds(290, 220, 240, 25);
		jtfPesquisa.setBackground(new java.awt.Color(205, 183, 181));
		jpanelPrincipal.add(jtfPesquisa);
		jtfPesquisa.setVisible(true);

		ExecutarBotoes();
		Excluir();
		PassarFocoNomeEmpresa();
		Pesquisa(PersisitirDadosBanco.ConsultaDB(""));
	}

	public static void PanelEditavel(ClasseIncluirCliente selecionarLinha) {

		contCodigo = new JLabel();
		contCodigo.setText(selecionarLinha.getCodigo());
		contCodigo.setBounds(440, 12, 100, 25);
		contCodigo.setForeground(new java.awt.Color(255, 0, 0));
		contCodigo.setFont(new Font("Arial", Font.BOLD, 15));
		jpTabela.add(contCodigo);
		contCodigo.setVisible(true);

		jtfNomeEmpresaEdit = new JTextField();
		jtfNomeEmpresaEdit.setBounds(30, 40, 500, 25);
		jtfNomeEmpresaEdit.setBackground(new java.awt.Color(205, 183, 181));
		jtfNomeEmpresaEdit.setVisible(true);
		jtfNomeEmpresaEdit.setText(selecionarLinha.getNomeEmpresa());
		jpTabela.add(jtfNomeEmpresaEdit);

		jtfAnyDeskEdit = new JTextField();
		jtfAnyDeskEdit.setBounds(30, 100, 500, 25);
		jtfAnyDeskEdit.setBackground(new java.awt.Color(205, 183, 181));
		jtfAnyDeskEdit.setVisible(true);
		jtfAnyDeskEdit.setText(selecionarLinha.getAnyDesk());
		jpTabela.add(jtfAnyDeskEdit);

		jtfTeamViewerEdit = new JTextField();
		jtfTeamViewerEdit.setBounds(30, 160, 500, 25);
		jtfTeamViewerEdit.setBackground(new java.awt.Color(205, 183, 181));
		jtfTeamViewerEdit.setVisible(true);
		jtfTeamViewerEdit.setText(selecionarLinha.getTeamViewer());
		jpTabela.add(jtfTeamViewerEdit);

		jtfObservacaoEdit = new JTextArea();
		jtfObservacaoEdit.setBackground(new java.awt.Color(205, 183, 181));
		jtfObservacaoEdit.setFont(new Font("Arial", Font.PLAIN, 15));
		jtfObservacaoEdit.setText(selecionarLinha.getObservacao());

		JScrollPane scroll = new JScrollPane(jtfObservacaoEdit);
		// scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(30, 300, 500, 220);
		scroll.setBackground(new java.awt.Color(55, 79, 79));
		jpTabela.add(scroll);
		scroll.setVisible(true);

		MaskFormatter telefone = new MaskFormatter();
		try {
			telefone = new MaskFormatter("(##)####-####");
			telefone.setPlaceholderCharacter('_');
		} catch (ParseException excp) {
			System.err.println(excp.getMessage());

		}

		jtfTelefoneEdit = new JFormattedTextField(telefone);
		jtfTelefoneEdit.setBounds(30, 220, 100, 25);
		jtfTelefoneEdit.setBackground(new java.awt.Color(205, 183, 181));
		jtfTelefoneEdit.setVisible(true);
		jtfTelefoneEdit.setText(selecionarLinha.getTelefone());
		jpTabela.add(jtfTelefoneEdit);

		MaskFormatter celular = new MaskFormatter();
		try {
			celular = new MaskFormatter("(##)#####-####");
			celular.setPlaceholderCharacter('_');
		} catch (ParseException excp) {
			System.err.println(excp.getMessage());

		}

		jtfCelularEdit = new JFormattedTextField(celular);
		jtfCelularEdit.setBounds(150, 220, 110, 25);
		jtfCelularEdit.setBackground(new java.awt.Color(205, 183, 181));
		jtfCelularEdit.setVisible(true);
		jtfCelularEdit.setText(selecionarLinha.getCelular());
		jpTabela.add(jtfCelularEdit);

	}

	public void PassarFocoNomeEmpresa() {

		jtfNomeEmpresa.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@SuppressWarnings("static-access")
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == e.VK_DOWN) {
					jtfObservacao.requestFocus();

				}
			}
		});
		PassarFocoAnyDesk();
	}

	public void PassarFocoAnyDesk() {

		jtfObservacao.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@SuppressWarnings("static-access")
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == e.VK_DOWN) {
					jtfAnyDesk.requestFocus();

				}

			}
		});
		PassarFocoTeamVIewer();
	}

	public void PassarFocoTeamVIewer() {

		jtfAnyDesk.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@SuppressWarnings("static-access")
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == e.VK_DOWN) {
					jtfTeamViewer.requestFocus();

				}

			}
		});
		PassarFocoTelefone();
	}

	public void PassarFocoTelefone() {

		jtfTeamViewer.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@SuppressWarnings("static-access")
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == e.VK_DOWN) {
					jtfTelefone.requestFocus();

				}

			}
		});
		PassarFocoCelular();
	}

	public void PassarFocoCelular() {
		jtfTelefone.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@SuppressWarnings("static-access")
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == e.VK_DOWN) {
					jtfCelular.requestFocus();
					
				}

			}
		});
		PassarFocoJBIncluir();
	}

	public void PassarFocoJBIncluir() {
		jtfCelular.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@SuppressWarnings("static-access")
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == e.VK_DOWN) {
					jbIncluir.requestFocus();

				}

			}
		});
		PassarFocoJBExcluir();
	}
	public void PassarFocoJBExcluir() {
		jbIncluir.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@SuppressWarnings("static-access")
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == e.VK_DOWN) {
					jbExcluir.requestFocus();

				}

			}
		});
		 PassarFocoNomeEmpresaDeNovo();
	}
	public void PassarFocoNomeEmpresaDeNovo() {
		jbExcluir.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@SuppressWarnings("static-access")
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == e.VK_DOWN) {
					jtfNomeEmpresa.requestFocus();

				}

			}
		});
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
					cliente.setObservacao(jtfObservacao.getText());

					jtfNomeEmpresa.setText("");
					jtfAnyDesk.setText("");
					jtfTeamViewer.setText("");
					jtfTelefone.setText("");
					jtfCelular.setText("");
					jtfObservacao.setText("");

					persisti.IncluirDB(cliente);

					List<ClasseIncluirCliente> buscarTable = PersisitirDadosBanco.ConsultaDB("");

					ClasseJTable modelo = new ClasseJTable(buscarTable);
					table.setModel(modelo);

				}
			}

		});
		jbIncluir.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jbIncluir.doClick();
				}
			}
		});

	}

	public void Pesquisa(List<ClasseIncluirCliente> buscar) {

		jtfPesquisa.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

				List<ClasseIncluirCliente> buscarDados = new ArrayList<>();

				String consulta = jtfPesquisa.getText();

				for (ClasseIncluirCliente cliente : buscar) {

					if (cliente.getCodigo().contains(consulta) || cliente.getNomeEmpresa().contains(consulta)
							|| cliente.getAnyDesk().contains(consulta) || cliente.getTeamViewer().contains(consulta)
							|| cliente.getTelefone().contains(consulta) || cliente.getCelular().contains(consulta)) {

						buscarDados.add(cliente);

					}

				}

				ClasseJTable atualiza = new ClasseJTable(buscarDados);
				table.setModel(atualiza);

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

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

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {

					int linha = table.getSelectedRow();

					if (table.getSelectedRow() >= 0) {

						int selecionarLinha = Integer.parseInt((String) table.getValueAt(linha, 0));

						ClasseIncluirCliente cliente = PersisitirDadosBanco.SelecionarID(selecionarLinha);

						cliente.getCodigo();

						ClasseLabel telaEditavel = new ClasseLabel();
						telaEditavel.TelaTable();
						telaEditavel.JTableEdit();

						ClasseButton editarTela = new ClasseButton();
						editarTela.PanelEditavel(cliente);
						editarTela.BotaoSalvar();
						editarTela.BotaoSalvarAction(cliente);

						jframePrincipal.dispose();

					}
				}

			}
		});

	}

	public void BotaoSalvarAction(ClasseIncluirCliente cliente) {

		ClasseIncluirCliente update = new ClasseIncluirCliente();
		PersisitirDadosBanco salvarUpdate = new PersisitirDadosBanco();

		jbSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (jtfNomeEmpresaEdit.getText().isEmpty() || jtfAnyDeskEdit.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null,
							"Ops,você não inseriru dados da Empresa e do AnyDesk! \nPor favor Verifique!", "Aviso",
							JOptionPane.WARNING_MESSAGE);

				} else {

					jfTelaEditar.dispose();
					TelaPrincipal();

					update.setCodigo(cliente.getCodigo());
					update.setNomeEmpresa(jtfNomeEmpresaEdit.getText());
					update.setAnyDesk(jtfAnyDeskEdit.getText());
					update.setTeamViewer(jtfTeamViewerEdit.getText());
					update.setTelefone(jtfTelefoneEdit.getText());
					update.setCelular(jtfCelularEdit.getText());
					update.setObservacao(jtfObservacaoEdit.getText());

					jtfNomeEmpresaEdit.setText("");
					jtfAnyDeskEdit.setText("");
					jtfTeamViewerEdit.setText("");
					jtfTelefoneEdit.setText("");
					jtfCelularEdit.setText("");
					jtfObservacaoEdit.setText("");

					salvarUpdate.SalvarDB(update);

					List<ClasseIncluirCliente> atualizaTable = PersisitirDadosBanco.ConsultaDB("");

					ClasseJTable atualizaModelo = new ClasseJTable(atualizaTable);
					table.setModel(atualizaModelo);

				}

			}
		});
		jbSalvar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jbSalvar.doClick();
				}
			}
		});

	}

	public void Excluir() {

		jbExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int linha = table.getSelectedRow();

				if (table.getSelectedRow() >= 0) {

					if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja fazer a exclusão?", "Aviso",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_NO_OPTION) {

						int selecionarLinha = Integer.parseInt((String) table.getValueAt(linha, 0));

						ClasseIncluirCliente cliente = PersisitirDadosBanco.SelecionarID(selecionarLinha);

						PersisitirDadosBanco excluirLinhaDB = new PersisitirDadosBanco();
						excluirLinhaDB.ExcluirDB(cliente);

						List<ClasseIncluirCliente> atualizaTable = PersisitirDadosBanco.ConsultaDB("");

						ClasseJTable atualizaModelo = new ClasseJTable(atualizaTable);
						table.setModel(atualizaModelo);

						JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);

					}
				} else if (jbExcluir.isEnabled()) {

					JOptionPane.showMessageDialog(null,
							"Ops! Você não selecionou nenhum registro. \nPor favor, verifique!", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

	}

}