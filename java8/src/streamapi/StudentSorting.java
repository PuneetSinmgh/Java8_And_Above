package java8.src.streamapi;

import java.util.*;

class Student{
    private String name;
    private Date dob;
    private int marks;

             public Student (String name , Date dob){
                this.name = name;
                this.dob = dob;
             }

    @Override
    public boolean equals(Object obj) {
        if ( obj == this)
            return  true;

        if (!( obj instanceof Student))
            return false  ;

        Student s1 = ( Student) obj;

        return this.name.equals( s1.name) && this.dob.equals(s1.dob);
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name , dob);
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }


}

public class StudentSorting {

    public static void main(String[] args) {

        List<Student> sts = List.of(
                new Student( "Ron", new Date( 2008, 3, 6) ),
                new Student( "John", new Date( 2001, 4 ,6) ),
                new Student( "Sun", new Date( 2000, 4 , 6) ),
                new Student( "MAt", new Date( 2008, 7, 9) ),
                new Student( "Jam", new Date( 20009, 4,9) )
        );

        sortStudent(sts).forEach( s -> System.out.print(s.toString()));
    }

    public static List<Student> sortStudent( List<Student> students){

        List<Student> newList = students.stream()
                .distinct()
                .sorted(
                        Comparator.comparing( Student:: getDob)
                                .thenComparing( Student::getName)
                ).toList();
        return newList;
    }


}
