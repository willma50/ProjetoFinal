package veicular.ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import veicular.logica.app.VeiculoLogicaIF;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JInicialUI extends JFrame implements VeiculoUIIF, ActionListener{

	private JPanel contentPane;
	private JMenuItem cadastrarMenuItem;
	private JMenuItem consultarMenuItem;
	private VeiculoLogicaIF appLogica;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInicialUI frame = new JInicialUI();
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
	public JInicialUI() {
		setTitle("Projeto de Poo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu manutencaoMenu = new JMenu("Manuten��o");
		menuBar.add(manutencaoMenu);
		
		JMenu veiculoMenu = new JMenu("Ve�culo");
		manutencaoMenu.add(veiculoMenu);
		
		cadastrarMenuItem = new JMenuItem("Cadastrar");
		cadastrarMenuItem.addActionListener(this);
		veiculoMenu.add(cadastrarMenuItem);
		
		consultarMenuItem = new JMenuItem("Consultar");
		consultarMenuItem.addActionListener(this);
		veiculoMenu.add(consultarMenuItem);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manuten��o");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ricardo\\workspace\\ProjetoFinal\\imagens\\MANUTEN\u00C7\u00C3O.jpg"));
		lblNewLabel.setBounds(0, 0, 432, 242);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == cadastrarMenuItem){
		    JCadastroDeVeiculoUI cadastro = new JCadastroDeVeiculoUI();
		    cadastro.setLogic(appLogica);		   
				try {
					cadastro.setDisplay();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
		}else
			if (e.getSource() == consultarMenuItem){
				JListaDeVeiculo lista = null;
				try {
					lista = new JListaDeVeiculo();
				} catch (Exception e2) {
					
					e2.printStackTrace();
				}
				lista.setLogic(appLogica);
				try {
					lista.setDisplay();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				System.out.println("consulta");
			}	
		
	}

	@Override
	public void setLogic(VeiculoLogicaIF app) {
		this.appLogica = app;
		
	}

	@Override
	public void setDisplay() throws Exception {
		this.setVisible(true);
		
	}
}
