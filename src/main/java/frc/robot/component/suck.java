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
    private static Compressor comLeft;
    private static Boolean compreBoolean;
    private static DoubleSolenoid SolRight;
    private static DoubleSolenoid SolLeft;
    private static Boolean suckBoolean; 

    public static void init(){
         suck =  new WPI_VictorSPX(9);
         comRight = new Compressor();
         comLeft = new Compressor();
         SolRight = new DoubleSolenoid(0,1);
         SolLeft = new DoubleSolenoid(2,3);
         compreBoolean = true;
         suckBoolean = false;
         comRight.setClosedLoopControl(compreBoolean);
         comLeft.setClosedLoopControl(compreBoolean);
    }

    public static void teleop(){
        if(Robot.xbox_1.getRawButton(10)) {
            SolRight.set(Value.kForward);
            SolLeft.set(Value.kForward);
        }
        else{
            SolRight.set(Value.kOff);
            SolLeft.set(Value.kOff);
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