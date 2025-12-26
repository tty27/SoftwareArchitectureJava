package healthcare.view;

import javax.swing.*;
import healthcare.controller.DataController;
import healthcare.model.Appointment;

public class AppointmentPanel extends BasePanel<Appointment> {
    private DataController controller;

    public AppointmentPanel(DataController controller) {
        super(new String[]{"Appointment ID", "Patient ID", "Clinician ID", "Facility ID", "Date", "Time", "Status"});
        this.controller = controller;
        
        loadAppointmentsIntoTable();

        setAddAction(e -> addAppointment());
        setEditAction(e -> editAppointment());
        setDeleteAction(e -> deleteAppointment());
    }

    private void loadAppointmentsIntoTable() {
        model.setRowCount(0);
        for (Appointment a : controller.getAppointments()) {
            String[] data = a.toString().split(",");
            if (data.length >= 13) {
                model.addRow(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5], data[8]});
            }
        }
    }

    private void addAppointment() {
        JTextField appointmentId = new JTextField();
        JTextField patientId = new JTextField();
        JTextField clinicianId = new JTextField();
        JTextField facilityId = new JTextField();
        JTextField appointmentDate = new JTextField();
        JTextField appointmentTime = new JTextField();
        JTextField durationMinutes = new JTextField("30");
        JTextField appointmentType = new JTextField("Consultation");
        JTextField status = new JTextField("Scheduled");
        JTextField reasonForVisit = new JTextField();
        JTextField notes = new JTextField();
        JTextField createdDate = new JTextField(java.time.LocalDate.now().toString());
        JTextField lastModified = new JTextField(java.time.LocalDate.now().toString());

        Object[] fields = {
            "Appointment ID:", appointmentId, 
            "Patient ID:", patientId, 
            "Clinician ID:", clinicianId, 
            "Facility ID:", facilityId,
            "Date (YYYY-MM-DD):", appointmentDate, 
            "Time (HH:MM):", appointmentTime, 
            "Duration (minutes):", durationMinutes,
            "Appointment Type:", appointmentType,
            "Status:", status,
            "Reason for Visit:", reasonForVisit, 
            "Notes:", notes
        };

        if (JOptionPane.showConfirmDialog(this, fields, "Add Appointment", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            Appointment a = new Appointment(
                appointmentId.getText().trim(),
                patientId.getText().trim(),
                clinicianId.getText().trim(),
                facilityId.getText().trim(),
                appointmentDate.getText().trim(),
                appointmentTime.getText().trim(),
                durationMinutes.getText().trim(),
                appointmentType.getText().trim(),
                status.getText().trim(),
                reasonForVisit.getText().trim(),
                notes.getText().trim(),
                createdDate.getText().trim(),
                lastModified.getText().trim()
            );
            controller.addAppointment(a);
            model.addRow(new Object[]{
                appointmentId.getText().trim(),
                patientId.getText().trim(),
                clinicianId.getText().trim(),
                facilityId.getText().trim(),
                appointmentDate.getText().trim(),
                appointmentTime.getText().trim(),
                status.getText().trim()
            });
        }
    }

    private void editAppointment() {
        int row = getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row first.");
            return;
        }

        String idVal = (String) model.getValueAt(row, 0);
        
        // Find the full appointment object
        Appointment existing = controller.getAppointments().stream()
            .filter(a -> a.toString().startsWith(idVal + ","))
            .findFirst()
            .orElse(null);
            
        if (existing == null) {
            JOptionPane.showMessageDialog(this, "Appointment not found.");
            return;
        }

        String[] data = existing.toString().split(",");
        
        JTextField appointmentId = new JTextField(data[0]);
        appointmentId.setEditable(false);
        JTextField patientId = new JTextField(data[1]);
        JTextField clinicianId = new JTextField(data[2]);
        JTextField facilityId = new JTextField(data[3]);
        JTextField appointmentDate = new JTextField(data[4]);
        JTextField appointmentTime = new JTextField(data[5]);
        JTextField durationMinutes = new JTextField(data[6]);
        JTextField appointmentType = new JTextField(data[7]);
        JTextField status = new JTextField(data[8]);
        JTextField reasonForVisit = new JTextField(data[9]);
        JTextField notes = new JTextField(data[10]);
        JTextField lastModified = new JTextField(java.time.LocalDate.now().toString());

        Object[] fields = {
            "Appointment ID:", appointmentId, 
            "Patient ID:", patientId, 
            "Clinician ID:", clinicianId, 
            "Facility ID:", facilityId,
            "Date (YYYY-MM-DD):", appointmentDate, 
            "Time (HH:MM):", appointmentTime, 
            "Duration (minutes):", durationMinutes,
            "Appointment Type:", appointmentType,
            "Status:", status,
            "Reason for Visit:", reasonForVisit, 
            "Notes:", notes
        };

        if (JOptionPane.showConfirmDialog(this, fields, "Edit Appointment", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            model.setValueAt(patientId.getText().trim(), row, 1);
            model.setValueAt(clinicianId.getText().trim(), row, 2);
            model.setValueAt(facilityId.getText().trim(), row, 3);
            model.setValueAt(appointmentDate.getText().trim(), row, 4);
            model.setValueAt(appointmentTime.getText().trim(), row, 5);
            model.setValueAt(status.getText().trim(), row, 6);

            Appointment updated = new Appointment(
                appointmentId.getText().trim(),
                patientId.getText().trim(),
                clinicianId.getText().trim(),
                facilityId.getText().trim(),
                appointmentDate.getText().trim(),
                appointmentTime.getText().trim(),
                durationMinutes.getText().trim(),
                appointmentType.getText().trim(),
                status.getText().trim(),
                reasonForVisit.getText().trim(),
                notes.getText().trim(),
                data[11], // keep original createdDate
                lastModified.getText().trim()
            );
            controller.updateAppointment(idVal, updated);
        }
    }

    private void deleteAppointment() {
        int row = getSelectedRow();
        if (row >= 0) {
            String id = (String) model.getValueAt(row, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Delete appointment ID " + id + "?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                model.removeRow(row);
                controller.deleteAppointment(id);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a row first.");
        }
    }
}