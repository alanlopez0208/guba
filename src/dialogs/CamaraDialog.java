package dialogs;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CamaraDialog extends javax.swing.JDialog {

    private Webcam webcam = null;
    private WebcamPanel panel = null;
    private BufferedImage img;
    private String path;
    private String matricula;

    public CamaraDialog(java.awt.Frame parent, boolean modal, String matriculaUsuario) {
        super(parent, modal);
        initComponents();
        matricula = matriculaUsuario;
        init();
    }

    private void init() {
        Dimension dimension = new Dimension(panelCamara.getWidth() - 15, panelCamara.getHeight() - 15);
        Dimension dimension1 = WebcamResolution.VGA.getSize();

        webcam = Webcam.getDefault();

        webcam.setViewSize(dimension1);
        webcam.addWebcamListener(new WebcamListener() {
            @Override
            public void webcamOpen(WebcamEvent we) {
                System.out.println("Webcam Open");
            }

            @Override
            public void webcamClosed(WebcamEvent we) {
                System.out.println("Webcam Closed");
            }

            @Override
            public void webcamDisposed(WebcamEvent we) {
                System.out.println("Webcam disposed");
            }

            @Override
            public void webcamImageObtained(WebcamEvent we) {
            }

        });

        panel = new WebcamPanel(webcam, dimension, false);
        panel.setFillArea(true);

        panelCamara.setLayout(new FlowLayout());
        panelCamara.add(panel);
        cargandoCamara();
        Thread t = new Thread() {
            @Override
            public void run() {
                panel.start();
                cargoCamara();
            }
        };
        t.setDaemon(true);
        t.start();
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar encender la camara porfavor intentalo de nuevo " + e.getMessage());
            }

        });
    }

    private void cargandoCamara() {
        picker.setEnabled(false);
        btnCapturar.setEnabled(false);
        btnCapturar.setText("Cargando Camara...");
        btnElegirFoto.setEnabled(false);
        btnElegirFoto.setText("Cargando Camara...");
    }

    private void cargoCamara() {
        picker.setEnabled(true);
        btnCapturar.setEnabled(true);
        btnCapturar.setText("Capturar Foto");
        btnElegirFoto.setEnabled(true);
        btnElegirFoto.setText("Guardar Foto");
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        webcamPicker1 = new com.github.sarxos.webcam.WebcamPicker();
        panelCamara = new javax.swing.JPanel();
        picker = new com.github.sarxos.webcam.WebcamPicker();
        btnElegirFoto = new swim.botones.ButtonRounded();
        btnCapturar = new swim.botones.ButtonRounded();
        panelCamara1 = new javax.swing.JPanel();
        txtFotoTomada = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tomar Foto a Alumno");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
        });

        panelCamara.setBackground(new java.awt.Color(255, 255, 255));
        panelCamara.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelCamaraLayout = new javax.swing.GroupLayout(panelCamara);
        panelCamara.setLayout(panelCamaraLayout);
        panelCamaraLayout.setHorizontalGroup(
            panelCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelCamaraLayout.setVerticalGroup(
            panelCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        picker.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pickerItemStateChanged(evt);
            }
        });

        btnElegirFoto.setBackground(new java.awt.Color(0, 51, 102));
        btnElegirFoto.setForeground(new java.awt.Color(255, 255, 255));
        btnElegirFoto.setText("Elegir Foto");
        btnElegirFoto.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 14)); // NOI18N
        btnElegirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirFotoActionPerformed(evt);
            }
        });

        btnCapturar.setBackground(new java.awt.Color(0, 51, 102));
        btnCapturar.setForeground(new java.awt.Color(255, 255, 255));
        btnCapturar.setText("Capturar Foto");
        btnCapturar.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 14)); // NOI18N
        btnCapturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturarActionPerformed(evt);
            }
        });

        panelCamara1.setBackground(new java.awt.Color(255, 255, 255));
        panelCamara1.setForeground(new java.awt.Color(255, 255, 255));

        txtFotoTomada.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));

        javax.swing.GroupLayout panelCamara1Layout = new javax.swing.GroupLayout(panelCamara1);
        panelCamara1.setLayout(panelCamara1Layout);
        panelCamara1Layout.setHorizontalGroup(
            panelCamara1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamara1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFotoTomada, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCamara1Layout.setVerticalGroup(
            panelCamara1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamara1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFotoTomada, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(picker, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                            .addComponent(panelCamara, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                        .addComponent(panelCamara1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnCapturar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnElegirFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCamara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCamara1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnCapturar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnElegirFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        webcam.close();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
        panel.pause();
    }//GEN-LAST:event_formWindowIconified

    private void btnCapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturarActionPerformed
        btnElegirFoto.setEnabled(true);

        ImageIcon foto;
        foto = new ImageIcon(webcam.getImage());
        Icon iconFoto = new ImageIcon(foto.getImage().getScaledInstance(txtFotoTomada.getWidth(), txtFotoTomada.getHeight(), Image.SCALE_SMOOTH));

        txtFotoTomada.setIcon(iconFoto);
        img = webcam.getImage();
    }//GEN-LAST:event_btnCapturarActionPerformed

    private void btnElegirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirFotoActionPerformed
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Deseas Guardar Fotografia?", "Pregunta", JOptionPane.YES_NO_OPTION);

        if (pregunta == JOptionPane.OK_OPTION) {

            img = webcam.getImage();
                dispose();
            // File outputFile = new File("D:\\Alan Lopez\\Imagenes\\probando\\"+matricula+".jpg");

            // try {
            // ImageIO.write(img, "jpg", outputFile);
            //   path = outputFile.getAbsolutePath();
            //   JOptionPane.showMessageDialog(null, "Imagen Guardada en : " + path);
          
            // } catch (IOException ex) {
            //   System.out.println(ex);
            // }
        }
        txtFotoTomada.setIcon(null);

    }//GEN-LAST:event_btnElegirFotoActionPerformed

    private void pickerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pickerItemStateChanged
        if (evt.getItem() != webcam) {
          Webcam camara = (Webcam) evt.getItem();
        
            System.out.println("Se cambio de camara");
            panel.stop();

            panelCamara.remove(panel);

            webcam.close();

            webcam = (Webcam) evt.getItem();

            Dimension dimension = new Dimension(panelCamara.getWidth() - 15, panelCamara.getHeight() - 15);
            Dimension dimension1 = WebcamResolution.VGA.getSize();

            webcam.setViewSize(dimension1);
            panel = new WebcamPanel(webcam, dimension, false);
            panel.setFillArea(true);
            panelCamara.setLayout(new FlowLayout());
            panelCamara.add(panel);

            Thread t = new Thread() {
                @Override
                public void run() {
                    cargandoCamara();
                    panel.start();

                    cargoCamara();
                }
            };
            t.setDaemon(true);
            t.start();
            t.setUncaughtExceptionHandler((Thread t1, Throwable e) -> {
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar encender la camara porfavor intentalo de nuevo " + e.getMessage());
            });
        }
    }//GEN-LAST:event_pickerItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swim.botones.ButtonRounded btnCapturar;
    private swim.botones.ButtonRounded btnElegirFoto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelCamara;
    private javax.swing.JPanel panelCamara1;
    private com.github.sarxos.webcam.WebcamPicker picker;
    private javax.swing.JLabel txtFotoTomada;
    private com.github.sarxos.webcam.WebcamPicker webcamPicker1;
    // End of variables declaration//GEN-END:variables
}
