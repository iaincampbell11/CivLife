package civLife;

public class menus {




	public void mainMenu(String civName, int year, int month) {
		System.out.println();
		System.out.println("       MENU              " + civName + "'s" + " civilization");
		System.out.println("-----------------------------------------------");
		System.out.println("(V)iew Rescources		 Y: " + year + "  " + "M: " + month);
		System.out.println("(G)ather Resources");
		System.out.println("(P)opulation");
		System.out.println("(B)uildings");
		System.out.println("(A)cquire Buildings");
		System.out.println("(H)elp");
		System.out.println("(E)xit");
		
	}

	public void helpMenu() {
		System.out.println("What do you need help with? Choose a Category");
		System.out.println("-------------------------------------------------");
		System.out.println("(T)he Game");
		System.out.println("(G)ather Resources");
		System.out.println("(P)opulation");
		System.out.println("(B)uildings");
		System.out.println("(A)cquire Buildings");
	}
}
