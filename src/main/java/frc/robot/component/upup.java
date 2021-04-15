package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Robot;
public class upup{
   
    private static WPI_VictorSPX up;
    public static void init(){
    up =  new WPI_VictorSPX( 87 );
    }
    public static void teleop(){
        if(Robot.xbox.getBButton()){
            up.set(ControlMode.PercentOutput,0.5);
        }
        else if(Robot.xbox.getAButton()){
            up.set(ControlMode.PercentOutput,-0.5);
        }
        else{
            up.set(ControlMode.PercentOutput,0);
        }
    }
}


