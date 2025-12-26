package healthcare.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import healthcare.controller.DataController;
import healthcare.model.Facility;
import java.awt.*;

public class FacilityPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private DataController controller;

    public FacilityPanel(DataController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());
        
        model = new DefaultTableModel(new String[]{
            "Facility ID", "Name", "Type", "Address", "Postcode", "Phone", "Email", "Manager", "Capacity"
        }, 0);
        table = new JTable(model);
        
        loadFacilities();

        JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton("Add Facility");
        JButton editBtn = new JButton("Edit");
        JButton deleteBtn = new JButton("Delete");

        addBtn.addActionListener(e -> addFacility());
        editBtn.addActionListener(e -> editFacility());
        deleteBtn.addActionListener(e -> deleteFacility());

        buttonPanel.add(addBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadFacilities() {
        model.setRowCount(0);
        for (Facility f : controller.getFacilities()) {
            model.addRow(new Object[]{
                f.getFacilityId(), 
                f.getFacilityName(), 
                f.getFacilityType(), 
                f.getAddress(), 
                f.getPostcode(), 
                f.getPhoneNumber(), 
                f.getEmail(), 
                f.getManagerName(), 
                f.getCapacity()
            });
        }
    }

    private void addFacility() {
        JTextField facilityId = new JTextField();
        JTextField facilityName = new JTextField();
        JTextField facilityType = new JTextField();
        JTextField address = new JTextField();
        JTextField postcode = new JTextField();
        JTextField phoneNumber = new JTextField();
        JTextField email = new JTextField();
        JTextField openingHours = new JTextField();
        JTextField managerName = new JTextField();
        JTextField capacity = new JTextField();
        JTextField specialitiesOffered = new JTextField();

        Object[] fields = {
            "Facility ID:", facilityId, 
            "Facility Name:", facilityName, 
            "Facility Type:", facilityType,
            "Address:", address, 
            "Postcode:", postcode, 
            "Phone Number:", phoneNumber, 
            "Email:", email,
            "Opening Hours:", openingHours, 
            "Manager Name:", managerName, 
            "Capacity:", capacity,
            "Specialities Offered:", specialitiesOffered
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Add Facility", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            Facility f = new Facility(
                facilityId.getText().trim(), 
                facilityName.getText().trim(), 
                facilityType.getText().trim(),
                address.getText().trim(), 
                postcode.getText().trim(), 
                phoneNumber.getText().trim(), 
                email.getText().trim(),
                openingHours.getText().trim(), 
                managerName.getText().trim(), 
                capacity.getText().trim(),
                specialitiesOffered.getText().trim()
            );
            controller.addFacility(f);
            loadFacilities();
        }
    }

    private void editFacility() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row first.");
            return;
        }

        String idVal = (String) model.getValueAt(row, 0);
        
        // Find the full facility object
        Facility existing = controller.getFacilities().stream()
            .filter(f -> f.getFacilityId().equals(idVal))
            .findFirst()
            .orElse(null);
            
        if (existing == null) {
            JOptionPane.showMessageDialog(this, "Facility not found.");
            return;
        }

        JTextField facilityId = new JTextField(existing.getFacilityId());
        facilityId.setEditable(false);
        JTextField facilityName = new JTextField(existing.getFacilityName());
        JTextField facilityType = new JTextField(existing.getFacilityType());
        JTextField address = new JTextField(existing.getAddress());
        JTextField postcode = new JTextField(existing.getPostcode());
        JTextField phoneNumber = new JTextField(existing.getPhoneNumber());
        JTextField email = new JTextField(existing.getEmail());
        JTextField openingHours = new JTextField(existing.getOpeningHours());
        JTextField managerName = new JTextField(existing.getManagerName());
        JTextField capacity = new JTextField(existing.getCapacity());
        JTextField specialitiesOffered = new JTextField(existing.getSpecialitiesOffered());

        Object[] fields = {
            "Facility ID:", facilityId, 
            "Facility Name:", facilityName, 
            "Facility Type:", facilityType,
            "Address:", address, 
            "Postcode:", postcode, 
            "Phone Number:", phoneNumber, 
            "Email:", email,
            "Opening Hours:", openingHours, 
            "Manager Name:", managerName, 
            "Capacity:", capacity,
            "Specialities Offered:", specialitiesOffered
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Edit Facility", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            Facility updated = new Facility(
                facilityId.getText().trim(), 
                facilityName.getText().trim(), 
                facilityType.getText().trim(),
                address.getText().trim(), 
                postcode.getText().trim(), 
                phoneNumber.getText().trim(), 
                email.getText().trim(),
                openingHours.getText().trim(), 
                managerName.getText().trim(), 
                capacity.getText().trim(),
                specialitiesOffered.getText().trim()
            );
            controller.updateFacility(idVal, updated);
            loadFacilities();
        }
    }

    private void deleteFacility() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row first.");
            return;
        }

        String id = (String) model.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Delete facility ID " + id + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            controller.deleteFacility(id);
            loadFacilities();
        }
    }
}