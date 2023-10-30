package ejercicio2;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewSelectPelicula extends JFrame {
	private static final long serialVersionUID = 1L;
    private JTextField textFieldNombre;
    private JComboBox<String> comboBoxPeliculas;
    private JLabel lblPeliculas;

    public ViewSelectPelicula() {
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Escribe el título de una película:");
        lblNewLabel.setBounds(75, 55, 180, 14);
        getContentPane().add(lblNewLabel);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(71, 80, 120, 20);
        getContentPane().add(textFieldNombre);
        textFieldNombre.setColumns(10);

        comboBoxPeliculas = new JComboBox<String>();
        comboBoxPeliculas.addItem("Buscando a Nemo");
        comboBoxPeliculas.addItem("La Sirenita");
        comboBoxPeliculas.setBounds(241, 80, 138, 20);
        getContentPane().add(comboBoxPeliculas);

        JButton btnNewButton = new JButton("Enviar");
        btnNewButton.setBounds(75, 140, 89, 23);
        getContentPane().add(btnNewButton);

        lblPeliculas = new JLabel("Peliculas");
        lblPeliculas.setBounds(241, 55, 83, 14);
        getContentPane().add(lblPeliculas);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombre.getText();

                if (!nombre.isEmpty()) {
                    comboBoxPeliculas.addItem(nombre);
                    JOptionPane.showMessageDialog(ViewSelectPelicula.this, "Película '" + nombre + "' agregada.");
                } else {
                    JOptionPane.showMessageDialog(ViewSelectPelicula.this, "Ingresa un nombre");
                }
            }
        });

        setSize(400, 200);
    }
}
