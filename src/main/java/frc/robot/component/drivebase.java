package frc.robot.component;

import frc.robot.Robot;
import org.team6083.lib.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
public class drivebase {
    public static DifferentialDrive drive;
    public static WPI_VictorSPX rightFront;
    public static WPI_VictorSPX rightBack;
    public static WPI_VictorSPX leftFront;
    public static WPI_VictorSPX leftBack;
    private static final int LF = 0;
    private static final int LB = 1;
    private static final int RF = 2;
    private static final int RB = 3;

    public static void init() {
        rightFront = new WPI_VictorSPX(RF);
        rightBack = new WPI_VictorSPX(RB);
        leftBack = new WPI_VictorSPX(LB);
        leftFront = new WPI_VictorSPX(LF);
        drive = new DifferentialDrive(rightBack, rightFront, leftBack, leftFront);
    }

    public static void teleop() {
        drive.tankDrive(Robot.xbox);
    }
}