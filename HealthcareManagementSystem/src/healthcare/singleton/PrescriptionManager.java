package healthcare.singleton;

import healthcare.model.Prescription;
import java.io.*;

public class PrescriptionManager {
    private static PrescriptionManager instance;
    
    private PrescriptionManager() {}
    
    public static PrescriptionManager getInstance() {
        if (instance == null) {
            instance = new PrescriptionManager();
        }
        return instance;
    }
    
    public void generatePrescriptionTextFile(Prescription p) {
        try {
            // Parse the prescription data from toString()
            String[] data = p.toString().split(",");
            String prescriptionId = data[0];
            String patientId = data[1];
            String clinicianId = data[2];
            String appointmentId = data[3];
            String prescriptionDate = data[4];
            String medicationName = data[5];
            String dosage = data[6];
            String frequency = data[7];
            String durationDays = data[8];
            String quantity = data[9];
            String instructions = data[10];
            String pharmacyName = data[11];
            String status = data[12];
            String issueDate = data[13];
            String collectionDate = data[14];
            
            FileWriter writer = new FileWriter("data/prescription_" + prescriptionId + ".txt");
            writer.write("========================================\n");
            writer.write("         NHS PRESCRIPTION               \n");
            writer.write("========================================\n\n");
            writer.write("Prescription ID: " + prescriptionId + "\n");
            writer.write("Issue Date: " + issueDate + "\n");
            writer.write("Prescription Date: " + prescriptionDate + "\n");
            writer.write("Status: " + status + "\n\n");
            
            writer.write("--- PATIENT INFORMATION ---\n");
            writer.write("Patient ID: " + patientId + "\n\n");
            
            writer.write("--- PRESCRIBER INFORMATION ---\n");
            writer.write("Clinician ID: " + clinicianId + "\n");
            writer.write("Appointment ID: " + appointmentId + "\n\n");
            
            writer.write("--- MEDICATION DETAILS ---\n");
            writer.write("Medication Name: " + medicationName + "\n");
            writer.write("Dosage: " + dosage + "\n");
            writer.write("Frequency: " + frequency + "\n");
            writer.write("Duration: " + durationDays + " days\n");
            writer.write("Quantity: " + quantity + "\n\n");
            
            writer.write("--- INSTRUCTIONS ---\n");
            writer.write(instructions + "\n\n");
            
            writer.write("--- PHARMACY INFORMATION ---\n");
            writer.write("Pharmacy Name: " + pharmacyName + "\n");
            writer.write("Collection Date: " + collectionDate + "\n\n");
            
            writer.write("========================================\n");
            writer.write("End of Prescription\n");
            writer.write("========================================\n");
            
            writer.close();
            System.out.println("Prescription text file generated: data/prescription_" + prescriptionId + ".txt");
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error parsing prescription data: " + e.getMessage());
        }
    }
}