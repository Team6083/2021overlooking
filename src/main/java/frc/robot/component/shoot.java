package frc.robot.component;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Robot;

public class shoot{
    private static WPI_VictorSPX shoot;
    private static Compressor com;
    private static DoubleSolenoid left;
    private static DoubleSolenoid right;
    private static final int port = 2;

    public static void init(){
        com = new Compressor();
        left = new DoubleSolenoid(0,1);
        right = new DoubleSolenoid(2,3);
        shoot =  new WPI_VictorSPX(port);
        com.setClosedLoopControl(true);
    }
    
    public static void teleop(){
        if(Robot.xbox.getStartButton()){
            left.set(Value.kForward);
            right.set(Value.kForward);
        }{
            
        }

        if(Robot.xbox.getBButton()){
            shoot.set(ControlMode.PercentOutput,0.5);
        }else{
            shoot.set(ControlMode.PercentOutput, 0);
        }
        
    }

}