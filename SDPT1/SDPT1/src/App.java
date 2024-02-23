public class App {
    public static void main(String[] args) throws Exception {
        
        Student s1 = new Student("John Daniel Binegas",23, "Male", "2nd Year", "BS Computer Science", "C231");
        Student s2 = new Student("Trisha Anne dineros", 21, "Female", "2nd Year", "BS Computer Science", "C231");
        System.out.println("");
        s1.Introduce();
        System.out.println("");
        s2.Introduce();
        
    }
}
