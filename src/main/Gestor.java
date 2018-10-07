package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gestor {

	private JFrame frame;
	private JTextArea textArea;
	private final int MAX_USERS = 2;
	private GUI[] users = new GUI[MAX_USERS]; 
	private int usersConnected = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestor window = new Gestor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gestor() {
		initialize();
	}
	private void Logger(String text) {
		textArea.append(text + "\n");
	}
	
	private boolean creatingNewChat() {
		if(usersConnected == 2) {
			return false;
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					users[usersConnected] = (GUI) new GUI();
					users[usersConnected].frmTeste.setVisible(true);
					users[usersConnected].setMyID(usersConnected+1);
					usersConnected += 1;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return true;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGestor = new JLabel("Gestor");
		lblGestor.setBounds(190, 11, 46, 14);
		frame.getContentPane().add(lblGestor);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 83, 414, 167);
		frame.getContentPane().add(textArea);
		
		JLabel lblUsersActivos = new JLabel("Users Activos");
		lblUsersActivos.setBounds(332, 58, 92, 14);
		frame.getContentPane().add(lblUsersActivos);
		
		JButton btnNovaLigao = new JButton("Nova Liga\u00E7\u00E3o");
		btnNovaLigao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(creatingNewChat()) {
					Logger("Creating new Chat Window");
				}else {
					Logger("Can't create more windows");
				}
			}
		});
		btnNovaLigao.setBounds(145, 36, 131, 23);
		frame.getContentPane().add(btnNovaLigao);
	}
}
