package at.mps.app.builder;

import java.util.ArrayList;
import java.util.List;

public class House {

    private final String streetName;
    private final int number;
    private List<Wall> walls = new ArrayList<>();
    private final Basement basement;
    private final Kitchen kitchen;
    private final Reception reception;
    private final Bedroom bedroom;
    private final Roof roof;


    private House(Builder builder){
        this.streetName = builder.streetName;
        this.number = builder.number;
        this.walls = builder.walls;
        this.basement=builder.basement;
        this.kitchen=builder.kitchen;
        this.reception = builder.reception;
        this.bedroom=builder.bedroom;
        this.roof = builder.roof;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getNumber() {
        return number;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public Basement getBasement() {
        return basement;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public Reception getReception() {
        return reception;
    }

    public Bedroom getBedroom() {
        return bedroom;
    }

    public Roof getRoof() {
        return roof;
    }

    public static class Builder {

        private String streetName;
        private int number;
        private List<Wall> walls = new ArrayList<>();
        private Basement basement;
        private Kitchen kitchen;
        private Reception reception;
        private Bedroom bedroom;
        private Roof roof;


        public Builder streetName(final String streetName){
            this.streetName=streetName;
            return this;
        }

        public Builder number(final int number){
            this.number=number;
            return this;
        }

        public Builder walls(final List<Wall>walls){
            this.walls=walls;
            return this;
        }

        public Builder basement(final Basement basement){
            this.basement=basement;
            return this;
        }

        public Builder kitchen(final Kitchen kitchen){
            this.kitchen=kitchen;
            return this;
        }

        public Builder reception(final Reception reception){
            this.reception=reception;
            return this;
        }

        public Builder bedroom(final Bedroom bedroom){
            this.bedroom=bedroom;
            return this;
        }

        public Builder roof(final Roof roof){
            this.roof=roof;
            return this;
        }

        public House build(){
            return new House(this);
        }


        


    }



}
