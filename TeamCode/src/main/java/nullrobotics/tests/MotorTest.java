package nullrobotics.tests;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="MotorTest", group="8103")
public class MotorTest extends LinearOpMode {
    public void sleep(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException e){
            telemetry.addData("CaughtException", "Thread Interrupted");
            telemetry.update();
        }
    }
    @Override
    public void runOpMode() {
        DcMotor testMotor = hardwareMap.dcMotor.get("DriveFL");
        testMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        testMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        testMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        long t;
        t = System.currentTimeMillis();
        telemetry.addData("start time", t);
        telemetry.update();
        waitForStart();
        sleep(500);
        t=System.currentTimeMillis();
        testMotor.setPower(0.8);
        while(System.currentTimeMillis() - 1000 < t){
            telemetry.addData("encoder", testMotor.getCurrentPosition());
            telemetry.update();
        }
        testMotor.setPower(0);
        sleep(500);
        t = System.currentTimeMillis();
        testMotor.setPower(-0.8);
        while(System.currentTimeMillis() - 1000 < t){
            telemetry.addData("encoder", testMotor.getCurrentPosition());
            telemetry.update();
        }
        testMotor.setPower(0);
        testMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        testMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        testMotor.setTargetPosition(0);
        testMotor.setPower(0.8);
        sleep(500);
        testMotor.setTargetPosition(200);
        t = System.currentTimeMillis();
        while(System.currentTimeMillis() - 5000 < t){
            telemetry.addData("encoder", testMotor.getCurrentPosition());
            telemetry.update();
        }
        sleep(500);
        testMotor.setTargetPosition(0);
        t = System.currentTimeMillis();
        while(System.currentTimeMillis() - 5000 < t){
            telemetry.addData("encoder", testMotor.getCurrentPosition());
            telemetry.update();
        }
    }
}