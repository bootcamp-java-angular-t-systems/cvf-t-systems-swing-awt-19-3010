package ejercicio4;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Color;

public class ViewsCalculadora extends JFrame {
	private static final long serialVersionUID = 1L;
	JButton[] caracteres = new JButton[6];
	JButton[] numeros = new JButton[10];
	private String operadorActual = "";
	private double numeroAnterior = 0.0;

	public ViewsCalculadora() {
		getContentPane().setLayout(null);

		JButton btn9 = new JButton("9");
		btn9.setBounds(192, 102, 58, 50);
		getContentPane().add(btn9);

		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn8.setBounds(120, 102, 58, 50);
		getContentPane().add(btn8);

		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn7.setBounds(44, 102, 58, 50);
		getContentPane().add(btn7);

		JButton btn6 = new JButton("6");
		btn6.setBounds(192, 163, 58, 50);
		getContentPane().add(btn6);

		JButton btn5 = new JButton("5");
		btn5.setBounds(120, 163, 58, 50);
		getContentPane().add(btn5);

		JButton btn4 = new JButton("4");
		btn4.setBounds(44, 163, 58, 50);
		getContentPane().add(btn4);

		JButton btn3 = new JButton("3");
		btn3.setBounds(192, 226, 58, 50);
		getContentPane().add(btn3);

		JButton btn2 = new JButton("2");
		btn2.setBounds(120, 226, 58, 50);
		getContentPane().add(btn2);

		JButton btn1 = new JButton("1");
		btn1.setBounds(44, 226, 58, 50);
		getContentPane().add(btn1);

		JButton btnEliminarCaracter = new JButton("Del");
		btnEliminarCaracter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminarCaracter.setBounds(44, 41, 58, 50);
		getContentPane().add(btnEliminarCaracter);

		JButton btnSum = new JButton("+");
		btnSum.setBounds(269, 163, 58, 50);
		getContentPane().add(btnSum);

		JButton btnRestar = new JButton("-");
		btnRestar.setBounds(269, 226, 58, 50);
		getContentPane().add(btnRestar);

		JButton btn0 = new JButton("0");
		btn0.setBounds(44, 287, 58, 50);
		getContentPane().add(btn0);

		JButton btnDecimal = new JButton(".");
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDecimal.setBounds(120, 287, 58, 50);
		getContentPane().add(btnDecimal);

		JButton btnIgual = new JButton("=");
		btnIgual.setBounds(192, 287, 135, 50);
		getContentPane().add(btnIgual);

		JButton btnMultiplicar = new JButton("x");
		btnMultiplicar.setBounds(269, 102, 58, 50);
		getContentPane().add(btnMultiplicar);

		JButton btnDivide = new JButton("/");
		btnDivide.setBounds(269, 41, 58, 50);
		getContentPane().add(btnDivide);
		setSize(400, 400);

		JLabel lblResult = new JLabel("");
		lblResult.setBackground(new Color(0, 0, 0));
		lblResult.setBounds(120, 41, 130, 50);
		getContentPane().add(lblResult);

		caracteres[0] = btnSum;
		caracteres[1] = btnDivide;
		caracteres[2] = btnMultiplicar;
		caracteres[3] = btnRestar;
		caracteres[4] = btnEliminarCaracter;
		caracteres[5] = btnIgual;

		numeros[0] = btn0;
		numeros[1] = btn1;
		numeros[2] = btn2;
		numeros[3] = btn3;
		numeros[4] = btn4;
		numeros[5] = btn5;
		numeros[6] = btn6;
		numeros[7] = btn7;
		numeros[8] = btn8;
		numeros[9] = btn9;

		for (int i = 0; i < caracteres.length; i++) {
			final int index = i;
			caracteres[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					operadorActual = caracteres[index].getText();
					numeroAnterior = Double.parseDouble(lblResult.getText());
					lblResult.setText("");
				}
			});
		}

		for (int i = 0; i < numeros.length; i++) {
			numeros[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton thisButton = (JButton) e.getSource();
					String content = thisButton.getText();
					 String currentText = lblResult.getText();
					 if (currentText.length() == 1 && currentText.equals("0"))
						 lblResult.setText(content);
					 else
						 lblResult.setText(lblResult.getText() + content);
				}
			});
		}

		btnIgual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double numeroActual = Double.parseDouble(lblResult.getText());
				double result = calcular(numeroAnterior, numeroActual, operadorActual);

				SwingUtilities.invokeLater(new Runnable() {
		            @Override
		            public void run() {
		                lblResult.setText(String.valueOf(result));
		            }
		        });
			}
		});

		btnDecimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!lblResult.getText().contains("."))
					lblResult.setText(lblResult.getText() + ".");
			}
		});

		btnEliminarCaracter.addActionListener(new ActionListener() {
			 @Override
			    public void actionPerformed(ActionEvent e) {
			        String numeroActual = lblResult.getText();
			        if (numeroActual.length() > 1)
			            numeroActual = numeroActual.substring(0, numeroActual.length() - 1);
			        else
			            numeroActual = "0";
			        final String numeroResultado = numeroActual;
			        SwingUtilities.invokeLater(new Runnable() {
			            @Override
			            public void run() {
			                lblResult.setText(numeroResultado);
			            }
			        });
			    }
		});
	}

	private double calcular(double num1, double num2, String operador) {
		switch (operador) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "x":
			return num1 * num2;
		case "/":
			if (num2 != 0)
				return num1 / num2;
			else 
				return Double.NaN;
		default:
			return num2;
		}
	}
}
