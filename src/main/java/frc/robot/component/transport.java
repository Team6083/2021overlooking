package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Robot;

public class transport {
    private static WPI_VictorSPX top;
    private static WPI_VictorSPX buttom;

    public static void init(){
        top = new WPI_VictorSPX(4);
        buttom = new WPI_VictorSPX(8);
    }

    public static void teleOp(){
        if(Robot.xbox_2.getRawButton(5)){
            top.set(ControlMode.PercentOutput,0.5);
            buttom.set(ControlMode.PercentOutput,0.5);
        }
        else if(Robot.xbox_2.getRawButton(6)){
            top.set(ControlMode.PercentOutput,-0.5);
            buttom.set(ControlMode.PercentOutput,-0.5);
        }
        else if(Robot.xbox_2.getBButton()){
            buttom.set(ControlMode.PercentOutput,0.5);
        }
        else if(Robot.xbox_2.getAButton()){
            top.set(ControlMode.PercentOutput,0.5);
        }
        else{
            top.set(ControlMode.PercentOutput,0);
            buttom.set(ControlMode.PercentOutput,0);
        }

    }
    public static void autonomousTransport(){
        top.set(ControlMode.PercentOutput,-0.5);
        buttom.set(ControlMode.PercentOutput,-0.5);
    }
}
