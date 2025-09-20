// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autos;

import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;

import java.io.IOError;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.commands.PathPlannerAuto;
import com.pathplanner.lib.path.PathPlannerPath;


public final class TopThreePieceMid extends SequentialCommandGroup {
  private List<PathPlannerPath> pathlist;
  public Pose2d startingPose;

  public TopThreePieceMid(String autoname) throws IOException, org.json.simple.parser.ParseException {
    pathlist = PathPlannerAuto.getPathGroupFromAutoFile(autoname);
    startingPose = pathlist.get(0).getStartingDifferentialPose();

    addCommands(
      Commands.sequence(
        AutoBuilder.followPath(pathlist.get(0)),
        AutoBuilder.followPath(pathlist.get(1)),
        AutoBuilder.followPath(pathlist.get(2))
      )
      
    );
  }

  public static Command exampleAuto(ExampleSubsystem m_exampleSubsystem) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'exampleAuto'");
  }
  
  
}
