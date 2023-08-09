/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario.Usuarios;

import controllers.UsuarioController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import models.Usuario;
import utils.Colores;
import utils.Conexion;

/**
 *
 * @author dan-dev
 */
public class TablaUsuarios extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    EdicionUsuarios edicionUsuarios;
    private UsuarioController usuarioController;

    public void setEdicionUsuarios(EdicionUsuarios edicionUsuarios) {
        this.edicionUsuarios = edicionUsuarios;
    }

    public TablaUsuarios() throws SQLException {
        this.inicializador();
        this.inicializarTabla();
        this.inicializadorEventos();
    }

    private void inicializador() {
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
    }

    private void inicializarTabla() throws SQLException {
        
        usuarioController = new UsuarioController();

        // Columnas de la tabla
        String[] columnNames = {"Nombre", "Identificacion Id", "Fecha Nacimiento", "Genero",
            "Direccion", "City", "Pais", "Celular", "Email", "Username"};

        // Crear el TableModel con los nombres de las columnas
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Crear la tabla con el TableModel
        table = new JTable(tableModel);

        // Permitir ajuste de ancho de columnas arrastrando
        table.getTableHeader().setResizingAllowed(true);
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(true);
        }

        // Actualizar los títulos de columna con saltos de línea
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnNames.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            if (columnNames[i].equals("Identificacion Id")) {
                column.setHeaderValue("<html>Identificacion <br> id </html>");
            } else if (columnNames[i].equals("Fecha Nacimiento")) {
                column.setHeaderValue("<html>Fecha<br>Nacimiento</html>");
            }
        }

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setReorderingAllowed(false);

        // Listar los usuarios existentes y agregarlos a la tabla
        ArrayList<Usuario> usuarios = usuarioController.obtenerUsuario();
        for (Usuario usuario : usuarios) {
            Object[] rowData = {
                usuario.getName(),
                usuario.getIdentity_document(),
                usuario.getDate_of_birth(),
                usuario.getGender(),
                usuario.getAddress(),
                usuario.getCity(),
                usuario.getCountry(),
                usuario.getPhone(),
                usuario.getEmail(),
                usuario.getUsername()
            };
            tableModel.addRow(rowData);
        }

        // Personalizar el aspecto de la tabla
        table.getTableHeader().setBackground(Colores.MORADO_BASE);
        table.getTableHeader().setForeground(Color.white);
        table.getTableHeader().setFont(table.getTableHeader().getFont().deriveFont(Font.BOLD, 15));
        table.setRowHeight(30);
        tableHeader.setPreferredSize(new Dimension(tableHeader.getPreferredSize().width, 50));
        // Agregar la tabla a un JScrollPane para hacerla desplazable
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    private void inicializadorEventos() {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        String nombreUsuario = table.getValueAt(selectedRow, 0).toString();
                        String direccion = table.getValueAt(selectedRow, 4).toString();
                        String telefono = table.getValueAt(selectedRow, 7).toString();
                        String email = table.getValueAt(selectedRow, 8).toString();
                        
                        edicionUsuarios.recogerDatos(nombreUsuario, direccion, telefono, email);
                    }

                }
            }

        });

    }
}
