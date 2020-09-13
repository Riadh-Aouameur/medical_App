package medical.DataBase;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import medical.APatientForWaitingRoom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Riadh
 */
public class Db1 {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Db1() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3305/medical2", "root", "1234");
            st = con.createStatement();

        } catch (Exception ex) {
            System.out.println("Errer : " + ex);

        }


    }



    //
    public ObservableList <APatientForWaitingRoom>getPatientData() {

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
        System.out.println("records from Db");

        return observableList;

//
//
    }
//
//
//
//
//


        //
//
//    public int InsertConsultation(Consultation consultation, int patientID,int doctorID)  {
//        PreparedStatement pstmt;
//        String query = "insert into consultation(patientID,historyOfTheIllness,dateofconsultation,physicalActivity,addictions,diagnosis,treatment,reasons,clinicalExamination,resultsOfTest,diet,familyHistory,surgicalHistory,medicalHistory,allergies,doctorID)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        try {
//            pstmt = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
//            pstmt.setInt(1, patientID);
//            pstmt.setString(2, consultation.getHistoryOfTheIllness());
//            pstmt.setObject(3, consultation.getDate());
//            pstmt.setString(4,consultation.getPhysicalActivity());
//            pstmt.setString(5,consultation.getAddictions());
//            pstmt.setString(6, consultation.getDiagnosis());
//            pstmt.setString(7, consultation.getTreatment());
//            pstmt.setString(8, consultation.getReasons());
//            pstmt.setString(9,consultation.getClinicalExamination());
//            pstmt.setString(10,consultation.getResultsOfTest());
//            pstmt.setString(11,consultation.getDiet());
//            pstmt.setString(12,consultation.getFamilyHistory());
//            pstmt.setString(13,consultation.getSurgicalHistory());
//            pstmt.setString(14,consultation.getMedicalHistory());
//            pstmt.setString(15,consultation.getAllergies());
//            pstmt.setInt(16,doctorID);
//
//            pstmt.executeUpdate();
//            rs = pstmt.getGeneratedKeys();
//            if(rs != null && rs.next()){
//                System.out.println("Generated Emp Id: "+rs.getInt(1));
//                consultation.setId(rs.getInt(1));
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//        return 0;
//
//    }
//
//    public int InsertPatientData(Patient patient)  {
//        PreparedStatement pstmt;
//        String query = "insert into patient(firstname,lastname,children,MarritalStatus,profession,birthday,phone,gender)values (?,?,?,?,?,?,?,?)";
//        try {
//            pstmt = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
//            pstmt.setString(1, patient.getFirstName());
//            pstmt.setString(2, patient.getLastName());
//            pstmt.setInt(3, patient.getChildren());
//            pstmt.setString(4, patient.getMarritalStatus());
//            pstmt.setString(5, patient.getProfession());
//            pstmt.setObject(6, patient.getBirthday());
//            pstmt.setString(7, patient.getPhone());
//            pstmt.setString(8, patient.getGender());
//
//
//
//            pstmt.executeUpdate();
//            rs = pstmt.getGeneratedKeys();
//            if(rs != null && rs.next()){
//                System.out.println("Generated Emp Id: "+rs.getInt(1));
//                patient.setId(rs.getInt(1));
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//        return 0;
//
//    }
//
//    public int Insert(Document document , int id,int dotorID)  {
//        PreparedStatement pstmt;
//        String query = "insert into document(typeofdocument,patientID,content,dateofdocumentdate,doctorID)values (?,?,?,?,?)";
//        try {
//            pstmt = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
//            pstmt.setString(1, document.getType());
//            pstmt.setInt(2, id);
//
//            pstmt.setString(3, document.getContent());
//            pstmt.setObject(4, document.getDate());
//            pstmt.setInt(5, dotorID);
//
//
//
//
//            pstmt.executeUpdate();
//            rs = pstmt.getGeneratedKeys();
//            if(rs != null && rs.next()){
//                System.out.println("Generated Emp Id: "+rs.getInt(1));
//                document.setId(rs.getInt(1));
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//        return 0;
//
//    }
//
//    public int InsertMedicament(Prescription prescription, int id,int doctorID)  {
//        PreparedStatement pstmt;
//        String query = "insert into Prescription(dateofprescriptiondate,patientID,doctorID)values (?,?,?)";
//        PreparedStatement pstmt1;
//        String query1 = "insert into Medicament(dosage,entityNumber,qsp,nameMedicament,prescriptionID)values (?,?,?,?,?)";
//        try {
//            pstmt = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
//            pstmt.setObject(1, prescription.getDate());
//            pstmt.setInt(2,id);
//            pstmt.setInt(3,doctorID);
//            pstmt.executeUpdate();
//            rs = pstmt.getGeneratedKeys();
//            if(rs != null && rs.next()){
//                System.out.println("Generated Emp Id: "+rs.getInt(1));
//                prescription.setId(rs.getInt(1));
//            }
//            pstmt1 = (PreparedStatement) con.prepareStatement(query1);
//
//            int i = 0;
//            while (i<prescription.getObservableList().size()) {
//                System.out.println("hhhhhhhhhhhhhhh");
//
//                pstmt1.setString(1, prescription.getObservableList().get(i).getDosage());
//                pstmt1.setInt(2, prescription.getObservableList().get(i).getEntityNumber());
//                pstmt1.setString(3, prescription.getObservableList().get(i).getQsp());
//                pstmt1.setString(4, prescription.getObservableList().get(i).getNameMedicament());
//                pstmt1.setInt(5,prescription.getId());
//                pstmt1.executeUpdate();
//                i++;
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//        return 0;
//
//    }
//
//
//
//
//


        //
