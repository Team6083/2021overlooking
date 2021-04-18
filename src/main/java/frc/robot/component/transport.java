package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Robot;

public class transport {
    private static WPI_VictorSPX horizontal;
    private static WPI_VictorSPX straight;
    private static Boolean transportBoolean;

    public static void init(){
        horizontal = new WPI_VictorSPX(6);
        straight = new WPI_VictorSPX(7);
        transportBoolean = false;
    }

    public static void teleOp(){
        if(Robot.xbox.getRawButton(9)){
            transportBoolean = !transportBoolean;
        }
        if(transportBoolean){
            horizontal.set(ControlMode.PercentOutput,0.5);
            straight.set(ControlMode.PercentOutput,0.5);
        }
        else{
            horizontal.set(ControlMode.PercentOutput,0);
            straight.set(ControlMode.PercentOutput,0);
        }
    }
}
