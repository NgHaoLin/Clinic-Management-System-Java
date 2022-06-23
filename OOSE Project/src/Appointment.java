
public class Appointment {
	private String PatientName;
    private String DoctorName;
    private String Date ;
    private String Time ;
    private String Memo;
    
    public Appointment(String PatientName, String DoctorName, String Date, String Time, String Memo) {
    	this.PatientName = PatientName;
    	this.DoctorName = DoctorName;
    	this.Date = Date;
    	this.Time = Time;
    	this.Memo = Memo;
    }
    
    public String getPatientName() {
		  return PatientName;
	 }
	
	public String getDoctorName() {
		  return DoctorName;
	 }
	
	public String getDate() {
		  return Date;
	 }
	
	public String getTime() {
		return Time;
	}
	
	public String getMemo() {
		  return Memo;
	 }
}
