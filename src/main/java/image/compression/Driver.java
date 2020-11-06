package image.compression;

public class Driver {

    public static void main(String[] args) {
        byte[] bytes = ImageSource.getBytes();
        System.out.println("original size: "+ bytes.length);
        byte[] compressedImage = ImageUtils.compressImage(bytes);
        System.out.println("compressed size: "+ compressedImage.length);
    }
}
