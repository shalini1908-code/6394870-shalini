import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Scanner;

interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;
    private BufferedImage image;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk: " + filename);
        try {
            File file = new File(filename);
            image = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    @Override
    public void display() {
        if (image != null) {
            System.out.println("Displaying image: " + filename);
        } else {
            System.out.println("No image to display.");
        }
    }
}

class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

public class ProxyPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the image filename to display: ");
        String filename = scanner.nextLine();

        Image image = new ProxyImage(filename);

        image.display();

        scanner.close();
    }
}
