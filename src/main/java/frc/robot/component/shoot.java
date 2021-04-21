package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Robot;

public class shoot{
    private static WPI_VictorSPX shoot;
    private static WPI_VictorSPX turn;

    public static void init(){
         shoot =  new WPI_VictorSPX( 2 );
         turn = new WPI_VictorSPX(4);
    }
    
    public static void teleop(){
        if(Robot.xbox.getYButton()){
            shoot.set(ControlMode.PercentOutput, 0.5);
        }else{
            shoot.set(ControlMode.PercentOutput, 0);
        }
        if(Robot.xbox.getRawButton(4)){
            turn.set(ControlMode.PercentOutput,0.5);
        }
        else if(Robot.xbox.getRawButton(5)){
            turn.set(ControlMode.PercentOutput,-0.5);
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