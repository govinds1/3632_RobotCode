// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;


import frc.robot.Constants;
import frc.robot.commands.AutoShootCommand;
import frc.robot.commands.DrivetrainDriveForDuration;
import frc.robot.commands.DrivetrainTurnForDuration;
import frc.robot.commands.IntakeControlCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** An example command that uses an example subsystem. */
public class AutonTwoBall extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AutonTwoBall(DrivetrainSubsystem drivetrain, IntakeSubsystem intake, ShooterSubsystem shooter) {
      addCommands(
          new ParallelRaceGroup(
              new DrivetrainDriveForDuration(drivetrain, 3, Constants.AUTON_DRIVE_POWER),
              new IntakeControlCommand(intake, true)
          ),
          new DrivetrainTurnForDuration(drivetrain, Constants.AUTON_TURN90_TIME * 1.9, Constants.AUTON_TURN_POWER),
          new DrivetrainDriveForDuration(drivetrain, 3, Constants.AUTON_DRIVE_POWER),
          new AutoShootCommand(intake, shooter)
      );
  }
}
