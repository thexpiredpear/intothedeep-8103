package nullrobotics.commandbaseexampledepr;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RobotHardware {
    private static RobotHardware instance;

    public ElapsedTime chassisElapsedTime = new ElapsedTime();
    HardwareMap chHardwareMap;
    Telemetry chTelemetry;

    public BNO055IMU imu;
    BNO055IMU.Parameters imuParameters;

    public DcMotorEx DriveFL;
    public DcMotorEx DriveFR;
    public DcMotorEx DriveBL;
    public DcMotorEx DriveBR;
    public DcMotorEx[] driveMotors = new DcMotorEx[] {DriveFL, DriveFR, DriveBL, DriveBR};

    public static RobotHardware getInstance() {
        if (instance == null) {
            instance = new RobotHardware();
        }
        return instance;
    }

    public void init(HardwareMap hardwareMap, Telemetry telemetry) {
        chHardwareMap = hardwareMap;
        chTelemetry = telemetry;

        DriveFL.setDirection(DcMotorSimple.Direction.FORWARD);
        DriveFR.setDirection(DcMotorSimple.Direction.REVERSE);
        DriveBR.setDirection(DcMotorSimple.Direction.FORWARD);
        DriveBL.setDirection(DcMotorSimple.Direction.REVERSE);
        DriveFL = hardwareMap.get(DcMotorEx.class, "DriveFL");
        DriveFR = hardwareMap.get(DcMotorEx.class, "DriveFR");
        DriveBL = hardwareMap.get(DcMotorEx.class, "DriveBL");
        DriveBR = hardwareMap.get(DcMotorEx.class, "DriveBR");

    }

    public void powerMotors(double powerFL, double powerFR, double powerBL, double powerBR) {
        DriveFL.setPower(powerFL);
        DriveFR.setPower(powerFR);
        DriveBL.setPower(powerBL);
        DriveBR.setPower(powerBR);
        for(DcMotorEx motor : driveMotors) {
            resetMotor(motor);
        }
    }

    public void resetMotor(DcMotorEx motor) {
        motor.setPower(0.0);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
