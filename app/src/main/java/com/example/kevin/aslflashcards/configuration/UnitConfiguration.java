package com.example.kevin.aslflashcards.configuration;

/**
 * Created by kevin on 3/1/18.
 * Unit 5 & 6 added by Devinn 10/11/18.
 * Unit 7 & 8 added by Devinn 10/13/18
 */

public class UnitConfiguration {

    private boolean unitOne;
    private boolean unitTwo;
    private boolean unitThree;
    private boolean unitFour;
    private boolean unitFive;
    private boolean unitSix;
    private boolean unitSeven;

    public boolean hasUnitOne() { return unitOne; }

    public boolean hasUnitTwo() { return unitTwo; }

    public boolean hasUnitThree() { return unitThree; }

    public boolean hasUnitFour() { return unitFour; }

    public boolean hasUnitFive() { return unitFive; }

    public boolean hasUnitSix() { return unitSix; }

    public boolean hasUnitSeven() { return unitSeven; }

    public static class Builder {
        private boolean unitOne;
        private boolean unitTwo;
        private boolean unitThree;
        private boolean unitFour;
        private boolean unitFive;
        private boolean unitSix;
        private boolean unitSeven;

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

        public Builder unitFive() {
            this.unitFive = true;
            return this;
        }

        public Builder unitSix() {
            this.unitSix = true;
            return this;
        }

        public Builder unitSeven() {
            this.unitSeven = true;
            return this;
        }

        public UnitConfiguration build() {
            UnitConfiguration configuration = new UnitConfiguration();
            configuration.unitOne = this.unitOne;
            configuration.unitTwo = this.unitTwo;
            configuration.unitThree = this.unitThree;
            configuration.unitFour = this.unitFour;
            configuration.unitFive = this.unitFive;
            configuration.unitSix = this.unitSix;
            configuration.unitSeven = this.unitSeven;
            return configuration;
        }
    }
}
