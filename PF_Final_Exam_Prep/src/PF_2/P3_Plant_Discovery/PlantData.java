package PF_2.P3_Plant_Discovery;

import java.util.List;

public class PlantData {
    private List<Integer> ratings;
    private int rarity;

    public PlantData(List<Integer> ratings, int rarity) {
        this.rarity = rarity;
        this.ratings = ratings;
    }
    public void addRating(int rating) {
        this.ratings.add(rating);
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public void clearRatings() {
        this.ratings.clear();
    }

    public int getRarity() {
        return rarity;
    }

    public double getAverageRatings() {
        double result = 0;
        for (Integer rating : this.ratings) {
            result += rating;
        }

        if (result == 0) {
            return 0;
        } else {
            return result / this.ratings.size();
        }

    }
}
