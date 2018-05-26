package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.monitor;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class MonitorV2 extends JFrame {

	private JPanel contentPane;
	private static PrintWriter out;
	private static BufferedReader in;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					monitor c=new monitor();
					MonitorV2 frame = new MonitorV2(c,out, in);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MonitorV2(monitor c,PrintWriter out1, BufferedReader in1) {
		
		
		out=out1;
		in=in1;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("MONITOR");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(UIManager.getColor("CheckBox.light"));
		label.setFont(new Font("Bernard MT Condensed", Font.BOLD, 30));
		label.setBounds(0, 24, 434, 72);
		contentPane.add(label);
		
		Color a1=new Color(153, 204, 51);
		Color b1=new Color(204, 51, 51);
		
		String a="Conectado";
		String b="Desconectado";
		
		JLabel lblConectado = new JLabel(a);
		lblConectado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String test=lblConectado.getText();
				if(test==a) {
					lblConectado.setForeground(b1);
					lblConectado.setText(b);
				} else if(test==b) {
					lblConectado.setForeground(a1);
					lblConectado.setText(a);
				}
				
			}
		});
		
		
		lblConectado.addPropertyChangeListener(new PropertyChangeListener() {
				
			public void propertyChange(PropertyChangeEvent d) {
					String test=lblConectado.getText();
					if(test==a) {
						out.println("mc/conectado");
						out.flush();
					} else if(test==b) {
						out.println("mc/desconectado");
						out.flush();
					}
				}
		
		        });
		
		lblConectado.setForeground(a1);
		lblConectado.setHorizontalAlignment(SwingConstants.CENTER);
		lblConectado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 60));
		lblConectado.setBounds(0, 99, 434, 81);
		contentPane.add(lblConectado);
	}

}
