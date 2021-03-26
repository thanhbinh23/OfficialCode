// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivebase;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoNav1 extends SequentialCommandGroup {


  /** Creates a new Autonomous. */
  public AutoNav1(Drivebase drive) {
    super(
       new Run(drive, 1, 1).withTimeout(0.9),
       new Run(drive, 1, 0.2).withTimeout(0.3),
       new Run(drive, 1, 1).withTimeout(0.2),
       new Run(drive, 1, 0.2).withTimeout(0.3),
       new Run(drive, 1, 1).withTimeout(0.1),
       new Run(drive, 1, 0.2).withTimeout(0.3),
       new Run(drive, 1, 1).withTimeout(0.3),
       new Run(drive, 1, 0.2).withTimeout(0.5),
       new Run(drive, 1, 1).withTimeout(0.2),
       new Run(drive, 1, 0.2).withTimeout(0.2),
       new Run(drive, 1, 1).withTimeout(0.2),
       new Run(drive, 1, 0.2).withTimeout(0.2),
       new Run(drive, 1, 1).withTimeout(0.6),
       new Run(drive, 0.2, 1).withTimeout(0.2),
       new Run(drive, 1, 1).withTimeout(0.2),
       new Run(drive, 0.2, 1).withTimeout(0.4),
       new Run(drive, 1, 1).withTimeout(0.3),
       new Run(drive, 0.2, 1).withTimeout(0.1),
       new Run(drive, 1, 1).withTimeout(0.6),
       new Run(drive, 0.2, 1).withTimeout(0.3),
       new Run(drive, 1, 1).withTimeout(0.5),
       new Run(drive, 0.2, 1).withTimeout(0.1),
       new Run(drive, 1, 1).withTimeout(0.5),
       new Run(drive, 0.2, 1).withTimeout(0.3) //854,949
    );
       
  }
}
