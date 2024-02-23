public class Student {
    String name;
    int age;
    String gender;
    String yearlevel;
    String course;
    String section;

    public Student(String name, int age, String gender, String yearlevel, String course, String section) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.yearlevel = yearlevel;
        this.course = course;
        this.section = section;
    }

    void Introduce() {
        System.out.println("Hello my name is " + name + " and I am " + age + " years old." + " I am currently a " + yearlevel + " in " + course + " and my section is " + section + ".");
    }

void dialogue(String name1, String name2) {
    System.out.println(name1 + ": " + "Hello how are you today " + name2 + "?");
}
}
