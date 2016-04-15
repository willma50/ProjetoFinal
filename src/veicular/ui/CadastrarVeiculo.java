package veicular.ui;

import javax.swing.JPanel;

import veicular.logica.app.VeiculoLogicaIF;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JMenuBar;

public class CadastrarVeiculo extends JPanel {
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public CadastrarVeiculo(VeiculoLogicaIF app) throws Exception {
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		add(chckbxNewCheckBox);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		add(panel);
		
		table = new JTable();
		add(table);
		app.addVeiculo("SIENA", "MGE-3654", 2006, 1, 20000);
		
	}

}
