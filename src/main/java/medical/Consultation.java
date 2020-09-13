package medical;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Consultation {
    SimpleIntegerProperty id;
    SimpleStringProperty historyOfTheIllness;
    SimpleStringProperty physicalActivity;
    SimpleStringProperty addictions;
    SimpleStringProperty diagnosis;
    SimpleStringProperty treatment;
    SimpleStringProperty reasons;
    SimpleStringProperty clinicalExamination;
    SimpleStringProperty resultsOfTest;
    SimpleStringProperty diet;
    SimpleStringProperty familyHistory;
    SimpleStringProperty surgicalHistory;
    SimpleStringProperty medicalHistory;
    SimpleStringProperty allergies;
    SimpleIntegerProperty doctorID;
    SimpleIntegerProperty patientID;

    SimpleObjectProperty <LocalDate> date;

    public Consultation(String historyOfTheIllness, String physicalActivity, String addictions, String diagnosis, String treatment,String reasons, String clinicalExamination, String resultsOfTest, String diet, LocalDate date , String familyHistory,
            String surgicalHistory,
             String medicalHistory,
             String allergies,Integer doctorID,Integer patientID) {


        this.id = new SimpleIntegerProperty();
        this.historyOfTheIllness = new SimpleStringProperty(historyOfTheIllness);
        this.physicalActivity = new SimpleStringProperty(physicalActivity);
        this.addictions = new SimpleStringProperty(addictions);
        this.diagnosis = new SimpleStringProperty( diagnosis);
        this.treatment = new SimpleStringProperty(treatment);
        this.reasons = new SimpleStringProperty(reasons);
        this.clinicalExamination = new SimpleStringProperty(clinicalExamination);
        this.resultsOfTest = new SimpleStringProperty(resultsOfTest);
        this.diet = new SimpleStringProperty(diet);
        this.date = new SimpleObjectProperty<LocalDate>(date);
        this.familyHistory = new SimpleStringProperty(familyHistory);
        this.surgicalHistory = new SimpleStringProperty(surgicalHistory);
        this.medicalHistory = new SimpleStringProperty(medicalHistory);
        this. allergies = new SimpleStringProperty(allergies);
        this.doctorID= new SimpleIntegerProperty(doctorID);
        this.patientID= new SimpleIntegerProperty(patientID);

    }
    public Consultation(String historyOfTheIllness, String physicalActivity, String addictions, String diagnosis, String treatment,String reasons, String clinicalExamination, String resultsOfTest, String diet, LocalDate date , String familyHistory,
                        String surgicalHistory,
                        String medicalHistory,
                        String allergies,Integer doctorID,Integer patientID,Integer consultationID) {


        this.id = new SimpleIntegerProperty(consultationID);
        this.historyOfTheIllness = new SimpleStringProperty(historyOfTheIllness);
        this.physicalActivity = new SimpleStringProperty(physicalActivity);
        this.addictions = new SimpleStringProperty(addictions);
        this.diagnosis = new SimpleStringProperty( diagnosis);
        this.treatment = new SimpleStringProperty(treatment);
        this.reasons = new SimpleStringProperty(reasons);
        this.clinicalExamination = new SimpleStringProperty(clinicalExamination);
        this.resultsOfTest = new SimpleStringProperty(resultsOfTest);
        this.diet = new SimpleStringProperty(diet);
        this.date = new SimpleObjectProperty<LocalDate>(date);
        this.familyHistory = new SimpleStringProperty(familyHistory);
        this.surgicalHistory = new SimpleStringProperty(surgicalHistory);
        this.medicalHistory = new SimpleStringProperty(medicalHistory);
        this. allergies = new SimpleStringProperty(allergies);
        this.doctorID= new SimpleIntegerProperty(doctorID);
        this.patientID= new SimpleIntegerProperty(patientID);

    }
    public int getDoctorID() {
        return doctorID.get();
    }

    public SimpleIntegerProperty doctorIDProperty() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID.set(doctorID);
    }

    public int getPatientID() {
        return patientID.get();
    }

    public SimpleIntegerProperty patientIDProperty() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID.set(patientID);
    }

    public String getFamilyHistory() {
        return familyHistory.get();
    }

    public SimpleStringProperty familyHistoryProperty() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory.set(familyHistory);
    }

    public String getSurgicalHistory() {
        return surgicalHistory.get();
    }

    public SimpleStringProperty surgicalHistoryProperty() {
        return surgicalHistory;
    }

    public void setSurgicalHistory(String surgicalHistory) {
        this.surgicalHistory.set(surgicalHistory);
    }

    public String getMedicalHistory() {
        return medicalHistory.get();
    }

    public SimpleStringProperty medicalHistoryProperty() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory.set(medicalHistory);
    }

    public String getAllergies() {
        return allergies.get();
    }

    public SimpleStringProperty allergiesProperty() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies.set(allergies);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getHistoryOfTheIllness() {
        return historyOfTheIllness.get();
    }

    public SimpleStringProperty historyOfTheIllnessProperty() {
        return historyOfTheIllness;
    }

    public void setHistoryOfTheIllness(String historyOfTheIllness) {
        this.historyOfTheIllness.set(historyOfTheIllness);
    }

    public String getPhysicalActivity() {
        return physicalActivity.get();
    }

    public SimpleStringProperty physicalActivityProperty() {
        return physicalActivity;
    }

    public void setPhysicalActivity(String physicalActivity) {
        this.physicalActivity.set(physicalActivity);
    }

    public String getAddictions() {
        return addictions.get();
    }

    public SimpleStringProperty addictionsProperty() {
        return addictions;
    }

    public void setAddictions(String addictions) {
        this.addictions.set(addictions);
    }

    public String getDiagnosis() {
        return diagnosis.get();
    }

    public SimpleStringProperty diagnosisProperty() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis.set(diagnosis);
    }

    public String getTreatment() {
        return treatment.get();
    }

    public SimpleStringProperty treatmentProperty() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment.set(treatment);
    }

    public String getReasons() {
        return reasons.get();
    }

    public SimpleStringProperty reasonsProperty() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons.set(reasons);
    }

    public String getClinicalExamination() {
        return clinicalExamination.get();
    }

    public SimpleStringProperty clinicalExaminationProperty() {
        return clinicalExamination;
    }

    public void setClinicalExamination(String clinicalExamination) {
        this.clinicalExamination.set(clinicalExamination);
    }

    public String getResultsOfTest() {
        return resultsOfTest.get();
    }

    public SimpleStringProperty resultsOfTestProperty() {
        return resultsOfTest;
    }

    public void setResultsOfTest(String resultsOfTest) {
        this.resultsOfTest.set(resultsOfTest);
    }

    public String getDiet() {
        return diet.get();
    }

    public SimpleStringProperty dietProperty() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet.set(diet);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }
}
