package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Robot;

public class shoot{
    private static WPI_VictorSPX shoot;
    private static WPI_VictorSPX spin;
    private static final int shootport = 1;
    private static final int spinport = 11;

    public static void init(){
        shoot =  new WPI_VictorSPX(shootport);
        spin = new WPI_VictorSPX(spinport);
    }
    
    public static void teleop(){

        if(Robot.maincontroller.getTriggerAxis(Hand.kRight)>Robot.maincontroller.getTriggerAxis(Hand.kLeft)){
            spin.set(ControlMode.PercentOutput,0.3);
        }else if(Robot.maincontroller.getTriggerAxis(Hand.kLeft)>Robot.maincontroller.getTriggerAxis(Hand.kRight)){
            spin.set(ControlMode.PercentOutput, -0.3);
        }else{
            spin.set(ControlMode.PercentOutput,0);
        }

        if(Robot.maincontroller.getBButton()){
            shoot.set(ControlMode.PercentOutput,0.7);
        }else{
            shoot.set(ControlMode.PercentOutput, 0);
        }
        
    }

    public static void startshoot(){
        shoot.set(ControlMode.PercentOutput, 0.7);
    }

    public static void spin(double speed){
        spin.set(ControlMode.PercentOutput, speed);
    }

    public static boolean limit(){
        boolean keep = false;

        return keep;
    }

}