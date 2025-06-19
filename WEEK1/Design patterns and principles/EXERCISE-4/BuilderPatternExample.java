public class BuilderPatternExample {

    public static class Computer {
        private String CPU;
        private String RAM;
        private String storage;
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
            this.isBluetoothEnabled = builder.isBluetoothEnabled;
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage +
                   ", Graphics Card Enabled=" + isGraphicsCardEnabled +
                   ", Bluetooth Enabled=" + isBluetoothEnabled + "]";
        }

        public static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            private boolean isGraphicsCardEnabled;
            private boolean isBluetoothEnabled;

            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
                this.isGraphicsCardEnabled = isGraphicsCardEnabled;
                return this;
            }

            public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
                this.isBluetoothEnabled = isBluetoothEnabled;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {

        Computer gamingComputer = new Computer.Builder()
            .setCPU("Intel i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGraphicsCardEnabled(true)
            .setBluetoothEnabled(true)
            .build();

        Computer officeComputer = new Computer.Builder()
            .setCPU("Intel i5")
            .setRAM("16GB")
            .setStorage("512GB SSD")
            .setGraphicsCardEnabled(false)
            .setBluetoothEnabled(false)
            .build();

        System.out.println("Gaming Computer Configuration:");
        System.out.println(gamingComputer);

        System.out.println("\nOffice Computer Configuration:");
        System.out.println(officeComputer);
    }
}
