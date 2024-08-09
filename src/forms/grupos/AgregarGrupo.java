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
import modelos.MaestroModelo;
import modelos.MateriaModelo;
import operaciones.OpMaestro;
import operaciones.OpCarreras;
import operaciones.OpGrupo;
import operaciones.OpMaterias;
import swim.Imagen;

public class AgregarGrupo extends javax.swing.JPanel {

    private EventoCerrarForm eventoCerrar;
    private Imagen imagen;
    private OpCarreras opCarrera;
    private OpGrupo opGrupo;
    private OpMaterias opMateria;
    private OpMaestro opMaestro; 
    private ArrayList<MateriaModelo> listaDeMaterias;

    public AgregarGrupo() {
        initComponents();

        //  listaDeMaterias = new ArrayList<>();
        init();
    }

    private void init() {
        imagen = new Imagen();
        opMaestro = new OpMaestro();
        InputStream input = this.getClass().getResourceAsStream("/icon/guardar.png");
        Image icono = imagen.toImageResizable(input, 20, 20);
        btnGuardar.setIcon(new ImageIcon(icono));
        input = this.getClass().getResourceAsStream("/icon/back.png");
        Image iconoBack = imagen.toImageResizable(input, 40, 40);
        btnBack.setIcon(new ImageIcon(iconoBack));
        
        
        opMaestro.getDocentes().forEach((docente)->{
            comboProfesor.addItem(docente);
        });
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
        if(comboProfesor.getSelectedIndex() == 0){
             JOptionPane.showMessageDialog(null, "Ingrese el profesor al grupo");
            return false;
        }
        return true;
    }

    public void addEventoCerrar(EventoCerrarForm eventoCerrar) {
        this.eventoCerrar = eventoCerrar;
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
            System.out.println("AÑADIENDO ROWS");
            MateriaModelo materia = listaDeMaterias.get(i);
            tabla1.addRow(new Object[]{
                materia.getIdMateria(), materia.getNombre(), materia.getHcba(), materia.getHti(), materia.getCreditos()
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
        btnGuardar = new swim.botones.ButtonRounded();
        buttonRounded2 = new swim.botones.ButtonRounded();
        jLabel3 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        buttonRounded3 = new swim.botones.ButtonRounded();
        jLabel4 = new javax.swing.JLabel();
        comboProfesor = new javax.swing.JComboBox();

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Grupo:");

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Profesor:");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

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
        if (tabla1.getColumnModel().getColumnCount() > 0) {
            tabla1.getColumnModel().getColumn(1).setMinWidth(150);
        }

        btnGuardar.setBackground(new java.awt.Color(20, 90, 95));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar Grupo");
        btnGuardar.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        buttonRounded2.setBackground(new java.awt.Color(51, 153, 255));
        buttonRounded2.setForeground(new java.awt.Color(255, 255, 255));
        buttonRounded2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/anadir.png"))); // NOI18N
        buttonRounded2.setText("Añadir Materias");
        buttonRounded2.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        buttonRounded2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRounded2ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Materias:");

        btnBack.setToolTipText("");
        btnBack.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
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

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Semestre: ");

        comboProfesor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-------------------------" }));

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, myPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addComponent(buttonRounded3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonRounded2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(comboProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnBack)
                .addGap(26, 26, 26)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRounded2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRounded3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        this.eventoCerrar.cerrarForm();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (esValido()) {
            int option = JOptionPane.showConfirmDialog(null, "¿Estas seguro de añadir el grupo : " + txtGrupo.getText() + " ?");

            if (option == JOptionPane.OK_OPTION) {
                GrupoModelo grupo = new GrupoModelo();
                grupo.setNombre(txtGrupo.getText().trim());
                grupo.setSemestre(txtSemestre.getText().trim());
                grupo.setMaterias(listaDeMaterias);
                grupo.setMaestro((MaestroModelo) comboProfesor.getSelectedItem());
                
                opGrupo = new OpGrupo();

                boolean estaAgregado = opGrupo.agregarGrupo(grupo);

                if (estaAgregado) {
                    JOptionPane.showMessageDialog(null, "Grupo Agregado Correctamente");
                    this.actualizarTabla();
                    this.eventoCerrar.cerrarForm();
                    return;
                }
                JOptionPane.showMessageDialog(null, "No se pudo agregar");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void buttonRounded2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRounded2ActionPerformed
        JComboBox comboCarreras = new JComboBox();
        JComboBox comboSemestre = new JComboBox();
        //JComboBox materias = new JComboBox();

        comboCarreras.addItem("--------");
        comboSemestre.addItem("1");
        comboSemestre.addItem("2");
        comboSemestre.addItem("3");
        comboSemestre.addItem("4");
        comboSemestre.addItem("5");
        comboSemestre.addItem("6");
        comboSemestre.addItem("7");
        comboSemestre.addItem("8");
        comboSemestre.addItem("9");
        comboSemestre.addItem("10");
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
        // comboSemestre.addItemListener((ItemEvent e) -> {

            //materias.setEnabled(true);
            //materias.setEnabled(false);
            //  });
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
            if (comboCarreras.getSelectedIndex() > 0) {

                int itemIndex = comboSemestre.getSelectedIndex();

                //materias.removeAllItems();
                CarrerasModelo carrera = (CarrerasModelo) comboCarreras.getItemAt(comboCarreras.getSelectedIndex());
                String semestre = (String) comboSemestre.getItemAt(comboSemestre.getSelectedIndex());

                opMateria = new OpMaterias();
                listaDeMaterias = opMateria.getMateriasByCarreraAndSemestre(carrera.getIdCarrera(), semestre);

                actualizarTabla();
            }
        }
    }//GEN-LAST:event_buttonRounded2ActionPerformed

    private void buttonRounded3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRounded3ActionPerformed

        if (!listaDeMaterias.isEmpty()) {
            listaDeMaterias.removeAll(listaDeMaterias);
        }

        this.actualizarTabla();
    }//GEN-LAST:event_buttonRounded3ActionPerformed

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked

    }//GEN-LAST:event_tabla1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private swim.botones.ButtonRounded btnGuardar;
    private swim.botones.ButtonRounded buttonRounded2;
    private swim.botones.ButtonRounded buttonRounded3;
    private javax.swing.JComboBox comboProfesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private swim.panel.MyPanel myPanel1;
    private swim.tabla.Tabla tabla1;
    private javax.swing.JTextField txtGrupo;
    private javax.swing.JTextField txtSemestre;
    // End of variables declaration//GEN-END:variables
}
