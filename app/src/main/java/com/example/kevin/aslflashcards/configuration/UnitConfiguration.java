package com.example.kevin.aslflashcards.configuration;

/**
 * Created by kevin on 3/1/18.
 */

public class UnitConfiguration {

    private boolean unitOne;
    private boolean unitTwo;
    private boolean unitThree;
    private boolean unitFour;

    public boolean hasUnitOne() { return unitOne; }

    public boolean hasUnitTwo() { return unitTwo; }

    public boolean hasUnitThree() { return unitThree; }

    public boolean hasUnitFour() { return unitFour; }

    public static class Builder {
        private boolean unitOne;
        private boolean unitTwo;
        private boolean unitThree;
        private boolean unitFour;

        public Builder unitOne() {
            this.unitOne = true;
            return this;
        }

        public Builder unitTwo() {
            this.unitTwo = true;
            return this;
        }

        public Builder unitThree() {
            this.unitThree = true;
            return this;
        }

        public Builder unitFour() {
            this.unitFour = true;
            return this;
        }

        public UnitConfiguration build() {
            UnitConfiguration configuration = new UnitConfiguration();
            configuration.unitOne = this.unitOne;
            configuration.unitTwo = this.unitTwo;
            configuration.unitThree = this.unitThree;
            configuration.unitFour = this.unitFour;
            return configuration;
        }
    }
}
