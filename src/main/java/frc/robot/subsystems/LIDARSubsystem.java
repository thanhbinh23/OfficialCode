// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;




import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.LIDARCommand;
import edu.wpi.first.wpilibj.DigitalSource;

public class LIDARSubsystem extends SubsystemBase {

  public void InitDefaultCommand() {
    setDefaultCommand(new LIDARCommand());
  }
  
  private static final int CALIBRATION_OFFSET = -6;

  private Counter counter;
  private int printedWarningCount = 5;

  /**
     * Create an object for a LIDAR-Lite attached to some digital input on the roboRIO
     * 
     * @param source The DigitalInput or DigitalSource where the LIDAR-Lite is attached (ex: new DigitalInput(9))
     */

  public void initLIDAR(DigitalSource source) {
    counter = new Counter(source);
    counter.setMaxPeriod(1.0);
    counter.setSemiPeriodMode(true);
    counter.reset();
  }

  public double getDistanceCm(boolean rounded){   //đo khoảng cách Cm
    double cm;
    if (counter.get() < 1) {
      if (printedWarningCount-- >0) {
        System.out.println("LidarLitePWM: chờ đo khoảng cách");
      }
      return 0;
    }
    cm = (counter.getPeriod() * 1000000.0/10.0) + CALIBRATION_OFFSET;
    if (!rounded){
      return cm;
    }
    else {
      return Math.floor(cm*10)/10;
    }
  }

  public double getDistanceIn(boolean rounded) {  //đo khoảng cách Inches
    double in = getDistanceCm(true) * 0.393700787;
    if(!rounded) {
      return in;
    }
    else{
      return Math.floor(in*10)/10;
    }
  }
}
