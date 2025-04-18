package org.example.Vista;

import org.example.Controlador.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VInicioAdmin extends JFrame {
    private VistaController vistaController;
    private Login login;
    private DVisualizarResultados dVisualizarResultados;

    private JPanel pPrincipal;
    private JPanel pHeader;
    private JPanel pBody;
    private JButton bAdministrar;
    private JButton bCerrarEtapa;
    private JButton bVerInforme;
    private JButton bGenerarCalendario;
    private JButton bIntroducirResultados;
    private JPanel pArriba;
    private JPanel pAbajo;
    private JButton bLogOut;

    public VInicioAdmin(VistaController vistaController, Login login) {
        this.vistaController = vistaController;
        this.login = login;

        setContentPane(pPrincipal);
        setTitle("Vista Admin");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);

        bLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login(vistaController);
                login.setVisible(true);
                dispose();
            }
        });

        bAdministrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VAdministrarAdmin vAdministrarAdmin = new VAdministrarAdmin(vistaController);
                vAdministrarAdmin.setVisible(true);
                dispose();
            }
        });

        bGenerarCalendario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numJornadas = Integer.parseInt(JOptionPane.showInputDialog(pPrincipal, "¿Cuantas jornadas quieres generar?"));

                    vistaController.generarCalendario(numJornadas);

                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(pPrincipal, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        bVerInforme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DVisualizarResultados dVisualizarResultados = new DVisualizarResultados(vistaController);
                    dVisualizarResultados.setVisible(true);

                }catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
