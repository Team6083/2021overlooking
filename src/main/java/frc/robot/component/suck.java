package frc.robot.component;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class suck{
    private static VictorSP suck;
    private static Compressor com;
    private static DoubleSolenoid sol;
    private static boolean cansuck = false;
    private static final int port = 0;

    public static void init(){
        suck = new VictorSP(port);
        com = new Compressor();
        sol = new DoubleSolenoid(1,0);
        com.setClosedLoopControl(true);
        
        showDashboard();
    }

    public static void teleop(){
        if(Robot.maincontroller.getStickButtonPressed(Hand.kRight)){
            if(sol.get()==Value.kForward){
                sol.set(Value.kReverse);
            }else if(sol.get()==Value.kReverse){
                sol.set(Value.kForward);
            }
        }else{
            sol.set(Value.kOff);
        }

        if(sol.get()==Value.kForward){
            cansuck = true;
        }else{
            cansuck = false;
        }

        if(Robot.maincontroller.getYButton() && cansuck){
            suck.set(0.5);
        }else{
            suck.set(0);
        }
        
    }

    public static void showDashboard(){
        SmartDashboard.putBoolean("Suck/Solenoid", sol.get()==Value.kForward);
    }

}