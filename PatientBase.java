import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientBase {
    private DataOutputStream outputStream;
    private DataInputStream inputStream;
    private String fileName;    //...поля объектов класса PatientBase

    PatientBase(String fileName) {
        this.fileName = fileName;
    }                               //...конструктор объектов класса PatientBase

    public void addAll(Patient... patients) throws IOException {
        try {
            outputStream = new DataOutputStream(new FileOutputStream(fileName));
            for (Patient patient : patients) {
                add(patient);
            }
        } finally {
            outputStream.close();
        }
    }

    private void add(Patient patient) throws IOException {
        outputStream.writeUTF(patient.getName());
        outputStream.writeUTF(patient.getSecondName());
        outputStream.writeLong(patient.getBirthday().getTime());
        outputStream.writeBoolean(patient.isHealthy());
    }

    private Patient get() throws IOException {
        String name=inputStream.readUTF();
        String secondName=inputStream.readUTF();
        Date birthDay=new Date(inputStream.readLong());
        boolean healthy=inputStream.readBoolean();
        return new Patient(name,secondName,birthDay,healthy);
    }

    public List<Patient> getAll() throws IOException {
        try {
            inputStream = new DataInputStream(new FileInputStream(fileName));
            List<Patient> list = new ArrayList<>();
            while (inputStream.available() != 0) {
                list.add(get());
            }
            return list;
        } finally {
            inputStream.close();
        }
    }

}
