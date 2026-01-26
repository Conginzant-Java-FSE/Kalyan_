public class NasaLaunchControl  {

    static class MissionAbortException extends Exception {
        public MissionAbortException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void validateLaunch(int fuel, String weather)
            throws MissionAbortException {

        try {
            if (fuel < 80) {
                throw new Exception("Fuel level is below 80%");
            }

            try {
                if (!"CLEAR".equalsIgnoreCase(weather)) {
                    throw new Exception("Weather is not clear");
                }

            } catch (Exception weatherEx) {
                throw new MissionAbortException(
                        "Mission aborted due to weather conditions",
                        weatherEx
                );
            }

        } catch (Exception fuelEx) {
            throw new MissionAbortException(
                    "Mission aborted due to insufficient fuel",
                    fuelEx
            );
        }
    }

    public static void main(String[] args) {
        try {
            validateLaunch(60, "STORM");
            System.out.println("Mission launched successfully");

        } catch (MissionAbortException e) {
            System.out.println("Mission launch failed");
            e.printStackTrace();
            System.out.println("Please resolve the issue and retry the launch");
        }
    }
}
