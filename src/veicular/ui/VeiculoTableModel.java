package veicular.ui;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import veicular.logica.dominio.Veiculo;


public class VeiculoTableModel extends AbstractTableModel{

	private static final int COL_DESCRICAO = 0;
	private static final int COL_CLASSE = 1;
	private static final int COL_PLACA = 2;
	private static final int COL_ANOFABRICACAO = 3;
	private List<Veiculo> linhas; 
	
	private String[] colunas = new String[]{"descricao", "classe", "placa", "anoFabricacao"}; 
	
	public VeiculoTableModel(List<Veiculo> veiculos) {		
		System.out.println("testando1\n");
		this.linhas = new ArrayList<Veiculo>(veiculos);
	}
	
	
	//, CLASSE, PLACA, ANOFABRICACAO
	@Override
	public int getRowCount() {	
		System.out.println("testando2\n");
		return this.linhas.size();
	}

	@Override
	public int getColumnCount() {		
		System.out.println("testando3\n");
		return this.colunas.length;
	}

	public String getColumnName(int columnIndex) { 
		System.out.println("testando4\n");
		return colunas[columnIndex]; 
	} 
	
	public boolean isCellEditable(int rowIndex, int columnIndex){ 
		System.out.println("testando5\n");
		return false; 
	} 
	
	public Class getColumnClass(int columnIndex) { 
		System.out.println("testando 0\n");
		return Boolean.class;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		System.out.println("testando6\n");
		Veiculo veic = linhas.get(rowIndex);
		
		if (columnIndex == COL_DESCRICAO)
			return veic.getDescricao();
		else
		if (columnIndex == COL_PLACA)
			return veic.getPlaca();
		else
		if (columnIndex == COL_ANOFABRICACAO)
			return veic.getAnoFabricacao();
		
		return "";
	}
	
	public void setValueAt(Object aValue, int row, int column){
		System.out.println("testando7\n");
		Veiculo veic = linhas.get(row); 
		
		if (column == COL_DESCRICAO){
			veic.setDescricao(aValue.toString());
		} 
		 else if (column == COL_PLACA) { 
			veic.setPlaca(aValue.toString()); 
		} else if (column == COL_ANOFABRICACAO) {
			veic.setAnoFabricacao((Integer) aValue); 
		}
	} 

}
