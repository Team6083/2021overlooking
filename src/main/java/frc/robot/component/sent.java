package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Robot;

public class sent {
    private static WPI_VictorSPX sent_h;
    private static WPI_VictorSPX sent_s;
    private static final int port_h = 8;
    private static final int port_s = 9;

    public static void init(){
        sent_h = new WPI_VictorSPX(port_h);
        sent_s = new WPI_VictorSPX(port_s);
    }

    public static void teleop(){
        if(Robot.xbox.getXButton()){    //check for how to control
            sent_h.set(ControlMode.PercentOutput, 0.3);
            sent_s.set(ControlMode.PercentOutput, 0.3);
        }else if(suck.issucked){
            sent_h.set(ControlMode.PercentOutput, 0.3);
        }else{
            sent_h.set(ControlMode.PercentOutput, 0);
            sent_s.set(ControlMode.PercentOutput, 0);
        }

    }
}
