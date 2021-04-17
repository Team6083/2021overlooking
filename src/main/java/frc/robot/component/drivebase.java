package frc.robot.component;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import org.team6083.lib.drive.DifferentialDrive;
import frc.robot.Robot;

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

    public static void teleOp() {
        if (Robot.xbox.getPOV()==0){
            leftFront.set(0.3);
            leftBack.set(0.3);
            rightFront.set(-0.3);
            rightBack.set(-0.3);
        }
        else if (Robot.xbox.getPOV()==180){
            leftFront.set(-0.3);
            leftFront.set(-0.3);
            rightFront.set(0.3);
            rightBack.set(0.3);
        }
        else if (Robot.xbox.getPOV()==90){
            leftFront.set(0.3);
            leftBack.set(0.3);
            rightFront.set(0);
            rightBack.set(0);
        }
        else if (Robot.xbox.getPOV()==270){
            leftFront.set(0);
            leftBack.set(0);
            rightFront.set(-0.3);
            rightBack.set(-0.3);
        }
        else{
        drive.tankDrive(Robot.xbox);
        }
    }
    public static void track(double speed, double rotation, boolean input) {
        drive.arcadeDrive(speed, rotation, input);
    }
    
    public static void directControl(double left, double right) {
        drive.directControl(left, right);
    }
}