package frc.robot.component;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class Visiontrack {
    private static PIDController PIDcontrol;
    private static boolean detect = false;
    private static final double Max_xspeed = 0.5;
    private static final double Max_yspeed = 0.7;
    private static double heading;
    private static double walk;

    public static void init(){
        PIDcontrol = new PIDController(0.04, 0.001, 0.001);
        SetCamMode(1);
        SetLEDMode(1);

        showDashboard();
    }

    public static void teleop(){
        if(Robot.xbox.getStartButtonPressed()){
            detect = !detect;
            SetCamMode(0);
            SetLEDMode(3);
        }

        if(detect){
            aiming();
        }else{
            SetCamMode(1);
            SetLEDMode(1);
        }
    }

    public static void aiming(){
        double tv = gettv();
        double tx = gettx();
        double ty = getty();

        if(tv==0){
            detect = false;
            return;
        }else{
            heading = PIDcontrol.calculate(tx, 0);
            walk = PIDcontrol.calculate(ty,0);
        }

        if(Math.abs(heading)>Max_xspeed){
            if(heading>=0){
                heading = Max_xspeed;
            }else{
                heading = -Max_xspeed;
            }
        }

        if(Math.abs(walk)>Max_yspeed){
            if(walk>=0){
                walk = Max_yspeed;
            }else{
                walk = -Max_yspeed;
            }
        }

        if(shoot.limit()){  //if turrent spin to the limit position rotate the drivebase
            drivebase.drive.arcadeDrive(walk, heading, false);
        }else{
            drivebase.drive.directControl(walk, -walk);
        }
    }

    private static void SetCamMode(int mode){
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(mode);
        //0->Vision 1->driver
    }

    private static void SetLEDMode(int mode){
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(mode);
        //0->current pipeline   1->off  2->blink    3->on
    }

    private static double gettx(){
        double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);

        return tx;
    }

    private static double getty(){
        double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);

        return ty;
    }

    private static double gettv(){
        double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);

        return tv;
    }

    private static void showDashboard(){
        SmartDashboard.putBoolean("Vsiontrack/traking",detect);
        SmartDashboard.putNumber("Visiontrack/tx", gettx());
        SmartDashboard.putNumber("Visiontrack/ty", getty());
        SmartDashboard.putNumber("Visiontrack/tv", gettv());
        SmartDashboard.putNumber("Visiontrack/DriveSpeed", walk);
        SmartDashboard.putNumber("Visiontrack/SpinSpeed", heading);
    }
    
}
