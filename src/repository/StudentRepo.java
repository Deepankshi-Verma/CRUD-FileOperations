package repository;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import entity.Student;

public class StudentRepo {
    public StudentRepo(){

    }
    public static List<Student> list = new ArrayList<>();

    static File file= new File("../first.txt");
    static ObjectOutputStream oos = null;
    static ObjectInputStream ois = null;

    public static void fileOp(){
        if(file.isFile()){
            try {
                ois= new ObjectInputStream(new FileInputStream(file));
                list= (ArrayList<Student>) ois.readObject();
                ois.close();
            } catch (IOException e ) {
                throw new RuntimeException(e);
            }catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
   public void fileWrite(Student student){
       //Student st =student.create(req);
        try {
            oos= new ObjectOutputStream(new FileOutputStream(file));
            list.add(student);
            oos.writeObject(list);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
   }

   public void fileWriteThroughString(Student student){
       try {
           FileWriter writer = new FileWriter(file);
           writer.write(student.toString());
           //System.out.println(student.toString());
           writer.close();
           System.out.println("Student object written to file successfully!");
       } catch (IOException e) {
           System.out.println("Error writing to file: " + e);
       }
   }

   public static void fileReadThroughString(){
       try {
           BufferedReader reader = new BufferedReader(new FileReader(file));
           String studentString = reader.readLine();
           System.out.println("Student object from file: \n" + studentString);
           reader.close();
       } catch (IOException e) {
           System.out.println("Error reading from file: " + e);
       }
   }

   public void toTraverseFileByName(String name ){

       List<Student> a= list.stream().filter(e -> e.getName().equalsIgnoreCase(name))
               .collect(Collectors.toList());
       if(a.isEmpty()){
           System.out.println("Student not found");
       }else {
           a.forEach(e -> System.out.println(e));
       }

//       boolean studentFound = false;
//       try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//           String line;
//           while ((line = br.readLine()) != null) {
//               // Check if the current line contains the student name
//               if (line.contains(req.getName())){
//                   studentFound = true;
//                   break;
//               }
//           }
//       } catch (FileNotFoundException e) {
//           throw new RuntimeException(e);
//       } catch (IOException e) {
//           throw new RuntimeException(e);
//       }
//
//       // Print the result
//       if (studentFound) {
//           System.out.println("Student found in the file.");
//       } else {
//           System.out.println("Student not found in the file.");
//       }
   }

    public void traverseRollCreate(String  roll){
        List<Student> a= list.stream().filter(e -> e.getRollNo().equals(roll))
                .collect(Collectors.toList());
        if(!a.isEmpty()){
            System.out.print("The student already present , these are its details");
            a.forEach(e -> System.out.println(e));
            System.exit(0);
        }

    }
   public void toTraverseByRoll(String roll){
       List<Student> a= list.stream().filter(e -> e.getRollNo().equals(roll))
                            .collect(Collectors.toList());
       if(a.isEmpty()){
           System.out.println("Student not found");
       }else {
           a.forEach(e -> System.out.println(e));
       }
   }

    public void searchByBoth(String roll, String name){

        List<Student> a= list.stream().filter(e -> e.getRollNo().equals(roll) && e.getName().equals(name))
                .collect(Collectors.toList());
        if(a.isEmpty()){
            System.out.println("Student not found");
        }else {
            a.forEach(e -> System.out.println(e));
        }
    }

   public void updateStudRepo(Student student){
       list.stream().filter(e-> student.getRollNo().equals(e.getRollNo())).findFirst().map(e -> {
              if(!student.getName().equals(""))
                  e.setName(student.getName());

              if(!student.getGender().equals(""))
                  e.setGender(student.getGender() );

              if(!student.getAddress().equals(""))
                  e.setAddress(student.getAddress());
           return e;
      });

       updateWrite();
   }

    public void updateWrite(){
        try {
            oos= new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(list);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayUtil(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e);
        }
    }


}



