package medical.DataBase;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3305/medical","root","1234");
            st = con.createStatement();

        }catch(Exception ex){
            System.out.println("Errer : " + ex);

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
               Patient patient = new Patient(id,lastName,firstName,children,LocalDate.parse(birthday),gender,profession,phone,marritalStatus);
               observableList.add(patient);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("records from Db");

            return  observableList ;



    }


    public void Show(){
        try {


            String query = "show tables from medical";
            System.out.println("records from databases");

            if (st.execute(query)) {
                rs = st.getResultSet();
            }
            while(rs.next()){
                String database =rs.getString("Tables_in_medical");
                System.out.println(database);




            }

        }catch(Exception ex){
            System.out.println(ex);
        }




    }


    public int InsertData(DoctorInformation doctorInformation)  {
        PreparedStatement pstmt;
        String query = "insert into doctor(firstname,lastname,birthday,address,specialty,emailorphone,pass,gender,idofapproval)values (?,?,?,?,?,?,?,?,?)";
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
            pstmt.setString(9, doctorInformation.getIdOfApproval());

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


    public int InsertConsultation(Consultation consultation, int patientID)  {
        PreparedStatement pstmt;
        String query = "insert into consultation(patientID,historyOfTheIllness,dateofconsultation,physicalActivity,addictions,diagnosis,treatment,reasons,clinicalExamination,resultsOfTest,diet,familyHistory,surgicalHistory,medicalHistory,allergies)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pstmt = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, patientID);
            pstmt.setString(2, consultation.getHistoryOfTheIllness());
            pstmt.setObject(3, consultation.getDate());
            pstmt.setString(4,consultation.getPhysicalActivity());
            pstmt.setString(5,consultation.getAddictions());
            pstmt.setString(6, consultation.getDiagnosis());
            pstmt.setString(7, consultation.getTreatment());
            pstmt.setString(8, consultation.getReasons());
            pstmt.setString(9,consultation.getClinicalExamination());
            pstmt.setString(10,consultation.getResultsOfTest());
            pstmt.setString(11,consultation.getDiet());
            pstmt.setString(12,consultation.getFamilyHistory());
            pstmt.setString(13,consultation.getSurgicalHistory());
            pstmt.setString(14,consultation.getMedicalHistory());
            pstmt.setString(15,consultation.getAllergies());

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next()){
                System.out.println("Generated Emp Id: "+rs.getInt(1));
                consultation.setId(rs.getInt(1));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        return 0;

    }

    public int InsertPatientData(Patient patient)  {
        PreparedStatement pstmt;
        String query = "insert into patient(firstname,lastname,children,MarritalStatus,profession,birthday,phone,gender)values (?,?,?,?,?,?,?,?)";
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

    public int Insert(Document document , int id)  {
        PreparedStatement pstmt;
        String query = "insert into document(typeofdocument,patientID,content,dateofdocumentdate)values (?,?,?,?)";
        try {
            pstmt = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, document.getType());
            pstmt.setInt(2, id);
            pstmt.setString(3, document.getContent());
            pstmt.setObject(4, document.getDate());




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

    public int InsertMedicament(Prescription prescription, int id)  {
        PreparedStatement pstmt;
        String query = "insert into Prescription(dateofprescriptiondate,patientID)values (?,?)";
        PreparedStatement pstmt1;
        String query1 = "insert into Medicament(dosage,entityNumber,qsp,nameMedicament,prescriptionID)values (?,?,?,?,?)";
        try {
            pstmt = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pstmt.setObject(1, prescription.getDate());
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next()){
                System.out.println("Generated Emp Id: "+rs.getInt(1));
                prescription.setId(rs.getInt(1));
            }
            pstmt1 = (PreparedStatement) con.prepareStatement(query1);

            int i = 0;
            while (i<prescription.getObservableList().size()) {
                System.out.println("hhhhhhhhhhhhhhh");

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
                System.out.println(prescriptionID);
                String date= rs.getString("dateofprescriptiondate");
                Prescription prescription = new Prescription(prescriptionID,LocalDate.parse(date));


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
}

