package dialogs;

import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelos.GrupoModelo;
import modelos.MaestroModelo;
import operaciones.OpGrupo;

public class EditarGruposProfesorDialog extends javax.swing.JDialog {

    HashSet<GrupoModelo> grupos;
    HashSet<GrupoModelo> gruposOriginal;
    private DefaultListModel<GrupoModelo> modelo;
    MaestroModelo maestro;

    public EditarGruposProfesorDialog(java.awt.Frame parent, boolean modal, HashSet<GrupoModelo> gruposOriginal) {
        super(parent, modal);
        initComponents();
        this.gruposOriginal = gruposOriginal;
        modelo = new DefaultListModel();
        grupos = new HashSet<>();
        this.listGrupos.setModel(modelo);
        init();
    }

    private void init() {
        modelo.removeAllElements();
        gruposOriginal.forEach((g) -> {
            modelo.addElement(g);
        });

        grupos.addAll(gruposOriginal);
    }

    public HashSet<GrupoModelo> getGrupos() {
        return grupos;
    }

    public void setGrupos(HashSet<GrupoModelo> grupos) {
        this.grupos = grupos;
        this.actualizarLista();
    }

    public MaestroModelo getMaestro() {
        return maestro;
    }

    public void setMaestro(MaestroModelo maestro) {
        this.maestro = maestro;
    }

    private void actualizarLista() {
        modelo.removeAllElements();
        grupos.forEach((g) -> {
            modelo.addElement(g);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanel1 = new swim.panel.MyPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listGrupos = new javax.swing.JList();
        buttonRounded2 = new swim.botones.ButtonRounded();
        btnGuardar = new swim.botones.ButtonRounded();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));
        myPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Grupos:");

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Selecciona los Grupos que Impartira el Profesor");

        listGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listGruposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listGrupos);

        buttonRounded2.setBackground(new java.awt.Color(51, 153, 255));
        buttonRounded2.setForeground(new java.awt.Color(255, 255, 255));
        buttonRounded2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/anadir.png"))); // NOI18N
        buttonRounded2.setText("Añadir Grupos");
        buttonRounded2.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        buttonRounded2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRounded2ActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(20, 90, 95));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar Grupos");
        btnGuardar.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(myPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonRounded2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addContainerGap())
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(buttonRounded2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRounded2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRounded2ActionPerformed
        JComboBox comboGrupos = new JComboBox();
        OpGrupo op = new OpGrupo();
        ArrayList<GrupoModelo> grupos = op.getGrupos();

        grupos.forEach((g) -> {
            comboGrupos.addItem(g);
        });

        Object[] message = {
            "Seleccione el grupo:", comboGrupos,};
        int option = JOptionPane.showConfirmDialog(null, message, "Selecciona el Grupo", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            GrupoModelo grupo = (GrupoModelo) comboGrupos.getSelectedItem();
            if (!this.grupos.contains(grupo)) {
                this.grupos.add(grupo);
            }

            this.actualizarLista();
        }
    }//GEN-LAST:event_buttonRounded2ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void listGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listGruposMouseClicked
        if (evt.getClickCount() == 2) {
            int index = listGrupos.getSelectedIndex();
            GrupoModelo grupo = (GrupoModelo) listGrupos.getModel().getElementAt(index);

            int response = JOptionPane.showConfirmDialog(null, "¿ Estas Seguro en Elimnar la materia asignada ?");
            if (response == JOptionPane.OK_OPTION) {
                grupos.remove(grupo);

                JOptionPane.showMessageDialog(null, "La materia se ha quitado con exito");
                actualizarLista();
            }

        }
    }//GEN-LAST:event_listGruposMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swim.botones.ButtonRounded btnGuardar;
    private swim.botones.ButtonRounded buttonRounded2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listGrupos;
    private swim.panel.MyPanel myPanel1;
    // End of variables declaration//GEN-END:variables
}
