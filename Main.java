import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        PatientInput patientInput = new ConsolePatientInput();//создаем объект, который может добавлять характеристики пациента
        Patient patientOne = patientInput.addPatient();//...
        Patient patientTwo = patientInput.addPatient();//создаем объект типа Пациент, который реализует объект с добавление характеристик
        System.out.println(patientOne);//...
        System.out.println(patientTwo);//печать пациентов
        PatientBase patientBase = new PatientBase("base.txt");
        patientBase.addAll(patientOne, patientTwo);
        List<Patient> list = patientBase.getAll();
        list.forEach(System.out::println);
    }
}
