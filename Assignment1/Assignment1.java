import java.util.ArrayList;
import java.util.Scanner;

public class Assignment1 {
    public static void main(String [] args){

        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of patients: ");
        int numberOfPatients = in.nextInt();
        Camp camp = new Camp(numberOfPatients);
        in.nextLine();

        for(int i = 0; i<numberOfPatients; i++){

            String s = in.nextLine();
            String[] arr = s.split(" ");
            String name = arr[0];
            float temperature = Float.parseFloat(arr[1]);
            int oxygenLevel = Integer.parseInt(arr[2]);
            int age = Integer.parseInt(arr[3]);

            Patient p = new Patient(name, temperature, oxygenLevel, age);
            camp.addPatient(p);
        }

        while (camp.getNumOnboardPatients()>0){

            System.out.print("Enter query number: ");
            int query = in.nextInt();

            if (query==1){

                System.out.print("Enter name of Health Care Institute: ");
                String name = in.next();
                System.out.print("Temperature Criteria: ");
                float temperatureCriteria = in.nextFloat();
                System.out.print("Oxygen Levels: ");
                int oxygenCriteria = in.nextInt();
                System.out.print("Number of available beds: ");
                int numOfAvailableBeds = in.nextInt();

                Hospital h = new Hospital(name, temperatureCriteria, oxygenCriteria, numOfAvailableBeds);
                camp.addHospital(h);
            }

            else if(query==2)
                Camp.removeAccounts();

            else if(query==3)
                Camp.removeHospital();

            else if(query==4)
                System.out.println(camp.getNumOnboardPatients()+" patients");

            else if(query==5)
                Camp.numOpenHospitals();

            else if(query==6){
                System.out.print("Health Care Institute Name: ");
                String name = in.next();
                camp.displayHospDetails(name);
            }

            else if(query==7){
                System.out.print("Enter the ID of the patient: ");
                int id = in.nextInt();
                camp.displayPatientDetails(id);
            }

            else if(query==8)
                Camp.display();

            else if(query==9){
                System.out.print("Enter Institute name: ");
                String name = in.next();
                Camp.recoveryTime(name);
            }
        }
    }
}

class Patient{
    private final String name;
    private final float temperature;
    private final int oxygenLevel;
    private final int age;
    private static int nextId = 0;
    private final int id;
    private int recoveryDays;
    private Hospital hospital;
    private boolean status;

    {
        hospital = null;
        nextId += 1;
    }

    public Patient(String name, float temperature, int oxygenLevel, int age){
        this.name = name;
        this.temperature = temperature;
        this.oxygenLevel = oxygenLevel;
        this.age = age;
        this.id = nextId;
        this.status = false;
    }

    public int getId() {
        return id;
    }

    public void setStatus(){
        this.status = true;
    }

    public boolean getStatus() {
        return status;
    }

    public int getOxygenLevel() {
        return oxygenLevel;
    }

    public float getTemperature() {
        return temperature;
    }

    public String getName(){
        return this.name;
    }

    public void setRecoveryDays(int recoveryDays) {
        this.recoveryDays = recoveryDays;
    }

    public void setHospital(Hospital h){
        this.hospital = h;
    }

    public Hospital getHospital(){
        return this.hospital;
    }

    public int getRecoveryDays() {
        return recoveryDays;
    }
}

class Hospital{
    private final String name;
    private final float tempCriteria;
    private final int oxyCriteria;
    private final int availableBeds;
    private boolean status;
    private ArrayList<Patient> admittedPatients;

    public Hospital(String name, float tempCriteria, int oxyCriteria, int availableBeds){
        this.name = name;
        this.tempCriteria = tempCriteria;
        this.oxyCriteria = oxyCriteria;
        this.availableBeds = availableBeds;
        this.status = true;
        this.admittedPatients = new ArrayList<>();
    }

    public int getAllBeds(){
        return this.availableBeds;
    }

    public int getAvailableBeds() {
        return availableBeds-admittedPatients.size();
    }

