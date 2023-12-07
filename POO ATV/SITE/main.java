import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

class Website implements Serializable {
    private static final long serialVersionUID = 1L;
    private String description;
    private String url;
    private String registrationDate;

    public Website(String description, String url, String registrationDate) {
        this.description = description;
        this.url = url;
        this.registrationDate = registrationDate;
    }
}

class SiteManager {
    private int nextId = 1;
    private String dataDirectory;

    public SiteManager(String dataDirectory) {
        this.dataDirectory = dataDirectory;
    }

    public void addWebsite(Website site) throws IOException {
        String fileName = dataDirectory + File.separator + nextId + ".data";
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName))) {
            output.writeObject(site);
        }
        nextId++;
    }
}

public class WebsiteRegistrationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SiteManager manager = new SiteManager("data");

        while (true) {
            System.out.println("1. Add Website\n2. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter URL: ");
                    String url = scanner.nextLine();
                    String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    Website website = new Website(description, url, currentDate);
                    try {
                        manager.addWebsite(website);
                        System.out.println("Website added successfully.");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
