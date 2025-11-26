package healthcare.controller;

import java.io.FileWriter;
import java.io.IOException;
import healthcare.model.Referral;

public class ReferralController {
    private static ReferralController instance;
    private static final String EMAIL_LOG_FILE = "data/referral_emails.txt";
    
    private ReferralController() {}
    
    public static ReferralController getInstance() {
        if (instance == null)
            instance = new ReferralController();
        return instance;
    }
    
    public void processReferral(Referral referral) {
        // Simulate email + log output
        try (FileWriter fw = new FileWriter(EMAIL_LOG_FILE, true)) {
            fw.write("=== REFERRAL SENT ===\n");
            fw.write("Referral ID: " + referral.toString().split(",")[0] + "\n");
            fw.write("Patient ID: " + referral.toString().split(",")[1] + "\n");
            fw.write("Referring Clinician ID: " + referral.toString().split(",")[2] + "\n");
            fw.write("Referred To Clinician ID: " + referral.toString().split(",")[3] + "\n");
            fw.write("Referral Reason: " + referral.toString().split(",")[8] + "\n");
            fw.write("Urgency Level: " + referral.toString().split(",")[7] + "\n");
            fw.write("Clinical Summary: " + referral.toString().split(",")[9] + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}