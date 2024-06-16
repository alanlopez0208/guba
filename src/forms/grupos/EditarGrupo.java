package forms.grupos;

import event.EventoCerrarForm;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.CarrerasModelo;
import modelos.GrupoModelo;
import modelos.MateriaModelo;
import operaciones.OpCarreras;
import operaciones.OpGrupo;
import operaciones.OpMaterias;
import swim.Imagen;

public class EditarGrupo extends javax.swing.JPanel {

    private EventoCerrarForm eventoCerrar;
    private Imagen imagen;
    private OpCarreras opCarrera;
    private final OpGrupo opGrupo;
    private final GrupoModelo grupoModelo;
    private OpMaterias opMateria;
    private ArrayList<MateriaModelo> listaDeMaterias;
    private ArrayList<MateriaModelo> listaDeMateriasAnt;

    public EditarGrupo(GrupoModelo grupoModelo) {
        initComponents();
        this.grupoModelo = grupoModelo;
        System.out.println(Integer.parseInt(grupoModelo.getId()));
        opGrupo = new OpGrupo();
        init();

    }

    private void init() {

        imagen = new Imagen();

        InputStream input = this.getClass().getResourceAsStream("/icon/guardar.png");
        Image icono = imagen.toImageResizable(input, 20, 20);
        btnGuardar.setIcon(new ImageIcon(icono));

        input = this.getClass().getResourceAsStream("/icon/back.png");
        Image iconoBack = imagen.toImageResizable(input, 40, 40);
        btnCerrar.setIcon(new ImageIcon(iconoBack));

        txtGrupo.setText(grupoModelo.getNombre());
        txtSemestre.setText(grupoModelo.getSemestre());
        iniciarTabla();
    }

    public void addEventoCerrar(EventoCerrarForm eventoCerrar) {
        this.eventoCerrar = eventoCerrar;
    }

    private boolean esValido() {

        if (txtGrupo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del grupo");
            return false;
        }
        if (txtSemestre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el semestre");
            return false;
        }
        if (listaDeMaterias == null || listaDeMaterias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese materias al grupo");
            return false;
        }
        return true;
    }

    public void iniciarTabla() {
        listaDeMaterias = opGrupo.getMateriasByGrupo(grupoModelo.getId());
        listaDeMateriasAnt = listaDeMaterias;
        for (int i = 0; i < listaDeMaterias.size(); i++) {
            MateriaModelo materia = listaDeMaterias.get(i);
            tabla1.addRow(new Object[]{
                materia.getIdMateria(), materia.getNombre(), materia.getHcba(), materia.getHti(), materia.getCreditos()
            });
        }
    }

