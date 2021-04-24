package frc.robot.component;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class Visiontrack {
    private static PIDController PIDcontrol;
    private static boolean detect = false;
    private static final double Max_spinspeed = 0.5;
    private static final double Max_drivespeed = 0.7;
    private static double heading;
    private static double walk;

    public static void init(){
        PIDcontrol = new PIDController(0.04, 0.001, 0.001);
        SetCamMode(1);
        SetLEDMode(1);

        showDashboard();
    }

    public static void teleop(){
        if(Robot.vicecontroller.getXButtonPressed()){
            detect = !detect;
            SetCamMode(0);
            SetLEDMode(3);
        }

        if(detect && !finishtracking()){
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
        if(shoot.limit()){
            AimWithTurrent(heading,walk);
        }else{
            AimOnlyDrivebase(heading, walk);
        }
    }

    public static void seek(){
        double tv = gettv();
        SetCamMode(0);
        SetLEDMode(3);

        if(tv==0){
            if(shoot.limit()){
                drivebase.drive.directControl(0.3, 0.3);
            }else{
                shoot.spin(0.3);
            }
        }else{
            aiming();
        }

    }

    private static boolean finishtracking(){
        double error = 3;
        boolean finished = false;
        if(Math.abs(gettx()) < error && Math.abs(getty()) < error){
            finished = true;
            detect = false;
        }else{
            finished = false;
        }

        return finished;
    }

    private static void AimWithTurrent(double tx, double ty){
        if(Math.abs(tx)>Max_spinspeed){
            if(tx>=0){
                tx = Max_spinspeed;
            }else{
                tx = -Max_spinspeed;
            }

            if(Math.abs(ty)>Max_drivespeed){
                if(ty>=0){
                    ty = Max_drivespeed;
                }else{
                    ty = -Max_drivespeed;
                }
            }
        }

        shoot.spin(tx);
        drivebase.drive.directControl(ty, ty);
    }

    private static void AimOnlyDrivebase(double tx, double ty){
        if(Math.abs(tx)>Max_drivespeed){
            if(tx>=0){
                tx = Max_drivespeed;
            }else{
                tx = -Max_drivespeed;
            }

            if(Math.abs(ty)>Max_drivespeed){
                if(ty>=0){
                    ty = Max_drivespeed;
                }else{
                    ty = -Max_drivespeed;
                }
            }
        }

        drivebase.drive.arcadeDrive(ty, tx, false);
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
