public class PotionBrewing {

    static class PotionExplosionException extends Exception {
        public PotionExplosionException(String message) {
            super(message);
        }
    }

    public static void brewPotion(int essenceDrops) throws PotionExplosionException {

        if (essenceDrops > 5) {
            throw new PotionExplosionException("Too many drops! Potion exploded.");
        }
        System.out.println("Potion brewed successfully");
    }

    public static void main(String[] args) {
        try {
            brewPotion(6);   
        } catch (Exception e) {
            System.out.println("Brewing failed: " + e.getMessage());
        }
    }
}
