import java.util.Scanner;
import java.util.ArrayList;

public class LibraryCatalog {

	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Device> deviceList = new ArrayList<>();

	static int count = 1;

	public static void main(String[] args) {

		LibraryCatalog catalog = new LibraryCatalog();

		catalog.displayHeader("\n\n");
		catalog.displayMenu();
	}

	// method for displaying the header. also allows for appending a String to the
	// end of the header to show which menu item was selected
	private void displayHeader(String append) {

		System.out.print("\t\t\tLibrary Device Checkout System" + append);
	}

	// method to display the menu. switch statement to call on certain methods
	// depending on which menu item was selected. if menu item 7 is selected, the
	// loop and program terminate
	private void displayMenu() {

		int menuOption = 0;
		int numberOfErrors = 0;
		boolean repeatInput = false;

		loadSampleData();

		do {

			System.out.println("1. List Devices by Title");
			System.out.println("2. Add New Devices");
			System.out.println("3. Edit Device Information");
			System.out.println("4. Search by Device Name");
			System.out.println("5. Check Out Devices");
			System.out.println("6. Check In Devices");
			System.out.println("7. Exit");

			System.out.print("\nSelect menu options 1-7: ");
			menuOption = Integer.parseInt(scanner.nextLine());

			switch (menuOption) {
			case 1:
				displayHeader(" - List\n\n");
				listCatalog();
				scanner.nextLine();
				break;
			case 2:
				displayHeader(" - Add New Device\n\n");
				addNewDevice();
				scanner.nextLine();
				break;
			case 3:
				displayHeader(" - Edit Device Information\n\n");
				editDevice();
				scanner.nextLine();
				break;
			case 4:
				displayHeader(" - Search\n\n");
				searchDevice();
				scanner.nextLine();
				break;
			case 5:
				displayHeader(" - Check Out Device\n\n");
				checkOut();
				scanner.nextLine();
				break;
			case 6:
				displayHeader(" - Check In Device\n\n");
				checkIn();
				scanner.nextLine();
				break;
			case 7:
				System.exit(0);
			}

		} while (menuOption != 7);
	}

	// method to load the hard coded sample data
	private void loadSampleData() {

		Device device1 = new Device("6757A", "Apple 9.7-inch iPad Pro", true);
		Device device2 = new Device("93P51B", "Amazon Kindle Fire Kids Edition", true);
		Device device3 = new Device("10N8C", "LeapFrog Epic Learning Tablet", true);
		Device device4 = new Device("85U2O", "Amazon Kindle Fire HD 8", false);
		Device device5 = new Device("91H2D", "HP Envy 8 Note", true);

		deviceList.add(device1);
		deviceList.add(device2);
		deviceList.add(device3);
		deviceList.add(device4);
		deviceList.add(device5);
	}

	// method to list the catalog of current items, their sku, and availability
	private void listCatalog() {

		for (Device d : deviceList) {

			System.out.printf("%d %-10s %-35s %s\n", deviceList.indexOf(d) + 1, d.getDeviceSku(), d.getDeviceName(),
					d.getDeviceAvailability());
		}
	}

	// method that allows the user to enter a new device. the user is prompted to
	// enter the SKU of the item as well as the item name
	private void addNewDevice() {

		Device tmpDevice = new Device();

		System.out.print("SKU: ");
		tmpDevice.setDeviceSku(scanner.nextLine().toUpperCase());

		System.out.print("Name: ");
		tmpDevice.setDeviceName(scanner.nextLine());

		deviceList.add(tmpDevice);

		System.out.printf("Added %s to the catalog\n", tmpDevice.getDeviceName());
		System.out.println("Press Enter to continue...");
		scanner.nextLine();
	}

	// method that allows the user to edit the SKU and name of any item that is
	// currently listed in the catalog
	private void editDevice() {

		int deviceEdit;
		String deviceSku;
		String deviceName;

		listCatalog();

		System.out.print("Enter device number to edit: ");
		deviceEdit = Integer.parseInt(scanner.nextLine());

		System.out.print("SKU: ");
		deviceSku = scanner.nextLine();

		System.out.print("Name: ");
		deviceName = scanner.nextLine();

		deviceList.get(deviceEdit - 1).setDeviceSku(deviceSku);
		deviceList.get(deviceEdit - 1).setDeviceName(deviceName);
	}

	// method that allows the user to search the catalog for keywords. if the
	// keyword matches an item in the catalog, those item(s) are returned to the
	// user
	private void searchDevice() {

		String search;

		System.out.print("Enter Device to search for: ");
		search = scanner.nextLine().toLowerCase();

		System.out.printf("\nListings for '%s'\n", search);

		for (Device d : deviceList) {

			if (d.getDeviceName().toLowerCase().contains(search)) {
				System.out.printf("%d %s %s\n", deviceList.indexOf(d) + 1, d.getDeviceSku(), d.getDeviceName());
			}
		}
	}

	// method that allows the user to check out items. the item is then listed as
	// checked out
	private void checkOut() {

		int deviceNumber;

		System.out.println("Available Devices\n");

		for (Device d : deviceList) {

			if (d.getDeviceAvailability().equalsIgnoreCase("Available")) {
				System.out.printf("%d %-10s %-35s\n", deviceList.indexOf(d) + 1, d.getDeviceSku(), d.getDeviceName());
			}
		}

		System.out.print("Enter Device number: ");
		deviceNumber = Integer.parseInt(scanner.nextLine());

		deviceList.get(deviceNumber - 1).setDeviceAvailability(false);
	}

	// method that allows the user to check in items. the item is then listed as
	// available
	private void checkIn() {

		int deviceNumber;

		System.out.println("Checked Out Devices\n");

		for (Device d : deviceList) {

			if (d.getDeviceAvailability().equalsIgnoreCase("Checked Out")) {
				System.out.printf("%d %-10s %-35s\n", deviceList.indexOf(d) + 1, d.getDeviceSku(), d.getDeviceName());
			}
		}

		System.out.print("Enter Device number: ");
		deviceNumber = Integer.parseInt(scanner.nextLine());

		deviceList.get(deviceNumber - 1).setDeviceAvailability(true);
	}

}
