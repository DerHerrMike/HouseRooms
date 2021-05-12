package at.mps.app.builder;

import java.util.List;

public class Reception {

    private final int sqrm;
    private final int doors;
    private final List<String> furnitureList;

    private Reception(Builder builder){
        this.sqrm = builder.sqrm;
        this.doors = builder.doors;
        this.furnitureList=builder.furnitureList;
    }

    public int getSqrm() {
        return sqrm;
    }

    public int getDoors() {
        return doors;
    }

    public List<String> getFurnitureList() {
        return furnitureList;
    }

    public static class Builder {

        private int sqrm;
        private int doors;
        private List<String> furnitureList;


        public Builder sqrm(final int sqrm) {
            this.sqrm = sqrm;
            return this;
        }

        public Builder doors(final int doors) {
            this.doors = doors;
            return this;
        }

        public Builder furnitureList(final List<String> furnitureList){
            this.furnitureList=furnitureList;
            return this;
        }

        public Reception build() {
            return new Reception(this);
        }


    }


}
