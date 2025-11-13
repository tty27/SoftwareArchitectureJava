package healthcare.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import healthcare.controller.DataController;
import healthcare.model.Staff;
import java.awt.*;

public class StaffPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private DataController controller;

    public StaffPanel(DataController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());
        
        model = new DefaultTableModel(new String[]{
            "Staff ID", "First Name", "Last Name", "Role", "Department", "Phone", "Email"
        }, 0);
        table = new JTable(model);
        
        loadStaff();

        JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton("Add Staff");
        JButton editBtn = new JButton("Edit");
        JButton deleteBtn = new JButton("Delete");

        addBtn.addActionListener(e -> addStaff());
        editBtn.addActionListener(e -> editStaff());
        deleteBtn.addActionListener(e -> deleteStaff());

        buttonPanel.add(addBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadStaff() {
        model.setRowCount(0);
        for (Staff s : controller.getStaff()) {
            String[] data = s.toString().split(",");
            if (data.length >= 12) {
                model.addRow(new Object[]{data[0], data[1], data[2], data[3], data[4], data[6], data[7]});
            }
        }
    }

    private void addStaff() {
        JTextField staffId = new JTextField();
        JTextField firstName = new JTextField();
        JTextField lastName = new JTextField();
        JTextField role = new JTextField();
        JTextField department = new JTextField();
        JTextField facilityId = new JTextField();
        JTextField phoneNumber = new JTextField();
        JTextField email = new JTextField();
        JTextField employmentStatus = new JTextField();
        JTextField startDate = new JTextField();
        JTextField lineManager = new JTextField();
        JTextField accessLevel = new JTextField();

        Object[] fields = {
            "Staff ID:", staffId, 
            "First Name:", firstName, 
            "Last Name:", lastName, 
            "Role:", role,
            "Department:", department, 
            "Facility ID:", facilityId, 
            "Phone Number:", phoneNumber, 
            "Email:", email,
            "Employment Status:", employmentStatus, 
            "Start Date:", startDate, 
            "Line Manager:", lineManager,
            "Access Level:", accessLevel
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Add Staff", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            Staff s = new Staff(
                staffId.getText().trim(), 
                firstName.getText().trim(), 
                lastName.getText().trim(), 
                role.getText().trim(),
                department.getText().trim(), 
                facilityId.getText().trim(), 
                phoneNumber.getText().trim(), 
                email.getText().trim(),
                employmentStatus.getText().trim(), 
                startDate.getText().trim(), 
                lineManager.getText().trim(),
                accessLevel.getText().trim()
            );
            controller.addStaff(s);
            loadStaff();
        }
    }

    private void editStaff() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row first.");
            return;
        }

        String idVal = (String) model.getValueAt(row, 0);
        
        // Find the full staff object
        Staff existing = controller.getStaff().stream()
            .filter(s -> s.toString().startsWith(idVal + ","))
            .findFirst()
            .orElse(null);
            
        if (existing == null) {
            JOptionPane.showMessageDialog(this, "Staff member not found.");
            return;
        }

        String[] data = existing.toString().split(",");
        
        JTextField staffId = new JTextField(data[0]);
        staffId.setEditable(false);
        JTextField firstName = new JTextField(data[1]);
        JTextField lastName = new JTextField(data[2]);
        JTextField role = new JTextField(data[3]);
        JTextField department = new JTextField(data[4]);
        JTextField facilityId = new JTextField(data[5]);
        JTextField phoneNumber = new JTextField(data[6]);
        JTextField email = new JTextField(data[7]);
        JTextField employmentStatus = new JTextField(data[8]);
        JTextField startDate = new JTextField(data[9]);
        JTextField lineManager = new JTextField(data[10]);
        JTextField accessLevel = new JTextField(data[11]);

        Object[] fields = {
            "Staff ID:", staffId, 
            "First Name:", firstName, 
            "Last Name:", lastName, 
            "Role:", role,
            "Department:", department, 
            "Facility ID:", facilityId, 
            "Phone Number:", phoneNumber, 
            "Email:", email,
            "Employment Status:", employmentStatus, 
            "Start Date:", startDate, 
            "Line Manager:", lineManager,
            "Access Level:", accessLevel
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Edit Staff", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            model.setValueAt(firstName.getText().trim(), row, 1);
            model.setValueAt(lastName.getText().trim(), row, 2);
            model.setValueAt(role.getText().trim(), row, 3);
            model.setValueAt(department.getText().trim(), row, 4);
            model.setValueAt(phoneNumber.getText().trim(), row, 5);
            model.setValueAt(email.getText().trim(), row, 6);

            Staff updated = new Staff(
                staffId.getText().trim(), 
                firstName.getText().trim(), 
                lastName.getText().trim(), 
                role.getText().trim(),
                department.getText().trim(), 
                facilityId.getText().trim(), 
                phoneNumber.getText().trim(), 
                email.getText().trim(),
                employmentStatus.getText().trim(), 
                startDate.getText().trim(), 
                lineManager.getText().trim(),
                accessLevel.getText().trim()
            );
            controller.updateStaff(idVal, updated);
            loadStaff();
        }
    }

    private void deleteStaff() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row first.");
            return;
        }

        String id = (String) model.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Delete staff ID " + id + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            controller.deleteStaff(id);
            loadStaff();
        }
    }
}