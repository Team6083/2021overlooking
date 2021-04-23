package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Robot;
public class upup{
    private static WPI_VictorSPX up;
    private static WPI_VictorSPX rope;
    private static final int UpPort = 2;
    private static final int RopePort = 10;

    public static void init(){
        up = new WPI_VictorSPX(UpPort);
        rope = new WPI_VictorSPX(RopePort);
    }

    public static void teleop(){
        if(Robot.maincontroller.getXButtonPressed()){
            up.set(ControlMode.PercentOutput,0.5);
        }else if(Robot.maincontroller.getAButtonPressed()){
            up.set(ControlMode.PercentOutput,-0.5);
        }else{
            up.set(ControlMode.PercentOutput,0);
        }

        if(Robot.vicecontroller.getTriggerAxis(Hand.kRight)>Robot.vicecontroller.getTriggerAxis(Hand.kLeft)){
            rope.set(ControlMode.PercentOutput, 0.5);
        }else if(Robot.vicecontroller.getTriggerAxis(Hand.kLeft)>Robot.vicecontroller.getTriggerAxis(Hand.kRight)){
            rope.set(ControlMode.PercentOutput, -0.5);
        }else{
            rope.set(ControlMode.PercentOutput, 0);
        }
    }
}


