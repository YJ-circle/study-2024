package studyfrontpattern.files;

public class Dispatcher {
	private static StudentView studentView = new StudentView();
	private static HomeView homeView = new HomeView();
	
	public void dispatch(String req) {
		switch (req.toLowerCase()) {
		case "student":
			studentView.show();
			break;
		case "home":
			homeView.show();
		default:
			break;
		}
	}
}
