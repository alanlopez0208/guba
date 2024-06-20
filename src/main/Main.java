package main;

import componentes.Menu;
import event.EventMenuSelected;
import forms.MainForm;
import forms.estudiantes.AgregarAlumnoForm;
import forms.estudiantes.EditarEstudiante;
import forms.estudiantes.EstudianteForm;
import forms.estudiantes.VerEstudiantesForm;

import forms.inicio.InicioForm;
import modelos.EstudianteModelo;
import net.miginfocom.swing.MigLayout;
import event.EventoAbrirForm;
import event.EventoCerrarForm;
import forms.carreras.*;
import forms.grupos.AgregarGrupo;
import forms.grupos.EditarGrupo;
import forms.grupos.VerGrupo;
import forms.grupos.VerGruposForm;
import forms.maestros.AgregarMaestroForm;
import forms.maestros.EditarMaestroForm;
import forms.maestros.MaestroForm;
import forms.maestros.VerMaestrosForm;
import forms.materias.AgregarMateria;
import forms.materias.EditarMateria;
import forms.materias.VerMateria;
import forms.materias.VerMateriasForm;

import modelos.*;

public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private MainForm main;
    private Menu menu;
    private VerEstudiantesForm verEstudiantesForm;
    private VerMaestrosForm verMaestrosForm;
    private VerGruposForm verGrupos;
    private VerMateriasForm verMaterias;
    private VerCarrerasForm verCarreras;

    public Main() {
        initComponents();
        init();
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");

        bg.setLayout(layout);
        menu = new Menu();
        main = new MainForm();
        verEstudiantesForm = new VerEstudiantesForm();
        verEstudiantesForm.addEventoForm(new EventoAbrirForm() {
            @Override
            public void abrirForm(Object modelo, int index) {
                if (index == 0) {
                    EstudianteForm estudianteForm = new EstudianteForm((EstudianteModelo) modelo, new EventoCerrarForm() {
                        @Override
                        public void cerrarForm() {
                            verEstudiantesForm.actualizarTabla();
                            main.showForm(verEstudiantesForm);
                        }
                    });

                    main.showForm(estudianteForm);
                } else if (index == 1) {
                    EditarEstudiante editarEstudianteForm = new EditarEstudiante((EstudianteModelo) modelo);
                    editarEstudianteForm.addEvento(new EventoCerrarForm() {
                        @Override
                        public void cerrarForm() {
                            verEstudiantesForm.actualizarTabla();
                            main.showForm(verEstudiantesForm);
                        }
                    });
                    main.showForm(editarEstudianteForm);
                }
            }
        });

        verMaestrosForm = new VerMaestrosForm();
        verMaestrosForm.addEventoForm(new EventoAbrirForm() {
            @Override
            public void abrirForm(Object modelo, int index) {
                if (index == 0) {
                    MaestroForm maestro = new MaestroForm((MaestroModelo) modelo, new EventoCerrarForm() {
                        @Override
                        public void cerrarForm() {
                            verMaestrosForm.actualizarTabla();
                            main.showForm(verMaestrosForm);
                        }
                    });
                    main.showForm(maestro);
                }
                if (index == 1) {

                    EditarMaestroForm editarMaestro = new EditarMaestroForm((MaestroModelo) modelo);
                    editarMaestro.addEvento(new EventoCerrarForm() {
                        @Override
                        public void cerrarForm() {
                            verMaestrosForm.actualizarTabla();
                            main.showForm(verMaestrosForm);
                        }
                    });
                    main.showForm(editarMaestro);
                }
            }
        });

        verGrupos = new VerGruposForm();
        verGrupos.addEventoForm(new EventoAbrirForm() {
            @Override
            public void abrirForm(Object modelo, int index) {
                if (index == 0) {
                    GrupoModelo grupo = (GrupoModelo) modelo;
                    VerGrupo verGrupo = new VerGrupo(grupo);
                    verGrupo.addEventoCerrar(new EventoCerrarForm() {
                        @Override
                        public void cerrarForm() {
                            verGrupos.actualizarTabla();
                            main.showForm(verGrupos);
                        }
                    });

                    main.showForm(verGrupo);

                } else if (index == 1) {
                    System.out.println(modelo);
                    EditarGrupo editarGrupo = new EditarGrupo((GrupoModelo) modelo);

                    editarGrupo.addEventoCerrar(new EventoCerrarForm() {
                        @Override
                        public void cerrarForm() {
                            verGrupos.actualizarTabla();
                            main.showForm(verGrupos);
                        }
                    });

                    main.showForm(editarGrupo);
                }
            }

        });

        verMaterias = new VerMateriasForm();
        verMaterias.addEventoForm(new EventoAbrirForm() {
            @Override
            public void abrirForm(Object modelo, int index) {
                MateriaModelo materia = (MateriaModelo) modelo;
                if (index == 0) {
                    VerMateria verMateria = new VerMateria(materia);
                    verMateria.addEventoCerrar(new EventoCerrarForm() {
                        @Override
                        public void cerrarForm() {
                          
                            main.showForm(verMaterias);
                        }

                    });

                    main.showForm(verMateria);
                } else if (index == 1) {
                    EditarMateria editarMateria = new EditarMateria(materia);
                    editarMateria.addEventoCerrar(new EventoCerrarForm() {
                        @Override
                        public void cerrarForm() {
                            verMaterias.actualizarTabla();
                            main.showForm(verMaterias);
                        }
                    });
                    main.showForm(editarMateria);
                }
            }
        });
        
        verCarreras = new VerCarrerasForm();
        verCarreras.addEventoForm(new EventoAbrirForm() {
            @Override
            public void abrirForm(Object modelo, int index) {
                CarrerasModelo carrera = (CarrerasModelo) modelo;
                if (index == 0) {
                    VerCarrera verCarrera = new VerCarrera(carrera);
                    verCarrera.addEventoCerrar(new EventoCerrarForm() {
                        @Override
                        public void cerrarForm() {
                            main.showForm(verCarreras);
                        }
                    });
                    main.showForm(verCarrera);
                    
                } else if (index == 1) {
                    EditarCarrera editarCarrer = new EditarCarrera(carrera);
                    editarCarrer.addEventoCerrar(new EventoCerrarForm() {
                        @Override
                        public void cerrarForm() {
                            verCarreras.actualizarTabla();
                            main.showForm(verCarreras);
                        }
                    });
                    main.showForm(editarCarrer);
                }
            }

        });

        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " Submenu Index " + subMenuIndex);
                switch (menuIndex) {
                    case 0 ->
                        main.showForm(new InicioForm());
                    case 1 -> {
                        if (subMenuIndex == 2) {
                            main.showForm(verEstudiantesForm);
                        } else if (subMenuIndex == 3) {
                            EventoCerrarForm evento = new EventoCerrarForm() {
                                @Override
                                public void cerrarForm() {
                                    verEstudiantesForm.actualizarTabla();
                                    main.showForm(verEstudiantesForm);
                                }
                            };
                            main.showForm(new AgregarAlumnoForm(evento));
                        }
                    }
                    case 2 -> {
                        if (subMenuIndex == 2) {

                            main.showForm(verMaestrosForm);
                        } else if (subMenuIndex == 3) {
                            EventoCerrarForm evento = new EventoCerrarForm() {
                                @Override
                                public void cerrarForm() {
                                    verMaestrosForm.actualizarTabla();
                                    main.showForm(verMaestrosForm);
                                }
                            };
                            main.showForm(new AgregarMaestroForm(evento));
                        }
                    }

                    case 3 -> {
                        if (subMenuIndex == 2) {
                            main.showForm(verGrupos);
                        } else if (subMenuIndex == 3) {

                            AgregarGrupo agregarGrupo = new AgregarGrupo();

                            agregarGrupo.addEventoCerrar(new EventoCerrarForm() {
                                @Override
                                public void cerrarForm() {
                                    verGrupos.actualizarTabla();
                                    main.showForm(verGrupos);
                                }

                            });
                            main.showForm(agregarGrupo);
                        }
                    }
                    
                    case 4->{
                        if(subMenuIndex ==2){
                            main.showForm(verMaterias);
                        }else if(subMenuIndex == 3){
                            AgregarMateria agregarMateria = new AgregarMateria();
                            agregarMateria.addEventoCerrar(new EventoCerrarForm() {
                                @Override
                                public void cerrarForm() {
                                    verMaterias.actualizarTabla();
                                    main.showForm(verMaterias);
                                }
                            });
                            
                            main.showForm(agregarMateria);
                        }
                    }
                    case 5->{
                        if(subMenuIndex ==2){
                            main.showForm(verCarreras);
                        }else if(subMenuIndex == 3){
                            AgregarCarrera agregarCarrera = new AgregarCarrera();
                            agregarCarrera.addEventoCerrar(new EventoCerrarForm() {
                                @Override
                                public void cerrarForm() {
                                    verCarreras.actualizarTabla();
                                    main.showForm(verCarreras);
                                }
                            });
                            
                            main.showForm(agregarCarrera);
                        }
                    }
                    default -> {
                    }
                }
            }
        });

        menu.initMenuItem();
        bg.add(menu, "w 240!, spany 2");
        bg.add(main, "w 100%, h 100%");
        main.showForm(new InicioForm());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
