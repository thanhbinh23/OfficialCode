// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.DRIVE_CONST.*;

import static frc.robot.Constants.STICK_CONST.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Shooter extends SubsystemBase {
  private static Shooter INSTANCE;

    /**
     * Returns the Singleton instance of this Shooter. This static method
     * should be used by external classes, rather than the constructor
     * to get the instance of this class. For example: {@code Shooter.getInstance();}
     */
    public static Shooter getInstance() {
        // Fast (non-synchronized) check to reduce overhead of acquiring a lock when it's not needed
        if (INSTANCE == null) {
            // Lock to make thread safe 
            synchronized (Shooter.class) {
                // check nullness again as multiple threads can reach above null check
                if (INSTANCE == null) {
                    INSTANCE = new Shooter();
                }
            }
        }
        return INSTANCE;
    }
  public WPI_TalonSRX shooterMaster = new WPI_TalonSRX(SHOOTER_MASTER_CAN);
  public WPI_TalonSRX shooterFOLLOW = new WPI_TalonSRX(SHOOTER_FOLLOW_CAN);

  public Shooter() {
    shooterMaster.setInverted(true);
    shooterFOLLOW.follow(shooterMaster);
  }
  public void shoot(double x){
    shooterMaster.set(x);
  }
  @Override
  public void periodic() {
    if (RobotContainer.stick.getRawButton(8)) {
      shoot(1);
      }
      else {shoot(0);}
    }
  }
  
  


