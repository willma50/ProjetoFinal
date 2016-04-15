package veicular.ui;


import java.awt.Container;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import veicular.logica.app.VeiculoLogicaIF;


public class Principal extends JFrame implements VeiculoUIIF, ActionListener{
	
	public Panel painel = new Panel();
	JMenuBar barra; 
	JMenu manutencao, veiculo, sair;
	JMenuItem cadastrar, consultar;
	
	private VeiculoLogicaIF appLogica;
	
	public Principal(){		
		super("Tela inicial");
	
	}
	
	public void montarTela() {
		
		Container tela = getContentPane();
		//painel.setBackground(new Color(0,0,0)); //configurando cor de fundo para o painel
        painel.setBounds(new Rectangle(0,28,800,520));//configurando forma no caso Ret�ngulo com posi��o x,y e medidas w, h
        tela.add(painel);  
         
		tela.setLayout(null);
		
		barra = new JMenuBar();
		
		setJMenuBar(barra);
		manutencao = new JMenu("Manuten��o");	
		veiculo = new JMenu("Veiculo");
		sair = new JMenu("Sair");		
		cadastrar = new JMenuItem("Cadastrar");
		consultar = new JMenuItem("Consultar");		
		
		barra.add(manutencao);
		barra.add(sair);
		manutencao.add(veiculo);		
		veiculo.add(cadastrar);
		veiculo.add(consultar);		
		
		consultar.addActionListener(this);
		cadastrar.addActionListener(this);
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == consultar){
			System.out.println("entrou menu ");
			
			try {
				this.appLogica.findAll();
			} catch (Exception e1) {
				System.out.println("Erro consulta!");
				e1.printStackTrace();
			}		
		}else
			
			if(e.getSource() == cadastrar){
				
				try {
					this.appLogica.addVeiculo("Veiculo1", "teste placa", 20009, 1);
				} catch (Exception e1) {
					System.out.println("Erro cadastro!");
					e1.printStackTrace();
				}	
			}
	}
	
	@Override
	public void setLogic(VeiculoLogicaIF app) {
		this.appLogica = app;
		
	}

	@Override
	public void setDisplay() throws Exception {
		this.montarTela();
		setSize(600,400);
		setLocationRelativeTo(null);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*public static void main (String args[]){
		Principal app = new Principal();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} */
}
