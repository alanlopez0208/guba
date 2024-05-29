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

public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private MainForm main;
    private Menu menu;
    private VerEstudiantesForm verEstudiantesForm;

    public Main() {
        initComponents();
        init();
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");

        bg.setLayout(layout);
        menu = new Menu();
        main = new MainForm();

        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " Submenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    main.showForm(new InicioForm());
                } else if (menuIndex == 1) {
                    if (subMenuIndex == 2) {
                        verEstudiantesForm = new VerEstudiantesForm();

                        verEstudiantesForm.addEventoForm(new EventoAbrirForm() {
                            @Override
                            public void abrirForm(EstudianteModelo modelo, int index) {
                                if (index == 0) {
                                    main.showForm(new EstudianteForm(modelo));
                                } else if (index == 1) {
                                    EditarEstudiante editarEstudianteForm = new EditarEstudiante(modelo);
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

                        main.showForm(verEstudiantesForm);

                    } else if (subMenuIndex == 3) {
                        EventoCerrarForm evento = new EventoCerrarForm(){
                            @Override
                            public void cerrarForm() {
                                 verEstudiantesForm.actualizarTabla();
                                  main.showForm(verEstudiantesForm);
                            }
                            
                        };
                        
                        main.showForm(new AgregarAlumnoForm(evento));
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

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1169, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
