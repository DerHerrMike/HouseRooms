package at.mps.app.builder;

public class Kitchen {

    private final int sqrm;
    private final int windowNumber;
    private final String manufacturer;

    private Kitchen(Builder builder){
        this.sqrm= builder.sqrm;
        this.windowNumber= builder.windowNumber;
        this.manufacturer= builder.manufacturer;
    }

    public int getSqrm() {
        return sqrm;
    }

    public int getWindowNumber() {
        return windowNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public static class Builder {

        private int sqrm;
        private int windowNumber;
        private String manufacturer;

        public Builder sqrm(final int sqrm) {
            this.sqrm = sqrm;
            return this;
        }

        public Builder windowNumber(final int windowNumber) {
            this.windowNumber = windowNumber;
            return this;
        }

        public Builder manufacturer(final String manufacturer) {
            this.manufacturer =manufacturer;
            return this;
        }

        public Kitchen build(){
            return new Kitchen(this);
        }
    }


}
