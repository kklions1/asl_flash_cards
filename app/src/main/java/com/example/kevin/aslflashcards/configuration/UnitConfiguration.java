package com.example.kevin.aslflashcards.configuration;

/**
 * Created by kevin on 3/1/18.
 */

public class UnitConfiguration {

    private boolean unitOne;
    private boolean unitTwo;
    private boolean unitThree;

    public boolean hasUnitOne() { return unitOne; }

    public boolean hasUnitTwo() { return unitTwo; }

    public boolean hasUnitThree() { return unitThree; }

    public static class Builder {
        private boolean unitOne;
        private boolean unitTwo;
        private boolean unitThree;

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

        public UnitConfiguration build() {
            UnitConfiguration configuration = new UnitConfiguration();
            configuration.unitOne = this.unitOne;
            configuration.unitTwo = this.unitTwo;
            configuration.unitThree = this.unitThree;
            return configuration;
        }
    }
}
