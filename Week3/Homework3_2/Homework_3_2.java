public class Homework_3_2 {
    public static void printStudentInfo(Student s) {
        System.out.printf("Name : %s%nAge  : %s%n", s.name, s.age);
    }

    public static boolean isSameAge(Student a, Student b) {
        return a.age == b.age;
    }

    public static Student getYoungestStudent(Student[] students) {
        int index = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].age < students[index].age) index = i;
        }
        return students[index];
    }

    public static double getRectangleArea(Rectangle2 r) {
        return r.width*r.height;
    }

    public static Rectangle2 getSquare(double d) {
        Rectangle2 r = new Rectangle2();
        r.width = d;
        r.height = d;
        return r;
    }

    public static void main(String[] args) {
        Student a = new Student();
        a.name = "Philip";
        a.age = 15;

        Student b = new Student();
        b.name = "George";
        b.age = 16;

        printStudentInfo(a);
        printStudentInfo(b);
        System.out.printf("Are %s and %s the same age? %b%n%n", a.name, b.name, isSameAge(a, b));

        Student students[] = new Student[4];
        students[0] = a;
        students[1] = b;
        students[2] = new Student();
        students[2].name = "Jack";
        students[2].age = 13;
        students[3] = new Student();
        students[3].name = "Lewis";
        students[3].age = 16;

        char c = 'a';
        for (Student s : students) {
            System.out.printf("Student %c%nName : %s%nAge  : %s%n", c, s.name, s.age);
            c++;
        }

        Student youngest = getYoungestStudent(students);
        System.out.printf("The youngest student is %s, which is %d years old%n", youngest.name, youngest.age);

        Rectangle2 r = new Rectangle2();
        r.height = 3.5;
        r.width = 5;

        System.out.println("\nRectangle =\nWidth  : " +  + r.width + "\nHeight : " + r.height);
        System.out.println("The area of the rectangle is " + getRectangleArea(r));

        Rectangle2 square = getSquare(4.0);
        System.out.println("\nSquare =\nWidth  : " +  + square.width + "\nHeight : " + square.height);
    }
}
