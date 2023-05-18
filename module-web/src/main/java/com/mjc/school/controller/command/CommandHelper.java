package com.mjc.school.controller.command;

import com.mjc.school.controller.Command;
import com.mjc.school.controller.Constant;
import com.mjc.school.controller.Operation;
import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.controller.impl.TagController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

@Component
public class CommandHelper {

    private final NewsController newsController;
    private final AuthorController authorController;
    private final TagController tagController;

    @Autowired
    public CommandHelper(NewsController newsController, AuthorController authorController, TagController tagController) {
        this.newsController = newsController;
        this.authorController = authorController;
        this.tagController = tagController;
    }

    public Command getCommand(Scanner scanner, Integer operationNumber) {
        Operation operations;

        operations = Arrays.stream(Operation.values())
                .filter(operation -> Objects.equals(operation.getOperationNumber(), operationNumber)).
                findFirst().get();

        if (operationNumber >= Constant.NEWS_FIRST_OPERATION && operationNumber <= Constant.NEWS_LAST_OPERATION) {
            return operations.getOperation(scanner, newsController);
        }
        if (operationNumber >= Constant.AUTHOR_FIRST_OPERATION && operationNumber <= Constant.AUTHOR_LAST_OPERATION) {
            return operations.getOperation(scanner, authorController);
        }
        if (operationNumber >= Constant.TAG_FIRST_OPERATION && operationNumber <= Constant.TAG_LAST_OPERATION) {
            return operations.getOperation(scanner, tagController);
        }
        return new ExitCommand();
    }
}