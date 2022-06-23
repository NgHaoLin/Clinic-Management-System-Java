import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Prescription {

	private Date datenow;
	private String Custname;
	private String DocName;
	private boolean McProvided;
	private int McDays;
	private double ConsultantFees;
	
	public Prescription(Date datenow, String Custname, String DocName, boolean McProvided, int McDays, double ConsultantFees){
		 this.datenow= datenow;
		 this.Custname = Custname;
		 this.DocName = DocName;
		 this.McProvided =McProvided;
		 this.McDays =McDays;
		 this.ConsultantFees = ConsultantFees;
	}
	
	public Date getDate() {
		  return datenow;
	 }
	
	public String getCustname() {
		  return Custname;
	 }
	
	public String getDocName() {
		  return DocName;
	 }
	
	public boolean getMcProvided() {
		  return McProvided;
	 }
	
	public int getMcDays() {
		  return McDays;
	 }
	
	public double getConsultantFees() {
		  return ConsultantFees;
	 }
}