package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

//import org.team6083.lib.RobotPower;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Robot;

public class sent {
    private static WPI_VictorSPX sent_high;
    private static WPI_VictorSPX sent_low;
    private static final int port_h = 4;
    private static final int port_l = 8;

    public static void init(){
        sent_high = new WPI_VictorSPX(port_h);
        sent_low = new WPI_VictorSPX(port_l);
    }

    public static void teleop(){
        if(Robot.vicecontroller.getBumper(Hand.kRight)){    //check for how to control
            sent_high.set(ControlMode.PercentOutput, 0.3);
            sent_low.set(ControlMode.PercentOutput, 0.3);
        }else if(Robot.vicecontroller.getBumper(Hand.kLeft)){
            sent_high.set(ControlMode.PercentOutput, -0.3);
            sent_low.set(ControlMode.PercentOutput, -0.3);
        }else if(Robot.vicecontroller.getBButton()){
            sent_high.set(ControlMode.PercentOutput,-0.3);
        }else if(Robot.vicecontroller.getAButton()){
            sent_low.set(ControlMode.PercentOutput,-0.3);
        }else{
            sent_high.set(ControlMode.PercentOutput, 0);
            sent_low.set(ControlMode.PercentOutput, 0);
        }


    }
}
