import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Normal {
    public static void main(String[] args) throws IOException {
        List<String> l = new ArrayList<>();
        DocEditor doc = new DocEditor(l);

        doc.addText("hello");
        doc.addImg("img2.png");
        doc.addText("world");
        doc.renderDoc();
        doc.saveToFile();
        doc.readFromFile();

    }
}

class DocEditor {
    List<String> elements;
    String renderDoc = "";

    public DocEditor(List<String> elements) {
        this.elements = elements;
    }

    public void addText(String txt) {
        elements.add(txt);
    }

    // just adding image name will add path later of the image
    public void addImg(String img) {
        elements.add("[Image : " + img + " ]");
    }

    // printing what in the doc
    public void renderDoc() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (String s : elements) {
            sb.append(s);
            sb.append("\n");
        }

        renderDoc = sb.toString();
    }

    public void saveToFile() {
        Path path = Paths.get("example.txt");

        try {
            // Write to a file (Creates file automatically)
            Files.writeString(path, renderDoc);
            System.out.println("File written successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        Path path = Paths.get("example.txt");

        try {
            // Read from a file
            List<String> allLines = Files.readAllLines(path);
            System.out.println("\n--- Reading File Content ---");
            for (String line : allLines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}