package at.mps.app.builder;

public class Bedroom {

    private final int sqrm;
    private final String name;

    private Bedroom(Builder builder) {
        this.sqrm = builder.sqrm;
        this.name = builder.name;
    }

    public int getSqrm() {
        return sqrm;
    }

    public String getName() {
        return name;
    }

    public static class Builder {

        private int sqrm;
        private String name;


        public Builder sqrm(final int sqrm) {
            this.sqrm = sqrm;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Bedroom build() {
            return new Bedroom(this);
        }

    }
}
