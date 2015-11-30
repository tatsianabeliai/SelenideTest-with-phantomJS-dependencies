package helpers;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class Helpers {
    public static List<String> readAllLines(String resourcePath) throws IOException {
        return Files.readAllLines(new File(resourcePath).toPath(), Charset.defaultCharset());
    }
}
