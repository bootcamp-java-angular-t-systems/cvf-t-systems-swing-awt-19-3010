package ejercicio1;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewHolaNombre extends JFrame {
	private static final long serialVersionUID = 1L;
    private JTextField textField;

    public ViewHolaNombre() {
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Escribe aqui tu nombre:");
        lblNewLabel.setBounds(75, 55, 257, 14);
        getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(71, 80, 192, 20);
        getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Enviar");
        btnNewButton.setBounds(75, 120, 89, 23);
        getContentPane().add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField.getText();
                if (!nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(ViewHolaNombre.this, "Hola, " + nombre);
                } else {
                    JOptionPane.showMessageDialog(ViewHolaNombre.this, "Ingresa un nombre");
                }
            }
        });
    }
}
