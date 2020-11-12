package project1;

public abstract class Course {

   
   private String courseName;
   private int crn;   
   private String courseNumber;
   private int sectionNumber;
   private int credithours;
   private String courseType;
   private String instName;

  public Course(String courseName, int crn, String courseNumber, int sectionNumber, int credithours,  
           String courseType, String instName) {
       this.courseName = courseName;
       this.crn = crn;
       this.courseNumber = courseNumber;
       this.sectionNumber = sectionNumber;
       this.credithours = credithours;
       this.courseType = courseType;
       this.instName = instName;
   }

 
   public String getCourseName() {
       return courseName;
   }

  public void setCourseName(String courseName ) {
      this.courseName = courseName;
  }
   public int getCrn() {
       return crn;
   }
   public void setCrn(int crn) {
       this.crn = crn;
   }

 
   public String getCourseNumber() {
       return courseNumber;
   }
   public void setCourseNumber(String CourseNumber) {
       this.courseNumber = CourseNumber;
   }

   public int getSectionNumber() {
       return sectionNumber;
   }
public void setSectionNumber(int SectionNumber) {
    this.sectionNumber = SectionNumber;
}

   public int getCredithours() {
       return credithours;
   }
   
  public void setCredithours(int Credithours) {
      this.sectionNumber = Credithours;
  }

   
   public String getCourseType() {
       return courseType;
   }

   public void setCourseType(String CourseType) {
       this.courseType = CourseType;
   }

   public String getInstName() {
       return instName;
   }

   public void setInstName(String InstName) {
       this.instName = InstName;
       
       
   }
   
    public abstract boolean ConflictsWith(Course Test);

}