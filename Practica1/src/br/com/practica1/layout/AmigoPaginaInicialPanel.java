package br.com.practica1.layout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AmigoPaginaInicialPanel extends JPanel {
	
	private	JScrollPane scrollPane;
	public AmigoPaginaInicialPanel() {
		String[] columnNames = { "Nick", "Desde" };
		Object[][] data = { { "Mary", "Esquiar" }, { "Vitor", "teste" } ,{ "Mary", "Esquiar" },{ "Mary", "Esquiar" }};
		JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(350, 70));
		scrollPane = new JScrollPane( table );
		add( scrollPane, BorderLayout.CENTER );
	}

}
