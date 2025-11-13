package healthcare.model;

public class Appointment {
    private String appointmentId;
    private String patientId;
    private String clinicianId;
    private String facilityId;
    private String appointmentDate;
    private String appointmentTime;
    private String durationMinutes;
    private String appointmentType;
    private String status;
    private String reasonForVisit;
    private String notes;
    private String createdDate;
    private String lastModified;

    public Appointment(String appointmentId, String patientId, String clinicianId, String facilityId,
                       String appointmentDate, String appointmentTime, String durationMinutes,
                       String appointmentType, String status, String reasonForVisit, String notes,
                       String createdDate, String lastModified) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.facilityId = facilityId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.durationMinutes = durationMinutes;
        this.appointmentType = appointmentType;
        this.status = status;
        this.reasonForVisit = reasonForVisit;
        this.notes = notes;
        this.createdDate = createdDate;
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return String.join(",", appointmentId, patientId, clinicianId, facilityId, appointmentDate,
                appointmentTime, durationMinutes, appointmentType, status, reasonForVisit, notes,
                createdDate, lastModified);
    }
}
