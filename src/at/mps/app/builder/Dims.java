package at.mps.app.builder;

public class Dims {

    private final int width;
    private final int height;
    private final int length;

    private Dims(Builder builder){
        this.width= builder.width;
        this.height= builder.height;
        this.length= builder.length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public static class Builder {

        private int width;
        private int height;
        private int length;

        public Builder width(final int width) {
            this.width = width;
            return this;
        }

        public Builder height(final int height) {
            this.height = height;
            return this;
        }

        public Builder length(final int length) {
            this.length = length;
            return this;
        }

        public Dims build(){
            return new Dims(this);
        }

    }
}
