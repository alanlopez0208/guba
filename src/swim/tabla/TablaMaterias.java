package swim.tabla;

import java.awt.Color;
import java.awt.Component;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import modelos.MateriaDisparador;
import javax.swing.JComboBox;

public class TablaMaterias extends JTable {

    private int columnEditor = -1;
    private Set<Integer> triggerRows;

    public TablaMaterias() {
        triggerRows = new HashSet<>();
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

                if (value instanceof AccionModelo dato) {
                    AccionMaterias componenente = new AccionMaterias(dato);
                    if (isSelected) {
                        componenente.setBackground(new Color(239, 244, 255));
                    } else {
                        componenente.setBackground(Color.WHITE);
                    }
                    return componenente;
                } else {
                    Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    if (triggerRows.contains(row)) {
                        component.setForeground(Color.WHITE);
                        component.setBackground(Color.RED);
                        return component;
                    }
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
            return new DefaultCellEditor(new JCheckBox()) {
                private AccionModelo data;

                @Override
                public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                    data = (AccionModelo) value;
                    AccionMaterias cell = new AccionMaterias(data);
                    cell.setBackground(new Color(239, 244, 255));
                    return cell;
                }

                @Override
                public Object getCellEditorValue() {
                    return data;
                }
            };
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

    public Set<Integer> getTriggerRows() {
        return triggerRows;
    }

}
