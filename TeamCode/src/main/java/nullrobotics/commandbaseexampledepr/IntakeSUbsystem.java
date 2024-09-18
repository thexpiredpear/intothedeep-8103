package nullrobotics.commandbaseexampledepr;

import com.arcrobotics.ftclib.command.SubsystemBase;

import nullrobotics.lib.RobotHardware;

public class IntakeSUbsystem extends SubsystemBase {
    public void initialize(){

    }

    public void periodic(){
        // update PID

        RobotHardware.getInstance();
    }
}