//    public int getNb() throws SQLException {
//        System.out.println("records from Db");
//        String query = "SELECT * FROM settings";
//
//        rs = st.executeQuery(query);
//
//
//        int  nb = 0;
//        while(rs.next()){
//            nb  = rs.getInt("setting");
//        }
//
//        return nb ;
//    }
//
//
//
//    public ArrayList<Image> getSuperData() throws SQLException {
//        PreparedStatement pstm = con.prepareStatement("SELECT * FROM bookphoto");
//        ArrayList<Image> list = new ArrayList<>();
//        rs =  pstm.executeQuery();
//
//        while(rs.next()){
//            String s =rs.getString("name");
//            System.out.println(s);
//
//
//            InputStream inputStream = rs.getBinaryStream("img");
//            Image image = new Image(inputStream);
//            list.add(image);
//
//        }
//
//        return list;
//
//
//
//    }
//    public ObservableList <Prescription>getPatientDaa(int id){
//
//        ObservableList <Prescription>observableList = FXCollections.observableArrayList();
//        try {
//             ResultSet resultSet ;
//            Statement stt;
//           stt = con.createStatement();
//            System.out.println("records from Db");
//            String query = "select * from  Prescription where patientID ="+id;
//
//            rs = st.executeQuery(query);
//            while(rs.next()){
//                int prescriptionID = rs.getInt("prescriptionID");
//                int doctorID = rs.getInt("doctorID");
//                System.out.println(prescriptionID);
//                String date= rs.getString("dateofprescriptiondate");
//
//                Prescription prescription = new Prescription(prescriptionID,LocalDate.parse(date),doctorID,id);
//
//
//                String query2 = "select * from  Medicament where PrescriptionID  ="+prescription.getId();
//                resultSet = stt.executeQuery(query2);
//                while(resultSet.next()){
//                    String dosage= resultSet.getString("dosage");
//                    int  entityNumber=resultSet.getInt("entityNumber");
//                    String qsp= resultSet.getString("qsp");
//                    String nameMedicament= resultSet.getString("nameMedicament");
//                    prescription.getObservableList().add(new Medicament(nameMedicament,dosage,entityNumber,qsp));
//                }
//                observableList.add(prescription);
//
//            }
//        }catch(Exception ex){
//            System.out.println(ex);
//        }
//        System.out.println("records from Db");
//
//        return  observableList ;
//
//
//
//    }
//
//
//
//    public ObservableList <String>getHistoryOfThell(int id){
//
//        ObservableList <String>observableList = FXCollections.observableArrayList();
//        try {
//
//
//            System.out.println("records from Db");
//            String query = "SELECT historyOfTheIllness FROM  consultation  where patientID ="+id;
//
//            rs = st.executeQuery(query);
//            while(rs.next()){
//                String theIllness= rs.getString("historyOfTheIllness");
//                observableList.add(theIllness);
//            }
//
//
//        }catch(Exception ex){
//            System.out.println(ex);
//        }
//        System.out.println("records from Db");
//
//        return  observableList ;
//
//
//
//    }
//
//

//
//    public DoctorInformation getDoctor(int x){
//
//        DoctorInformation doctorInformation = null;
//        try {
//            System.out.println("records from Db");
//            String query = "select*from  doctor where doctorID ="+x;
//            rs = st.executeQuery(query);
//            while(rs.next()){
//
//                String lastName= rs.getString("lastname");
//                String firstName = rs.getString("firstname") ;
//                String birthday= rs.getString("birthday");
//                String gender= rs.getString("gender");
//                String idOfApproval= rs.getString("idofapproval") ;
//                String emailOrPhone = rs.getString("emailorphone");
//                String specialty = rs.getString("specialty");
//                String address= rs.getString("address");
//            doctorInformation = new DoctorInformation(firstName,lastName,LocalDate.parse(birthday),specialty,address,emailOrPhone,x,gender,idOfApproval);
//
//
//            }
//        }catch(Exception ex){
//            System.out.println(ex);
//        }
//        System.out.println("records from Db");
//
//        return  doctorInformation ;
//
//
//
    }
