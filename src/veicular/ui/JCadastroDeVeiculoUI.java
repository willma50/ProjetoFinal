package veicular.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import veicular.logica.app.ProprietarioLogica;
import veicular.logica.app.ProprietarioLogicaIF;
import veicular.logica.app.VeiculoLogicaIF;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCadastroDeVeiculoUI extends JFrame implements VeiculoUIIF, ActionListener{

	private static final long serialVersionUID = 1L;
	private VeiculoLogicaIF appLogica;
	private ProprietarioLogicaIF appLogicaPropietario;
	private JPanel contentPane;
	private JTextField textPlaca;
	private JTextField textAno;
	private JTextField textValor;
	private JComboBox comboProprietario;
	private JButton btnConfirmar;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastroDeVeiculoUI frame = new JCadastroDeVeiculoUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public JCadastroDeVeiculoUI() {
		setTitle("Cadastro de Veicular");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lbProprietario = new JLabel("Propriet\u00E1rio");
		
		comboProprietario = new JComboBox();
		
		JLabel lbPlaca = new JLabel("Placa");
		
		textPlaca = new JTextField();
		textPlaca.setColumns(10);
		
		JLabel lblAnoFabricao = new JLabel("Ano Fabrica\u00E7\u00E3o");
		
		JLabel lbValorCompra = new JLabel("Valor de Compra");
		
		textAno = new JTextField();
		textAno.setColumns(10);
		
		JLabel lbTipo = new JLabel("Tipo");
		
		textValor = new JTextField();
		textValor.setColumns(10);
		
		JPanel panelTipo = new JPanel();		
		JPanel painelButton = new JPanel();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(52)
							.addComponent(panelTipo, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lbTipo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAnoFabricao)
										.addComponent(lbProprietario)
										.addComponent(lbPlaca))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textAno, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
											.addGap(12)
											.addComponent(lbValorCompra)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(textPlaca, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
										.addComponent(comboProprietario, 0, 307, Short.MAX_VALUE)))
								.addComponent(painelButton, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbProprietario)
						.addComponent(comboProprietario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbPlaca))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAnoFabricao)
						.addComponent(textAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbValorCompra)
						.addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbTipo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelTipo, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(painelButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(this);;
		painelButton.add(btnConfirmar);
		
		JRadioButton radioAeronave = new JRadioButton("Aeronave");
		radioAeronave.setSelected(true);
		
		JRadioButton radioEmbarcacao = new JRadioButton("Embarca\u00E7\u00E3o");
		
		JRadioButton radioTerrestre = new JRadioButton("Terrestre");
		
		JRadioButton radioOutro = new JRadioButton("Outro");
		
		ButtonGroup grupoRadio = new ButtonGroup();
		grupoRadio.add(radioOutro);
		grupoRadio.add(radioEmbarcacao);
		grupoRadio.add(radioAeronave);
		grupoRadio.add(radioTerrestre);
		
		GroupLayout gl_panelTipo = new GroupLayout(panelTipo);
		gl_panelTipo.setHorizontalGroup(
			gl_panelTipo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTipo.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panelTipo.createParallelGroup(Alignment.LEADING)
						.addComponent(radioAeronave)
						.addComponent(radioTerrestre))
					.addGap(18)
					.addGroup(gl_panelTipo.createParallelGroup(Alignment.LEADING)
						.addComponent(radioOutro)
						.addComponent(radioEmbarcacao))
					.addGap(114))
		);
		gl_panelTipo.setVerticalGroup(
			gl_panelTipo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTipo.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelTipo.createParallelGroup(Alignment.BASELINE)
						.addComponent(radioAeronave)
						.addComponent(radioEmbarcacao))
					.addGap(5)
					.addGroup(gl_panelTipo.createParallelGroup(Alignment.BASELINE)
						.addComponent(radioTerrestre)
						.addComponent(radioOutro)))
		);
		panelTipo.setLayout(gl_panelTipo);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void setLogic(VeiculoLogicaIF app) {
		this.appLogica = app;
		
	}

	@Override
	public void setDisplay() throws Exception {
		this.appLogicaPropietario = new  ProprietarioLogica();
		Collection<String> proprietario = this.appLogicaPropietario.findAll();
		this.comboProprietario.setModel(new DefaultComboBoxModel<String>(new Vector<String>(proprietario)));
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConfirmar){
			try {
				this.appLogica.addVeiculo(this.textPlaca.getText(), Integer.parseInt(this.textAno.getText()), 1, Double.parseDouble(this.textValor.getText()), (String)this.comboProprietario.getSelectedItem());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("confirmar");
		}
			
		
	}
}
