package at.mps.app.builder;

public class Chimney {

    private final String color;
    private final Dims dims;

    private Chimney (Builder builder){
        this.color = builder.color;
        this.dims = builder.dims;
    }

    public String getColor() {
        return color;
    }

    public Dims getDims() {
        return dims;
    }

    public static class Builder {

        private String color;
        private Dims dims;

        public Builder color(final String color){
            this.color = color;
            return this;
        }

        public Builder dims(final Dims dims){
            this.dims = dims;
            return this;
        }

        public Chimney build(){
            return new Chimney(this);
        }
    }

}
