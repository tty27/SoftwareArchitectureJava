package healthcare.view;

import javax.swing.*;
import healthcare.controller.DataController;
import healthcare.model.Clinician;

public class ClinicianPanel extends BasePanel<Clinician> {
    private DataController controller;

    public ClinicianPanel(DataController controller) {
        super(new String[]{"ID", "First Name", "Last Name", "Title", "Speciality", "GMC", "Phone", "Email"});
        this.controller = controller;
        
        loadCliniciansIntoTable();

        setAddAction(e -> addClinician());
        setEditAction(e -> editClinician());
        setDeleteAction(e -> deleteClinician());
    }

    private void loadCliniciansIntoTable() {
        model.setRowCount(0);
        for (Clinician c : controller.getClinicians()) {
            model.addRow(new Object[]{
                c.getClinicianId(), c.getFirstName(), c.getLastName(), c.getTitle(), 
                c.getSpeciality(), c.getGmcNumber(), c.getPhoneNumber(), c.getEmail()
            });
        }
    }

    private void addClinician() {
        JTextField id = new JTextField();
        JTextField firstName = new JTextField();
        JTextField lastName = new JTextField();
        JTextField title = new JTextField();
        JTextField speciality = new JTextField();
        JTextField gmc = new JTextField();
        JTextField phone = new JTextField();
        JTextField email = new JTextField();
        JTextField workplaceId = new JTextField();
        JTextField workplaceType = new JTextField();
        JTextField employmentStatus = new JTextField();
        JTextField startDate = new JTextField();

        Object[] fields = {
            "Clinician ID:", id, 
            "First Name:", firstName, 
            "Last Name:", lastName, 
            "Title:", title,
            "Speciality:", speciality, 
            "GMC Number:", gmc, 
            "Phone:", phone, 
            "Email:", email,
            "Workplace ID:", workplaceId,
            "Workplace Type:", workplaceType,
            "Employment Status:", employmentStatus,
            "Start Date:", startDate
        };

        if (JOptionPane.showConfirmDialog(this, fields, "Add Clinician", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            Clinician c = new Clinician(
                id.getText().trim(), 
                firstName.getText().trim(), 
                lastName.getText().trim(), 
                title.getText().trim(),
                speciality.getText().trim(), 
                gmc.getText().trim(), 
                phone.getText().trim(), 
                email.getText().trim(),
                workplaceId.getText().trim(),
                workplaceType.getText().trim(),
                employmentStatus.getText().trim(),
                startDate.getText().trim()
            );
            controller.addClinician(c);
            model.addRow(new Object[]{
                c.getClinicianId(), c.getFirstName(), c.getLastName(), c.getTitle(), 
                c.getSpeciality(), c.getGmcNumber(), c.getPhoneNumber(), c.getEmail()
            });
        }
    }

    private void editClinician() {
        int row = getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row first.");
            return;
        }

        String idVal = (String) model.getValueAt(row, 0);
        
        // Find the full clinician object
        Clinician existing = controller.getClinicians().stream()
            .filter(c -> c.getClinicianId().equals(idVal))
            .findFirst()
            .orElse(null);
            
        if (existing == null) {
            JOptionPane.showMessageDialog(this, "Clinician not found.");
            return;
        }

        JTextField id = new JTextField(existing.getClinicianId());
        id.setEditable(false);
        JTextField firstName = new JTextField(existing.getFirstName());
        JTextField lastName = new JTextField(existing.getLastName());
        JTextField title = new JTextField(existing.getTitle());
        JTextField speciality = new JTextField(existing.getSpeciality());
        JTextField gmc = new JTextField(existing.getGmcNumber());
        JTextField phone = new JTextField(existing.getPhoneNumber());
        JTextField email = new JTextField(existing.getEmail());
        JTextField workplaceId = new JTextField(existing.getWorkplaceId());
        JTextField workplaceType = new JTextField(existing.getWorkplaceType());
        JTextField employmentStatus = new JTextField(existing.getEmploymentStatus());
        JTextField startDate = new JTextField(existing.getStartDate());

        Object[] fields = {
            "Clinician ID:", id, 
            "First Name:", firstName, 
            "Last Name:", lastName, 
            "Title:", title,
            "Speciality:", speciality, 
            "GMC Number:", gmc, 
            "Phone:", phone, 
            "Email:", email,
            "Workplace ID:", workplaceId,
            "Workplace Type:", workplaceType,
            "Employment Status:", employmentStatus,
            "Start Date:", startDate
        };

        if (JOptionPane.showConfirmDialog(this, fields, "Edit Clinician", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            model.setValueAt(firstName.getText().trim(), row, 1);
            model.setValueAt(lastName.getText().trim(), row, 2);
            model.setValueAt(title.getText().trim(), row, 3);
            model.setValueAt(speciality.getText().trim(), row, 4);
            model.setValueAt(gmc.getText().trim(), row, 5);
            model.setValueAt(phone.getText().trim(), row, 6);
            model.setValueAt(email.getText().trim(), row, 7);

            Clinician updated = new Clinician(
                id.getText().trim(), 
                firstName.getText().trim(), 
                lastName.getText().trim(), 
                title.getText().trim(),
                speciality.getText().trim(), 
                gmc.getText().trim(), 
                phone.getText().trim(), 
                email.getText().trim(),
                workplaceId.getText().trim(),
                workplaceType.getText().trim(),
                employmentStatus.getText().trim(),
                startDate.getText().trim()
            );
            controller.updateClinician(idVal, updated);
        }
    }

    private void deleteClinician() {
        int row = getSelectedRow();
        if (row >= 0) {
            String id = (String) model.getValueAt(row, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Delete clinician ID " + id + "?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                model.removeRow(row);
                controller.deleteClinician(id);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a row first.");
        }
    }
}