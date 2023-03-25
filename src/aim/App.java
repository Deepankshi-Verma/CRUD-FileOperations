package aim;
import java.util.*;

import services.SearchStudentRequest;
import services.*;


public class App {
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);
        int c;
        StudentServices  student= new StudentServiceImpl();

        StudentRequest studentRequest= new StudentRequest();
        SearchStudentRequest searchStudentRequest = new SearchStudentRequest();
        UpdateStudentRequest updateStudentRequest= new UpdateStudentRequest();
        //student.fileOut();
        student.fileReadString();

        String sName;
        do{
            System.out.println("1.Insert");
            System.out.println("2.Search");
            System.out.println("3.Update");
            System.out.println("4.Display");
            System.out.println("0.Exit");
            System.out.println("Enter your choice: ");
            c= Integer.parseInt(s.nextLine());

            switch(c){

                case 1: // insert 
                    System.out.print("Enter name: ");
                    sName= s.nextLine();
                    studentRequest.setsName(sName);

                    System.out.print("Enter Roll no.: ");
                    String roll= s.nextLine();
                    studentRequest.setsRoll(roll);

                    System.out.print("Enter date of birth in YYYY-MM-DD : ");
                    String sDob= s.nextLine();
                    studentRequest.setDob(sDob);
            
                    System.out.print("Enter gender: ");
                    String sGender= s.nextLine();
                    studentRequest.setsGender(sGender);
            
                    System.out.print("Enter address: ");
                    String sAddress= s.nextLine();
                    studentRequest.setsAddress(sAddress);

                    student.create(studentRequest);
                    break;
                   
                case 2:// search
                    System.out.println("Enter Roll number to be searched");
                    searchStudentRequest.setRollNo(s.nextLine());

                    System.out.println("Enter name  to be searched");
                    searchStudentRequest.setName(s.nextLine());

                    student.search(searchStudentRequest);
                    break;

                case 3:// update
                   System.out.println("enter the roll no. to be updated.");
                   roll= s.nextLine();
                   updateStudentRequest.setRollNo(roll);

                   System.out.print("Enter name: ");
                   sName= s.nextLine();
                   updateStudentRequest.setName(sName);

                   System.out.print("Enter gender: ");
                   sGender= s.nextLine();
                   updateStudentRequest.setGender(sGender);

                   System.out.print("Enter address: ");
                   sAddress= s.nextLine();
                   updateStudentRequest.setAddress(sAddress);

                   student.update(updateStudentRequest);
                   break;

                case 4: // display
                    student.display();
                    break;

                default:System.exit(0);
                  break;         
            }
        }while(c!=0);

        s.close();
    }
}
