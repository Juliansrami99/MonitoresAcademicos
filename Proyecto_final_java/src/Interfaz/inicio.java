package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.SystemColor;
import javax.swing.ButtonGroup;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Window;

public class inicio extends JFrame {

	private JPanel frame;
	private final ButtonGroup tipousuarios = new ButtonGroup();
	private PrintWriter out;
	private BufferedReader in ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String hostName = "localhost";
					
					int portNumber = 9002;
					Socket echoSocket;
					byte[] msgByte = new byte[1024];
					String msg = "como estas?";					
					    echoSocket = new Socket(hostName, portNumber);

					    PrintWriter out =
					        new PrintWriter(echoSocket.getOutputStream(), true);
					    
					    BufferedReader in =
					        new BufferedReader(
					            new InputStreamReader(echoSocket.getInputStream()));
					    
					    
					inicio window = new inicio(out, in);
					window.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					
				}
			}
		});
	}
		

	/**
	 * Create the application.
	 */


	/**
	 * Initialize the contents of the frame.
	 */
	private inicio(PrintWriter out1,BufferedReader in1) {
		out=out1;
		in=in1;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		frame = new JPanel();
		frame.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(frame);
		frame.setLayout(null);
		
		ImageIcon a=new ImageIcon("..//Proyecto_final_java//imagenes//5.png");
		ImageIcon b=new ImageIcon("..//Proyecto_final_java//imagenes//2.png");
		
		
		
		JButton continuar = new JButton("Continuar");
		continuar.setForeground(new Color(51, 102, 153));
		continuar.setFont(new Font("Century Gothic", Font.BOLD, 18));
		continuar.setBackground(UIManager.getColor("Button.background"));
		continuar.setToolTipText("");
		continuar.setBounds(863, 458, 135, 31);
		getContentPane().add(continuar);
		
		JRadioButton estudiante = new JRadioButton("Estudiante");
		tipousuarios.add(estudiante);
		estudiante.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		estudiante.setBounds(823, 283, 234, 85);
		getContentPane().add(estudiante);
		estudiante.setOpaque(false);
		estudiante.setContentAreaFilled(false);
		estudiante.setBorderPainted(false);
		estudiante.setSelected(true);
		
		JRadioButton monitor = new JRadioButton("Monitor");
		tipousuarios.add(monitor);
		monitor.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		monitor.setBounds(823, 214, 265, 60);
		getContentPane().add(monitor);
		monitor.setOpaque(false);
		monitor.setContentAreaFilled(false);
		monitor.setBorderPainted(false);
		
		JLabel imagen_fondo = new JLabel("");
		imagen_fondo.setForeground(UIManager.getColor("Button.focus"));
		imagen_fondo.setBackground(UIManager.getColor("Button.background"));
		imagen_fondo.setIcon(a);
		imagen_fondo.setBounds(0, 0, 1280, 720);
		getContentPane().add(imagen_fondo);	
		

				
		monitor.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(monitor.isSelected()) {
					imagen_fondo.setIcon(b);
				}
			}
		});
		
		
		estudiante.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(estudiante.isSelected()) {
					imagen_fondo.setIcon(a);
				}
				
			}
		});
		
		continuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(monitor.isSelected()) {
					MonitorV1 a= new MonitorV1(out, in);
					a.setVisible(true);
					dispose();
					
					
				}else if(estudiante.isSelected()) {
					EstudianteV1 a= new EstudianteV1(out, in);
					a.setVisible(true);
					dispose();
					
					
				}
			}
		});
		
		

	}
}
