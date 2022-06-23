
public class Index {
	
	public static void main(String[] args) {
		Screen_Login screenLogin = new Screen_Login();
		Controller controller = new Controller(screenLogin);
		controller.SystemStart();
	}
}
