package healthcare.view;

import javax.swing.*;
import healthcare.controller.DataController;
import healthcare.singleton.PrescriptionManager;
import healthcare.model.Prescription;

public class PrescriptionPanel extends BasePanel<Prescription> {
    private DataController controller;
    private PrescriptionManager prescriptionManager;

    public PrescriptionPanel(DataController controller) {
        super(new String[]{"Prescription ID", "Patient ID", "Clinician ID", "Medication", "Dosage", "Frequency", "Status"});
        this.controller = controller;
        this.prescriptionManager = PrescriptionManager.getInstance(); // Singleton
        
        loadPrescriptionsIntoTable();

        setAddAction(e -> addPrescription());
        setEditAction(e -> editPrescription());
        setDeleteAction(e -> deletePrescription());
        
        // Add custom button for generating prescription document
        JButton generateBtn = new JButton("Generate Prescription Document");
        generateBtn.addActionListener(e -> generatePrescriptionDocument());
        buttonPanel.add(generateBtn);
    }

    private void loadPrescriptionsIntoTable() {
        model.setRowCount(0);
        for (Prescription p : controller.getPrescriptions()) {
            String[] data = p.toString().split(",");
            if (data.length >= 15) {
                model.addRow(new Object[]{data[0], data[1], data[2], data[5], data[6], data[7], data[12]});
            }
        }
    }

    private void addPrescription() {
        JTextField prescriptionId = new JTextField();
        JTextField patientId = new JTextField();
        JTextField clinicianId = new JTextField();
        JTextField appointmentId = new JTextField();
        JTextField prescriptionDate = new JTextField(java.time.LocalDate.now().toString());
        JTextField medicationName = new JTextField();
        JTextField dosage = new JTextField();
        JTextField frequency = new JTextField();
        JTextField durationDays = new JTextField("7");
        JTextField quantity = new JTextField();
        JTextField instructions = new JTextField();
        JTextField pharmacyName = new JTextField();
        JTextField status = new JTextField("Issued");
        JTextField issueDate = new JTextField(java.time.LocalDate.now().toString());
        JTextField collectionDate = new JTextField();

        Object[] fields = {
            "Prescription ID:", prescriptionId,
            "Patient ID:", patientId,
            "Clinician ID:", clinicianId,
            "Appointment ID:", appointmentId,
            "Prescription Date:", prescriptionDate,
            "Medication Name:", medicationName,
            "Dosage:", dosage,
            "Frequency:", frequency,
            "Duration (days):", durationDays,
            "Quantity:", quantity,
            "Instructions:", instructions,
            "Pharmacy Name:", pharmacyName,
            "Status:", status
        };

        if (JOptionPane.showConfirmDialog(this, fields, "Add Prescription", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            Prescription p = new Prescription(
                prescriptionId.getText().trim(),
                patientId.getText().trim(),
                clinicianId.getText().trim(),
                appointmentId.getText().trim(),
                prescriptionDate.getText().trim(),
                medicationName.getText().trim(),
                dosage.getText().trim(),
                frequency.getText().trim(),
                durationDays.getText().trim(),
                quantity.getText().trim(),
                instructions.getText().trim(),
                pharmacyName.getText().trim(),
                status.getText().trim(),
                issueDate.getText().trim(),
                collectionDate.getText().trim()
            );
            controller.addPrescription(p);
            model.addRow(new Object[]{
                prescriptionId.getText().trim(),
                patientId.getText().trim(),
                clinicianId.getText().trim(),
                medicationName.getText().trim(),
                dosage.getText().trim(),
                frequency.getText().trim(),
                status.getText().trim()
            });
        }
    }

    private void editPrescription() {
        int row = getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row first.");
            return;
        }

        String idVal = (String) model.getValueAt(row, 0);
        
        // Find the full prescription object
        Prescription existing = controller.getPrescriptions().stream()
            .filter(p -> p.toString().startsWith(idVal + ","))
            .findFirst()
            .orElse(null);
            
        if (existing == null) {
            JOptionPane.showMessageDialog(this, "Prescription not found.");
            return;
        }

        String[] data = existing.toString().split(",");
        
        JTextField prescriptionId = new JTextField(data[0]);
        prescriptionId.setEditable(false);
        JTextField patientId = new JTextField(data[1]);
        JTextField clinicianId = new JTextField(data[2]);
        JTextField appointmentId = new JTextField(data[3]);
        JTextField prescriptionDate = new JTextField(data[4]);
        JTextField medicationName = new JTextField(data[5]);
        JTextField dosage = new JTextField(data[6]);
        JTextField frequency = new JTextField(data[7]);
        JTextField durationDays = new JTextField(data[8]);
        JTextField quantity = new JTextField(data[9]);
        JTextField instructions = new JTextField(data[10]);
        JTextField pharmacyName = new JTextField(data[11]);
        JTextField status = new JTextField(data[12]);
        JTextField collectionDate = new JTextField(data.length > 14 ? data[14] : "");

        Object[] fields = {
            "Prescription ID:", prescriptionId,
            "Patient ID:", patientId,
            "Clinician ID:", clinicianId,
            "Appointment ID:", appointmentId,
            "Prescription Date:", prescriptionDate,
            "Medication Name:", medicationName,
            "Dosage:", dosage,
            "Frequency:", frequency,
            "Duration (days):", durationDays,
            "Quantity:", quantity,
            "Instructions:", instructions,
            "Pharmacy Name:", pharmacyName,
            "Status:", status,
            "Collection Date:", collectionDate
        };

        if (JOptionPane.showConfirmDialog(this, fields, "Edit Prescription", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            model.setValueAt(patientId.getText().trim(), row, 1);
            model.setValueAt(clinicianId.getText().trim(), row, 2);
            model.setValueAt(medicationName.getText().trim(), row, 3);
            model.setValueAt(dosage.getText().trim(), row, 4);
            model.setValueAt(frequency.getText().trim(), row, 5);
            model.setValueAt(status.getText().trim(), row, 6);

            Prescription updated = new Prescription(
                prescriptionId.getText().trim(),
                patientId.getText().trim(),
                clinicianId.getText().trim(),
                appointmentId.getText().trim(),
                prescriptionDate.getText().trim(),
                medicationName.getText().trim(),
                dosage.getText().trim(),
                frequency.getText().trim(),
                durationDays.getText().trim(),
                quantity.getText().trim(),
                instructions.getText().trim(),
                pharmacyName.getText().trim(),
                status.getText().trim(),
                data[13], // keep original issue date
                collectionDate.getText().trim()
            );
            controller.updatePrescription(idVal, updated);
        }
    }

    private void deletePrescription() {
        int row = getSelectedRow();
        if (row >= 0) {
            String id = (String) model.getValueAt(row, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Delete prescription ID " + id + "?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                model.removeRow(row);
                controller.deletePrescription(id);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a row first.");
        }
    }
    
    private void generatePrescriptionDocument() {
        int row = getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a prescription first.");
            return;
        }

        String idVal = (String) model.getValueAt(row, 0);
        
        Prescription prescription = controller.getPrescriptions().stream()
            .filter(p -> p.toString().startsWith(idVal + ","))
            .findFirst()
            .orElse(null);
            
        if (prescription != null) {
            prescriptionManager.generatePrescriptionTextFile(prescription);
            JOptionPane.showMessageDialog(this, "Prescription document generated: data/prescription_" + idVal + ".txt");
        }
    }
}