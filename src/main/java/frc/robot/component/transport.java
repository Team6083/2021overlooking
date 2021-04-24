package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Robot;

public class transport {
    private static WPI_VictorSPX horizontal;
    private static WPI_VictorSPX straight;

    public static void init(){
        horizontal = new WPI_VictorSPX(4);
        straight = new WPI_VictorSPX(8);
    }

    public static void teleOp(){
        if(Robot.xbox_2.getRawButton(5)){
            horizontal.set(ControlMode.PercentOutput,0.5);
            straight.set(ControlMode.PercentOutput,0.5);
        }
        else if(Robot.xbox_2.getRawButton(6)){
            horizontal.set(ControlMode.PercentOutput,-0.5);
            straight.set(ControlMode.PercentOutput,-0.5);
        }
        else if(Robot.xbox_2.getBButton()){
            straight.set(ControlMode.PercentOutput,0.5);
        }
        else if(Robot.xbox_2.getAButton()){
            horizontal.set(ControlMode.PercentOutput,0.5);
        }
        else{
            horizontal.set(ControlMode.PercentOutput,0);
            straight.set(ControlMode.PercentOutput,0);
        }

    }
    public static void autonomousTransport(){
        horizontal.set(ControlMode.PercentOutput,0.4);
        straight.set(ControlMode.PercentOutput,0.4);
    }
}
