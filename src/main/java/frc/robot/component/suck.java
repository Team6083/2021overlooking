package frc.robot.component;

import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class suck{
    private static WPI_VictorSPX suck;
    private static Compressor com;
    private static DoubleSolenoid left;
    private static DoubleSolenoid right;
    private static final int port = 9;

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
            suck.set(ControlMode.PercentOutput, 0.5);
        }else{
            suck.set(ControlMode.PercentOutput, 0);
        }
        
    }

    public static void showDashboard(){
        SmartDashboard.putBoolean("suck/LeftSolenoid", left.get()==Value.kForward);
        SmartDashboard.putBoolean("suck/RightSolenoid", right.get()==Value.kForward);
    }

}