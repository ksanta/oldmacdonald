package lol.karl.oldmacdonald;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import lol.karl.oldmacdonald.chants.ReverseOrder;
import lol.karl.oldmacdonald.chants.NoRepeat;
import lol.karl.oldmacdonald.chants.InOrder;
import lol.karl.oldmacdonald.polly.PollyClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class SongGeneratorTest {

    @Test
    public void testGenerateSongAllInReverse() {
        SongGenerator generator = new SongGenerator();
        List<Animal> animals = Arrays.asList(
                new Animal("mouse", "squeek"),
                new Animal("cat", "meow"),
                new Animal("cow", "moo"));
        String lyrics = generator.generateLyrics(animals, true, new ReverseOrder());
        log.info(lyrics);
    }

    @Test
    public void testGenerateSongNoRepeats() {
        SongGenerator generator = new SongGenerator();
        List<Animal> animals = Arrays.asList(
                new Animal("mouse", "squeek"),
                new Animal("cat", "meow"),
                new Animal("cow", "moo"));
        String lyrics = generator.generateLyrics(animals, true, new NoRepeat());
        log.info(lyrics);
    }

    @Test
    public void testGenerateSongInOrder() {
        SongGenerator generator = new SongGenerator();
        List<Animal> animals = Arrays.asList(
                new Animal("mouse", "squeek"),
                new Animal("cat", "meow"),
                new Animal("cow", "moo"));
        String lyrics = generator.generateLyrics(animals, true, new InOrder());
        log.info(lyrics);
    }

    @Test
    public void testGenerateSongWigglesStyleWithPolly() throws IOException {
        SongGenerator generator = new SongGenerator();
        List<Animal> animals = Arrays.asList(
                new Animal("mouse", "squeek"),
                new Animal("cat", "meow"),
                new Animal("cow", "moo"));
        String lyrics = generator.generateLyrics(animals, false, new InOrder());
        log.info(lyrics);

        PollyClient pollyClient = new PollyClient(Region.getRegion(Regions.AP_SOUTHEAST_2));
        pollyClient.synthesize(lyrics, "target/old_macdonald.mp3");
    }
}