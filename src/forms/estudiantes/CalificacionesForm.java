package forms.estudiantes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import modelos.CalificacionModelo;
import modelos.EstudianteModelo;
import modelos.GrupoModelo;
import modelos.Periodo;
import swim.tabla.AccionModelo;
import swim.tabla.EventoAccion;
import operaciones.OpCalificaciones;
import operaciones.OpPeriodo;
import swim.tabla.EventoEditar;

public class CalificacionesForm extends javax.swing.JPanel {

    private OpCalificaciones opCalificacion;
    private EstudianteModelo estudiante;
    private ArrayList<CalificacionModelo> lista;
    private Periodo periodo;
    private OpPeriodo opPeriodo;

    public CalificacionesForm(EstudianteModelo estudiante) {
        initComponents();
        this.estudiante = estudiante;
        opCalificacion = new OpCalificaciones();
        opPeriodo = new OpPeriodo();
        init();
    }

    private void init() {
        periodo = opPeriodo.getUltimoPeriodo();
        tabla1.getTableHeader().setReorderingAllowed(false);
        tabla1.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
                c.setForeground(Color.black);
                if (column <= 7 && column >= 3) {
                    c.setBackground(new Color(20, 90, 95));
                    c.setForeground(Color.WHITE);
                } else if (column <= 12 && column >= 8) {
                    c.setBackground(new Color(104, 108, 133));
                    c.setForeground(Color.WHITE);
                } else if (column <= 17 && column >= 13) {
                    c.setBackground(new Color(20, 90, 95));
                    c.setForeground(Color.WHITE);
                } else if (column <= 22 && column >= 18) {
                    c.setBackground(new Color(104, 108, 133));
                    c.setForeground(Color.WHITE);
                } else {
                    c.setBackground(Color.WHITE);
                    c.setForeground(Color.BLACK);
                }

                if (c instanceof JLabel jLabel) {
                    jLabel.setBorder(new EmptyBorder(10, 5, 10, 5));
                }

                return c;
            }
        });

        tabla1.getModelo().addTableModelListener(new TableModelListener() {

            private boolean isUpdating = false;

            @Override
            public void tableChanged(TableModelEvent e) {
                if (isUpdating) {
                    return;
                }
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    CalificacionModelo calificacion = (CalificacionModelo) lista.get(row);
                    Object newValue = tabla1.getModelo().getValueAt(row, column);
                    try {

                        if (newValue != null) {
                            float calUnidad = Float.parseFloat(newValue.toString());
                            switch (column) {
                                case 3 -> {
                                    calificacion.setP1U1(calUnidad);
                                }
                                case 4 -> {
                                    calificacion.setP2U1(calUnidad);
                                }
                                case 5 -> {
                                    calificacion.setP3U1(calUnidad);
                                }
                                case 6 -> {
                                    calificacion.setP4U1(calUnidad);
                                }

                                case 8 -> {
                                    calificacion.setP1U2(calUnidad);
                                }
                                case 9 -> {
                                    calificacion.setP2U2(calUnidad);
                                }
                                case 10 -> {
                                    calificacion.setP3U2(calUnidad);
                                }
                                case 11 -> {
                                    calificacion.setP4U2(calUnidad);
                                }

                                case 13 -> {
                                    calificacion.setP1U3(calUnidad);
                                }
                                case 14 -> {
                                    calificacion.setP2U3(calUnidad);
                                }
                                case 15 -> {
                                    calificacion.setP3U3(calUnidad);
                                }
                                case 16 -> {
                                    calificacion.setP4U3(calUnidad);
                                }

                                case 18 -> {
                                    calificacion.setP1U4(calUnidad);
                                }
                                case 19 -> {
                                    calificacion.setP2U4(calUnidad);
                                }
                                case 20 -> {
                                    calificacion.setP3U4(calUnidad);
                                }
                                case 21 -> {
                                    calificacion.setP4U4(calUnidad);
                                }

                                case 23 -> {
                                    calificacion.setTrabjoFinal(calUnidad);
                                }
                            }
                        }

                        boolean actualizacionCalificacion = opCalificacion.updateCalificacion(calificacion);

                        if (actualizacionCalificacion) {
                            JOptionPane.showMessageDialog(null, "Calificacion Agregada");
                            isUpdating = true;
                            actualizarTabla();
                            isUpdating = false;
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo agregar / actualizar la calificacion");

                        }

                    } catch (NumberFormatException ex) {
                        String value = newValue.toString().trim().replaceAll("\\s", "");

                        if (value.isEmpty()) {
                            switch (column) {
                                case 3 -> {
                                    calificacion.setP1U1(null);
                                }
                                case 4 -> {
                                    calificacion.setP2U1(null);
                                }
                                case 5 -> {
                                    calificacion.setP3U1(null);
                                }
                                case 6 -> {
                                    calificacion.setP4U1(null);
                                }
                                case 8 -> {
                                    calificacion.setP1U2(null);
                                }
                                case 9 -> {
                                    calificacion.setP2U2(null);
                                }
                                case 10 -> {
                                    calificacion.setP3U2(null);
                                }
                                case 11 -> {
                                    calificacion.setP4U2(null);
                                }
                                case 13 -> {
                                    calificacion.setP1U3(null);
                                }
                                case 14 -> {
                                    calificacion.setP2U3(null);
                                }
                                case 15 -> {
                                    calificacion.setP3U3(null);
                                }
                                case 16 -> {
                                    calificacion.setP4U3(null);
                                }

                                case 18 -> {
                                    calificacion.setP1U4(null);
                                }
                                case 19 -> {
                                    calificacion.setP2U4(null);
                                }
                                case 20 -> {
                                    calificacion.setP3U4(null);
                                }
                                case 21 -> {
                                    calificacion.setP4U4(null);
                                }

                                case 23 -> {
                                    calificacion.setTrabjoFinal(null);
                                }
                            }

                            boolean actualizacionCalificacion = opCalificacion.updateCalificacion(calificacion);

                            if (actualizacionCalificacion) {
                                isUpdating = true;
                                actualizarTabla();
                                isUpdating = false;
                            }
                        }
                        Float calificacionAnterior = null;
                        switch (column) {
                            case 3 -> {
                                calificacionAnterior = calificacion.getP1U1();
                            }
                            case 4 -> {
                                calificacionAnterior = calificacion.getP2U1();
                            }
                            case 5 -> {
                                calificacionAnterior = calificacion.getP3U1();
                            }
                            case 6 -> {
                                calificacionAnterior = calificacion.getP4U1();
                            }
                            case 8 -> {
                                calificacionAnterior = calificacion.getP1U2();
                            }
                            case 9 -> {
                                calificacionAnterior = calificacion.getP2U2();
                            }
                            case 10 -> {
                                calificacionAnterior = calificacion.getP3U2();
                            }
                            case 11 -> {
                                calificacionAnterior = calificacion.getP4U2();
                            }
                            case 13 -> {
                                calificacionAnterior = calificacion.getP1U3();
                            }
                            case 14 -> {
                                calificacionAnterior = calificacion.getP2U3();
                            }
                            case 15 -> {
                                calificacionAnterior = calificacion.getP3U3();
                            }
                            case 16 -> {
                                calificacionAnterior = calificacion.getP4U3();
                            }

                            case 18 -> {
                                calificacionAnterior = calificacion.getP1U4();
                            }
                            case 19 -> {
                                calificacionAnterior = calificacion.getP2U4();
                            }
                            case 20 -> {
                                calificacionAnterior = calificacion.getP3U4();
                            }
                            case 21 -> {
                                calificacionAnterior = calificacion.getP4U4();
                            }

                            case 23 -> {
                                calificacionAnterior = calificacion.getTrabjoFinal();
                            }
                        }
                        isUpdating = true;
                        tabla1.getModel().setValueAt(calificacionAnterior, row, column);
                        isUpdating = false;
                    }

                }
            }
        });

        lista = opCalificacion.obtenerCalificaciones(estudiante.getId());

        for (int i = 0; i < lista.size(); i++) {
            CalificacionModelo calificacion = lista.get(i);
            String idPeriodo = calificacion.getPeriodo().getId();
            if (!idPeriodo.equals(periodo.getId())) {
                tabla1.getTriggerRows().add(i);
            }
            tabla1.addRow(calificacion.toRowTable());
        }

        txtAsignaturas.setText(Integer.toString(lista.size()));
        obtenerPromedioCertificado();
    }

    private void actualizarTabla() {
        tabla1.clear();
        lista = opCalificacion.obtenerCalificaciones(estudiante.getId());

        for (int i = 0; i < lista.size(); i++) {
            CalificacionModelo calificacion = lista.get(i);
            String idPeriodo = calificacion.getPeriodo().getId();
            if (!idPeriodo.equals(periodo.getId())) {
                tabla1.getTriggerRows().add(i);
            }
            tabla1.addRow(calificacion.toRowTable());
        }

        obtenerPromedioCertificado();
    }

    private void obtenerPromedioCertificado() {
        int promediosDisponibles = 0;
        double calificaciones = 0.0;

        for (CalificacionModelo calificacion : lista) {
            if (calificacion.getPromedioFinal() != null) {
                calificaciones += calificacion.getPromedioFinal();
                promediosDisponibles++;
            }
        }

        if (promediosDisponibles > 0) {
            float promedioFinal = (float) (calificaciones / promediosDisponibles);
            txtPromedio.setText(String.format("%.2f", promedioFinal));
        } else {
            txtPromedio.setText("N/A"); // Opcional: Indicar que no hay promedios disponibles
        }
    }

    private void actualizarCalificacion(CalificacionModelo calificacion, int column, Float calUnidad) {
        switch (column) {
            case 3 ->
                calificacion.setP1U1(calUnidad);
            case 4 ->
                calificacion.setP2U1(calUnidad);
            case 5 ->
                calificacion.setP3U1(calUnidad);
            case 6 ->
                calificacion.setP4U1(calUnidad);
            case 8 ->
                calificacion.setP1U2(calUnidad);
            case 9 ->
                calificacion.setP2U2(calUnidad);
            case 10 ->
                calificacion.setP3U2(calUnidad);
            case 11 ->
                calificacion.setP4U2(calUnidad);
            case 13 ->
                calificacion.setTrabjoFinal(calUnidad);
        }
    }

    private Float obtenerCalificacionAnterior(CalificacionModelo calificacion, int column) {
        return switch (column) {
            case 3 ->
                calificacion.getP1U1();
            case 4 ->
                calificacion.getP2U1();
            case 5 ->
                calificacion.getP3U1();
            case 6 ->
                calificacion.getP4U1();
            case 8 ->
                calificacion.getP1U2();
            case 9 ->
                calificacion.getP2U2();
            case 10 ->
                calificacion.getP3U2();
            case 11 ->
                calificacion.getP4U2();
            case 13 ->
                calificacion.getTrabjoFinal();
            default ->
                null;
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanel1 = new swim.panel.MyPanel();
        jLabel5 = new javax.swing.JLabel();
        comboSemestre = new javax.swing.JComboBox();
        myPanel2 = new swim.panel.MyPanel();
        txtAsignaturas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPromedio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new swim.tabla.Tabla();

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Semestre:");

        comboSemestre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "1", "2", "3", "4", "5", "6", "7", "8" }));
        comboSemestre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSemestreItemStateChanged(evt);
            }
        });
        comboSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSemestreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel5)
                .addGap(45, 45, 45)
                .addComponent(comboSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        myPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtAsignaturas.setEditable(false);
        txtAsignaturas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("No. de Asignaturas: ");

        txtPromedio.setEditable(false);
        txtPromedio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Promedio : ");

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));

        jSeparator3.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setOpaque(false);

        tabla1.setBackground(new java.awt.Color(255, 255, 255));
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Semestre", "Ciclo", "Materia", "U I Parcial I", "U I Parcial II", "U I Parcial III", "U 1 Parcial IV", "Promedio UI", "U II Parcial I", "U II Parcial II", "U II Parcial III", "U II Parcial IV", "Promedio UII", "U III Parcial I", "U III Parcial II", "U III Parcial III", "U III Parcial IV", "Promedio U III", "U I Parcial IV", "U II Parcial IV", "U III Parcial IV", "U IV Parical IV", "Promedio U IV", "Trabajo Final", "Promedio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, false, true, true, true, true, false, true, true, true, true, false, true, true, true, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tabla1);
        if (tabla1.getColumnModel().getColumnCount() > 0) {
            tabla1.getColumnModel().getColumn(0).setResizable(false);
            tabla1.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(1).setResizable(false);
            tabla1.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(2).setResizable(false);
            tabla1.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabla1.getColumnModel().getColumn(3).setResizable(false);
            tabla1.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(4).setResizable(false);
            tabla1.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(5).setResizable(false);
            tabla1.getColumnModel().getColumn(5).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(6).setResizable(false);
            tabla1.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(7).setResizable(false);
            tabla1.getColumnModel().getColumn(7).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(8).setResizable(false);
            tabla1.getColumnModel().getColumn(8).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(9).setResizable(false);
            tabla1.getColumnModel().getColumn(9).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(10).setResizable(false);
            tabla1.getColumnModel().getColumn(10).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(11).setResizable(false);
            tabla1.getColumnModel().getColumn(11).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(12).setResizable(false);
            tabla1.getColumnModel().getColumn(12).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(13).setResizable(false);
            tabla1.getColumnModel().getColumn(13).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(14).setResizable(false);
            tabla1.getColumnModel().getColumn(14).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(15).setResizable(false);
            tabla1.getColumnModel().getColumn(15).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(16).setResizable(false);
            tabla1.getColumnModel().getColumn(16).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(17).setResizable(false);
            tabla1.getColumnModel().getColumn(17).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(18).setResizable(false);
            tabla1.getColumnModel().getColumn(18).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(19).setResizable(false);
            tabla1.getColumnModel().getColumn(19).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(20).setResizable(false);
            tabla1.getColumnModel().getColumn(20).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(21).setResizable(false);
            tabla1.getColumnModel().getColumn(21).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(22).setResizable(false);
            tabla1.getColumnModel().getColumn(22).setPreferredWidth(100);
            tabla1.getColumnModel().getColumn(23).setResizable(false);
            tabla1.getColumnModel().getColumn(23).setPreferredWidth(150);
            tabla1.getColumnModel().getColumn(24).setResizable(false);
            tabla1.getColumnModel().getColumn(24).setPreferredWidth(150);
        }

        javax.swing.GroupLayout myPanel2Layout = new javax.swing.GroupLayout(myPanel2);
        myPanel2.setLayout(myPanel2Layout);
        myPanel2Layout.setHorizontalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1428, Short.MAX_VALUE))
                    .addGroup(myPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator3)
                            .addComponent(txtPromedio, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(txtAsignaturas, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        myPanel2Layout.setVerticalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 0, 0)
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(myPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboSemestreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSemestreItemStateChanged

        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            int itemIndex = comboSemestre.getSelectedIndex();

            if (itemIndex == 0) {
                actualizarTabla();
            } else {


                tabla1.clear();
                
                
                lista.stream().filter((calificaciones) -> {
                    return calificaciones.getMateria().getSemestre().equals(comboSemestre.getSelectedItem());
                }).forEach((calificacion) -> {
                    System.out.println(calificacion);
                    tabla1.addRow(calificacion.toRowTable());
                });
            }
        }
    }//GEN-LAST:event_comboSemestreItemStateChanged

    private void comboSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSemestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSemestreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboSemestre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private swim.panel.MyPanel myPanel1;
    private swim.panel.MyPanel myPanel2;
    private swim.tabla.Tabla tabla1;
    private javax.swing.JTextField txtAsignaturas;
    private javax.swing.JTextField txtPromedio;
    // End of variables declaration//GEN-END:variables
}
