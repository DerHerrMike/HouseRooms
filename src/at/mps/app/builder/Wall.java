package at.mps.app.builder;

public class Wall {

    private final String direction;

    private Wall(Builder builder){
        this.direction = builder.direction;
    }

    public String getDirection() {
        return direction;
    }

    public static class Builder {

        private String direction;


        public Builder direction (final String direction){
            this.direction = direction;
            return this;
        }


        public Wall build(){
            return new Wall(this);
        }
    }




}
