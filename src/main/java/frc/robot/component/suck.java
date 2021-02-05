package frc.robot.component;

public class suck{
    WPI_VictorSPX suckleft;
    WPI_VictorSPX suckright;

    public static void init(){
        suckleft =  new WPI_VictorSPX( 1 );
        suckright  = new WPI_VictorSPX( 2 );
    }

    public static void teleop(){
        suckleft.set(ControlMode.PercentOutput, 0.5);
        suckright.set(ControlMode.PercentOutput, -0.5);
    }

}