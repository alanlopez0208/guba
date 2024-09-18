package forms.grupos;

import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelos.GrupoModelo;
import modelos.EstudianteModelo;
import modelos.GrupoModelo;
import modelos.GrupoMateriaModelo;
import modelos.MaestroModelo;
import modelos.Periodo;
import modelos.MateriaModelo;
import operaciones.OpGrupoMateria;
import operaciones.OpAlumno;
import operaciones.OpGrupoMateria;
import operaciones.OpMaterias;
import operaciones.OpPeriodo;
import swim.botones.ButtonRounded;

public class AlumnosGruposForm extends javax.swing.JPanel {

    private final OpAlumno opAlumno;
    private GrupoModelo grupoModelo;
    private OpMaterias opMaterias;
    private OpPeriodo opPeriodo;
    private OpGrupoMateria opGrupoMateria;
    private ArrayList<EstudianteModelo> alumnos;
    private ArrayList<GrupoMateriaModelo> gruposMateria;
    private MouseAdapter mouseAdapter;

    public AlumnosGruposForm(GrupoModelo grupoModelo) {
        initComponents();
        this.grupoModelo = grupoModelo;
        opAlumno = new OpAlumno();
        opGrupoMateria = new OpGrupoMateria();
        opMaterias = new OpMaterias();
        opPeriodo = new OpPeriodo();
        opGrupoMateria = new OpGrupoMateria();
        init();
    }

