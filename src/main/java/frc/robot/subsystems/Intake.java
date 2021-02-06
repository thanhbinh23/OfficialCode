// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.DRIVE_CONST.*;
import static frc.robot.Constants.STICK_CONST.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Intake extends SubsystemBase {
  private static Intake INSTANCE;
  public static Intake getInstance() {
      // Fast (non-synchronized) check to reduce overhead of acquiring a lock when it's not needed
      if (INSTANCE == null) { // tránh giá trị bằng null
          // Lock to make thread safe 
          synchronized (Drivebase.class) {
              // check nullness again as multiple threads can reach above null check
              if (INSTANCE == null) {
                  INSTANCE = new Intake();
              }
          }
      }
      return INSTANCE;
  }
  public WPI_TalonSRX Intake = new WPI_TalonSRX(INTAKE_CAN);

  public void suck() {
  Intake.set(1);
  }
  public void stop() {
    Intake.stopMotor();
  }
}
