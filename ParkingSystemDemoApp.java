import java.util.Scanner;

public class ParkingSystemDemoApp {

	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
		System.out.print("Enter the input : ");
		String input = scan.nextLine();
		ParkingSystem vehicles = new ParkingSystem(input);
		System.out.println("Vehicle final position : "+ vehicles.getEndPosition().getVert_axis() + "," + vehicles.getEndPosition().getHori_axis());
	}

}