    public void init() {
        gruposMateria = opGrupoMateria.obtenerGruposMateriasPorIdGrupo(grupoModelo.getId());

        gruposMateria.forEach((grupoMateria) -> {
            comboMaterias.addItem(grupoMateria.getMateria());
        });

        mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {

                    int option = JOptionPane.showConfirmDialog(null, "¿Estas seguro de retirar al alumno?");

                    if (option == JOptionPane.OK_OPTION) {
                        EstudianteModelo estudiante = alumnos.get(tabla1.getSelectedRow());
                        MateriaModelo materia = (MateriaModelo) comboMaterias.getSelectedItem();

                        boolean eliminado = opAlumno.eliminarCalificaciones(estudiante.getId(), materia.getIdMateria());
                        if (eliminado) {
                            JOptionPane.showMessageDialog(null, "Alumno retirado con exito");
                            alumnos = opAlumno.getEstudiantesByMateria(materia.getIdMateria(), opPeriodo.getUltimoPeriodo().getId());

                            actualizarTabla();
                        } else {
                            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el gurpo");
                        }
                    }
                }
            }
        };

        tabla1.addMouseListener(mouseAdapter);
    }

    public void actualizarTabla() {

        tabla1.clear();

        for (int i = 0; i < alumnos.size(); i++) {

            EstudianteModelo estudiante = alumnos.get(i);
            tabla1.addRow(new Object[]{
                estudiante.getMatricula(), estudiante.getNombre(), estudiante.getApPaterno(), estudiante.getApMaterno()});
        }

    }

    public void modoVer() {

        this.remove(btnAgregarAlumnos);
        this.revalidate();
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabla1 = new swim.tabla.Tabla();
        btnAgregarAlumnos = new swim.botones.ButtonRounded();
        btnAgregarAlumno = new swim.botones.ButtonRounded();
        jLabel3 = new javax.swing.JLabel();
        comboMaterias = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setOpaque(false);

        tabla1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nombre", "Apellido Paterno", "Apellido Materno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        add(jScrollPane2);
        jScrollPane2.setBounds(10, 70, 1530, 600);

        btnAgregarAlumnos.setBackground(new java.awt.Color(0, 102, 102));
        btnAgregarAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/6.png"))); // NOI18N
        btnAgregarAlumnos.setText("Agregar Alumnos");
        btnAgregarAlumnos.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        btnAgregarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAlumnosActionPerformed(evt);
            }
        });
        add(btnAgregarAlumnos);
        btnAgregarAlumnos.setBounds(20, 680, 240, 44);

        btnAgregarAlumno.setBackground(new java.awt.Color(0, 102, 102));
        btnAgregarAlumno.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/6.png"))); // NOI18N
        btnAgregarAlumno.setText("Agregar Alumno");
        btnAgregarAlumno.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        btnAgregarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAlumnoActionPerformed(evt);
            }
        });
        add(btnAgregarAlumno);
        btnAgregarAlumno.setBounds(1280, 680, 240, 44);

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Materia :");
        add(jLabel3);
        jLabel3.setBounds(30, 20, 130, 25);

        comboMaterias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---------------------" }));
        comboMaterias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboMateriasItemStateChanged(evt);
            }
        });
        add(comboMaterias);
        comboMaterias.setBounds(120, 22, 260, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAlumnosActionPerformed
        if (comboMaterias.getSelectedIndex() > 0) {

            if (opAlumno.getEstudiantesByCarreraAndSemestre(grupoModelo.getCarrera().getIdCarrera(), grupoModelo.getSemestre()).isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay alumnos registrados para este semestre");
                return;
            }

            MateriaModelo materia = gruposMateria.get(comboMaterias.getSelectedIndex() - 1).getMateria();
            ArrayList<EstudianteModelo> estudiantesSinMaterias = opAlumno.getEstudiantesByCarreraAndSemestreSinCalificaciones(grupoModelo.getCarrera().getIdCarrera(), grupoModelo.getSemestre(), materia.getIdMateria());

            if (!estudiantesSinMaterias.isEmpty()) {

                MaestroModelo maestro = gruposMateria.get(comboMaterias.getSelectedIndex() - 1).getMaestro();

                Periodo periodo = opPeriodo.getUltimoPeriodo();
                boolean seAgregaron = opAlumno.insertarCalificaciones(estudiantesSinMaterias, maestro.getId(), materia.getIdMateria(), periodo.getId());
                boolean agregarGrupo = opAlumno.actualizarGrupoEstudiantes(grupoModelo.getId(), estudiantesSinMaterias);
                if (seAgregaron && agregarGrupo) {
                    alumnos = opAlumno.getEstudiantesByMateria(materia.getIdMateria(), periodo.getId());
                    JOptionPane.showMessageDialog(null, "Se les asigno la materia a el alumno correctamente");
                    actualizarTabla();

                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error al asignar la materia");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ya se han asigandos todos los alumnos");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una materia para agregar Alumnos");
        }


    }//GEN-LAST:event_btnAgregarAlumnosActionPerformed

    private void btnAgregarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAlumnoActionPerformed
        if (comboMaterias.getSelectedIndex() > 0) {

            if (opAlumno.getEstudiantesByCarreraAndSemestre(grupoModelo.getCarrera().getIdCarrera(), grupoModelo.getSemestre()).isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay alumnos registrados para este semestre");
                return;
            }

            JComboBox comoboEstudiantes = new JComboBox();
            MateriaModelo materia = (MateriaModelo) comboMaterias.getSelectedItem();
            ArrayList<EstudianteModelo> estudiantes = opAlumno.getEstudiantesByCarreraAndSemestreSinCalificaciones(grupoModelo.getCarrera().getIdCarrera(), grupoModelo.getSemestre(), materia.getIdMateria());

            if (!estudiantes.isEmpty()) {

                estudiantes.forEach((alumno) -> {
                    comoboEstudiantes.addItem(alumno);
                });

                Object[] message = {
                    "Selecciona el alumno a agregar", comoboEstudiantes};

                int option = JOptionPane.showConfirmDialog(null, message, "Selecciona", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION && comoboEstudiantes.getItemCount() > 0) {
                    EstudianteModelo estudiante = (EstudianteModelo) comoboEstudiantes.getSelectedItem();

                    MaestroModelo maestro = gruposMateria.get(comboMaterias.getSelectedIndex() - 1).getMaestro();
                    Periodo periodo = opPeriodo.getUltimoPeriodo();

                    boolean insertaCalificacion = opAlumno.insertarCalificacion(estudiante, maestro.getId(), materia.getIdMateria(), periodo.getId());
                    boolean agregarGrupo = opAlumno.actualizarIdGrupoEstudiante(grupoModelo.getId(), estudiante);
                    if (insertaCalificacion) {
                        alumnos = opAlumno.getEstudiantesByMateria(materia.getIdMateria(), periodo.getId());
                        JOptionPane.showMessageDialog(null, "Se les asigno la materia a el alumno correctamente");
                        actualizarTabla();
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un error al asignar la materia");
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "Todos los alumnos ya han sido asignados a esta ");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una materia para agregar Alumnos");
        }


    }//GEN-LAST:event_btnAgregarAlumnoActionPerformed

    private void comboMateriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboMateriasItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            if (comboMaterias.getSelectedIndex() > 0) {
                System.out.println("SE VAN A VER LOS ALUMNOSSS");
                GrupoMateriaModelo grupoMateria = gruposMateria.get(comboMaterias.getSelectedIndex() - 1);

                btnAgregarAlumnos.setVisible(grupoMateria.getCursada() != 1);
                btnAgregarAlumno.setVisible(grupoMateria.getCursada() != 1);

                if (grupoMateria.getCursada() == 1) {
                    tabla1.removeMouseListener(this.mouseAdapter);
                } else if (grupoMateria.getCursada() == 0 && tabla1.getMouseListeners().length > 0) {
                    tabla1.addMouseListener(this.mouseAdapter);
                }
                MateriaModelo materia = grupoMateria.getMateria();

                alumnos = opAlumno.getEstudiantesByMateria(materia.getIdMateria(), opPeriodo.getUltimoPeriodo().getId());
                actualizarTabla();
            } else {
                alumnos = opAlumno.getEstudiantesByMateria("0", opPeriodo.getUltimoPeriodo().getId());
                actualizarTabla();
            }
        }
    }//GEN-LAST:event_comboMateriasItemStateChanged

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabla1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swim.botones.ButtonRounded btnAgregarAlumno;
    private swim.botones.ButtonRounded btnAgregarAlumnos;
    private javax.swing.JComboBox comboMaterias;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private swim.tabla.Tabla tabla1;
    // End of variables declaration//GEN-END:variables
}
