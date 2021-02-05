package frc.robot.component;

import edu.wpi.first.wpilibj.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Joystick;

public class suck{
    static WPI_VictorSPX suckleft;
    static WPI_VictorSPX suckright;

    public static void init(){
         suckleft =  new WPI_VictorSPX( 1 );
         suckright  = new WPI_VictorSPX( 2 );
    }

    public static void teleop(){
        if(Robot.joy.getRawButton(1)){
            suckleft.set(ControlMode.PercentOutput, 0.5);
            suckright.set(ControlMode.PercentOutput, -0.5);
        }else{
            suckleft.set(ControlMode.PercentOutput, 0);
            suckright.set(ControlMode.PercentOutput, 0);
        }
        
    }

}