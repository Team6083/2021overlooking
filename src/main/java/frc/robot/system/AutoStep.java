package frc.robot.system;

import frc.robot.component.VisionTracking;
import frc.robot.component.shoot;
import frc.robot.component.transport;

public class AutoStep extends AutoEngine {
        private static final int errAngle = 5;
        public static void loop(double d) {
            switch (step) {
                case 0:
                    /* walk "dis" inch */
                    currentStep = "walk";
                    eWalker.walk(15.748);
                    leftSpeed = eWalker.getLeftSpeed();
                    rightSpeed = eWalker.getRightSpeed();
                    if (eWalker.getLeftDis() > 15.748 || eWalker.getRightDis() > 15.748 ) {
                        nextStep();
                    }
                    break;
                case 1:
                    /* turn "angle" */
                    currentStep = "turn";
                    gWalker.setTargetAngle(d);
                    gWalker.calculate(leftSpeed, rightSpeed);
                    if (gWalker.getErrorAngle() < errAngle || d == 0) {
                        nextStep();
                    }
                    leftSpeed = 0;
                    rightSpeed = 0;
                    break;
                case 2:
                    /* take aim */
                    currentStep = "aim";
                    isAiming = true;
                    if (VisionTracking.detectIfTrackingFinished()) {
                        isAiming = false;
                        nextStep();
                    } else {
                        VisionTracking.seeking();
                    }
                    break;
                case 3:
                    /* shoot */
                    currentStep = "shoot";
                    leftSpeed = 0;
                    rightSpeed = 0;
                    gWalker.setTargetAngle(gWalker.getCurrentAngle());
                    shoot.shootingTarget();
                    transport.autonomousTransport();
                    break;
            }
        }
    }