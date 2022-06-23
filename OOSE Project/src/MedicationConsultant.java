
public class MedicationConsultant {
	private String MedicineName;
	private int MedicineAmount;
	private double MedicinePrice;
	
	public MedicationConsultant(String MedicineName, int MedicineAmount, double MedicinePrice) {
		 this.MedicineName = MedicineName;
		 this.MedicineAmount= MedicineAmount;
		 this.MedicinePrice = MedicinePrice; 
	}
	
	 public String getMedicineName() {
		  return MedicineName;
	 }
	
	 public int getMedicineAmount() {
		  return MedicineAmount;
	 }
	
	 public double getMedicinePrice() {
		  return MedicinePrice;
	 }
}
