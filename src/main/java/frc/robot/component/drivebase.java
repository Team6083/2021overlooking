package frc.robot.component;

import frc.robot.Robot;
import org.team6083.lib.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
public class drivebase {
    public static DifferentialDrive drive;
    public static WPI_VictorSPX right1;
    public static WPI_VictorSPX right2;
    public static WPI_VictorSPX left1;
    public static WPI_VictorSPX left2;
    private static final int L1 = 0;
    private static final int L2 = 1;
    private static final int R1 = 2;
    private static final int R2 = 3;

    public static void init() {
        right1 = new WPI_VictorSPX(R1);
        right2 = new WPI_VictorSPX(R2);
        left1 = new WPI_VictorSPX(L1);
        left2 = new WPI_VictorSPX(L2);
        drive = new DifferentialDrive(right1,right2,left1,left2);
    }

    public static void teleop() {
        drive.tankDrive(Robot.maincontroller);
    }
}