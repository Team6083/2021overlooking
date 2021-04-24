package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Robot;

public class suck{
    private static WPI_VictorSPX suck;
    private static Compressor comRight;
    private static Boolean compreBoolean;
    private static DoubleSolenoid SolRight;

    public static void init(){
         suck =  new WPI_VictorSPX(9);
         comRight = new Compressor();
         SolRight = new DoubleSolenoid(4,5);
         compreBoolean = true;
         comRight.setClosedLoopControl(compreBoolean);
    }

    public static void teleop(){
        if(Robot.xbox_1.getRawButton(10)) {
            SolRight.set(Value.kForward);
        }
        else{
            SolRight.set(Value.kOff);
        }

        if(Robot.xbox_1.getYButton()){
            suck.set(ControlMode.PercentOutput,0.5);
        }
        else if(Robot.xbox_2.getYButton()){
            suck.set(ControlMode.PercentOutput,-0.5);
        }
        else{
            suck.set(ControlMode.PercentOutput,0);
        }

    }

}