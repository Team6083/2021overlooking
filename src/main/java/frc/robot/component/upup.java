package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Robot;
public class upup{
    private static WPI_VictorSPX up;
    private static WPI_VictorSPX rope;
    private static final int UpPort = 3;
    private static final int RopePort = 4;

    public static void init(){
        up = new WPI_VictorSPX(UpPort);
        rope = new WPI_VictorSPX(RopePort);
    }

    public static void teleop(){
        if(Robot.xbox.getTriggerAxis(Hand.kRight)>Robot.xbox.getTriggerAxis(Hand.kLeft)){
            up.set(ControlMode.PercentOutput,0.5);
        }else if(Robot.xbox.getTriggerAxis(Hand.kLeft)>Robot.xbox.getTriggerAxis(Hand.kRight)){
            up.set(ControlMode.PercentOutput,-0.5);
        }else{
            up.set(ControlMode.PercentOutput,0);
        }

        if(Robot.xbox.getPOV()==0){
            rope.set(ControlMode.PercentOutput, 0.5);
        }else if(Robot.xbox.getPOV()==180){
            rope.set(ControlMode.PercentOutput, -0.5);
        }else{
            rope.set(ControlMode.PercentOutput, 0);
        }
    }
}


