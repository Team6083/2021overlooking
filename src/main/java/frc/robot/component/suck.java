package frc.robot.component;

import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class suck{
    private static WPI_VictorSPX suck;
    private static final int port = 1;

    public static void init(){
        suck = new WPI_VictorSPX(port);
    }

    public static void teleop(){
        if(Robot.xbox.getAButtonPressed()){
            suck.set(ControlMode.PercentOutput, 0.5);
        }else{
            suck.set(ControlMode.PercentOutput, 0);
        }
        
    }

}