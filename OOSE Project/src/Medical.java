
public class Medical {
	private String id;
	private String name;
	private int quantity;
	private String date;
	private String store;
	
	public Medical(String id, String name, int quantity, String date, String store) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.date = date;
		this.store = store;
	}
	
	public String getID() {
		  return id;
	 }
	
	public String getName() {
		  return name;
	 }
	
	public int getQuantity() {
		  return quantity;
	 }
	
	public String getDate() {
		return date;
	}
	
	public String getStore() {
		  return store;
	 }
}
