package br.com.BackEnd;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClasseJTable extends AbstractTableModel {

	private static final long serialVersionUID = -2907913129227694965L;

	// Esta colecao representa os dados que est�o sendo
	// exibidos na tabela.
	private List<ClasseIncluirCliente> clientes = new ArrayList<ClasseIncluirCliente>();

// Estas variaveis representam as minhas colunas a serem exibidas. Eu exibo 3 colunas, acrescente as que foram necessarias.
//lembrando que essas sao as "minhas" colunas, vc deve definir as suas.
	private static final int NOMEEMPRESA = 0;
	private static final int ANYDESK = 1;
	private static final int TEAMVIEWER = 2;
	private static final int TELEFONE = 3;
	private static final int CELULAR = 4;

//muda o objeto cliente para a classe que vc precisar
	public ClasseJTable(List<ClasseIncluirCliente> clientes) {
		this.clientes = clientes;
	}

// Retorna o numero de linhas que a tabela tem.
	// O numero de linhas, o tamanho da colecao, visto
	// que cada item da colecao e uma linha da tabela.
	@Override
	public int getColumnCount() {
//aqui vc define a quantidade de colunas que vc vai exibir
		return 5;
	}

// Retorna o numero de colunas que voce quer exibir.
	@Override
	public int getRowCount() {

		return clientes.size();
	}

// Retorna o valor especifico de uma coluna, atraves
	// da linha e coluna que sao recebidas por parametro.
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		ClasseIncluirCliente cliente = this.clientes.get(rowIndex);
//aqui defino os itens que vou adicionar. No caso precisei apenas de três itens. Mas pode colocar quantos for necessario
		if (columnIndex == NOMEEMPRESA)
			return cliente.getNomeEmpresa();
		if (columnIndex == ANYDESK)
			return cliente.getAnyDesk();
		if (columnIndex == TEAMVIEWER)
			return cliente.getTeamViewer();
		if (columnIndex == TELEFONE)
			return cliente.getTelefone();
		if (columnIndex == CELULAR)
			return cliente.getCelular();
		return "";
	}

// Retorna o nome da coluna atraves do indice recebido
// por par�metro.
	@Override
	public String getColumnName(int column) {
	
		if(column == NOMEEMPRESA) {
			return "Empresa";
		}
		if(column == ANYDESK) {
			return "AnyDesk";
		}
		if(column == TEAMVIEWER) {
			return "TeamViewer";
			
		}	
		if(column == TELEFONE) {
			return "Telefone";
			
		}	
		if(column == CELULAR) {
			return "Celular";
			
		}
		return null;
	}
}