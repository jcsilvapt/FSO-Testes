package main;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {

	public JFrame frmTeste;
	private JTextField txtNick;
	private JTextField sendTxt;
	private JTextArea txtArea;

	private String nickname;
	private int myID = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmTeste.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		init();
	}
	
	

	public int getMyID() {
		return myID;
	}

	public void setMyID(int myID) {
		this.myID = myID;
		frmTeste.setTitle("My Chatroom, ID: " + String.valueOf(this.myID));
	}

	private void init() {
		this.nickname = "";
		if(nickname.equals("")) {
			frmTeste.setTitle("My Chatroom, ID: " + String.valueOf(myID));
		}
		
	}

	private void GUILogger(String text) {
		txtArea.append(text + "\n");
	}

	private void sendMsg(String text) {
		if (nickname != "") {
			GUILogger(this.nickname + ": " + text);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTeste = new JFrame();
		frmTeste.setResizable(false);
		frmTeste.setTitle("My Chat");
		frmTeste.setBounds(100, 100, 450, 300);
		frmTeste.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeste.getContentPane().setLayout(null);

		JLabel lblNickname = new JLabel("nickname:");
		lblNickname.setBounds(24, 11, 69, 14);
		frmTeste.getContentPane().add(lblNickname);

		txtNick = new JTextField();
		txtNick.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					if (txtNick.getText().length() >= 0 && !txtNick.getText().equalsIgnoreCase("") && txtNick != null) {
						nickname = txtNick.getText();
						GUILogger("Setting nickname as " + txtNick.getText());
						frmTeste.setTitle("My ChatRoom as " + nickname);
					} else {
						GUILogger("Cannot set Empty name...");
					}
				}
			}
		});
		txtNick.setBounds(103, 8, 86, 20);
		frmTeste.getContentPane().add(txtNick);
		txtNick.setColumns(10);

		sendTxt = new JTextField();
		sendTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					if(sendTxt.getText().length() >= 0 && !sendTxt.getText().equalsIgnoreCase("") && sendTxt != null && nickname != null && !nickname.equalsIgnoreCase("")) {
						sendMsg(sendTxt.getText());
						sendTxt.setText("");
					}
				}
			}
		});
		sendTxt.setBounds(10, 240, 325, 20);
		frmTeste.getContentPane().add(sendTxt);
		sendTxt.setColumns(10);

		txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtArea.setBounds(10, 36, 424, 193);
		frmTeste.getContentPane().add(txtArea);

		JButton btnSend = new JButton("Send");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(sendTxt.getText().length() >= 0 && !sendTxt.getText().equalsIgnoreCase("") && sendTxt != null && nickname != null && !nickname.equalsIgnoreCase("")) {
					sendMsg(sendTxt.getText());
					sendTxt.setText("");
				}
			}
		});
		btnSend.setBounds(345, 239, 89, 23);
		frmTeste.getContentPane().add(btnSend);

	}
}
