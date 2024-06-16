package swim.tabla;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class Tabla extends JTable {

    private int columnEditor = -1;

    public Tabla() {
        this.setShowHorizontalLines(true);
        this.setGridColor(new Color(230, 230, 230));
        this.setRowHeight(40);
        this.getTableHeader().setReorderingAllowed(false);
        this.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TablaHeader header = new TablaHeader(value + "");
                return header;
            }
        });
        this.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof AccionModelo datos) {
                    AccionColumna componente = new AccionColumna(datos);
                    if (isSelected) {
                        componente.setBackground(new Color(239, 244, 255));
                    } else {
                        componente.setBackground(Color.WHITE);
                    }
                    return componente;
                } else {
                    Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setBorder(noFocusBorder);
                    component.setForeground(new Color(102, 102, 102));
                    if (isSelected) {
                        component.setBackground(new Color(239, 244, 255));
                    } else {
                        component.setBackground(Color.WHITE);
                    }
                    return component;
                }
            }
        });
    }

    @Override
    public TableCellEditor getCellEditor(int row, int column) {
        if (column == columnEditor) {
            return new TablaCellAccion();
        } else {
            return super.getCellEditor(row, column);
        }
    }

    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
    }

    public void addColumna(String column) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addColumn(column);
    }

    public void clear() {

        if (this.isEditing()) {
            this.getCellEditor().stopCellEditing();
        }
        DefaultTableModel mod = (DefaultTableModel) getModel();
        int count = mod.getRowCount();

        for (int i = count - 1; i >= 0; i--) {
            mod.removeRow(i);
        }
    }

    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }

    public int getColumnEditor() {
        return columnEditor;
    }

    public void setColumnEditor(int columnEditor) {
        this.columnEditor = columnEditor;
    }

    public DefaultTableModel getModelo() {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        return mod;
    }

}
