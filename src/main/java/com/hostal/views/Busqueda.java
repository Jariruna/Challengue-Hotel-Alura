package com.hostal.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javax.swing.table.DefaultTableModel;


import com.hostal.controller.HuespedController;
import com.hostal.controller.ReservaController;
import com.hostal.dao.HuespedDao;
import com.hostal.dao.ReservaDao;
import com.hostal.modelo.Huesped;
import com.hostal.modelo.Reserva;

import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.ImageIcon;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {
	
	private HuespedController huespedController;
	private ReservaController reservaController;
	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modeloReserva;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	private JTabbedPane tabbedPane;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Busqueda frame = new Busqueda();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	

	public Busqueda() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		this.reservaController=new ReservaController();
		this.huespedController=new HuespedController();
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 307, 42);
		contentPane.add(lblNewLabel_4);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(12, 138, 199));
		tabbedPane.setFont(new Font("Roboto", Font.PLAIN, 16));
		tabbedPane.setBounds(20, 169, 865, 328);
		contentPane.add(tabbedPane);
		
//		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
//		panel.setBackground(new Color(12, 138, 199));
//		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
//		panel.setBounds(20, 169, 865, 328);
//		contentPane.add(panel);

		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloReserva = (DefaultTableModel) tbReservas.getModel();
		modeloReserva.addColumn("Numero de Reserva");
		modeloReserva.addColumn("Fecha Check In");
		modeloReserva.addColumn("Fecha Check Out");
		modeloReserva.addColumn("Valor");
		modeloReserva.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		tabbedPane.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		tabbedPane.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
//		btnbuscar.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//			}
//		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
		
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscar();
			}
			
		});
		
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminar();
			}
		});
		
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editar();
			}
		});
		
		actualizarReservas();
		actualizarHuespedes();
	}
	
	
	
protected void editar() {
	String selectedTabName=tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
	int indexRow=-1;
	
	switch(selectedTabName) {
	case "Reservas":
		indexRow=tbReservas.getSelectedRow();
		if(indexRow == -1) {
			JOptionPane.showMessageDialog(contentPane,"Error: Debe selecionar un registro.");
			return;
		}
		String reservaId=(String)modeloReserva.getValueAt(indexRow,0);
		Reserva reserva=reservaController.getById(Long.valueOf(reservaId));
		
		EditarReserva editarReserva=new EditarReserva(reserva);
		editarReserva.setVisible(true);
		dispose();
		break;
	case "Huéspedes":
		indexRow=tbHuespedes.getSelectedRow();
		if(indexRow == -1) {
			JOptionPane.showMessageDialog(contentPane,"Error: Debe selecionar un registro.");
			return;
		}
		String huespedId=(String)modeloHuesped.getValueAt(indexRow,0);
		Huesped huesped=huespedController.getById(Long.valueOf(huespedId));
		
		EditarHuesped editarHuesped=new EditarHuesped(huesped);
		editarHuesped.setVisible(true);
		dispose();
		
		break;
	default:
		throw new IndexOutOfBoundsException("No existe Tab");
	}
		
	}



protected void eliminar() {
	String seleccioneTabla=tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
	int indexRow=-1;
	String id="";
	int opt;
	
	switch(seleccioneTabla) {
	case "Reservas":
		indexRow=tbReservas.getSelectedRow();
		
		if(indexRow == -1) {
			JOptionPane.showMessageDialog(contentPane,"Error: Debe selecionar un registro.");
			return;
		}
		id=(String)modeloReserva.getValueAt(indexRow,0);
		opt=JOptionPane.showConfirmDialog(contentPane,"Esta seguro que desea eliminar registros id:"+id);
		if(opt!=JOptionPane.YES_OPTION)	return;
		
		
		modeloReserva.removeRow(indexRow);
		reservaController.removeById(Long.valueOf(id));
		break;
	case "Huéspedes":
		indexRow=tbHuespedes.getSelectedRow();
		
		if(indexRow == -1) {
			JOptionPane.showMessageDialog(contentPane,"Error: Debe selecionar un registro.");
			return;
		}
		id=(String)modeloHuesped.getValueAt(indexRow,0);
		opt=JOptionPane.showConfirmDialog(contentPane,"Esta seguro que desea eliminar registros id:"+id+" y todas las reservas asociadas?");
		if(opt!=JOptionPane.YES_OPTION)	return;
		
				
		Huesped huesped=huespedController.getById(Long.valueOf(id));
		huespedController.remove(huesped);
		
		modeloHuesped.removeRow(indexRow);
		actualizarReservas(); 
		
		break;
	default:
		throw new IndexOutOfBoundsException("No existe Tabla");
	}
	}



protected void buscar() {
		String seleccioneTabla = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
		String busqueda = txtBuscar.getText();
		
		switch(seleccioneTabla) {
		case "Reservas":
			if(busqueda.isBlank()) {
				actualizarReservas();
				return;
			}
			modeloReserva.setRowCount(0);
			for(Reserva r:reservaController.list()) {
				modeloReserva.addRow(r.toArray());
			}
			break;
			
		case "Huéspedes":
			if(busqueda.isBlank()) {
				actualizarHuespedes();
			}
			modeloHuesped.setRowCount(0);
			for(Huesped h:huespedController.search(busqueda)) {
				modeloHuesped.addRow(h.toArray());
			}
			break;
			
		default:
			throw new IndexOutOfBoundsException("No existe tabla");
		}
	}

	private void actualizarHuespedes() {
		modeloHuesped.setRowCount(0);
		for(Huesped h:huespedController.list()) {
			modeloHuesped.addRow(h.toArray());
		}
}



	private void actualizarReservas() {
		modeloReserva.setRowCount(0);
		for(Reserva r:reservaController.list()) {
			modeloReserva.addRow(r.toArray());
		}
}



	//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
