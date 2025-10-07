public class Car {
        private String model;
        private int yearOfManifacture;
        private String country;



        public Car (String model,  int yearOfManifacture, String country) {
            this.model = model;
            this.yearOfManifacture = yearOfManifacture;
            this.country = country;

        }

        public void printCarInfo() {
            System.out.println("Есть одна машина, " + model +
                    " , она произведена в " + yearOfManifacture + "-м году. " +
                    "Страна выпуска - " + country);
        }

}
