package nullrobotics.lib;

public class Common {
    public static final double DEFAULT_DRIVE_SPEED = 0.4;
    public static final double SLOWMODE_MULTIPLIER = 0.25;

    public void tsleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            //do nothing
        }
    }
}
