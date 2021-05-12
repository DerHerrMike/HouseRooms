package at.mps.app.builder;

public class Basement {

    private final int areas;
    private final String flooring;

    private Basement(Builder builder) {
        this.areas = builder.areas;
        this.flooring = builder.flooring;
    }

    public int getAreas() {
        return areas;
    }

    public String getFlooring() {
        return flooring;
    }

    public static class Builder {

        private int areas;
        private String flooring;


        public Builder areas(final int sqrm) {
            this.areas = sqrm;
            return this;
        }

        public Builder flooring(final String name) {
            this.flooring = name;
            return this;
        }

        public Basement build() {
            return new Basement(this);
        }

    }
}
