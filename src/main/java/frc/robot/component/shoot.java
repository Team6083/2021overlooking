package frc.robot.component;

import edu.wpi.first.wpilibj.WPI_VictorSPX;

public class shoot{
    private static WPI_VictorSPX shoot;

    public static void init(){
         shoot =  new WPI_VictorSPX( 2 );
    }
    
    public static void teleop(){
        if(Robot.joy.getRawButton(2)){
            shoot.set(ControlMode.PercentOutput, 0.5);
        }else{
            shoot.set(ControlMode.PercentOutput, 0);
        }
        
    }

}