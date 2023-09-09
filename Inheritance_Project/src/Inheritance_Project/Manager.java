package Inheritance_Project;

public class Manager extends Employee {
    private byte EmployeeCount;

    public byte setEmployeeCount(byte EmployeeCount) {
        this.EmployeeCount = EmployeeCount;
        return EmployeeCount;
    }
    public byte getEmployeeCount() {
        return EmployeeCount;
    }
    

}
