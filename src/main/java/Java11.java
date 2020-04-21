import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;

public class Java11 {
    public static void main(String[] args) throws Exception {
        //Lambda and var
        Function<String,String> test = (var string) -> string + " World";
        String s = test.apply("Hello");
        System.out.println(s);

        //String add repeat function
        var str = "123 ";
        var repeated = str.repeat(3);
        System.out.println(repeated);

        //file read and write
        Path path = null;
        path = Files.writeString(Files.createTempFile("test",".txt"),"test");
        System.out.println(path);
        String fileString = Files.readString(path);
        System.out.println(fileString);
    }
}
