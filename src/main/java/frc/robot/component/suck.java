package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Robot;

public class suck{
    private static WPI_VictorSPX suck;

    public static void init(){
         suck =  new WPI_VictorSPX( 1 );
    }

    public static void teleop(){
        if(Robot.xbox.getXButton()) {
            suck.set(ControlMode.PercentOutput, 0.5);
        }else{
            suck.set(ControlMode.PercentOutput, 0);
        }
        
    }

}