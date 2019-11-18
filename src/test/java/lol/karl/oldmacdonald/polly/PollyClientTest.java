package lol.karl.oldmacdonald.polly;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import org.junit.Test;

import java.io.IOException;

public class PollyClientTest {

    @Test
    public void testPollyClient() throws IOException {
        PollyClient client = new PollyClient(Region.getRegion(Regions.AP_SOUTHEAST_2));
        client.synthesize("Hello world!", "target/output.mp3");
    }
}