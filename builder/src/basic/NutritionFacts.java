package basic;

/**
 * 必须参数：servingSize、servings
 * 可选参数：calories、fat、sodium
 * 要求这个类是不可变的
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;

    private final int calorise;

    private final int fat;

    private final int sodium;

    private NutritionFacts(NutritionFacts.Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calorise = builder.calorise;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
    }


    public static class Builder {
        private int servingSize;
        private int servings;

        private int calorise;

        private int fat;

        private int sodium;

        public Builder(int servingSize,int servings){
            this.servings = servings;
            this.servingSize = servingSize;
        }

        public Builder calories(int calorise) {
            this.calorise = calorise;
            return this;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }

    }

    public static void main(String[] args) {
        new Builder(1,1).calories(1).fat(1).sodium(2).build();
    }
}
