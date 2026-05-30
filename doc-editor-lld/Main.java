import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Document document = new Document();

        DocEditor editor = new DocEditor(document);

        editor.addText("Hello");
        editor.addImg("img2.png");
        editor.addText("World");

        DocumentRenderer renderer = new DocumentRenderer();
        renderer.render(document);

        Persistence persistence = new FilePersistence();
        persistence.save(document);

        ((FilePersistence) persistence).read();
    }
}

interface DocElement {
    String render();
}

class TextElement implements DocElement {

    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}

class ImageElement implements DocElement {

    private String path;

    public ImageElement(String path) {
        this.path = path;
    }

    @Override
    public String render() {
        return "[Image : " + path + "]";
    }
}

class Document {

    private List<DocElement> elements = new ArrayList<>();

    public void addElement(DocElement element) {
        elements.add(element);
    }

    public List<DocElement> getElements() {
        return elements;
    }
}

class DocEditor {

    private Document document;

    public DocEditor(Document document) {
        this.document = document;
    }

    public void addText(String text) {
        document.addElement(new TextElement(text));
    }

    public void addImg(String path) {
        document.addElement(new ImageElement(path));
    }
}

class DocumentRenderer {

    public void render(Document document) {

        System.out.println("----- Document -----");

        for (DocElement element : document.getElements()) {
            System.out.println(element.render());
        }

        System.out.println("--------------------");
    }
}

interface Persistence {
    void save(Document document);
}

class FilePersistence implements Persistence {

    private static final String FILE_NAME = "example.txt";

    @Override
    public void save(Document document) {

        StringBuilder sb = new StringBuilder();

        for (DocElement element : document.getElements()) {
            sb.append(element.render()).append("\n");
        }

        try {
            Files.writeString(Paths.get(FILE_NAME), sb.toString());
            System.out.println("File saved successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() {

        try {
            List<String> lines =
                    Files.readAllLines(Paths.get(FILE_NAME));

            System.out.println("\n----- File Content -----");

            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}