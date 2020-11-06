package image.compression;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Objects;

public class ImageSource {

    public static String getBase64() {
        String data = null;
        try {
            ClassLoader classLoader = ImageSource.class.getClassLoader();
            Path path = Paths.get(Objects.requireNonNull(classLoader.getResource("image.txt")).toURI());
            System.out.println(path.toFile().exists());
            data = new String(Files.readAllBytes(path));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static byte[] getBytes() {
        byte[] decodedString = null;
        try {
            decodedString = Base64.getDecoder().decode(getBase64().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decodedString;
    }
}
