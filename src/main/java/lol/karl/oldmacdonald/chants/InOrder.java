package lol.karl.oldmacdonald.chants;

import lol.karl.oldmacdonald.Animal;
import lol.karl.oldmacdonald.Lines;
import lol.karl.oldmacdonald.RepeatStrategy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * After the new animal call, repeat older animal calls in order
 */
public class InOrder extends RepeatStrategy {

    Deque<Animal> previousAnimals = new ArrayDeque<>();

    @Override
    public String animalCalls(Animal animal, boolean extraSounds) {
        StringBuilder sb = new StringBuilder();

        sb.append(Lines.withABorkBorkHereAndABorkBorkThere(animal));
        if (extraSounds || previousAnimals.isEmpty()) {
            sb.append(Lines.hereABorkThereABorkEverywhereABorkBork(animal));
        }

        for (Animal previousAnimal : previousAnimals) {
            if (extraSounds) {
                sb.append(Lines.borkBorkHereAndABorkBorkThere(previousAnimal));
                sb.append(Lines.hereABorkThereABorkEverywhereABorkBork(previousAnimal));
            } else {
                sb.append(Lines.borkBorkHereBorkBorkThere(previousAnimal));
            }
        }

        previousAnimals.addLast(animal);

        return sb.toString();
    }
}
