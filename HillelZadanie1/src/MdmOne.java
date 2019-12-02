public class MdmOne {

    public static void main(String[] args) {

        Student myStudent = new Student();
        myStudent.name = "Dumanskyi";
        myStudent.group = "QA";
        myStudent.course = 1;


        System.out.println("Name: " + myStudent.name);
        System.out.println("Group: " + myStudent.group);
        System.out.println("Course: " + myStudent.course);
    }

}
