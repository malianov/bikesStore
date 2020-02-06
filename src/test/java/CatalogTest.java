import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CatalogTest {
    @BeforeAll
    void setup() throws IOException {
        String inputFile = "ecobike.txt";
        List<String> rawLinesInOriginalFile = Files.readAllLines(Path.of(inputFile));
    }

    @Test
    void TestCreatingFoldingBike() {

    }

}
