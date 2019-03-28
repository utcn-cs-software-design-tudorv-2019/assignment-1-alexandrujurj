package presentation;
import java.util.ArrayList;

import business.StudentBusiness;
import business.Validation;
import data_access.Course;
import data_access.Grade;
import data_access.StudentProfile;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StudentView {
	
	Stage window;
	
	StudentProfile student;
	
	Course course;
	
	Grade grade;
	
	//Button createPersonal;
	
	private ListView<String> courses;
    private Label courseName;
    private Label courseTeacher;
    
    private TextField searchField;
    private TextField keyField;
	
	
	private TextField idStudent; private Label idStudentLabel;
	private TextField firstName; private Label firstNameLabel;
    private TextField lastName; private Label lastNameLabel;
    private TextField cnp; private Label cnpLabel;
    private TextField address; private Label addressLabel;
    private TextField phone; private Label phoneLabel;
    private TextField email; private Label emailLabel;
    private TextField group; private Label groupLabel;
    
    public StudentView(StudentProfile student) {
    	this.student = student;
    	System.out.println(student.getId()+" "+student.getStudentId()+ " "+student.getFirstName());
        StudentProfile pi = (new StudentBusiness()).viewStudent(student);
      
        window = new Stage();
        window.setTitle("Student Profile");
        window.setOnCloseRequest(e->handleWindowClosure());
       /* errorlog = new TextArea();
        errorlog.setLayoutX(630);
        errorlog.setLayoutY(30);
        errorlog.setPrefSize(550,100);
        errorlog.setPromptText("Error messages will appear here");
        errorlog.setEditable(false);*/

        TabPane layout = new TabPane();
        Tab tab1 = new Tab("Personal Info");
        tab1.setClosable(false);
        initiatePersonalInfoTab(tab1);
        Tab tab4 = new Tab("Courses");
        tab4.setClosable(false);
        initiateEnrollmentTab(tab4);
        
        layout.getTabs().addAll(tab1,tab4);

        Scene scene = new Scene(layout,1200,800);
       // scene.getStylesheets().add("DarkTheme.css");
        window.setScene(scene);
        window.show();
        
        viewPersonalInfo(pi);
        viewEnrolledCourses();
    }
    
    void initiateEnrollmentTab(Tab enrollmentInfo){
        ArrayList<Label> labels = new ArrayList<>();
        courses = new ListView<>();
        courseName = new Label("");labels.add(courseName);
        courseTeacher = new Label("");labels.add(courseTeacher);
        
        
        searchField = new TextField();
        
        Button searchButton = new Button("Search");
        searchButton.setOnAction(e->handleSearchOperation());
        Button enrollButton = new Button("Enroll me");
        enrollButton.setOnAction(e->handleEnrollmentOperation());
        createCourse(enrollmentInfo,searchField,labels,searchButton,enrollButton,courses);
    }
    
    static void createCourse(Tab tab,TextField searchField,ArrayList<Label> labels,Button searchButton,Button enrollButton,ListView<String> courses){
        Pane layout = new Pane();
        tab.setContent(layout);

        Separator sep = new Separator();
        sep.setOrientation(Orientation.HORIZONTAL);
        sep.setLayoutX(0);
        sep.setLayoutY(220);
        sep.setPrefWidth(1200);
        layout.getChildren().add(sep);

        sep = new Separator();
        sep.setOrientation(Orientation.VERTICAL);
        sep.setLayoutX(780);
        sep.setLayoutY(220);
        sep.setPrefHeight(580);
        layout.getChildren().add(sep);

        Label label = new Label("My Courses");
        label.setLayoutX(65);
        label.setLayoutY(250);
        layout.getChildren().add(label);

        courses.setLayoutX(65);
        courses.setLayoutY(300);
        courses.setPrefWidth(600);
        layout.getChildren().add(courses);

        label = new Label("Search for new course");
        label.setLayoutX(340);
        label.setLayoutY(50);
        layout.getChildren().add(label);

        label = new Label("Course Information");
        label.setLayoutX(830);
        label.setLayoutY(250);
        layout.getChildren().add(label);

       
        searchField.setLayoutX(340);
        searchField.setLayoutY(90);
        searchField.setPrefWidth(600);
        
        layout.getChildren().addAll(searchField);

        searchButton.setLayoutX(1040);
        searchButton.setLayoutY(90);
        enrollButton.setLayoutX(860);
        enrollButton.setLayoutY(700);
        layout.getChildren().addAll(searchButton,enrollButton);

        ArrayList<Label> localLabels = new ArrayList<>();
        localLabels.add(new Label("Name :"));
        localLabels.add(new Label("Teacher Name :"));
        

        for(int i=0;i<localLabels.size();i++){
            localLabels.get(i).setLayoutX(830);
            localLabels.get(i).setLayoutY(300 + i*100);
        }
        layout.getChildren().addAll(localLabels);

        for(int i=0;i<labels.size();i++){
            labels.get(i).setLayoutX(860);
            labels.get(i).setLayoutY(350 + i*100);
        }
        layout.getChildren().addAll(labels);

        
    }
    
    void initiatePersonalInfoTab(Tab personalInfo){
        ArrayList<TextField> textFields = new ArrayList<>();
        ArrayList<Label> labels = new ArrayList<>();
        ArrayList<Button> buttons = new ArrayList<>();
        
        idStudent = new TextField(); textFields.add(idStudent);
        firstName = new TextField();textFields.add(firstName);
        lastName = new TextField();textFields.add(lastName);
        cnp =  new TextField();textFields.add(cnp);
        address = new TextField();textFields.add(address);
        phone = new TextField();textFields.add(phone);
        email = new TextField();textFields.add(email);
        group = new TextField();textFields.add(group);

        idStudentLabel = new Label();labels.add(idStudentLabel);
        firstNameLabel = new Label();labels.add(firstNameLabel);
        lastNameLabel = new Label();labels.add(lastNameLabel);
        cnpLabel = new Label();labels.add(cnpLabel);
        addressLabel =  new Label();labels.add(addressLabel);
        phoneLabel =  new Label();labels.add(phoneLabel);
       	emailLabel =  new Label();labels.add(emailLabel);
        groupLabel =  new Label();labels.add(groupLabel);

     //   createPersonal = new Button("Create");buttons.add(createPersonal);
      //  createPersonal.setOnAction(e->handlePersonalInfoCreation());
        Button updatePersonal = new Button("Update");buttons.add(updatePersonal);
        updatePersonal.setOnAction(e->handlePersonalInfoUpdate());

        createPersonal(personalInfo,textFields,labels,buttons);
    }
    
    void viewPersonalInfo(StudentProfile pi){
        
    	System.out.println(pi.getEmail());
        //createPersonal.setVisible(false);
        
        System.out.println(pi.getEmail());
        if(!Integer.toString(pi.getStudentId()).isEmpty())
        	idStudentLabel.setText(Integer.toString(pi.getStudentId()));
        if(!pi.getFirstName().isEmpty())
            firstNameLabel.setText(pi.getFirstName());
        if(!pi.getLastName().isEmpty())
            lastNameLabel.setText(pi.getLastName());
        if(!pi.getCnp().isEmpty())
            cnpLabel.setText(pi.getCnp());
        if(!pi.getAddress().isEmpty())
            addressLabel.setText(pi.getAddress());
        if(!pi.getPhone().isEmpty())
            phoneLabel.setText(pi.getPhone());
        if(!pi.getEmail().isEmpty())
            emailLabel.setText(pi.getEmail());
        if(!pi.getGroup().isEmpty())
            groupLabel.setText(pi.getGroup());
    }
    
    void handlePersonalInfoUpdate(){
    	
    	String idStudentText = idStudent.getText();
        String firstNameText = firstName.getText();
        String lastNameText = lastName.getText();
        String cnpText = cnp.getText();
        String addressText = address.getText();
        String phoneText = phone.getText();
        String emailText = email.getText();
        String groupText = group.getText();
        
        cleanPersonalInfoTextFields();
        new StudentBusiness().updateStudent(student,firstNameText,lastNameText,cnpText,addressText,phoneText,emailText,groupText);
        
   		
        StudentProfile pi = (new StudentBusiness()).viewStudent(student);
         viewPersonalInfo(pi);
     
    }
    void cleanCourseSearch(){
        searchField.clear();
        
      
    }

    
    
    private void handleSearchOperation(){
        String searchCourseSession = searchField.getText();
        course = (new StudentBusiness()).searchForCourse(searchCourseSession);
        cleanCourseSearch();
        if(course == null) return;
        if(!course.getCourseName().isEmpty())
            courseName.setText(course.getCourseName());
        System.out.println(course.getTeacherName());
        if(!course.getTeacherName().isEmpty())
            courseTeacher.setText(course.getTeacherName());
        

    }
    
   
    
    private void handleEnrollmentOperation(){
        
        cleanCourseSearch();
     	new StudentBusiness().enrollStudent(student,course);
        viewEnrolledCourses();
    }
    private void viewEnrolledCourses(){
        ObservableList<String> enrolledCourses = (new StudentBusiness()).findEnrolledCourses(student);
        courses.setEditable(false);
        courses.setItems(enrolledCourses);
    }
    
    void handlePersonalInfoCreation(){
    	String idStudentText = idStudent.getText();
        String firstNameText = firstName.getText();
        String lastNameText = lastName.getText();
        String cnpText = cnp.getText();
        String addressText = address.getText();
        String phoneText = phone.getText();
        String emailText = email.getText();
        String groupText = group.getText();
        cleanPersonalInfoTextFields();

       new StudentBusiness().addStudent(0,Integer.parseInt(idStudentText),firstNameText,lastNameText,cnpText,addressText,phoneText,emailText,groupText);
       
       		
           StudentProfile pi = (new StudentBusiness()).viewStudent(student);
            viewPersonalInfo(pi);
        
    }
    
    static void createPersonal(Tab tab, ArrayList<TextField> textFields, ArrayList<Label> labels, ArrayList<Button> buttons){
        Pane layout = new Pane();
        tab.setContent(layout);

        ArrayList<Label> localLabels = new ArrayList<>();
        localLabels.add(new Label("Student ID"));
        localLabels.add(new Label("FirstName"));
        localLabels.add(new Label("LastName"));
        localLabels.add(new Label("Cnp"));
        localLabels.add(new Label("Address"));
        localLabels.add(new Label("Phone"));
        localLabels.add(new Label("Email"));
        localLabels.add(new Label("Group"));

        for(int i=0;i<localLabels.size();i++){
            localLabels.get(i).setLayoutX(65);
            localLabels.get(i).setLayoutY(300 + i*50);
        }
        layout.getChildren().addAll(localLabels);

        localLabels.clear();
        localLabels.add(new Label("Student ID"));
        localLabels.add(new Label("FirstName"));
        localLabels.add(new Label("LastName"));
        localLabels.add(new Label("Cnp"));
        localLabels.add(new Label("Address"));
        localLabels.add(new Label("Phone"));
        localLabels.add(new Label("Email"));
        localLabels.add(new Label("Group"));
        for(int i=0;i<localLabels.size();i++){
            localLabels.get(i).setLayoutX(650);
            localLabels.get(i).setLayoutY(300 + i*50);
        }
        layout.getChildren().addAll(localLabels);

        Separator sep = new Separator();
        sep.setOrientation(Orientation.HORIZONTAL);
        sep.setLayoutX(0);
        sep.setLayoutY(220);
        sep.setPrefWidth(1200);
        layout.getChildren().add(sep);

        sep = new Separator();
        sep.setOrientation(Orientation.VERTICAL);
        sep.setLayoutX(560);
        sep.setLayoutY(220);
        sep.setPrefHeight(580);
        layout.getChildren().add(sep);

        for(int i=0;i<textFields.size();i++){
            textFields.get(i).setLayoutX(900);
            textFields.get(i).setLayoutY(300+i*50);
            textFields.get(i).setMinWidth(250);
        }
        layout.getChildren().addAll(textFields);

        for(int i=0;i<labels.size();i++){
            labels.get(i).setText("info");
            labels.get(i).setLayoutX(300);
            labels.get(i).setLayoutY(300 + i*50);
        }
        layout.getChildren().addAll(labels);

        for(int i=0;i<buttons.size();i++){
            buttons.get(i).setLayoutX(900 + 150*i);
            buttons.get(i).setLayoutY(700);
        }
        layout.getChildren().addAll(buttons);
        /*
        ImageView img = new ImageView(new Image("https://xvp.akamaized.net/assets/illustrations/happy-laptop-user-girl-ce42c1b1997f0128b89c6c25c55c3446.png"));
        img.setFitHeight(200);
        img.setFitWidth(200);
        img.setLayoutX(65);
        img.setLayoutY(10);
        layout.getChildren().add(img);

        layout.getChildren().add(errorlog);*/
    }
    
    private void cleanPersonalInfoTextFields(){
        firstName.clear();
        lastName.clear();
        cnp.clear();
        address.clear();
        phone.clear();
        email.clear();
        group.clear();
    }
    
    private void handleWindowClosure(){
        window.close();
        new Login();
    }

}
