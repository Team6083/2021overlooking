package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Robot;

public class shoot{
    private static WPI_VictorSPX shoot;
    private static WPI_VictorSPX turn;

    public static void init(){
         shoot =  new WPI_VictorSPX(1);
         turn = new WPI_VictorSPX(3);
    }
    
    public static void teleop(){
        if(Robot.xbox_1.getBButton()){
            shoot.set(ControlMode.PercentOutput, 0.5);
        }else{
            shoot.set(ControlMode.PercentOutput, 0);
        }
        
        if(Robot.xbox_1.getTriggerAxis(Hand.kLeft)>0.7){
            turn.set(ControlMode.PercentOutput,0.3);
        }
        else if(Robot.xbox_1.getTriggerAxis(Hand.kRight)>0.7){
            turn.set(ControlMode.PercentOutput,-0.3);
        }
        else{
            turn.set(ControlMode.PercentOutput,0);
        }
    }
    public static void shootingTarget() {
        shoot.set(ControlMode.PercentOutput,0.5);
    }
    public static void findingTarget() {
        turn.set(ControlMode.PercentOutput,0.5);
    }
    public static void aimingTarget(double shootSpeeed){
        shoot.set(ControlMode.PercentOutput,shootSpeeed);
    }
}