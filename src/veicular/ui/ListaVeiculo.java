package veicular.ui;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import veicular.logica.app.VeiculoLogicaIF;
import veicular.logica.dominio.Veiculo;


public class ListaVeiculo extends JFrame implements VeiculoUIIF{

private static final long serialVersionUID = 1L;
	
	private JPanel painelFundo; 
	private JPanel painelBotoes; 
	private JTable tabela; 
	private JScrollPane barraRolagem; 
	private JButton btInserir; 
	private JButton btExcluir; 
	
	private VeiculoTableModel modelo;
	private List<Veiculo> lista;
	
	private VeiculoLogicaIF app;
	
	public ListaVeiculo() throws Exception { 
		super("Veiculos");		
		//this.criaJanela();
	} 
	
	private void pesquisar() throws Exception {
	//	this.lista = new ArrayList<String>(app.findAll()); 
		//this.modelo = new VeiculoTableModel(lista); 
		//this.tabela.setModel(modelo); 
	}

	public void criaJanela(){ 
		this.btInserir = new JButton("Inserir"); 
		this.btExcluir = new JButton("Excluir"); 
		this.painelBotoes = new JPanel(); 
		this.barraRolagem = new JScrollPane(tabela); 
		this.painelFundo = new JPanel(); 
		this.painelFundo.setLayout(new BorderLayout()); 
		this.painelFundo.add(BorderLayout.CENTER, barraRolagem); 
		this.painelBotoes.add(btInserir); 
		this.painelBotoes.add(btExcluir); 
		this.painelFundo.add(BorderLayout.SOUTH, painelBotoes); 
		this.getContentPane().add(painelFundo); 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		this.setSize(1200, 400); 
		this.setVisible(true); 
		this.btInserir.addActionListener(new BtInserirListener()); 
		this.btExcluir.addActionListener(new BtExcluirListener()); 
	} 
	
	
	private void criaJTable() throws Exception {
		this.tabela = new JTable(modelo);
		this.pesquisar();		
		this.tabela.getColumnModel().getColumn(0).setPreferredWidth(100); 
		this.tabela.getColumnModel().getColumn(1).setPreferredWidth(50); 
		this.tabela.getColumnModel().getColumn(2).setPreferredWidth(10); 
		this.tabela.getColumnModel().getColumn(3).setPreferredWidth(20);
		this.tabela.getColumnModel().getColumn(4).setPreferredWidth(20); 
		this.tabela.getColumnModel().getColumn(5).setPreferredWidth(20); 
		this.tabela.getColumnModel().getColumn(6).setPreferredWidth(5);

	} 


	
	private class BtInserirListener implements ActionListener { 
	public void actionPerformed(ActionEvent e) { 
		/*	CriarProduto criarProduto = new CriarProduto(app);
			criarProduto.setModalityType(ModalityType.APPLICATION_MODAL);
			criarProduto.setVisible(true);
			try {
				pesquisar();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		}
	}
	
	
	private class BtExcluirListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1; 
			linhaSelecionada = tabela.getSelectedRow(); 
			if (linhaSelecionada >= 0) { 
				String nome = (String) tabela.getValueAt(linhaSelecionada, 0); 
				try {
					//app.removerProduto(nome);
					pesquisar(); 
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			} 
			else { 
				JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha."); } 
			} 
	}




	@Override
	public void setLogic(VeiculoLogicaIF VeiculoApp) {
		this.app = VeiculoApp;
		
	}

	@Override
	public void setDisplay() throws Exception {
		this.criaJTable(); 
		this.criaJanela();
		this.setVisible(true);
		
	} 
}
