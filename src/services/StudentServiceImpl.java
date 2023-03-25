package services;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


import entity.Student;
import repository.StudentRepo;


public class StudentServiceImpl implements StudentServices{

    String sDob;
    StudentRepo str = new StudentRepo();
    Student student = new Student();

     public Student create(StudentRequest request){
        String sName= request.getsName();
        if(!sName.matches("(?:[A-Z][a-z]*)") ){
            System.out.println("please enter a valid name with capital or small alphabets.");
            System.exit(0);
        }

        String roll=request.getsRoll();
        str.traverseRollCreate(roll);
         if(!roll.matches("[0-9]+")) {
             System.out.println("Enter valid Number");
             System.exit(0);
         }


        String sGender=request.getsGender();  
        if(!sGender.matches("(?:m|M|male|Male|f|F|female|Female|FEMALE|MALE|Not prefer to say$)")) {
            System.out.println("Enter either m,M,male,Male,f,F,female,Female,FEMALE,MALE,Not prefer to say");
            System.exit(0);
        }

        LocalDate dob = null;
        try{
         sDob=request.getDob();
         dob= LocalDate.parse(sDob);
        }catch(DateTimeParseException e ){
            System.out.println("Enter date in specified format");
            System.exit(0);
        }

        String sAddress=request.getsAddress();

        student = new Student(roll,sName,dob,sGender,sAddress);
        str.fileWriteThroughString(student);
        //str.fileWrite(student);
        return student ;
    }

    public Student search(SearchStudentRequest request1){

        String roll= request1.getRollNo();
        String name = request1.getName();

        if(!roll.equals("") && !name.equals("")){
            str.searchByBoth(roll, name);
        }

        else if(!roll.equals("")){
             str.toTraverseByRoll(roll);
        } else if(!name.equals(" ")){
            str.toTraverseFileByName(name);
        }

         return student ;
    }

    public Student update(UpdateStudentRequest request){

        String sRoll= request.getRollNo();
        String sName= request.getName();
        String sGender= request.getGender();
        String sAddress= request.getAddress();

        student = new Student(sRoll,sName,sGender,sAddress);
        str.updateStudRepo(student);
        return student;
    }

    public void display(){
         str.displayUtil();
//        System.out.println("---------------------------");
//        repository.StudentRepo.list.stream().forEach(e->System.out.println(e));
//        System.out.println("---------------------------");
    }

    public void fileOut(){
        repository.StudentRepo.fileOp();
    }

    public void fileReadString(){
         repository.StudentRepo.fileReadThroughString();
    }
    
    
}

