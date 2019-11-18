package lol.karl.oldmacdonald;

import java.util.List;

public class SongGenerator {

    public String generateLyrics(List<Animal> animals, boolean extraSounds, RepeatStrategy repeatStrategy) {
        StringBuilder sb = new StringBuilder();

        for (Animal animal : animals) {
            sb.append(generateVerseForAnimal(animal, extraSounds, repeatStrategy));
        }

        // Slow final line to wrap up the song
        sb.append(Lines.closingOldMacdonaldHadAFarm());

        return sb.toString();
    }

    private String generateVerseForAnimal(Animal animal, boolean extraSounds, RepeatStrategy repeatStrategy) {
        StringBuilder sb = new StringBuilder();

        sb.append(Lines.openingOldMacdonaldHadAFarm());
        sb.append(Lines.andOnThisFarmHeHadA(animal));
        sb.append(repeatStrategy.animalCalls(animal, extraSounds));
        sb.append(Lines.closingOldMacdonaldHadAFarm());

        return sb.toString();
    }
}
