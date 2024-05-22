public class Student {
    float averageMark;
    String name;
    String LastName;

    public Student(float averageMark, String name, String lastName) {
        this.averageMark = averageMark;
        this.name = name;
        LastName = lastName;
    }

    public float getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "averageMark=" + averageMark +
                ", name='" + name + '\'' +
                ", LastName='" + LastName + '\'' +
                '}' + "\n";
    }
}
