package ca.bcit.comp2522.assignment3;

public class Course {
    private String institute;
    private String courseName;

    /**
     * Constructor for Course object.
     * @param newInstitute as a string
     * @param newCourseName as a string
     */
    public Course(final String newInstitute, final String newCourseName) {
        this.institute = newInstitute;
        this.courseName = newCourseName;
    }

    /**
     * Getter for institute variable.
     * @return institute variable
     */
    public String getInstitute() {
        return institute;
    }

    /**
     * Getter for courseName variable.
     * @return courseName variable
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Setter for courseName variable.
     * @param newCourseName as a string
     */
    public void setCourseName(final String newCourseName) {
        courseName = newCourseName;
    }

    /**
     * Setter for institute variable.
     * @param newInstitute as a string
     */
    public void setInstitute(final String newInstitute) {
        institute = newInstitute;
    }
}
