package build;

public class Pizza {

    private String a;

    private String b;

    private String c;

    private Pizza(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
    }

    public static class Builder {
        private String a;

        private String b;

        private String c;

        public Builder(String a,String b) {
            this.a = a;
            this.b = b;
        }

        public Builder setC(String c) {
            this.c = c;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
