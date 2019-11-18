package lol.karl.oldmacdonald;

import lol.karl.oldmacdonald.chants.ReverseOrder;
import lol.karl.oldmacdonald.chants.NoRepeat;
import lol.karl.oldmacdonald.chants.InOrder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

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
    public void testGenerateSongWigglesStyle() {
        SongGenerator generator = new SongGenerator();
        List<Animal> animals = Arrays.asList(
                new Animal("mouse", "squeek"),
                new Animal("cat", "meow"),
                new Animal("cow", "moo"));
        String lyrics = generator.generateLyrics(animals, false, new InOrder());
        log.info(lyrics);
    }
}