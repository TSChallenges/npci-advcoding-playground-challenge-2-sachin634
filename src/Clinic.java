import java.util.Queue;
import java.util.LinkedList;   // LinkedList also implements Queue
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class Clinic {

    private Queue<Patient> patientQueue;
    private Set<Patient> admittedPatients;
    private int dayCount;
    private int appointmentLimit ;
    

    // Constructor to initialize the clinic with a queue and a set of admitted patients
    public Clinic() {
        this.patientQueue = new LinkedList<>();       // no patient in queue yet
        this.admittedPatients = new HashSet<>();      // no patient admitted yet
        this.dayCount = 1;    // Start with Day 1
        this.appointmentLimit =3; // Appointment limit 
    }


    // Admit a patient to the clinic
    public void admitPatient(Patient patient) {
        // Add the patient to the queue and print "Patient <name> admitted."
    	if(patient!=null) {
    	
    	admittedPatients.add(patient);
    	patientQueue.add(patient);
    	System.out.println("Patient "+patient.getName()+" admitted");
        // TODO
    }
    	else {
        	System.out.println("Patient Object is null");

    	}
    }

    // Schedule appointments (maximum 3 patients per day)
    public void getSchedule() {
        // Assign appointment day to patients(eg. Day 1, Day 2, and so on) as per their order in queue. 
        // Give appointment to maximum 3 patients per day.
        // Once appointment is given to a patient, add that patient to `admittedPatients` set. Also, print "Scheduled <name> on <appointmentDay>"

        // TODO
    	
    	List<Patient> patientScheduleData = new LinkedList<Patient>(patientQueue);
    	int iteratingFirstIndex = (dayCount-1)*appointmentLimit ; 
    	int iteratingLastIndex = dayCount*appointmentLimit;
    	System.out.println("Scheduling appointments for Day "+dayCount+"..");
    	for(int i=iteratingFirstIndex ; i<iteratingLastIndex && i<patientScheduleData.size() ;i++) {
    		System.out.println("Scheduled "+patientScheduleData.get(i).getName()+"on Day "+dayCount);
    	}
    	dayCount++;
    	
    	
    	
    }


    // Provide treatment or prescription for a patient after their appointment
    public void providedTreatment(Patient patient, String treatment) {
        // Provide treatment to a patient only if the patient is admitted. Print "Treatment provided to <name>: <treatment>"
        // Else print "Patient not found in the admitted list."
        
        // TODO
    	
    	if( patientQueue.contains(patient)) {
    		System.out.println("Treatment provided to "+patient.getName()+":"+treatment);
    	}
    	else {
    		System.out.println("Patient not found in the admitted list.");
    	}
    }

    // Get the details of a patient
    public void getPatientDetails(Patient patient) {
        // Print patient details only if the patient is admitted.
        // Else print "Patient not found in the admitted list."
        
        // TODO
    	
    	if( patientQueue.contains(patient)) {
    		System.out.println("patient details : "+patient.toString());
    	}
    	else {
    		System.out.println("Patient not found in the admitted list.");
    	}
    	
    }
    


    // Get the appointment details of a patient
    public void getAppointmentDetails(Patient patient) {
        // Print appointment details of a patient only if the patient is admitted. "Appointment Details: <name> is scheduled on <appointmentDay>"
        // Else print "Patient not found in the admitted list."
        
        // TODO
    		
    	
    	List<Patient> patientScheduleData = new LinkedList<Patient>(patientQueue);
    	int i=0;
    	boolean Notfound = true;
    	for(Patient patientAppointment :patientScheduleData){
    		if(patientAppointment.equals(patient)) {
    			Notfound=false;
    			System.out.println("Appointment Details:"+patientAppointment.getName()+" is scheduled on Day "+((i/appointmentLimit)+1));
    			break;
    		}
    		i++;
    	}
    	if(Notfound) {
    		System.out.println("Patient not found in the admitted list.");
    	}
    	
    }


    // Discharge a patient from the clinic
    public void dischargePatient(Patient patient) {
        // Remove the patient from admitted patients list. Print "Patient <name> discharged."
    	boolean patientRemove =  patientQueue .remove(patient);
    	admittedPatients.remove(patient);
    	
    	if(patientRemove) {
    		System.out.println("Patient "+patient.getName()+" discharged.");
    	}
    	else {
    		System.out.println("Patient "+patient.getName()+"not discharged.");
    	}
        // TODO
    }
}
