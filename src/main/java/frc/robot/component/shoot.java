package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Robot;

public class shoot{
    private static WPI_VictorSPX shoot;
    private static final int port = 2;

    public static void init(){
        shoot =  new WPI_VictorSPX(port);
    }
    
    public static void teleop(){
        if(Robot.xbox.getBButton()){
            shoot.set(ControlMode.PercentOutput,0.5);
        }else{
            shoot.set(ControlMode.PercentOutput, 0);
        }
        
    }

}