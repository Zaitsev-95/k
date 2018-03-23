import java.util.Date;

public class Patient {
    private String name;
    private String secondName;
    private Date birthday;
    private boolean healthy;//...проля объектов класса Пациент

    public Patient(String name, String secondName, Date birthday, boolean healthy) {
        this.name = name;
        this.secondName = secondName;
        this.birthday = birthday;
        this.healthy = healthy;//...конструктор объектов класса Пациент
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public boolean isHealthy() {
        return healthy;
    }                                 //...геттеры

    @Override
    public String toString() {
        return name +
                ";" + secondName +
                ";" + birthday +
                ";" + healthy;
    }
}                                               //...переоопределённый метод toString
