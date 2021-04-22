package frc.robot.component;

import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class suck{
    private static WPI_VictorSPX suck;
    private static Compressor com;
    private static DoubleSolenoid left;
    private static DoubleSolenoid right;
    private static final int port = 1;
    public static boolean issucked;

    public static void init(){
        suck = new WPI_VictorSPX(port);
        com = new Compressor();
        left = new DoubleSolenoid(0,1);
        right = new DoubleSolenoid(2,3);
        com.setClosedLoopControl(true);
        
    }

    public static void teleop(){
        if(Robot.maincontroller.getStickButtonPressed(Hand.kRight)){     //check for if the code is right
            if(left.get()==Value.kForward && right.get()==Value.kForward){
                left.set(Value.kReverse);
                right.set(Value.kReverse);
            }else{
                left.set(Value.kForward);
                right.set(Value.kForward);
            }
        }else{
            left.set(Value.kOff);
            right.set(Value.kOff);
        }

        if(Robot.maincontroller.getYButton()){
            issucked = true;
            suck.set(ControlMode.PercentOutput, 0.5);
        }else{
            suck.set(ControlMode.PercentOutput, 0);
            issucked = false;
        }
        
    }

}