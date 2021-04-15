package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Robot;

public class shoot{
    private static WPI_VictorSPX shoot;

    public static void init(){
         shoot =  new WPI_VictorSPX( 2 );
    }
    
    public static void teleop(){
        if(Robot.xbox.getAButton()){
            shoot.set(ControlMode.PercentOutput, 0.5);
        }else{
            shoot.set(ControlMode.PercentOutput, 0);
        }
        
    }

}