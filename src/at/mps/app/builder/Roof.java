package at.mps.app.builder;

public class Roof {

    private final int tiles;
    private final int age;
    private final String color;
    private final Chimney chimney;

    private Roof(Builder builder) {
        this.tiles = builder.tiles;
        this.age = builder.age;
        this.color = builder.color;
        this.chimney = builder.chimney;
    }

    public int getTiles() {
        return tiles;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public Chimney getChimney() {
        return chimney;
    }

    public static class Builder {

        private int tiles;
        private int age;
        private String color;
        private Chimney chimney;

        public Builder tiles(final int tiles){
            this.tiles = tiles;
            return this;
        }

        public Builder age(final int age){
            this.age = age;
            return this;
        }

        public Builder color(final String color){
            this.color = color;
            return this;
        }

        public Builder chimney(final Chimney chimney){
            this.chimney=chimney;
            return this;
        }

        public Roof build(){
            return new Roof(this);
        }
    }


}
