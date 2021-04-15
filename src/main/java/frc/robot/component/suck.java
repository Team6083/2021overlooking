package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Robot;

public class suck{
    private static WPI_VictorSPX suck;
    private static Compressor com1;
    private static Compressor com2;

    public static void init(){
         suck =  new WPI_VictorSPX( 1 );
         com1 = new Compressor();
         com2 = new Compressor()
    }

    public static void teleop(){
        if(Robot.xbox.getXButton()) {
            com1.setClosedLoopControl(true);
            com2.setClosedLoopControl(true);
            suck.set(ControlMode.PercentOutput, 0.5);
        }else{
            com1.setClosedLoopControl(false);
            com2.setClosedLoopControl(false);
            suck.set(ControlMode.PercentOutput, 0);
        }
        
    }

}