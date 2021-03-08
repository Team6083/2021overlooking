package frc.robot.component;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Joystick;
public class upup{
    private static VictorSP up;
    public static void init(){
    up =  new VictorSP( 87 );
    }
    public static void teleop(){
        if(Robot.joy.getRawButton(87)){
            up.set(0.5);
        }else{
            up.set(0);
        }
    }
}


