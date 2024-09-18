package nullrobotics.commandbaseexampledepr;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

public class IntakeCommand extends SequentialCommandGroup {
    IntakeSUbsystem intakeSubsystem = null;

    public IntakeCommand(){
        super(
                new WaitCommand(100),
                new InstantCommand(),
                new WaitCommand(50)
        );

        addRequirements(intakeSubsystem);
    }
}
