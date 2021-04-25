package frc.robot.system;

import java.io.IOException;
import java.nio.file.Path;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;
import frc.robot.component.drivebase;

public class NewAutoEngine {

  protected static Timer timer = new Timer();

  protected static String trajectoryJSON = "output/1.wpilib.json";// path的路徑選擇
  protected static Trajectory trajectory = new Trajectory();

  public static void init() {

    // drive = new DifferentialDrive(leftmotor, rightmotor);

    try {
      Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON);
      trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
    } catch (IOException ex) {
      DriverStation.reportError("Unable to open trajectory: " + trajectoryJSON, ex.getStackTrace());
    }
    var pose = trajectory.getInitialPose();

    drivebase.setODOPose(pose);
  }

  public static void start() {
    drivebase.resetFilters();
    drivebase.resetPIDs();

    timer.reset();
    timer.start();
  }

  static int step = 0;

  public static void loop() {
    switch (step) {
    case 1:
      drivebase.runTraj(trajectory, timer.get());
      if (timer.get() > trajectory.getTotalTimeSeconds()) {
        step++;
        timer.reset();
        timer.start();
      }
      break;
    case 2:
      drivebase.runTraj(trajectory, timer.get());
      if (timer.get() > trajectory.getTotalTimeSeconds()) {
        step++;
        timer.reset();
        timer.start();
      }
      break;
    default:
      break;
    }
  }

}