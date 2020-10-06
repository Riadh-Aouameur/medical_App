package medical.DataBase;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import medical.*;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Riadh
 */
public class Db {
    private Connection con ;
    private Statement st ;
    private ResultSet rs ;
    public Db (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3305/medical?autoReconnect=true&&useSSL=false","root","1234");
            st = con.createStatement();

        }catch(Exception ex){
            System.out.println("Errer : " + ex);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText("");
            alert.setContentText("Database Connection Time Out");
            alert.setTitle("Connection Error");
            alert.showAndWait();

        }




    }

    public boolean memberLogin(MemberLogin memberLogin) {
        PreparedStatement ps;
        ResultSet rs;
        Boolean r =false;
        String query = "SELECT * FROM `doctor` WHERE `firstname` =? AND `lastname`=? AND `pass` =?";

        try {
            ps = con.prepareStatement(query);
            System.out.println(memberLogin.getFirstName());
            System.out.println(memberLogin.getPassword());
            System.out.println(memberLogin.getLastName());


            ps.setString(1, memberLogin.getFirstName());
            ps.setString(2, memberLogin.getLastName());
            ps.setString(3, memberLogin.getPassword());

            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getInt(1));
                memberLogin.setDoctorID(rs.getInt(1));
                r=true;
            } else {
                System.out.println("er");
               r=false;
            }

        } catch (SQLException ex) {

        }

        return r;
    }

    public ObservableList <Patient>getPatientData(){

        ObservableList <Patient>observableList = FXCollections.observableArrayList();
        try {
            System.out.println("records from Db");
            String query = "SELECT * FROM patient";
            rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("patientID");
               Integer children = rs.getInt("children");
               String lastName= rs.getString("lastname");
               String firstName = rs.getString("firstname") ;
               String birthday= rs.getString("birthday");
               String gender= rs.getString("gender");
               String profession= rs.getString("Profession") ;
               String phone = rs.getString("phone");
               String marritalStatus = rs.getString("MarritalStatus");
               String status = rs.getString("pstatus");
               Patient patient = new Patient(id,lastName,firstName,children,LocalDate.parse(birthday),gender,profession,phone,marritalStatus,status);
               observableList.add(patient);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

            return  observableList ;



    }
    public Patient getPatient(int id){
        Patient patient = null;

        try {
            System.out.println("records from Db");
            String query = "SELECT * FROM patient where patientID="+id;
            rs = st.executeQuery(query);
            while(rs.next()){

               Integer children = rs.getInt("children");
               String lastName= rs.getString("lastname");
               String firstName = rs.getString("firstname") ;
               String birthday= rs.getString("birthday");
               String gender= rs.getString("gender");
               String profession= rs.getString("Profession") ;
               String phone = rs.getString("phone");
               String marritalStatus = rs.getString("MarritalStatus");
               String status = rs.getString("pstatus");
             patient = new Patient(id,lastName,firstName,children,LocalDate.parse(birthday),gender,profession,phone,marritalStatus,status);

            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

            return  patient;



    }

    public ObservableList <Patient>getPatientDataNoActive(){

        ObservableList <Patient>observableList = FXCollections.observableArrayList();
        try {
            System.out.println("records from Db");
            String query = "SELECT * FROM patient where pstatus = 'No Active'";
            rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("patientID");
                Integer children = rs.getInt("children");
                String lastName= rs.getString("lastname");
                String firstName = rs.getString("firstname") ;
                String birthday= rs.getString("birthday");
                String gender= rs.getString("gender");
                String profession= rs.getString("Profession") ;
                String phone = rs.getString("phone");
                String marritalStatus = rs.getString("MarritalStatus");
                String status = rs.getString("pstatus");
                Patient patient = new Patient(id,lastName,firstName,children,LocalDate.parse(birthday),gender,profession,phone,marritalStatus,status);
                observableList.add(patient);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }
    public ObservableList <Patient>getPatientDataActive(){

        ObservableList <Patient>observableList = FXCollections.observableArrayList();
        try {

            String query = "SELECT * FROM patient where pstatus = 'Active'";
            rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("patientID");
                Integer children = rs.getInt("children");
                String lastName= rs.getString("lastname");
                String firstName = rs.getString("firstname") ;
                String birthday= rs.getString("birthday");
                String gender= rs.getString("gender");
                String profession= rs.getString("Profession") ;
                String phone = rs.getString("phone");
                String marritalStatus = rs.getString("MarritalStatus");
                String status = rs.getString("pstatus");
                Patient patient = new Patient(id,lastName,firstName,children,LocalDate.parse(birthday),gender,profession,phone,marritalStatus,status);
                observableList.add(patient);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }


        return  observableList ;



    }
    public void updatePatient(Patient patient) {


        String sql = "UPDATE patient SET firstname ='" + patient.getFirstName() +"'"+",birthday ='"+patient.getBirthday()+"',lastname = '" + patient.getLastName() + "',phone='" + patient.getPhone() + "',gender= '" + patient.getGender() + "',pstatus = '" + patient.getStatus() +"', marritalStatus = '"+patient.getMarritalStatus()+"',profession = '"+patient.getProfession()+"',children = "+patient.getChildren()+" WHERE patientID =" + patient.getId();
        try     {
            st.executeUpdate(sql);
            System.out.println("saveeeeeee");
        } catch (SQLException e) {
            System.out.println("Patient update"+e.getMessage());

        }

    }
    public ObservableList <Patient>getPatientPatient(String iFirstName,String iLastName){

        ObservableList <Patient>observableList = FXCollections.observableArrayList();
        try {

            String query = "SELECT * FROM patient  WHERE lower(firstname) = '"+iFirstName+"' || lower(lastname) ='"+iLastName+"' ";
            rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("patientID");
                Integer children = rs.getInt("children");
                String lastName= rs.getString("lastname");
                String firstName = rs.getString("firstname") ;
                String birthday= rs.getString("birthday");
                String gender= rs.getString("gender");
                String profession= rs.getString("Profession") ;
                String phone = rs.getString("phone");
                String marritalStatus = rs.getString("MarritalStatus");
                String status = rs.getString("pstatus");
                Patient patient = new Patient(id,lastName,firstName,children,LocalDate.parse(birthday),gender,profession,phone,marritalStatus,status);
                observableList.add(patient);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }


        return  observableList ;



    }



    public int InsertData(DoctorInformation doctorInformation)  {
        PreparedStatement pstmt;
        String query = "insert into doctor(firstname,lastname,birthday,address,specialty,emailorphone,pass,gender)values (?,?,?,?,?,?,?,?)";
        try {
            pstmt = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, doctorInformation.getFirstName());
            pstmt.setString(2, doctorInformation.getLastName());
            pstmt.setObject(3, doctorInformation.getBirthday());
            pstmt.setString(4, doctorInformation.getAddress());
            pstmt.setString(5, doctorInformation.getSpecialty());
            pstmt.setString(6, doctorInformation.getEmailOrPhone());
            pstmt.setString(7, doctorInformation.getPass());
            pstmt.setString(8, doctorInformation.getGender());


            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next()){
                System.out.println("Generated Emp Id: "+rs.getInt(1));
                doctorInformation.setId(rs.getInt(1));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        return 0;

    }
    public int getTestAppointment(LocalDate date) {

        int i = 0;
        try {

            System.out.println("records from Db");
            String query = "select * from  appointment where dateOne =" + "'" + date + "'";

            rs = st.executeQuery(query);

            while (rs.next()) {

                i++;

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return i;


    }
    public void deleteAppointment(int id) {
        System.out.println("test");
        String sql = "DELETE FROM appointment WHERE appointmentID=" + id;
        try {

            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error");

        }
    }
    public boolean updateTestAppointment(LocalDate localDate) {
        boolean b = true;
        int a = getTestAppointment(localDate);
        b = a < 5;
        return b;

    }

    public void updateAppointment(PatientForAppointment patientForAppointment) {
        boolean b = true;

        String sql = "UPDATE appointment SET firstname ='" + patientForAppointment.getFirstName() + "'" + ",dateOne ='" + patientForAppointment.getDateOne() + "',lastname = '" + patientForAppointment.getLastName() + "',phone='" + patientForAppointment.getPhone() + "',gender= '" + patientForAppointment.getGender() + "',pstatus = '" + patientForAppointment.getStatus() + "' WHERE appointmentID =" + patientForAppointment.getId();
        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {

        }


    }
    public boolean InsertAppointment(PatientForAppointment patient) {
        PreparedStatement pstmt;
        String query = "insert into appointment(firstname,lastname,pstatus,dateOne,dateTwo,phone,gender)values (?,?,?,?,?,?,?)";
        try {
            if (getTestAppointment(patient.getDateOne()) < 5) {
                pstmt = (PreparedStatement) con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, patient.getFirstName());
                pstmt.setString(2, patient.getLastName());
                pstmt.setString(3, patient.getStatus());
                pstmt.setObject(4, patient.getDateOne());
                pstmt.setObject(5, patient.getDateTwo());
                pstmt.setString(6, patient.getPhone());
                pstmt.setString(7, patient.getGender());


                pstmt.executeUpdate();
                rs = pstmt.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    System.out.println("Generated Emp Id: " + rs.getInt(1));
                    patient.setId(rs.getInt(1));

                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return true;


    }
    public ObservableList<PatientForAppointment> getAppointmentAll() {

        ObservableList<PatientForAppointment> observableList = FXCollections.observableArrayList();
        try {

            System.out.println("records from Db");
            String query = "select * from  appointment";

            rs = st.executeQuery(query);
            while (rs.next()) {
                int appointmentID = rs.getInt("appointmentID");
                String firstNName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String phone = rs.getString("phone");
                String gender = rs.getString("gender");
                String dateOne = rs.getString("dateOne");
                String dateTwo = rs.getString("dateTwo");
                String status = rs.getString("pstatus");

                PatientForAppointment patientForAppointment = new PatientForAppointment(appointmentID, firstNName, lastName, gender, phone, LocalDate.parse(dateOne), LocalDate.parse(dateTwo), status);
                observableList.add(patientForAppointment);


            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return observableList;


    }

    public ObservableList<PatientForAppointment> getAppointmentWaiting() {

        ObservableList<PatientForAppointment> observableList = FXCollections.observableArrayList();
        try {

            System.out.println("records from Db");
            String query = "select * from  appointment where pstatus = 'Waiting'";

            rs = st.executeQuery(query);
            while (rs.next()) {
                int appointmentID = rs.getInt("appointmentID");
                String firstNName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String phone = rs.getString("phone");
                String gender = rs.getString("gender");
                String dateOne = rs.getString("dateOne");
                String dateTwo = rs.getString("dateTwo");
                String status = rs.getString("pstatus");

                PatientForAppointment patientForAppointment = new PatientForAppointment(appointmentID, firstNName, lastName, gender, phone, LocalDate.parse(dateOne), LocalDate.parse(dateTwo), status);
                observableList.add(patientForAppointment);


            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return observableList;


    }

    public ObservableList<PatientForAppointment> getAppointmentPass() {

        ObservableList<PatientForAppointment> observableList = FXCollections.observableArrayList();
        try {

            System.out.println("records from Db");
            String query = "select * from  appointment where pstatus = 'Pass'";

            rs = st.executeQuery(query);
            while (rs.next()) {
                int appointmentID = rs.getInt("appointmentID");
                String firstNName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String phone = rs.getString("phone");
                String gender = rs.getString("gender");
                String dateOne = rs.getString("dateOne");
                String dateTwo = rs.getString("dateTwo");
                String status = rs.getString("pstatus");

                PatientForAppointment patientForAppointment = new PatientForAppointment(appointmentID, firstNName, lastName, gender, phone, LocalDate.parse(dateOne), LocalDate.parse(dateTwo), status);
                observableList.add(patientForAppointment);


            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return observableList;


    }
    public int InsertConsultation(Consultation consultation)  {
        PreparedStatement pstmt;
        String query = "insert into consultation(historyOfTheIllness,dateofconsultation,physicalActivity,addictions,diagnosis,treatment,reasons,clinicalExamination,resultsOfTest,diet,familyHistory,surgicalHistory,medicalHistory,allergies,patientID,doctorID) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pstmt = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, consultation.getHistoryOfTheIllness());
            pstmt.setObject(2, consultation.getDate());
            pstmt.setString(3,consultation.getPhysicalActivity());
            pstmt.setString(4,consultation.getAddictions());
            pstmt.setString(5, consultation.getDiagnosis());
            pstmt.setString(6, consultation.getTreatment());
            pstmt.setString(7, consultation.getReasons());
            pstmt.setString(8,consultation.getClinicalExamination());
            pstmt.setString(9,consultation.getResultsOfTest());
            pstmt.setString(10,consultation.getDiet());
            pstmt.setString(11,consultation.getFamilyHistory());
            pstmt.setString(12,consultation.getSurgicalHistory());
            pstmt.setString(13,consultation.getMedicalHistory());
            pstmt.setString(14,consultation.getAllergies());
            pstmt.setInt(15, consultation.getPatientID());
            pstmt.setInt(16,consultation.getDoctorID());

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next()){

                consultation.setId(rs.getInt(1));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        return 0;

    }

    public int InsertPatientData(Patient patient)  {
        PreparedStatement pstmt;
        String query = "insert into patient(firstname,lastname,children,MarritalStatus,profession,birthday,phone,gender,pstatus)values (?,?,?,?,?,?,?,?,?)";
        try {
            pstmt = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, patient.getFirstName());
            pstmt.setString(2, patient.getLastName());
            pstmt.setInt(3, patient.getChildren());
            pstmt.setString(4, patient.getMarritalStatus());
            pstmt.setString(5, patient.getProfession());
            pstmt.setObject(6, patient.getBirthday());
            pstmt.setString(7, patient.getPhone());
            pstmt.setString(8, patient.getGender());
            pstmt.setString(9, "Active");



            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next()){
                System.out.println("Generated Emp Id: "+rs.getInt(1));
                patient.setId(rs.getInt(1));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        return 0;

    }

    public int Insert(Document document)  {
        PreparedStatement pstmt;
        String query = "insert into document(typeofdocument,patientID,content,dateofdocumentdate,doctorID)values (?,?,?,?,?)";
        try {
            pstmt = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, document.getType());
            pstmt.setInt(2, document.getPatientID());
            pstmt.setString(3, document.getContent());
            pstmt.setObject(4, document.getDate());
            pstmt.setInt(5, document.getDoctorID());




            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next()){
                System.out.println("Generated Emp Id: "+rs.getInt(1));
                document.setId(rs.getInt(1));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        return 0;

    }
    public int InsertCheckup(Checkup checkup)  {
        PreparedStatement pstmt;
        int id = 0;
        String query = "insert into checkup(patientID,content,dateofcheckup,doctorID)values (?,?,?,?)";
        try {
            pstmt = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, checkup.getPatientID());
            pstmt.setString(2, checkup.getContent());
            pstmt.setObject(3, checkup.getDate());
            pstmt.setInt(4, checkup.getDoctorID());




            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next()){
                    id= rs.getInt(1);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        return id;

    }

    public int InsertMedicament(Prescription prescription, int id,int doctorID)  {
        PreparedStatement pstmt;
        String query = "insert into Prescription(dateofprescriptiondate,patientID,doctorID)values (?,?,?)";
        PreparedStatement pstmt1;
        String query1 = "insert into Medicament(dosage,entityNumber,qsp,nameMedicament,prescriptionID)values (?,?,?,?,?)";
        try {
            pstmt = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pstmt.setObject(1, prescription.getDate());
            pstmt.setInt(2,id);
            pstmt.setInt(3,doctorID);
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next()){
                System.out.println("Generated Emp Id: "+rs.getInt(1));
                prescription.setId(rs.getInt(1));
            }
            pstmt1 = (PreparedStatement) con.prepareStatement(query1);

            int i = 0;
            while (i<prescription.getObservableList().size()) {


                pstmt1.setString(1, prescription.getObservableList().get(i).getDosage());
                pstmt1.setInt(2, prescription.getObservableList().get(i).getEntityNumber());
                pstmt1.setString(3, prescription.getObservableList().get(i).getQsp());
                pstmt1.setString(4, prescription.getObservableList().get(i).getNameMedicament());
                pstmt1.setInt(5,prescription.getId());
                pstmt1.executeUpdate();
                i++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }




        return 0;

    }





    public void update(int i){
        System.out.println("test");
        String sql = "UPDATE settings SET setting ="+i+"   WHERE id = 1";
        try {
            st.executeUpdate(sql);
        }catch(SQLException e) {
            System.out.println("Error");

        }

    }

    public int getNb() throws SQLException {
        System.out.println("records from Db");
        String query = "SELECT * FROM settings";

        rs = st.executeQuery(query);


        int  nb = 0;
        while(rs.next()){
            nb  = rs.getInt("setting");
        }

        return nb ;
    }



    public ArrayList<Image> getSuperData() throws SQLException {
        PreparedStatement pstm = con.prepareStatement("SELECT * FROM bookphoto");
        ArrayList<Image> list = new ArrayList<>();
        rs =  pstm.executeQuery();

        while(rs.next()){
            String s =rs.getString("name");
            System.out.println(s);


            InputStream inputStream = rs.getBinaryStream("img");
            Image image = new Image(inputStream);
            list.add(image);

        }

        return list;



    }
    public ObservableList <Prescription>getPatientDaa(int id){

        ObservableList <Prescription>observableList = FXCollections.observableArrayList();
        try {
             ResultSet resultSet ;
            Statement stt;
           stt = con.createStatement();
            System.out.println("records from Db");
            String query = "select * from  Prescription where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                int prescriptionID = rs.getInt("prescriptionID");
                int doctorID = rs.getInt("doctorID");
                System.out.println(prescriptionID);
                String date= rs.getString("dateofprescriptiondate");

                Prescription prescription = new Prescription(prescriptionID,LocalDate.parse(date),doctorID,id);


                String query2 = "select * from  Medicament where PrescriptionID  ="+prescription.getId();
                resultSet = stt.executeQuery(query2);
                while(resultSet.next()){
                    String dosage= resultSet.getString("dosage");
                    int  entityNumber=resultSet.getInt("entityNumber");
                    String qsp= resultSet.getString("qsp");
                    String nameMedicament= resultSet.getString("nameMedicament");
                    prescription.getObservableList().add(new Medicament(nameMedicament,dosage,entityNumber,qsp));
                }
                observableList.add(prescription);

            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }
    public ObservableList <Consultation>getHistoryOfConsultation(int id){

        ObservableList <Consultation>observableList = FXCollections.observableArrayList();
        try {

            System.out.println("records from Db");
            String query = "select * from  consultation where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                int consultationID = rs.getInt("consultationID");
                int doctorID = rs.getInt("doctorID");
                String dateOfConsultation =  rs.getString("dateofconsultation");
                String historyOfTheIllness= rs.getString("historyOfTheIllness");
                String physicalActivity= rs.getString("physicalActivity");
                String addictions= rs.getString("addictions");
                String diagnosis= rs.getString("diagnosis");
                String treatment= rs.getString("treatment");
                String reasons= rs.getString("reasons");
                String clinicalExamination= rs.getString("clinicalExamination");
                String resultsOfTest= rs.getString("resultsOfTest");
                String diet= rs.getString("diet");
                String familyHistory= rs.getString("familyHistory");
                String surgicalHistory= rs.getString("surgicalHistory");
                String medicalHistory= rs.getString("medicalHistory");
                String allergies= rs.getString("allergies");
                Integer patientID= rs.getInt("patientID");



//                diagnosis text ,
//                treatment text ,
//                reasons text ,
//                clinicalExamination text,
//                resultsOfTest text ,
//                diet text ,
//                familyHistory text ,
//                surgicalHistory text ,
//                medicalHistory text ,
//                allergies text ,


                Consultation consultation = new Consultation(historyOfTheIllness,physicalActivity,addictions,diagnosis,treatment,reasons,clinicalExamination,resultsOfTest,diet,LocalDate.parse(dateOfConsultation),familyHistory,surgicalHistory,medicalHistory,allergies,patientID,doctorID,consultationID);
                observableList.add(consultation);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }
    public ObservableList <Document>getDocumentHistory(int id){

        ObservableList <Document>observableList = FXCollections.observableArrayList();
        try {

            System.out.println("records from Db");
            String query = "select * from  document where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                int documentID = rs.getInt("documentID");
                int doctorID = rs.getInt("doctorID");
                int patientID = rs.getInt("patientID");
                String date= rs.getString("dateofdocumentdate");
                String content= rs.getString("content");
                String type= rs.getString("typeofdocument");

             Document document  = new Document(id,content,type,LocalDate.parse(date),doctorID,patientID);

                observableList.add(document);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }

    public ObservableList <Checkup>getCheckupHistory(int id){

        ObservableList <Checkup>observableList = FXCollections.observableArrayList();
        try {

            System.out.println("records from Db");
            String query = "select * from  checkup where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                int documentID = rs.getInt("checkupID");
                int doctorID = rs.getInt("doctorID");
                String date= rs.getString("dateofcheckup");
                String content= rs.getString("content");
                Checkup checkup  = new Checkup( content,  LocalDate.parse(date),doctorID, id, documentID);
                observableList.add(checkup);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }


        return  observableList ;



    }

    public ObservableList <String>getTestAndResults(int id){

        ObservableList <String>observableList = FXCollections.observableArrayList();
        try {


            System.out.println("records from Db");
            String query = "SELECT resultsOfTest FROM  consultation  where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                String theIllness= rs.getString("resultsOfTest");
                observableList.add(theIllness);
            }


        }catch(Exception ex){
            System.out.println(ex);
        }


        return  observableList ;



    }
    public ObservableList <String>getHistoryOfThell(int id){

        ObservableList <String>observableList = FXCollections.observableArrayList();
        try {


            System.out.println("records from Db");
            String query = "SELECT historyOfTheIllness FROM  consultation  where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                String theIllness= rs.getString("historyOfTheIllness");
                observableList.add(theIllness);
            }


        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }
    public ObservableList <String>getClinicalExamination(int id){

        ObservableList <String>observableList = FXCollections.observableArrayList();
        try {


            System.out.println("records from Db");
            String query = "SELECT clinicalExamination FROM  consultation  where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                String theIllness= rs.getString("clinicalExamination");
                observableList.add(theIllness);
            }


        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }
    public ObservableList <String>getSurgicalHistory(int id){

        ObservableList <String>observableList = FXCollections.observableArrayList();
        try {


            System.out.println("records from Db");
            String query = "SELECT surgicalHistory FROM  consultation  where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                String theIllness= rs.getString("surgicalHistory");
                observableList.add(theIllness);
            }


        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }
    public ObservableList <String>getMedicalHistory(int id){

        ObservableList <String>observableList = FXCollections.observableArrayList();
        try {


            System.out.println("records from Db");
            String query = "SELECT medicalHistory FROM  consultation  where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                String theIllness= rs.getString("medicalHistory");
                observableList.add(theIllness);
            }


        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }
    public ObservableList <String>getTreatment(int id){

        ObservableList <String>observableList = FXCollections.observableArrayList();
        try {


            System.out.println("records from Db");
            String query = "SELECT treatment FROM  consultation  where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                String theIllness= rs.getString("treatment");
                observableList.add(theIllness);
            }


        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }
    public ObservableList <String>getHistoryOfReasons(int id){

        ObservableList <String>observableList = FXCollections.observableArrayList();
        try {


            System.out.println("records from Db");
            String query = "SELECT reasons FROM  consultation  where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                String theIllness= rs.getString("reasons");
                observableList.add(theIllness);
            }


        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }
    public ObservableList <String>getFamilyHistory(int id){

        ObservableList <String>observableList = FXCollections.observableArrayList();
        try {


            System.out.println("records from Db");
            String query = "SELECT familyHistory FROM  consultation  where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                String theIllness= rs.getString("familyHistory");
                observableList.add(theIllness);
            }


        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }
    public ObservableList <String>getAllergies(int id){

        ObservableList <String>observableList = FXCollections.observableArrayList();
        try {


            System.out.println("records from Db");
            String query = "SELECT allergies FROM  consultation  where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                String theIllness= rs.getString("allergies");
                observableList.add(theIllness);
            }


        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }
    public ObservableList <String>getAddictions(int id){

        ObservableList <String>observableList = FXCollections.observableArrayList();
        try {


            String query = "SELECT addictions FROM  consultation  where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                String theIllness= rs.getString("addictions");
                observableList.add(theIllness);
            }


        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }
    public ObservableList <String>getPhysicalActivity(int id){

        ObservableList <String>observableList = FXCollections.observableArrayList();
        try {


            String query = "SELECT physicalActivity FROM  consultation  where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                String theIllness= rs.getString("physicalActivity");
                observableList.add(theIllness);
            }


        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }
    public ObservableList <String>getDiet(int id){

        ObservableList <String>observableList = FXCollections.observableArrayList();
        try {


            String query = "SELECT diet FROM  consultation  where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                String theIllness= rs.getString("diet");
                observableList.add(theIllness);
            }


        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }
    public ObservableList <String>getHistoryOfDiagnosis(int id){

        ObservableList <String>observableList = FXCollections.observableArrayList();
        try {


            System.out.println("records from Db");
            String query = "SELECT diagnosis FROM  consultation  where patientID ="+id;

            rs = st.executeQuery(query);
            while(rs.next()){
                String diagnosis= rs.getString("diagnosis");
                observableList.add(diagnosis);
            }


        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  observableList ;



    }


    public ObservableList <String>getDoctorData(int x){

        ObservableList  <String>observableList = FXCollections.observableArrayList();
        try {

            String query = "select*from  doctor where doctorID ="+x;
            rs = st.executeQuery(query);
            while(rs.next()){

                String lastName= rs.getString("lastname");
                String firstName = rs.getString("firstname") ;
                String birthday= rs.getString("birthday");
                String gender= rs.getString("gender");
                String emailOrPhone = rs.getString("emailorphone");
                String specialty = rs.getString("specialty");
                String address= rs.getString("address");
                observableList.addAll(firstName,lastName,birthday,gender,emailOrPhone,specialty,address);


            }
        }catch(Exception ex){
            System.out.println(ex);
        }


        return   observableList;



    }



    public DoctorInformation getDoctor(int x){

        DoctorInformation doctorInformation = null;
        try {
            System.out.println("records from Db");
            String query = "select*from  doctor where doctorID ="+x;
            rs = st.executeQuery(query);
            while(rs.next()){

                String lastName= rs.getString("lastname");
                String firstName = rs.getString("firstname") ;
                String birthday= rs.getString("birthday");
                String gender= rs.getString("gender");

                String emailOrPhone = rs.getString("emailorphone");
                String specialty = rs.getString("specialty");
                String address= rs.getString("address");
            doctorInformation = new DoctorInformation(firstName,lastName,LocalDate.parse(birthday),specialty,address,emailOrPhone,x,gender);


            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

        return  doctorInformation ;



    }
    public void deletePatient(int id){
        deleteConsultation(id);
        deleteCheckUp(id);
        deletePrescription(id);
        deleteDocument(id);

        String sql = "DELETE FROM patient WHERE patientID="+id;

        try {

            st.executeUpdate(sql);
        }catch(SQLException e) {
            System.out.println("Error");

        }
    }
   private void deleteConsultation(int id){
        String sql = "DELETE FROM consultation WHERE patientID="+id;

        try {

            st.executeUpdate(sql);
        }catch(SQLException e) {
            System.out.println("Error");

        }
    }
    private void deleteDocument(int id){
        String sql = "delete FROM document WHERE patientID="+id;

        try {

            st.executeUpdate(sql);
        }catch(SQLException e) {
            System.out.println("Error");

        }
    }
    private void deleteCheckUp(int id){
        String sql = "delete FROM checkup WHERE patientID="+id;

        try {

            st.executeUpdate(sql);
        }catch(SQLException e) {
            System.out.println("Error");

        }
    }
    private void deletePrescription(int id){
        String sql = "delete FROM Prescription WHERE patientID="+id;

        try {

            st.executeUpdate(sql);
        }catch(SQLException e) {
            System.out.println("Error");

        }
    }
    public void deleteMedi(int id){
        System.out.println("test");
        String sql = "DELETE FROM MedicamentName WHERE MedicamentNameID="+id;
        try {

            st.executeUpdate(sql);
        }catch(SQLException e) {
            System.out.println("Error");

        }



    }
    public void deleteCheckup(int id){
        System.out.println("test");
        String sql = "DELETE FROM checkupName WHERE checkupNameID="+id;
        try {

            st.executeUpdate(sql);
        }catch(SQLException e) {
            System.out.println("Error");

        }



    }
    public int InsertMedi(MedicamentName medicamentName)  {
        PreparedStatement pstmt;
        int id = 0;
        String query = "insert into MedicamentName(mediName,dosage)values(?,?)";
        try {
            pstmt = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, medicamentName.getName());
            pstmt.setString(2,medicamentName.getDosage());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next()){
                id= rs.getInt(1);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        return id;

    }
    public int InsertCheckup(CheckupName checkupName)  {
        PreparedStatement pstmt;
        int id = 0;
        String query = "insert into checkupName(checkupName)values(?)";
        try {
            pstmt = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, checkupName.getName());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next()){
                id= rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;

    }
    public ObservableList <MedicamentName>getMedi(){

        ObservableList <MedicamentName>observableList = FXCollections.observableArrayList();
        try {
            System.out.println("records from Db");
            String query = "SELECT * FROM MedicamentName";
            rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("MedicamentNameID");

                String dosage= rs.getString("dosage");
                String name = rs.getString("mediName") ;
                observableList.add(new MedicamentName(id,name,dosage));
            }
        }catch(Exception ex){
            System.out.println(ex);
        }


        return  observableList ;



    }
    public ObservableList <CheckupName>getCheckupName(){

        ObservableList <CheckupName>observableList = FXCollections.observableArrayList();
        try {
            System.out.println("records from Db");
            String query = "SELECT * FROM checkupName";
            rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("checkupNameID");
                String name = rs.getString("checkupName") ;
                observableList.add(new CheckupName(name,id));
            }
        }catch(Exception ex){
            System.out.println(ex);
        }


        return  observableList ;



    }

    public ObservableList<APatientForWaitingRoom> getPatientDataa() {

        ObservableList<APatientForWaitingRoom> observableList = FXCollections.observableArrayList();
        try {
            System.out.println("records from Db");
            String query = "select*from  waiting where firstname != \"\"and  lastname!=\"\" ;";
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("waitingID");
                String lastName = rs.getString("lastname");
                String firstName = rs.getString("firstname");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String pstatus = rs.getString("pstatus");
                APatientForWaitingRoom p = new APatientForWaitingRoom(firstName, lastName, gender, phone, id, pstatus);
                observableList.add(p);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }


        return observableList;


    }
    public String getLicenses() {

        String limiteWait = null;
        try {


            String query = "SELECT * FROM limite ";

            rs = st.executeQuery(query);
            while (rs.next()) {
                limiteWait = rs.getString("licenses2");
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.setTitle("ERROR");
            alert.setHeaderText("");
            alert.showAndWait();

        }

        return limiteWait;



    }

}

