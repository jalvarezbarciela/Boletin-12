package bol12_1;

import javax.swing.JOptionPane;

/**
 *
 * @author jalvarezbarciela
 */
public class Garaje {
    private int numeroCoches, numeroPlazas = 5;
    private long horaEntrada, horaSalida, horas;
    private String matricula;
    private double precio, cantidadIntroducida, cambio;

    public Garaje() {
    }

    public void aparcar() {
        if (numeroPlazas == 0) {
            JOptionPane.showMessageDialog(null, "COMPLETO");
        } else {
            JOptionPane.showMessageDialog(null, "PLAZAS DISPONIBLES");
            matricula = JOptionPane.showInputDialog(null, "INTRODUZCA MATRICULA");
            numeroPlazas--;
            numeroCoches++;
            horaEntrada = System.currentTimeMillis() / 1000 / 60 / 60;
        }
    }

    public void retirar() {
        if (numeroPlazas == 5) {
            JOptionPane.showMessageDialog(null, "NO HAY COCHES A RETIRAR");
        } else {
            horaSalida = System.currentTimeMillis() / 1000 / 60 / 60;
            if (horaSalida - horaEntrada < 3) {
                precio = 1.5;
            } else {
                horas = (horaSalida - horaEntrada) - 3;
                Math.floor(horas);
                precio = 1.5 + (0.2 * horas);
            }
            cantidadIntroducida = Double.parseDouble(JOptionPane.showInputDialog(null, "INTRODUZCA PAGO"));
            while (cantidadIntroducida < precio) {
                JOptionPane.showMessageDialog(null, "PAGO INSUFICIENTE");
                cantidadIntroducida = cantidadIntroducida + Double.parseDouble(JOptionPane.showInputDialog(null, "INTRODUZCA PAGO"));
            }
            cambio = cantidadIntroducida - precio;
            JOptionPane.showMessageDialog(null, "FACTURA\nMATRICULA COCHE: " + matricula + "\nTIEMPO: " + (horaSalida - horaEntrada) + "\nPRECIO: " + precio + "\nDINERO RECIBIDO: " + cantidadIntroducida + "\nDINERO DEVUELTO: " + cambio);
            numeroPlazas++;
            numeroCoches--;
        }
    }

    public void programa() {
        int eleccion;
        String[] opciones = {"APARCAR", "RETIRAR", "SALIR"};
        eleccion = JOptionPane.showOptionDialog(null, "QUE ACCIÓN DESEA HACER?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
        while (eleccion <= 1) {
            if (eleccion <= 1) {
                switch (eleccion) {
                    case 0:
                        aparcar();
                        eleccion = JOptionPane.showOptionDialog(null, "QUE ACCIÓN DESEA HACER?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
                        break;
                    case 1:
                        retirar();
                        eleccion = JOptionPane.showOptionDialog(null, "QUE ACCIÓN DESEA HACER?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
                        break;
                }
            }
        }
    }
}
