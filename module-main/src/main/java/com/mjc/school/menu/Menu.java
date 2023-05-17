package com.mjc.school.menu;

import com.mjc.school.controller.Command;
import com.mjc.school.controller.Operation;
import com.mjc.school.controller.command.CommandHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.mjc.school.controller.Constant.FIRST_OPERATION;
import static com.mjc.school.controller.Constant.LAST_OPERATION;

@Component
public class Menu {

    private final CommandHelper commandHelper;

    @Autowired
    public Menu(CommandHelper commandHelper) {
        this.commandHelper = commandHelper;
    }

    public void run() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            try {
                printMenu();
                int operationNumber = getOperationNumber(scanner);
                if (operationNumber >= FIRST_OPERATION && operationNumber <= LAST_OPERATION) {
                    Command command = commandHelper.getCommand(scanner, operationNumber);
                    isRunning = command.execute();
                } else System.out.println("Wrong number of operation");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printMenu() {
        System.out.println("Enter number of operation");
        for (Operation operation : Operation.values()) {
            System.out.println(operation.getOperationNumber() + ": " + operation.getOperationName());
        }
    }

    private int getOperationNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}