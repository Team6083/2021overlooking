package frc.robot.component;

import edu.wpi.first.networktables.NetworkTableInstance;

public class Visiontrake {
    public static void init(){
        CamMode(0);
        LEDMode(3);
    }

    public static void teleop(){
        
    }

    private static void CamMode(int mode){
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(mode);
        //0->Vision 1->driver
    }

    private static void LEDMode(int mode){
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(mode);
        //0->current pipeline   1->off  2->blink    3->on
    }
    
}