    public int getOxyCriteria() {
        return oxyCriteria;
    }

    public float getTempCriteria(){
        return tempCriteria;
    }

    public void admitPatient(Patient p){
        admittedPatients.add(p);
    }

    public boolean isEmpty(){
        if(admittedPatients.size()==availableBeds){
            status = false;
            return status;
        }
        return status;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Patient> getAdmittedPatients() {
        return admittedPatients;
    }
}

class Camp{
    private int numOnboardPatients;
    private static ArrayList<Patient> allPatients;
    private static ArrayList<Patient> patients;
    private static ArrayList<Hospital> hospitals;
    private static ArrayList<Patient> admittedPatients;

    public Camp(int numOnboardPatients){
        this.numOnboardPatients = numOnboardPatients;
        patients = new ArrayList<>();
        hospitals = new ArrayList<>();
        admittedPatients = new ArrayList<>();
        allPatients = new ArrayList<>();
    }

    public void addPatient(Patient p){
        patients.add(p);
        allPatients.add(p);
    }

    public int getNumOnboardPatients(){
        return numOnboardPatients;
    }

    public void addHospital(Hospital h){
        hospitals.add(h);
        if(h.getAllBeds()>0) {
            int oxygenLevels = h.getOxyCriteria();
            float tempLevels = h.getTempCriteria();
            ArrayList<Patient> addedPatients = new ArrayList<>();
            int sze = patients.size();

            for (int i = 0; i < sze; i++) {
                Patient p = patients.get(i);
                int pOxyLevel = p.getOxygenLevel();
                if (pOxyLevel >= oxygenLevels) {
                    h.admitPatient(p);
                    numOnboardPatients -= 1;
                    p.setHospital(h);
                    p.setStatus();
                    addedPatients.add(p);

                    admittedPatients.add(p);
                    if (!h.isEmpty())
                        break;
                }

            }

            for (int i = 0; i < admittedPatients.size(); i++) {
                int id1 = admittedPatients.get(i).getId();
                for (int j = 0; j < patients.size(); j++) {
                    int id2 = patients.get(j).getId();
                    if (id1 == id2) {
                        patients.remove(j);
                        break;
                    }
                }
            }

            int sze0 = patients.size();

            if (h.isEmpty()) {
                for (int i = 0; i < sze0; i++) {

                    Patient p;
                    p = patients.get(i);
                    float pTempLevel = p.getTemperature();
                    if (pTempLevel <= tempLevels) {
                        h.admitPatient(p);
                        numOnboardPatients -= 1;
                        p.setHospital(h);
                        p.setStatus();
                        addedPatients.add(p);

                        admittedPatients.add(p);
                        if (!h.isEmpty())
                            break;
                    }
                }
            }

            for (int i = 0; i < admittedPatients.size(); i++) {
                int id1 = admittedPatients.get(i).getId();
                for (int j = 0; j < patients.size(); j++) {
                    int id2 = patients.get(j).getId();
                    if (id1 == id2) {
                        patients.remove(j);
                        break;
                    }
                }
            }

            System.out.println(h.getName());
            System.out.println("Temperature should be <= " + h.getTempCriteria());
            System.out.println("Oxygen levels should be >= " + h.getOxyCriteria());
            System.out.println("Number of available beds: " + h.getAllBeds());
            System.out.println("Admission Status: OPEN");

            Scanner in = new Scanner(System.in);
            for (int i = 0; i < addedPatients.size(); i++) {
                Patient p = addedPatients.get(i);
                System.out.print("Recovery days for patient ID " + p.getId() + ": ");
                int recoveryDays = in.nextInt();
                p.setRecoveryDays(recoveryDays);
            }
        }
        else{
            System.out.println(h.getName());
            System.out.println("Temperature should be <= " + h.getTempCriteria());
            System.out.println("Oxygen levels should be >= " + h.getOxyCriteria());
            System.out.println("Number of available beds: " + h.getAllBeds());
            System.out.println("Admission Status: CLOSED");
        }
    }

