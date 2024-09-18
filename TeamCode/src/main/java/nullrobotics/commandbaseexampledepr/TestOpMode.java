package nullrobotics.commandbaseexampledepr;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import nullrobotics.lib.RobotHardware;

public class TestOpMode extends CommandOpMode {
    @Override
    public void initialize() {
        GamepadEx gamepad = new GamepadEx(gamepad1);
        //RobotHardware.getInstance().init();

        schedule(new IntakeCommand());

        gamepad.getGamepadButton(GamepadKeys.Button.A)
                .whenPressed(new IntakeCommand());
    }
}
