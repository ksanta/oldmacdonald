package lol.karl.oldmacdonald.chants;

import lol.karl.oldmacdonald.Animal;
import lol.karl.oldmacdonald.Lines;
import lol.karl.oldmacdonald.RepeatStrategy;

/**
 * Do not repeat the previous animal calls
 */
public class NoRepeat extends RepeatStrategy {

    @Override
    public String animalCalls(Animal animal, boolean extraSounds) {
        return Lines.withABorkBorkHereAndABorkBorkThere(animal) +
                Lines.hereABorkThereABorkEverywhereABorkBork(animal);
    }
}
