package healthcare.model;

public class Referral {
    private String referralId;
    private String patientId;
    private String referringClinicianId;
    private String referredToClinicianId;
    private String referringFacilityId;
    private String referredToFacilityId;
    private String referralDate;
    private String urgencyLevel;
    private String referralReason;
    private String clinicalSummary;
    private String requestedInvestigations;
    private String status;
    private String appointmentId;
    private String notes;
    private String createdDate;
    private String lastUpdated;

    public Referral(String referralId, String patientId, String referringClinicianId, String referredToClinicianId,
                    String referringFacilityId, String referredToFacilityId, String referralDate, String urgencyLevel,
                    String referralReason, String clinicalSummary, String requestedInvestigations, String status,
                    String appointmentId, String notes, String createdDate, String lastUpdated) {
        this.referralId = referralId;
        this.patientId = patientId;
        this.referringClinicianId = referringClinicianId;
        this.referredToClinicianId = referredToClinicianId;
        this.referringFacilityId = referringFacilityId;
        this.referredToFacilityId = referredToFacilityId;
        this.referralDate = referralDate;
        this.urgencyLevel = urgencyLevel;
        this.referralReason = referralReason;
        this.clinicalSummary = clinicalSummary;
        this.requestedInvestigations = requestedInvestigations;
        this.status = status;
        this.appointmentId = appointmentId;
        this.notes = notes;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return String.join(",", referralId, patientId, referringClinicianId, referredToClinicianId,
                referringFacilityId, referredToFacilityId, referralDate, urgencyLevel, referralReason,
                clinicalSummary, requestedInvestigations, status, appointmentId, notes, createdDate, lastUpdated);
    }
}
