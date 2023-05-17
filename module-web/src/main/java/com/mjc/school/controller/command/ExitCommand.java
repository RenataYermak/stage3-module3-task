package com.mjc.school.controller.command;

import com.mjc.school.controller.Command;

public class ExitCommand implements Command {

    @Override
    public boolean execute() {
        System.exit(0);
        return false;
    }
}