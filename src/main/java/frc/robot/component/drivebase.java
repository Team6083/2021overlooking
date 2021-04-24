package frc.robot.component;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import org.team6083.lib.drive.DifferentialDrive;
import frc.robot.Robot;

public class drivebase {
    public static DifferentialDrive drive;
    public static WPI_VictorSPX right_1;
    public static WPI_VictorSPX right_2;
    public static WPI_VictorSPX left_1;
    public static WPI_VictorSPX left_2;
    private static final int Left_1 = 6;
    private static final int Left_2= 7;
    private static final int Right_1 = 5;
    private static final int Right_2 = 3;
    public static void init() {
        right_1 = new WPI_VictorSPX(Right_1);
        right_2 = new WPI_VictorSPX(Right_2);
        left_2 = new WPI_VictorSPX(Left_2);
        left_1 = new WPI_VictorSPX(Left_1);
        drive = new DifferentialDrive(right_1, right_2, left_1, left_2);
     
    }

    public static void teleOp() {
        drive.tankDrive(Robot.xbox_1);
    }
    public static void track(double speed, double rotation, boolean input) {
        drive.arcadeDrive(speed, rotation, input);
    }
    
    public static void directControl(double left, double right) {
        drive.directControl(left, right);
    }
}