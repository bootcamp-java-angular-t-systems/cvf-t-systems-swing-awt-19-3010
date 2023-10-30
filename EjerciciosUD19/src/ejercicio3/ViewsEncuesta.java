package ejercicio3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class ViewsEncuesta extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JRadioButton windowsRadio, linuxRadio, macRadio;
	private JCheckBox programacionCheck, disenoGraficoCheck, administracionCheck;
	private JSlider horasSlider;

	public ViewsEncuesta() {
		getContentPane().setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(45, 25, 80, 14);
		getContentPane().add(lblNombre);

		textField = new JTextField();
		textField.setBounds(91, 20, 148, 25);
		getContentPane().add(textField);

		JLabel lblSistemaOperativo = new JLabel("Elige un sistema operativo:");
		lblSistemaOperativo.setBounds(45, 59, 200, 14);
		getContentPane().add(lblSistemaOperativo);

		windowsRadio = new JRadioButton("Windows");
		windowsRadio.setBounds(45, 77, 100, 20);
		getContentPane().add(windowsRadio);

		linuxRadio = new JRadioButton("Linux");
		linuxRadio.setBounds(45, 100, 100, 20);
		getContentPane().add(linuxRadio);

		macRadio = new JRadioButton("Mac");
		macRadio.setBounds(45, 123, 100, 20);
		getContentPane().add(macRadio);

		ButtonGroup sistemaOperativoGroup = new ButtonGroup();
		sistemaOperativoGroup.add(windowsRadio);
		sistemaOperativoGroup.add(linuxRadio);
		sistemaOperativoGroup.add(macRadio);

		JLabel lblEspecialidad = new JLabel("Elige especialidad:");
		lblEspecialidad.setBounds(45, 150, 200, 14);
		getContentPane().add(lblEspecialidad);

		programacionCheck = new JCheckBox("Programacion");
		programacionCheck.setBounds(45, 171, 120, 20);
		getContentPane().add(programacionCheck);

		disenoGraficoCheck = new JCheckBox("Diseño grafico");
		disenoGraficoCheck.setBounds(45, 194, 120, 20);
		getContentPane().add(disenoGraficoCheck);

		administracionCheck = new JCheckBox("Administración");
		administracionCheck.setBounds(45, 217, 120, 20);
		getContentPane().add(administracionCheck);

		JLabel lblHorasDedicadas = new JLabel("Horas dedicadas en el ordenador:");
		lblHorasDedicadas.setBounds(75, 240, 220, 14);
		getContentPane().add(lblHorasDedicadas);

		horasSlider = new JSlider(0, 10);
		horasSlider.setBounds(45, 269, 200, 20);
		horasSlider.setMajorTickSpacing(1);
		horasSlider.setPaintTicks(true);
		horasSlider.setPaintLabels(true);
		getContentPane().add(horasSlider);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(75, 300, 89, 23);
		getContentPane().add(btnEnviar);

		ActionListener enviarEncuesta = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = textField.getText();
				String sistemaOperativo = getSelectedRadioButton(sistemaOperativoGroup);
				String especialidad = getSelectedCheckBoxes();
				int horasDedicadas = horasSlider.getValue();

				String mensaje = "Nombre: " + nombre + "\nSistema Operativo: " + sistemaOperativo + "\nEspecialidad: "
						+ especialidad + "\nHoras Dedicadas: " + horasDedicadas;
				JOptionPane.showMessageDialog(ViewsEncuesta.this, mensaje);
			}
		};

		btnEnviar.addActionListener(enviarEncuesta);

		setSize(335, 408);
	}

	private String getSelectedRadioButton(ButtonGroup group) {
		Enumeration<AbstractButton> elements = group.getElements();
		while (elements.hasMoreElements()) {
			AbstractButton button = elements.nextElement();
			if (button.isSelected()) {
				return button.getText();
			}
		}
		return "No seleccionado";
	}

	private String getSelectedCheckBoxes() {
		StringBuilder selected = new StringBuilder();
		if (programacionCheck.isSelected()) {
			selected.append("Programación, ");
		}
		if (disenoGraficoCheck.isSelected()) {
			selected.append("Diseño gráfico, ");
		}
		if (administracionCheck.isSelected()) {
			selected.append("Administración");
		}
		return selected.toString();
	}

}
