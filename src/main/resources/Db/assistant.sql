create database medical;
use medical ;
CREATE TABLE doctor (
doctorID INT(11) AUTO_INCREMENT not null,
firstname VARCHAR(32) NOT NULL,
lastname VARCHAR(32) NOT NULL,
birthday date NOT NULL,
specialty VARCHAR(64) NOT NULL,
address VARCHAR(64) ,
emailorphone VARCHAR(64) ,
gender VARCHAR(10) ,
idofapproval VARCHAR(32) ,
pass VARCHAR(10) NOT NULL,
 PRIMARY KEY(doctorID));
 
CREATE TABLE patient (
patientID INT(11) AUTO_INCREMENT not null,
firstname VARCHAR(32) NOT NULL,
lastname VARCHAR(32) NOT NULL,
birthday date NOT NULL,
profession VARCHAR(32) ,
phone VARCHAR(64) ,
gender VARCHAR(10) ,
children INT,
pstatus VARCHAR(10) NOT NULL,
marritalStatus VARCHAR(32) ,
PRIMARY KEY(patientID));

CREATE TABLE Prescription (
prescriptionID INT(11) AUTO_INCREMENT not null,
dateofprescriptiondate  date not null,
doctorID INT,
patientID INT,
FOREIGN KEY (patientID) REFERENCES patient(patientID),
FOREIGN KEY (doctorID) REFERENCES doctor(doctorID),
PRIMARY KEY(prescriptionID));

CREATE TABLE Medicament (
dosage VARCHAR(32) ,
entityNumber int,
qsp VARCHAR(32) ,
nameMedicament VARCHAR(32) ,
prescriptionID INT,
FOREIGN KEY (prescriptionID) REFERENCES Prescription(prescriptionID));



CREATE TABLE document (
documentID INT(11) AUTO_INCREMENT not null,
dateofdocumentdate  date not null,
typeofdocument VARCHAR(32) NOT NULL,
patientID INT,
doctorID INT,
content text not null ,
FOREIGN KEY (patientID) REFERENCES patient(patientID),
FOREIGN KEY (doctorID) REFERENCES doctor(doctorID),
PRIMARY KEY(DocumentID));

CREATE TABLE consultation (
consultationID INT(11) AUTO_INCREMENT not null,
dateofconsultation date not null,
patientID INT,
doctorID INT,
historyOfTheIllness  text  ,
physicalActivity text,
addictions text,
diagnosis text ,
treatment text ,
reasons text ,
clinicalExamination text,
resultsOfTest text ,
diet text ,
familyHistory text ,
surgicalHistory text ,
medicalHistory text ,
allergies text ,
FOREIGN KEY (patientID) REFERENCES patient(patientID),
FOREIGN KEY (doctorID) REFERENCES doctor(doctorID),
PRIMARY KEY(consultationID));

CREATE TABLE checkup (
checkupID INT(11) AUTO_INCREMENT not null,
dateofcheckup  date not null,
patientID INT,
doctorID INT,
content text not null ,
FOREIGN KEY (patientID) REFERENCES patient(patientID),
FOREIGN KEY (doctorID) REFERENCES doctor(doctorID),
PRIMARY KEY(checkupID));

CREATE TABLE MedicamentName (
MedicamentNameID INT(11) AUTO_INCREMENT not null,
mediName  VARCHAR(32),
dosage VARCHAR(32) ,
PRIMARY KEY(checkupID));



