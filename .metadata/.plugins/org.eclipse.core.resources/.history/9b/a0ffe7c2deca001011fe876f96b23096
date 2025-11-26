package healthcare.controller;

import java.io.*;
import java.util.*;
import healthcare.model.*;

public class DataController {
    private static final String DATA_PATH = "data/";

    private List<Patient> patients = new ArrayList<>();
    private List<Clinician> clinicians = new ArrayList<>();
    private List<Facility> facilities = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private List<Prescription> prescriptions = new ArrayList<>();
    private List<Referral> referrals = new ArrayList<>();
    private List<Staff> staffList = new ArrayList<>();

    public DataController() {
        loadAllData();
    }

    // ================= LOAD ALL DATA ==================
    public void loadAllData() {
        patients = loadPatients();
        clinicians = loadClinicians();
        facilities = loadFacilities();
        appointments = loadAppointments();
        prescriptions = loadPrescriptions();
        referrals = loadReferrals();
        staffList = loadStaff();
    }

    // ================= PATIENTS ==================
    private List<Patient> loadPatients() {
        List<Patient> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_PATH + "patients.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length >= 6)
                    list.add(new Patient(p[0], p[1], p[2], p[3], p[4], p[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void savePatients() {
        saveToFile(DATA_PATH + "patients.csv", patients);
    }

    public void addPatient(Patient p) {
        patients.add(p);
        savePatients();
    }

    public void updatePatient(String id, Patient updated) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId().equals(id)) {
                patients.set(i, updated);
                break;
            }
        }
        savePatients();
    }

    public void deletePatient(String id) {
        patients.removeIf(p -> p.getId().equals(id));
        savePatients();
    }

    // ================= CLINICIANS ==================
    private List<Clinician> loadClinicians() {
        List<Clinician> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_PATH + "clinicians.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] c = line.split(",");
                if (c.length >= 12)
                    list.add(new Clinician(c[0], c[1], c[2], c[3], c[4], c[5], 
                                          c[6], c[7], c[8], c[9], c[10], c[11]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveClinicians() {
        saveToFile(DATA_PATH + "clinicians.csv", clinicians);
    }

    public void addClinician(Clinician c) {
        clinicians.add(c);
        saveClinicians();
    }

    public void updateClinician(String id, Clinician updated) {
        for (int i = 0; i < clinicians.size(); i++) {
            if (clinicians.get(i).getClinicianId().equals(id)) {
                clinicians.set(i, updated);
                break;
            }
        }
        saveClinicians();
    }

    public void deleteClinician(String id) {
        clinicians.removeIf(c -> c.getClinicianId().equals(id));
        saveClinicians();
    }

    // ================= FACILITIES ==================
    private List<Facility> loadFacilities() {
        List<Facility> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_PATH + "facilities.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] f = line.split(",");
                if (f.length >= 11)
                    list.add(new Facility(f[0], f[1], f[2], f[3], f[4], f[5], 
                                         f[6], f[7], f[8], f[9], f[10]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveFacilities() {
        saveToFile(DATA_PATH + "facilities.csv", facilities);
    }

    public void addFacility(Facility f) {
        facilities.add(f);
        saveFacilities();
    }

    public void updateFacility(String id, Facility updated) {
        for (int i = 0; i < facilities.size(); i++) {
            if (facilities.get(i).getFacilityId().equals(id)) {
                facilities.set(i, updated);
                break;
            }
        }
        saveFacilities();
    }

    public void deleteFacility(String id) {
        facilities.removeIf(f -> f.getFacilityId().equals(id));
        saveFacilities();
    }

    // ================= APPOINTMENTS ==================
    private List<Appointment> loadAppointments() {
        List<Appointment> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_PATH + "appointments.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] a = line.split(",");
                if (a.length >= 13)
                    list.add(new Appointment(a[0], a[1], a[2], a[3], a[4], a[5], 
                                            a[6], a[7], a[8], a[9], a[10], a[11], a[12]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveAppointments() {
        saveToFile(DATA_PATH + "appointments.csv", appointments);
    }

    public void addAppointment(Appointment a) {
        appointments.add(a);
        saveAppointments();
    }

    public void updateAppointment(String id, Appointment updated) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).toString().startsWith(id + ",")) {
                appointments.set(i, updated);
                break;
            }
        }
        saveAppointments();
    }

    public void deleteAppointment(String id) {
        appointments.removeIf(a -> a.toString().startsWith(id + ","));
        saveAppointments();
    }

    // ================= PRESCRIPTIONS ==================
    private List<Prescription> loadPrescriptions() {
        List<Prescription> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_PATH + "prescriptions.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length >= 15)
                    list.add(new Prescription(p[0], p[1], p[2], p[3], p[4], p[5], 
                                             p[6], p[7], p[8], p[9], p[10], p[11], 
                                             p[12], p[13], p[14]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void savePrescriptions() {
        saveToFile(DATA_PATH + "prescriptions.csv", prescriptions);
    }

    public void addPrescription(Prescription p) {
        prescriptions.add(p);
        savePrescriptions();
    }

    public void updatePrescription(String id, Prescription updated) {
        for (int i = 0; i < prescriptions.size(); i++) {
            if (prescriptions.get(i).toString().startsWith(id + ",")) {
                prescriptions.set(i, updated);
                break;
            }
        }
        savePrescriptions();
    }

    public void deletePrescription(String id) {
        prescriptions.removeIf(p -> p.toString().startsWith(id + ","));
        savePrescriptions();
    }

    // ================= REFERRALS ==================
    private List<Referral> loadReferrals() {
        List<Referral> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_PATH + "referrals.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] r = line.split(",");
                if (r.length >= 16)
                    list.add(new Referral(r[0], r[1], r[2], r[3], r[4], r[5], 
                                         r[6], r[7], r[8], r[9], r[10], r[11], 
                                         r[12], r[13], r[14], r[15]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveReferrals() {
        saveToFile(DATA_PATH + "referrals.csv", referrals);
    }

    public void addReferral(Referral r) {
        referrals.add(r);
        saveReferrals();
    }

    public void updateReferral(String id, Referral updated) {
        for (int i = 0; i < referrals.size(); i++) {
            if (referrals.get(i).toString().startsWith(id + ",")) {
                referrals.set(i, updated);
                break;
            }
        }
        saveReferrals();
    }

    public void deleteReferral(String id) {
        referrals.removeIf(r -> r.toString().startsWith(id + ","));
        saveReferrals();
    }

    // ================= STAFF ==================
    private List<Staff> loadStaff() {
        List<Staff> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_PATH + "staff.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split(",");
                if (s.length >= 12)
                    list.add(new Staff(s[0], s[1], s[2], s[3], s[4], s[5], 
                                      s[6], s[7], s[8], s[9], s[10], s[11]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveStaff() {
        saveToFile(DATA_PATH + "staff.csv", staffList);
    }

    public void addStaff(Staff s) {
        staffList.add(s);
        saveStaff();
    }

    public void updateStaff(String id, Staff updated) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).toString().startsWith(id + ",")) {
                staffList.set(i, updated);
                break;
            }
        }
        saveStaff();
    }

    public void deleteStaff(String id) {
        staffList.removeIf(s -> s.toString().startsWith(id + ","));
        saveStaff();
    }

    // ================= GENERIC SAVE ==================
    private <T> void saveToFile(String fileName, List<T> list) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (T item : list)
                pw.println(item.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ================= GETTERS ==================
    public List<Patient> getPatients() { return patients; }
    public List<Clinician> getClinicians() { return clinicians; }
    public List<Facility> getFacilities() { return facilities; }
    public List<Appointment> getAppointments() { return appointments; }
    public List<Prescription> getPrescriptions() { return prescriptions; }
    public List<Referral> getReferrals() { return referrals; }
    public List<Staff> getStaff() { return staffList; }
}