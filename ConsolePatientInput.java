import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsolePatientInput implements PatientInput{
    private Scanner scan=new Scanner(System.in);

    @Override
    public Patient addPatient() {//реализуем метод интерфейса по добавлению характеристик пациента
        System.out.println("Введите:\nИмя\nФамилию\nДень рожддения формата dd-MM-yyyy");
        String name=scan.nextLine();//спомощью сканера сканируем введенную информацию типа String и записываем её в name
        String secondName=scan.nextLine();//сканируем введенную информацию типа String и записываем её в secondName
        Date birthday=birthday(scan.nextLine());
        boolean healthy=scan.nextBoolean();//сканируем введенную информацию типа boolean и записываем её в healthy
        scan.nextLine();
        return new Patient(name,secondName,birthday,healthy);//метод возращает имя,фамилию, день рождения, здоров/нездоров
    }
    private Date birthday(String birthday){//метод считывает инфоормацию типа String через сканнер
        SimpleDateFormat sdf=new SimpleDateFormat("dd mm yyyy");
        try {
            return sdf.parse(birthday);
        } catch (ParseException e) {
            System.out.println("Неверная дата рождения, повторите ввод");
            return birthday(scan.nextLine());
        }
    }
}
