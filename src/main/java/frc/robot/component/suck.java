package frc.robot.component;

import edu.wpi.first.wpilibj.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Joystick;

public class suck{
    private static WPI_VictorSPX suck;

    public static void init(){
         suck =  new WPI_VictorSPX( 1 );
    }

    public static void teleop(){
        if(Robot.joy.getRawButton(1)){
            suck.set(ControlMode.PercentOutput, 0.5);
        }else{
            suck.set(ControlMode.PercentOutput, 0);
        }
        
    }

}