    public static void removeAccounts(){
        int size = admittedPatients.size();
        for(int i = 0; i<size; i++){
            Patient p = admittedPatients.get(i);
            System.out.println(p.getId());
        }
        for(int i = 0; i<size; i++){
            admittedPatients.remove(0);
        }
    }

    public static void removeHospital(){
        int size = hospitals.size();
        for(int i = 0; i<size; i++){
            if(!hospitals.isEmpty()){
                Hospital hospital = hospitals.get(0);
                if(!hospital.isEmpty()){
                    System.out.println(hospital.getName());
                    hospitals.remove(0);
                }
            }
        }
    }

    public static void numOpenHospitals(){
        int size = hospitals.size();
        int count = 0;
        for(int i = 0; i<size; i++){
            Hospital hospital = hospitals.get(i);
            if(hospital.isEmpty()){
                count+=1;
            }
        }
        if(count<2){
            System.out.println(count+" institute is admitting patients currently.");
        }
        else
            System.out.println(count+" institutes are admitting patients currently.");
    }

    public void displayHospDetails(String hospital){
        for(int i = 0; i< hospitals.size(); i++){
            Hospital h = hospitals.get(i);
            String s = h.getName();
            if(s.equalsIgnoreCase(hospital)){
                System.out.println(s);
                System.out.println("Temperature should be <= "+h.getTempCriteria());
                System.out.println("Oxygen should be >= "+h.getOxyCriteria());
                System.out.println("Number of vacant beds: "+h.getAvailableBeds());
                if(h.isEmpty())
                    System.out.println("Admission status: OPEN");
                else
                    System.out.println("Admission status: CLOSED");
            }
        }
    }

    public void displayPatientDetails(int ID){

        boolean flag = false;
        for(int i = 0; i<patients.size(); i++){
            Patient patient = patients.get(i);
            if(patient.getId()==ID){
                System.out.println(patient.getName());
                System.out.println("ID number: "+ID);
                System.out.println("Temperature: "+patient.getTemperature());
                System.out.println("Oxygen level: "+patient.getOxygenLevel());
                if(patient.getStatus()){
                    System.out.println("Admission status: Admitted");
                    System.out.println("Admitted in "+patient.getHospital().getName());
                }
                else{
                    System.out.println("Admission status: Not admitted");
                }
                flag = true;
                break;
            }
        }

        if(!flag){
            for(int i = 0; i<admittedPatients.size(); i++){
                Patient patient = admittedPatients.get(i);
                if(patient.getId()==ID){
                    System.out.println(patient.getName());
                    System.out.println("ID number: "+ID);
                    System.out.println("Temperature: "+patient.getTemperature());
                    System.out.println("Oxygen level: "+patient.getOxygenLevel());
                    if(patient.getStatus()){
                        System.out.println("Admission status: Admitted");
                        System.out.println("Admitted in "+patient.getHospital().getName());
                    }
                    else{
                        System.out.println("Admission status: Not admitted");
                    }
                }
            }
        }


    }

    public static void display(){
        for(int i = 0; i< patients.size(); i++){
            Patient p = patients.get(i);
            System.out.println("Name: "+p.getName()+", ID: "+p.getId());
        }
        for(int i = 0; i<admittedPatients.size(); i++){
            Patient p = admittedPatients.get(i);
            System.out.println("Name: "+p.getName()+", ID: "+p.getId());
        }
    }

    public static void recoveryTime(String name){
        for(int i = 0; i< hospitals.size(); i++){
            Hospital hospital = hospitals.get(i);
            String name1 = hospital.getName();
            if(name.equalsIgnoreCase(name1)){
                ArrayList<Patient> patients = hospital.getAdmittedPatients();
                for(int j = 0; j<patients.size(); j++){
                    Patient patient = patients.get(j);
                    System.out.println(patient.getName()+", recovery time: "+ patient.getRecoveryDays()+" days");
                }
                break;
            }
        }
    }
}