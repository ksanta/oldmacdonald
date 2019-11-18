package lol.karl.oldmacdonald;

public abstract class Lines {

    public static String openingOldMacdonaldHadAFarm() {
        return "Old Macdonald had a farm, E-I-E-I-O!\n";
    }

    public static String andOnThisFarmHeHadA(Animal animal) {
        return "And on this farm he had a " + animal.getName() + ", E-I-E-I-O!\n";
    }

    public static String withABorkBorkHereAndABorkBorkThere(Animal animal) {
        return "With a " + animal.getSound() + " " + animal.getSound() + " here and a " + animal.getSound() + " " + animal.getSound() + " there,\n";
    }

    public static String borkBorkHereBorkBorkThere(Animal animal) {
        return animal.getSound() + " " + animal.getSound() + " here, " + animal.getSound() + " " + animal.getSound() + " there,\n";
    }

    public static String borkBorkHereAndABorkBorkThere(Animal animal) {
        return animal.getSound() + " " + animal.getSound() + " here and a " + animal.getSound() + " " + animal.getSound() + " there\n";
    }

    public static String hereABorkThereABorkEverywhereABorkBork(Animal animal) {
        return "Here a " + animal.getSound() + " there a " + animal.getSound() + " everywhere a " + animal.getSound() + " " + animal.getSound() + ",\n";
    }

    public static String closingOldMacdonaldHadAFarm() {
        return "Old Macdonald had a farm, E-I-E-I-O!\n";
    }
}
