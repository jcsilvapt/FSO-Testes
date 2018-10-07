package IChat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class server {

	private JFrame frmIchatServer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					server window = new server();
					window.frmIchatServer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIchatServer = new JFrame();
		frmIchatServer.setTitle("IChat - Server");
		frmIchatServer.setBounds(100, 100, 450, 300);
		frmIchatServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIchatServer.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 74, 414, 176);
		frmIchatServer.getContentPane().add(textArea);
		
		JCheckBox chckbxStartServer = new JCheckBox("Start Server");
		chckbxStartServer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxStartServer.isSelected()) {
					//start();
					textArea.append("Starting ... \n");
				}else {
					textArea.append("Desligando ... \n");
				}
			}
		});
		chckbxStartServer.setBounds(27, 26, 97, 23);
		frmIchatServer.getContentPane().add(chckbxStartServer);
	}
}
