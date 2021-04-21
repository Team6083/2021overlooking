package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Robot;

public class shoot{
    private static WPI_VictorSPX shoot;
    private static WPI_VictorSPX spin;
    private static final int shootport = 2;
    private static final int spinport = 3;

    public static void init(){
        shoot =  new WPI_VictorSPX(shootport);
        spin = new WPI_VictorSPX(spinport);
    }
    
    public static void teleop(){

        if(Robot.xbox.getBumper(Hand.kRight)){
            spin.set(ControlMode.PercentOutput,0.3);
        }else if(Robot.xbox.getBumper(Hand.kLeft)){
            spin.set(ControlMode.PercentOutput, -0.3);
        }else{
            spin.set(ControlMode.PercentOutput,0);
        }

        if(Robot.xbox.getBButton()){
            shoot.set(ControlMode.PercentOutput,0.7);
        }else{
            shoot.set(ControlMode.PercentOutput, 0);
        }
        
    }

    public static void startshoot(boolean startshooting){
        if(startshooting){
            shoot.set(ControlMode.PercentOutput, 0.7);
        }else{
            shoot.set(ControlMode.PercentOutput, 0);
        }
    }

    public static boolean limit(){
        boolean keep = true;

        return keep;
    }

}