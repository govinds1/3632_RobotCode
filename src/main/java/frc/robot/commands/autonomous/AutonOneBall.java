// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;


import frc.robot.Constants;
import frc.robot.commands.AutoShootCommand;
import frc.robot.commands.DrivetrainDriveForDuration;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** An example command that uses an example subsystem. */
public class AutonOneBall extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AutonOneBall(DrivetrainSubsystem drivetrain, IntakeSubsystem intake, ShooterSubsystem shooter) {
      addCommands(
        new AutoShootCommand(intake, shooter),
        new DrivetrainDriveForDuration(drivetrain, 4, -Constants.AUTON_DRIVE_POWER)
      );
  }
}
