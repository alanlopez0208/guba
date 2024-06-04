import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrupoModelo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JDialog Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton button = new JButton("Show Dialog");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(frame, "Dialog Title", true);
                dialog.setSize(200, 150);
                dialog.setLayout(new BorderLayout());

                JLabel label = new JLabel("This is a JDialog", SwingConstants.CENTER);
                dialog.add(label, BorderLayout.CENTER);

                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                    }
                });
                dialog.add(okButton, BorderLayout.SOUTH);

                dialog.setLocationRelativeTo(frame);
                dialog.setVisible(true);
            }
        });

        frame.getContentPane().add(button);
        frame.setVisible(true);
    }
}
