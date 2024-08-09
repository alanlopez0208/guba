package forms.materias;

import swim.tabla.EventoAccion;
import event.EventoAbrirForm;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.MateriaModelo;
import operaciones.OpCarreras;
import operaciones.OpMaterias;

public class VerMateriasForm extends javax.swing.JPanel {

    private EventoAbrirForm eventoForm;
    private OpMaterias opMaterias;
    private OpCarreras opCarreras;
    private EventoAccion accion;

    public VerMateriasForm() {
        initComponents();
        tabla1.setColumnEditor(5);
        tabla1.fixTable(jScrollPane1);
        opMaterias = new OpMaterias();
        opCarreras = new OpCarreras();
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
                MateriaModelo materia = (MateriaModelo) modelo;
                eventoForm.abrirForm(materia, 0);
            }

            @Override
            public void borrar(Object modelo) {
                MateriaModelo materia = (MateriaModelo) modelo;
                int response = JOptionPane.showConfirmDialog(null, "Estas Seguro en Elimnar a " + materia.getNombre());
                if (response == JOptionPane.OK_OPTION) {

                    boolean seElimino = opMaterias.eliminarMateria(materia.getIdMateria());

                    if (seElimino) {
                        JOptionPane.showMessageDialog(null, "La materia se elimino con exito");
                        actualizarTabla();
                        return;

                    }
                    JOptionPane.showMessageDialog(null, "Hubo un error al eliminar");
                }
            }

            @Override
            public void editar(Object modelo) {
                MateriaModelo materia = (MateriaModelo) modelo;
                eventoForm.abrirForm(materia, 1);
            }
        };
        actualizarTabla();

    }

    public void actualizarTabla() {
        tabla1.clear();
        ArrayList<MateriaModelo> lista = opMaterias.getMaterias();

        for (int i = 0; i < lista.size(); i++) {
            MateriaModelo materia = lista.get(i);
            materia.setCarreraModelo(opCarreras.getCarreraByd(materia.getCarrera()));
            tabla1.addRow(materia.toRowTable(accion));
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
        btnAgregarGrupo = new swim.botones.ButtonRounded();
        myPanel2 = new swim.panel.MyPanel();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboFiltro = new javax.swing.JComboBox<>();

        setName(""); // NOI18N

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Materias:");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tabla1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Creditos", "Semestre ", "Carrera", "Modalidad", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabla1.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(tabla1);
        if (tabla1.getColumnModel().getColumnCount() > 0) {
            tabla1.getColumnModel().getColumn(0).setMinWidth(250);
            tabla1.getColumnModel().getColumn(3).setMinWidth(250);
            tabla1.getColumnModel().getColumn(4).setMinWidth(250);
            tabla1.getColumnModel().getColumn(5).setMinWidth(200);
        }

        btnAgregarGrupo.setBackground(new java.awt.Color(51, 153, 255));
        btnAgregarGrupo.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/anadir.png"))); // NOI18N
        btnAgregarGrupo.setText("Añadir Materia");
        btnAgregarGrupo.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        btnAgregarGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAgregarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
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

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Creditos", "Semestre", "Modalidad" }));

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
                .addContainerGap(724, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(myPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    where = "Nombre";
                }
                case 1 -> {
                    where = "Creditos";
                }
                case 2 -> {
                    where = "Semestre";
                }
                case 3 -> {
                    where = "Modalidad";
                }
            }
            ArrayList<MateriaModelo> lista = opMaterias.buscarMaterias(where, txtBuscar.getText().trim());

            for (int i = 0; i < lista.size(); i++) {
                MateriaModelo materia = lista.get(i);
                materia.setCarreraModelo(opCarreras.getCarreraByd(materia.getCarrera()));
                tabla1.addRow(materia.toRowTable(accion));
            }
        } else {
            actualizarTabla();
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnAgregarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarGrupoActionPerformed


        /*   JTextField txtNombreGrupo = new JTextField();
        JComboBox comboCarreras = new JComboBox();
        JComboBox comboSemestre = new JComboBox();
        JComboBox comboProfesores = new JComboBox();

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
    ArrayList<CarrerasModelo> allCarreras = opCarrera.getAllCarreras();
    allCarreras.forEach((carrera) -> {
        comboCarreras.addItem(carrera);
        });

        comboProfesores.addItem("--------");
        opMaestro.getDocentes().forEach((maestro) -> {
            comboProfesores.addItem(maestro);
        });

        Object[] message = {
            "Ingrese el nombre del Grupo:", txtNombreGrupo,
            "Ingrese el profesor a Impartir : ", comboProfesores,
            "Ingrese la carrera:", comboCarreras,
            "Ingrese el semestre:", comboSemestre,};

        int option = JOptionPane.showConfirmDialog(null, message, "Ingresa los datos", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (!txtNombreGrupo.getText().trim().isEmpty() && comboCarreras.getSelectedIndex() > 0 && comboProfesores.getSelectedIndex() > 0) {
                GrupoModelo grupo = new GrupoModelo();

                grupo.setNombre(txtNombreGrupo.getText().trim());
                grupo.setCarrera((CarrerasModelo) comboCarreras.getSelectedItem());
                grupo.setMaestro((MaestroModelo) comboProfesores.getSelectedItem());
                grupo.setSemestre((String) comboSemestre.getSelectedItem());

                boolean agregado = opGrupo.agregarGrupo(grupo);

                if (agregado) {
                    this.actualizarTabla();
                    JOptionPane.showMessageDialog(null, "Se agrego correctamente el grupo para agregar el grupo");
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error al agregar el grupo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe de Ingresar el Nombre y la carrera para agregar el grupo");
            }
        }*/
    }//GEN-LAST:event_btnAgregarGrupoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swim.botones.ButtonRounded btnAgregarGrupo;
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
