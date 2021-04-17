package frc.robot.component;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.controller.PIDController;

public class Visiontrack {
    private static PIDController PIDcontrol;
    private static final double Max_xspeed = 0.5;
    private static final double Max_yspeed = 0.7;
    private static double heading;
    private static double walk;

    public static void init(){
        PIDcontrol = new PIDController(0.04, 0.001, 0.001);
        CamMode(0);
        LEDMode(3);
    }

    public static void aiming(){
        double tx = gettx();
        double ty = getty();
        if(gettv()!=1.0){
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
    }

    public static void seeking(){
        if(gettv()==0){
            heading = 0.3;
        }else{

        }
    }

    private static void CamMode(int mode){
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(mode);
        //0->Vision 1->driver
    }

    private static void LEDMode(int mode){
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
    
}
