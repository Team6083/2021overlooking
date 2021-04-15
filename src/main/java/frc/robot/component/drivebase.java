package frc.robot.component;

import org.team6083.lib.drive.DifferentialDrive;
import org.team6083.lib.drive.inputs.TankInput;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import frc.robot.Robot;

public class DriveBase {
    public static DifferentialDrive drive;
    public static VictorSP rightFront;
    public static VictorSP rightBack;
    public static VictorSP leftFront;
    public static VictorSP leftBack;
    private static final int LF = 0;
    private static final int LB = 1;
    private static final int RF = 2;
    private static final int RB = 3;

    public static void init() {
        rightFront = new VictorSP(RF);
        rightBack = new VictorSP(RB);
        leftBack = new VictorSP(LB);
        leftFront = new VictorSP(LF);
        drive = new DifferentialDrive(rightBack, rightFront, leftBack, leftFront);
    }

    public static void teleOp() {
        drive.tankDrive(Robot.xbox);
    }
    
    public static void directControl(double left, double right) {
        drive.directControl(left, right);
    }
}