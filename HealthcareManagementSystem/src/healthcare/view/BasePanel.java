package healthcare.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class BasePanel<T> extends JPanel {
    protected DefaultTableModel model;
    protected JTable table;
    protected JButton addButton, editButton, deleteButton;

    public BasePanel(String[] columns) {
        setLayout(new BorderLayout(10, 10));

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    protected void setAddAction(ActionListener listener) { addButton.addActionListener(listener); }
    protected void setEditAction(ActionListener listener) { editButton.addActionListener(listener); }
    protected void setDeleteAction(ActionListener listener) { deleteButton.addActionListener(listener); }

    protected int getSelectedRow() { return table.getSelectedRow(); }
    protected void removeRow(int row) { model.removeRow(row); }
}
