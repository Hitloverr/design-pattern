package inheritedBuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {
        HAM,MUSHROOM,ONION,PEPPER,SAUSAGE
    }

    final Set<Topping> toppings;

    Pizza(Builder<?> builder) {
        this.toppings = builder.toppingEnumSet.clone();
    }

    abstract static class Builder<T extends Builder<T>>{
        EnumSet<Topping> toppingEnumSet = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppingEnumSet.add(Objects.requireNonNull(topping));
            return self();
        }

        protected abstract T self();

        abstract Pizza build();
    }
}

class NyPizza extends Pizza {
    private int size;
    private NyPizza(Builder builder) {
        super(builder);
        this.size = builder.size;

    }

    public static class Builder extends Pizza.Builder<Builder> {
        private final int size;
        @Override
        protected Builder self() {
            return this;
        }

        public Builder(int size) {
            super();
            this.size = size;
        }

        @Override
        Pizza build() {
            return new NyPizza(this);
        }
    }
}

class PizzaMain {
    public static void main(String[] args) {
        new NyPizza.Builder(3).addTopping(Pizza.Topping.HAM).build();
    }
}
