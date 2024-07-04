package forms.pagosDocentes;


import swim.tabla.EventoAccion;
import event.EventoAbrirForm;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import modelos.PagoDocentesModelo;
import operaciones.OpPagoDocentes;

public class VerPagosDocentesForm extends javax.swing.JPanel {

    private EventoAbrirForm eventoForm;
    private OpPagoDocentes opPago;
    private EventoAccion accion;

    public VerPagosDocentesForm() {
        initComponents();
        tabla1.setColumnEditor(4);
        tabla1.fixTable(jScrollPane1);
        opPago = new OpPagoDocentes();
        iniciarTabla();
        comboFiltro.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtBuscar.setText("");
                    actualizarTabla();
                }
            }

        });
    }

    private void iniciarTabla() {
        accion = new EventoAccion() {
            @Override
            public void ver(Object modelo) {
                PagoDocentesModelo pago = (PagoDocentesModelo) modelo;
                eventoForm.abrirForm(pago, 0);
            }

            @Override
            public void borrar(Object modelo) {
                PagoDocentesModelo pago = (PagoDocentesModelo) modelo;
                int response = JOptionPane.showConfirmDialog(null, "Estas Seguro en Elimnar a " + pago.getConcepto());
                if (response == JOptionPane.OK_OPTION) {

                    boolean seElimino = opPago.deletePago(pago.getIdPago());

                    if (seElimino) {
                        JOptionPane.showMessageDialog(null, "El pago se elimino con exito");
                        actualizarTabla();
                        return;

                    }
                    JOptionPane.showMessageDialog(null, "Hubo un error al eliminar");
                }
            }

            @Override
            public void editar(Object modelo) {
                PagoDocentesModelo pago = (PagoDocentesModelo) modelo;
                eventoForm.abrirForm(pago, 1);
            }
        };
        actualizarTabla();

    }

    public void actualizarTabla() {
        tabla1.clear();
        ArrayList<PagoDocentesModelo> lista = opPago.getPagos();

        for (int i = 0; i < lista.size(); i++) {
            tabla1.addRow(lista.get(i).toRowTable(accion));
        }
    }

    public void addEventoForm(EventoAbrirForm eventoForm) {
        this.eventoForm = eventoForm;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanel1 = new swim.panel.MyPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new swim.tabla.Tabla();
        myPanel2 = new swim.panel.MyPanel();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboFiltro = new javax.swing.JComboBox<>();

        setEnabled(false);

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Pagos:");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Fecha", "Cantidad", "Concepto", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla1);
        if (tabla1.getColumnModel().getColumnCount() > 0) {
            tabla1.getColumnModel().getColumn(0).setResizable(false);
            tabla1.getColumnModel().getColumn(1).setMinWidth(300);
            tabla1.getColumnModel().getColumn(2).setResizable(false);
            tabla1.getColumnModel().getColumn(4).setMinWidth(200);
        }

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE))
                .addContainerGap())
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        myPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtBuscar.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Buscar por: ");

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fecha", "Cantidad", "Concepto" }));

        javax.swing.GroupLayout myPanel2Layout = new javax.swing.GroupLayout(myPanel2);
        myPanel2.setLayout(myPanel2Layout);
        myPanel2Layout.setHorizontalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        myPanel2Layout.setVerticalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(myPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(myPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(myPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if (txtBuscar.getText().length() > 0) {
            if (tabla1.isEditing()) {
                tabla1.getCellEditor().stopCellEditing();
            }
            tabla1.clear();

            String where = "";
            switch (comboFiltro.getSelectedIndex()) {
                case 0 -> {
                    where = "Fecha";
                }
                case 1 -> {
                    where = "Cantidad";
                }
                case 2 -> {
                    where = "Concepto";
                }
            }
            ArrayList<PagoDocentesModelo> lista = opPago.buscarPagos(where, txtBuscar.getText());
            for (int i = 0; i < lista.size(); i++) {
                tabla1.addRow(lista.get(i).toRowTable(accion));
            }

        } else {
            actualizarTabla();
        }
    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private swim.panel.MyPanel myPanel1;
    private swim.panel.MyPanel myPanel2;
    private swim.tabla.Tabla tabla1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
