package healthcare.view;

import javax.swing.*;
import java.awt.*;
import healthcare.controller.DataController;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private DataController controller;

    public MainFrame() {
        controller = new DataController();
        setTitle("Healthcare Management System");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Core panels (assuming you already have these)
        tabbedPane.addTab("Patients", new PatientPanel(controller));
        tabbedPane.addTab("Clinicians", new ClinicianPanel(controller));
        tabbedPane.addTab("Appointments", new AppointmentPanel(controller));
        tabbedPane.addTab("Prescriptions", new PrescriptionPanel(controller));

        // New panels
        tabbedPane.addTab("Facilities", new FacilityPanel(controller));
        tabbedPane.addTab("Staff", new StaffPanel(controller));
        tabbedPane.addTab("Referrals", new ReferralPanel(controller));

        // Add tabbed pane to frame
        add(tabbedPane);

        // Optional: Customize the overall look
        UIManager.put("TabbedPane.selected", new Color(0xDCEFFF));
        UIManager.put("TabbedPane.contentAreaColor", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
        UIManager.put("Button.font", new Font("Segoe UI", Font.PLAIN, 13));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
