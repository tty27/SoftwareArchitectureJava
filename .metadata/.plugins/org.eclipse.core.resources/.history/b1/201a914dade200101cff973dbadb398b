package healthcare.singleton;

import healthcare.model.Referral;
import java.util.*;
import java.io.*;

public class ReferralManager {
    private static ReferralManager instance;
    private List<Referral> referrals;
    
    private ReferralManager() {
        referrals = new ArrayList<>();
    }
    
    public static ReferralManager getInstance() {
        if (instance == null) {
            instance = new ReferralManager();
        }
        return instance;
    }
    
    public void addReferral(Referral r) {
        referrals.add(r);
    }
    
    public List<Referral> getReferrals() {
        return referrals;
    }
    
    public void generateReferralTextFile(Referral r) {
        try {
            // Parse the referral data from toString()
            String[] data = r.toString().split(",");
            String referralId = data[0];
            String patientId = data[1];
            String referringClinicianId = data[2];
            String referredToClinicianId = data[3];
            String referringFacilityId = data[4];
            String referredToFacilityId = data[5];
            String referralDate = data[6];
            String urgencyLevel = data[7];
            String referralReason = data[8];
            String clinicalSummary = data[9];
            String requestedInvestigations = data[10];
            String status = data[11];
            
            FileWriter writer = new FileWriter("data/referral_" + referralId + ".txt");
            writer.write("========================================\n");
            writer.write("         NHS REFERRAL DOCUMENT          \n");
            writer.write("========================================\n\n");
            writer.write("Referral ID: " + referralId + "\n");
            writer.write("Referral Date: " + referralDate + "\n");
            writer.write("Status: " + status + "\n");
            writer.write("Urgency Level: " + urgencyLevel + "\n\n");
            
            writer.write("--- PATIENT INFORMATION ---\n");
            writer.write("Patient ID: " + patientId + "\n\n");
            
            writer.write("--- REFERRING INFORMATION ---\n");
            writer.write("Referring Clinician ID: " + referringClinicianId + "\n");
            writer.write("Referring Facility ID: " + referringFacilityId + "\n\n");
            
            writer.write("--- REFERRAL DESTINATION ---\n");
            writer.write("Referred To Clinician ID: " + referredToClinicianId + "\n");
            writer.write("Referred To Facility ID: " + referredToFacilityId + "\n\n");
            
            writer.write("--- CLINICAL DETAILS ---\n");
            writer.write("Reason for Referral:\n" + referralReason + "\n\n");
            writer.write("Clinical Summary:\n" + clinicalSummary + "\n\n");
            writer.write("Requested Investigations:\n" + requestedInvestigations + "\n\n");
            
            writer.write("========================================\n");
            writer.write("End of Referral Document\n");
            writer.write("========================================\n");
            
            writer.close();
            System.out.println("Referral text file generated: data/referral_" + referralId + ".txt");
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error parsing referral data: " + e.getMessage());
        }
    }
}