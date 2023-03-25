package services;


import entity.Student;

// buisness logic
public interface StudentServices {

    Student create(StudentRequest request);
    Student search(SearchStudentRequest request);
    Student update(UpdateStudentRequest request);
    void display();

    void fileOut();

    void fileReadString();
}