    private void actualizarTabla() {
        if (tabla1.isEditing()) {
            tabla1.getCellEditor().stopCellEditing();
        }
        DefaultTableModel model = (DefaultTableModel) tabla1.getModel();
        int rows = model.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        for (int i = 0; i < listaDeMaterias.size(); i++) {
            //ystem.out.println("AÑADIENDO ROWS");
            MateriaModelo materia = listaDeMaterias.get(i);
            tabla1.addRow(new Object[]{
                materia.getClave(), materia.getNombre(), materia.getHcba(), materia.getHti(), materia.getCreditos()
            });
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanel1 = new swim.panel.MyPanel();
        jLabel1 = new javax.swing.JLabel();
        txtGrupo = new javax.swing.JTextField();
        txtSemestre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla1 = new swim.tabla.Tabla();
        buttonRounded1 = new swim.botones.ButtonRounded();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new swim.botones.ButtonRounded();
        btnCerrar = new javax.swing.JButton();
        buttonRounded3 = new swim.botones.ButtonRounded();

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Grupo:");

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Semestre: ");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setOpaque(false);

        tabla1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "HCBA", "HTI", "Creditos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla1);

        buttonRounded1.setBackground(new java.awt.Color(51, 153, 255));
        buttonRounded1.setForeground(new java.awt.Color(255, 255, 255));
        buttonRounded1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/anadir.png"))); // NOI18N
        buttonRounded1.setText("Añadir Materia");
        buttonRounded1.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        buttonRounded1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRounded1ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Materias:");

        btnGuardar.setBackground(new java.awt.Color(20, 90, 95));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Actualizar Grupo");
        btnGuardar.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCerrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        buttonRounded3.setBackground(new java.awt.Color(0, 153, 153));
        buttonRounded3.setForeground(new java.awt.Color(255, 255, 255));
        buttonRounded3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        buttonRounded3.setText("Eliminar Materias");
        buttonRounded3.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        buttonRounded3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRounded3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCerrar)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                                .addComponent(buttonRounded3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addComponent(btnCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonRounded3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addComponent(buttonRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked

    }//GEN-LAST:event_tabla1MouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.eventoCerrar.cerrarForm();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void buttonRounded3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRounded3ActionPerformed
        listaDeMaterias.removeAll(listaDeMaterias);
        this.actualizarTabla();

    }//GEN-LAST:event_buttonRounded3ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (esValido()) {
            int option = JOptionPane.showConfirmDialog(null, "¿Estas seguro de actualizar el grupo : " + txtGrupo.getText() + " ?");

            if (option == JOptionPane.OK_OPTION) {
                
                grupoModelo.setNombre(txtGrupo.getText().trim());
                grupoModelo.setSemestre(txtSemestre.getText().trim());
                grupoModelo.setMaterias(listaDeMaterias);

                boolean materiasActualizadas = true;

                boolean mismasMaterias = listaDeMateriasAnt.equals(listaDeMaterias);
                System.out.println(Boolean.toString(mismasMaterias));
                boolean seActualizo = opGrupo.actualizarGrupo(grupoModelo , mismasMaterias);

                if (seActualizo) {
                    JOptionPane.showMessageDialog(null, "Grupo Actualizado Correctamente");
                    this.eventoCerrar.cerrarForm();
                    return;
                }
                JOptionPane.showMessageDialog(null, "No se pudo actualizar");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void buttonRounded1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRounded1ActionPerformed
        JComboBox comboCarreras = new JComboBox();
        JComboBox comboSemestre = new JComboBox();
        //JComboBox materias = new JComboBox();

        comboSemestre.addItem("--------");
        comboCarreras.addItem("--------");
        comboSemestre.addItem("I");
        comboSemestre.addItem("II");
        comboSemestre.addItem("III");
        comboSemestre.addItem("IIII");
        comboSemestre.setEnabled(false);
        //materias.setEnabled(false);

        comboCarreras.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int itemIndex = comboCarreras.getSelectedIndex();
                if (itemIndex > 0) {
                    comboSemestre.setEnabled(true);
                    comboSemestre.setSelectedIndex(0);
                    //materias.removeAll();
                    //materias.setEnabled(false);
                    return;
                }
                comboSemestre.setEnabled(false);
                //materias.setEnabled(false);
                comboSemestre.setSelectedIndex(0);

            }
        });
        comboSemestre.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int itemIndex = comboSemestre.getSelectedIndex();
                if (itemIndex > 0) {
                    //materias.removeAllItems();
                    CarrerasModelo carrera = (CarrerasModelo) comboCarreras.getItemAt(comboCarreras.getSelectedIndex());
                    String semestre = (String) comboSemestre.getItemAt(comboSemestre.getSelectedIndex());
                    opMateria = new OpMaterias();
                    listaDeMaterias = opMateria.getMateriasByCarreraAndSemestre(carrera.getIdCarrera(), semestre);

                    //materias.setEnabled(true);
                    return;
                }
                //materias.setEnabled(false);
            }
        });
        opCarrera = new OpCarreras();
        ArrayList<CarrerasModelo> allCarreras = opCarrera.getAllCarreras();
        allCarreras.forEach((carrera) -> {
            comboCarreras.addItem(carrera);
        });
        Object[] message = {
            "Ingrese la carrera:", comboCarreras,
            "Ingrese el semestre:", comboSemestre, //  "Seleccione la Materia:", materias
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Ingresa los datos", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            System.out.println("SE LE PUSO QUE OK");
            if (comboCarreras.getSelectedIndex() > 0 && comboSemestre.getSelectedIndex() > 0) {
                System.out.println("Si se va a añadir materia ");

                actualizarTabla();
            }
        }
    }//GEN-LAST:event_buttonRounded1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private swim.botones.ButtonRounded btnGuardar;
    private swim.botones.ButtonRounded buttonRounded1;
    private swim.botones.ButtonRounded buttonRounded3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private swim.panel.MyPanel myPanel1;
    private swim.tabla.Tabla tabla1;
    private javax.swing.JTextField txtGrupo;
    private javax.swing.JTextField txtSemestre;
    // End of variables declaration//GEN-END:variables
}
