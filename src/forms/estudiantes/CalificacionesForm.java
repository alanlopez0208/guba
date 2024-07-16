package forms.estudiantes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
import operaciones.OpCalificaciones;

public class CalificacionesForm extends javax.swing.JPanel {

    private OpCalificaciones opCalificacion;
    private EstudianteModelo estudiante;
    private ArrayList<CalificacionModelo> lista;

    public CalificacionesForm(EstudianteModelo estudiante) {
        initComponents();
        this.estudiante = estudiante;
        init();
    }

    private void init() {

        opCalificacion = new OpCalificaciones();
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
                } else {
                    c.setBackground(Color.WHITE);
                }

                if (c instanceof JLabel) {
                    ((JLabel) c).setBorder(new EmptyBorder(10, 5, 10, 5));
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
        System.out.println("-------------------" + lista.size());
        lista.forEach((calificacion) -> {
            tabla1.addRow(calificacion.toRowTable());
        });

        List<GrupoModelo> listaGrupos = lista.stream().map((caliificacion) -> {
            return caliificacion.getGrupo();
        }).distinct().collect(Collectors.toList());

        listaGrupos.forEach((grupo) -> {
            comboGrupo.addItem(grupo);
        });

        txtAsignaturas.setText(Integer.toString(lista.size()));
        obtenerPromedioCertificado();
    }

    private void actualizarTabla() {
        tabla1.clear();
        lista = opCalificacion.obtenerCalificaciones(estudiante.getId());
        System.out.println("-------------------" + lista.size());
        lista.forEach((calificacion) -> {
            tabla1.addRow(calificacion.toRowTable());
        });

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
        comboGrupo = new javax.swing.JComboBox();
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
        jLabel5.setText("Grupo:");

        comboGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos" }));
        comboGrupo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboGrupoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                "Semestre", "Grupo", "Materia", "U I Parcial I", "U I Parcial II", "U I Parcial III", "U 1 Parcial IV", "Promedio UI", "U II Parcial I", "U II Parcial II", "U II Parcial III", "U II Parcial IV", "Promedio UII", "Trabajo Final", "Promedio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, false, true, true, true, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane1.setViewportView(tabla1);
        if (tabla1.getColumnModel().getColumnCount() > 0) {
            tabla1.getColumnModel().getColumn(0).setMinWidth(150);
            tabla1.getColumnModel().getColumn(2).setMinWidth(200);
            tabla1.getColumnModel().getColumn(3).setMinWidth(90);
            tabla1.getColumnModel().getColumn(4).setMinWidth(90);
            tabla1.getColumnModel().getColumn(5).setMinWidth(90);
            tabla1.getColumnModel().getColumn(6).setMinWidth(90);
            tabla1.getColumnModel().getColumn(7).setMinWidth(90);
            tabla1.getColumnModel().getColumn(8).setMinWidth(90);
            tabla1.getColumnModel().getColumn(9).setMinWidth(90);
            tabla1.getColumnModel().getColumn(10).setMinWidth(90);
            tabla1.getColumnModel().getColumn(11).setMinWidth(90);
            tabla1.getColumnModel().getColumn(12).setMinWidth(90);
        }

        javax.swing.GroupLayout myPanel2Layout = new javax.swing.GroupLayout(myPanel2);
        myPanel2.setLayout(myPanel2Layout);
        myPanel2Layout.setHorizontalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addContainerGap(1025, Short.MAX_VALUE))
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        myPanel2Layout.setVerticalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void comboGrupoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboGrupoItemStateChanged

        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            int itemIndex = comboGrupo.getSelectedIndex();

            if (itemIndex == 0) {
                actualizarTabla();
            } else {

                GrupoModelo grupoSeleccionado = (GrupoModelo) comboGrupo.getSelectedItem();

                tabla1.clear();
                lista.stream().filter((calificaciones) -> {
                    return calificaciones.getGrupo().equals(grupoSeleccionado);
                }).forEach((calificacion) -> {
                    System.out.println(calificacion);
                    tabla1.addRow(calificacion.toRowTable());
                });
            }
        }
    }//GEN-LAST:event_comboGrupoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboGrupo;
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
