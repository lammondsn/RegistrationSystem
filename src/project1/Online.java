package project1;

public class Online extends Course {
    
    public Online(String courseName, int crn, String courseNumber, int sectionNumber, int credithours, String courseType, String instName){
        super(courseName, crn, courseNumber, sectionNumber,  credithours, courseType,  instName);
    }
    
    @Override
    public boolean ConflictsWith(Course Test) {
        return false;
    }
    
    @Override
    public String toString(){
       ///#21722: CS 230-002 (Fundamentals of Computing), Sajib Datta, World Wide Web
       
       return ("#" + super.getCrn() + ":" + super.getCourseNumber() + "(" + super.getCourseName() + ")" + "," + super.getInstName() + ", " 
               + super.getCourseType());

    
    
}
}
