package pds_atv_tela_sistema_academia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuInstrutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MenuSobre menuSobre;

	public MenuInstrutor() {
		
		setTitle("Sistema Academia (Modo Instrutor)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 338, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Treinos");
		mnNewMenu.setFont(new Font("SansSerif", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem criarTreinos = new JMenuItem("Criar Treinos");
		mnNewMenu.add(criarTreinos);
		
		JMenuItem atribuirTreinos = new JMenuItem("Atribuir Treinos");
		mnNewMenu.add(atribuirTreinos);
		
		JMenu buttonUsuarios = new JMenu("Usuarios");
		buttonUsuarios.setFont(new Font("SansSerif", Font.PLAIN, 12));
		menuBar.add(buttonUsuarios);
		
		JMenuItem buttonCUsuario = new JMenuItem("Cadastrar Usuario");
		buttonCUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NovoUsuario().setVisible(true);
			}
			
		});
		buttonUsuarios.add(buttonCUsuario);
		
		JMenuItem buttonBBoletos = new JMenuItem("Baixar Boletos");
		buttonUsuarios.add(buttonBBoletos);
		
		JMenu buttonBoletos = new JMenu("Informes");
		buttonBoletos.setFont(new Font("SansSerif", Font.PLAIN, 12));
		menuBar.add(buttonBoletos);
		
		JMenuItem consultarInformes = new JMenuItem("Consultar Informes");
		buttonBoletos.add(consultarInformes);
		
		JMenuItem novosInformes = new JMenuItem("Novos Informes");
		buttonBoletos.add(novosInformes);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(10, 130, 414, 80);
		contentPane.add(textArea);
		
		JLabel userName = new JLabel("");
		userName.setFont(new Font("SansSerif", Font.PLAIN, 16));
		userName.setBounds(10, 228, 121, 22);
		contentPane.add(userName);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				updateFields(userName);
			}
		});
	}
	
	private void updateFields(JLabel userName) {
		userName.setText(Tela.loggedUserName);
	}
}
