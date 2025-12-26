package healthcare.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import healthcare.controller.DataController;
import healthcare.controller.ReferralController;
import healthcare.singleton.ReferralManager;
import healthcare.model.Referral;
import java.awt.*;

public class ReferralPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private DataController controller;
    private ReferralController referralController;
    private ReferralManager referralManager;

    public ReferralPanel(DataController controller) {
        this.controller = controller;
        this.referralController = ReferralController.getInstance(); // Singleton
        this.referralManager = ReferralManager.getInstance(); // Singleton
        
        setLayout(new BorderLayout());
        
        model = new DefaultTableModel(new String[]{
            "Referral ID", "Patient ID", "From Clinician", "To Clinician", "Urgency", "Status", "Date"
        }, 0);
        table = new JTable(model);
        
        loadReferrals();

        JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton("Add Referral");
        JButton editBtn = new JButton("Edit");
        JButton deleteBtn = new JButton("Delete");
        JButton generateBtn = new JButton("Generate Referral Document");

        addBtn.addActionListener(e -> addReferral());
        editBtn.addActionListener(e -> editReferral());
        deleteBtn.addActionListener(e -> deleteReferral());
        generateBtn.addActionListener(e -> generateReferralDocument());

        buttonPanel.add(addBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(generateBtn);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadReferrals() {
        model.setRowCount(0);
        for (Referral r : controller.getReferrals()) {
            String[] data = r.toString().split(",");
            if (data.length >= 16) {
                model.addRow(new Object[]{data[0], data[1], data[2], data[3], data[7], data[11], data[6]});
            }
        }
    }

    private void addReferral() {
        JTextField referralId = new JTextField();
        JTextField patientId = new JTextField();
        JTextField referringClinicianId = new JTextField();
        JTextField referredToClinicianId = new JTextField();
        JTextField referringFacilityId = new JTextField();
        JTextField referredToFacilityId = new JTextField();
        JTextField referralDate = new JTextField(java.time.LocalDate.now().toString());
        JTextField urgencyLevel = new JTextField("Routine");
        JTextArea referralReason = new JTextArea(3, 20);
        JTextArea clinicalSummary = new JTextArea(3, 20);
        JTextArea requestedInvestigations = new JTextArea(3, 20);
        JTextField status = new JTextField("Pending");
        JTextField appointmentId = new JTextField();
        JTextArea notes = new JTextArea(3, 20);
        JTextField createdDate = new JTextField(java.time.LocalDate.now().toString());
        JTextField lastUpdated = new JTextField(java.time.LocalDate.now().toString());

        JScrollPane reasonScroll = new JScrollPane(referralReason);
        JScrollPane summaryScroll = new JScrollPane(clinicalSummary);
        JScrollPane investigationsScroll = new JScrollPane(requestedInvestigations);
        JScrollPane notesScroll = new JScrollPane(notes);

        Object[] fields = {
            "Referral ID:", referralId,
            "Patient ID:", patientId,
            "Referring Clinician ID:", referringClinicianId,
            "Referred To Clinician ID:", referredToClinicianId,
            "Referring Facility ID:", referringFacilityId,
            "Referred To Facility ID:", referredToFacilityId,
            "Referral Date:", referralDate,
            "Urgency Level:", urgencyLevel,
            "Referral Reason:", reasonScroll,
            "Clinical Summary:", summaryScroll,
            "Requested Investigations:", investigationsScroll,
            "Status:", status,
            "Appointment ID:", appointmentId,
            "Notes:", notesScroll
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Add Referral", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            Referral r = new Referral(
                referralId.getText().trim(),
                patientId.getText().trim(),
                referringClinicianId.getText().trim(),
                referredToClinicianId.getText().trim(),
                referringFacilityId.getText().trim(),
                referredToFacilityId.getText().trim(),
                referralDate.getText().trim(),
                urgencyLevel.getText().trim(),
                referralReason.getText().trim(),
                clinicalSummary.getText().trim(),
                requestedInvestigations.getText().trim(),
                status.getText().trim(),
                appointmentId.getText().trim(),
                notes.getText().trim(),
                createdDate.getText().trim(),
                lastUpdated.getText().trim()
            );
            
            // Add to controller and singleton manager
            controller.addReferral(r);
            referralManager.addReferral(r);
            referralController.processReferral(r);
            
            loadReferrals();
            JOptionPane.showMessageDialog(this, "Referral added and email log generated!");
        }
    }

    private void editReferral() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row first.");
            return;
        }

        String idVal = (String) model.getValueAt(row, 0);
        
        Referral existing = controller.getReferrals().stream()
            .filter(r -> r.toString().startsWith(idVal + ","))
            .findFirst()
            .orElse(null);
            
        if (existing == null) {
            JOptionPane.showMessageDialog(this, "Referral not found.");
            return;
        }

        String[] data = existing.toString().split(",");
        
        JTextField referralId = new JTextField(data[0]);
        referralId.setEditable(false);
        JTextField patientId = new JTextField(data[1]);
        JTextField referringClinicianId = new JTextField(data[2]);
        JTextField referredToClinicianId = new JTextField(data[3]);
        JTextField referringFacilityId = new JTextField(data[4]);
        JTextField referredToFacilityId = new JTextField(data[5]);
        JTextField referralDate = new JTextField(data[6]);
        JTextField urgencyLevel = new JTextField(data[7]);
        JTextArea referralReason = new JTextArea(data[8], 3, 20);
        JTextArea clinicalSummary = new JTextArea(data[9], 3, 20);
        JTextArea requestedInvestigations = new JTextArea(data[10], 3, 20);
        JTextField status = new JTextField(data[11]);
        JTextField appointmentId = new JTextField(data[12]);
        JTextArea notes = new JTextArea(data[13], 3, 20);
        JTextField lastUpdated = new JTextField(java.time.LocalDate.now().toString());

        JScrollPane reasonScroll = new JScrollPane(referralReason);
        JScrollPane summaryScroll = new JScrollPane(clinicalSummary);
        JScrollPane investigationsScroll = new JScrollPane(requestedInvestigations);
        JScrollPane notesScroll = new JScrollPane(notes);

        Object[] fields = {
            "Referral ID:", referralId,
            "Patient ID:", patientId,
            "Referring Clinician ID:", referringClinicianId,
            "Referred To Clinician ID:", referredToClinicianId,
            "Referring Facility ID:", referringFacilityId,
            "Referred To Facility ID:", referredToFacilityId,
            "Referral Date:", referralDate,
            "Urgency Level:", urgencyLevel,
            "Referral Reason:", reasonScroll,
            "Clinical Summary:", summaryScroll,
            "Requested Investigations:", investigationsScroll,
            "Status:", status,
            "Appointment ID:", appointmentId,
            "Notes:", notesScroll
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Edit Referral", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            Referral updated = new Referral(
                referralId.getText().trim(),
                patientId.getText().trim(),
                referringClinicianId.getText().trim(),
                referredToClinicianId.getText().trim(),
                referringFacilityId.getText().trim(),
                referredToFacilityId.getText().trim(),
                referralDate.getText().trim(),
                urgencyLevel.getText().trim(),
                referralReason.getText().trim(),
                clinicalSummary.getText().trim(),
                requestedInvestigations.getText().trim(),
                status.getText().trim(),
                appointmentId.getText().trim(),
                notes.getText().trim(),
                data[14], // keep original createdDate
                lastUpdated.getText().trim()
            );
            controller.updateReferral(idVal, updated);
            loadReferrals();
        }
    }

    private void deleteReferral() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row first.");
            return;
        }

        String id = (String) model.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Delete referral ID " + id + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            controller.deleteReferral(id);
            loadReferrals();
        }
    }

    private void generateReferralDocument() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a referral first.");
            return;
        }

        String idVal = (String) model.getValueAt(row, 0);
        
        Referral referral = controller.getReferrals().stream()
            .filter(r -> r.toString().startsWith(idVal + ","))
            .findFirst()
            .orElse(null);
            
        if (referral != null) {
            referralManager.generateReferralTextFile(referral);
            JOptionPane.showMessageDialog(this, "Referral document generated: data/referral_" + idVal + ".txt");
        }
    }
}