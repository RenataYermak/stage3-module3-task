package com.mjc.school.controller;

import com.mjc.school.controller.command.AuthorCreate;
import com.mjc.school.controller.command.AuthorDelete;
import com.mjc.school.controller.command.AuthorGetAll;
import com.mjc.school.controller.command.AuthorGetById;
import com.mjc.school.controller.command.AuthorUpdate;
import com.mjc.school.controller.command.ExitCommand;
import com.mjc.school.controller.command.NewsCreate;
import com.mjc.school.controller.command.NewsDelete;
import com.mjc.school.controller.command.NewsGetAll;
import com.mjc.school.controller.command.NewsGetById;
import com.mjc.school.controller.command.NewsUpdate;
import com.mjc.school.controller.command.TagCreate;
import com.mjc.school.controller.command.TagDelete;
import com.mjc.school.controller.command.TagGetAll;
import com.mjc.school.controller.command.TagGetById;
import com.mjc.school.controller.command.TagUpdate;
import com.mjc.school.service.dto.AuthorRequestDto;
import com.mjc.school.service.dto.AuthorResponseDto;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.dto.NewsResponseDto;
import com.mjc.school.service.dto.TagRequestDto;
import com.mjc.school.service.dto.TagResponseDto;

import java.util.Scanner;

public enum Operation {

    GET_ALL_NEWS(1, "Get all news") {
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new NewsGetAll((BaseController<NewsRequestDto, NewsResponseDto, Long>) controller);
        }
    },
    GET_NEWS_BY_ID(2, "Get news by id") {
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new NewsGetById(scanner, (BaseController<NewsRequestDto, NewsResponseDto, Long>) controller);
        }
    },
    CREAT_NEWS(3, "Create news") {
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new NewsCreate(scanner, (BaseController<NewsRequestDto, NewsResponseDto, Long>) controller);
        }
    },
    UPDATE_NEWS(4, "Update news") {
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new NewsUpdate(scanner, (BaseController<NewsRequestDto, NewsResponseDto, Long>) controller);
        }
    },
    DELETE_NEWS(5, "Delete news") {
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new NewsDelete(scanner, (BaseController<NewsRequestDto, NewsResponseDto, Long>) controller);
        }
    },
    GET_ALL_AUTHORS(6, "Get all authors") {
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new AuthorGetAll((BaseController<AuthorRequestDto, AuthorResponseDto, Long>) controller);
        }
    },
    GET_AUTHOR_BY_ID(7, "Get author by id") {
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new AuthorGetById(scanner, (BaseController<AuthorRequestDto, AuthorResponseDto, Long>) controller);
        }
    },
    CREATE_AUTHOR(8, "Create author") {
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new AuthorCreate(scanner, (BaseController<AuthorRequestDto, AuthorResponseDto, Long>) controller);
        }
    },
    UPDATE_AUTHOR(9, "Update author") {
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new AuthorUpdate(scanner, (BaseController<AuthorRequestDto, AuthorResponseDto, Long>) controller);
        }
    },
    DELETE_AUTHOR(10, "Delete author"){
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new AuthorDelete(scanner, (BaseController<AuthorRequestDto, AuthorResponseDto, Long>) controller);
        }
    },
    GET_ALL_TAGS(11, "Get all tags") {
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new TagGetAll((BaseController<TagRequestDto, TagResponseDto, Long>) controller);
        }
    },
    GET_TAG_BY_ID(12, "Get tag by id") {
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new TagGetById(scanner, (BaseController<TagRequestDto, TagResponseDto, Long>) controller);
        }
    },
    CREATE_TAG(13, "Create tag") {
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new TagCreate(scanner, (BaseController<TagRequestDto, TagResponseDto, Long>) controller);
        }
    },
    UPDATE_TAG(14, "Update tag") {
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new TagUpdate(scanner, (BaseController<TagRequestDto, TagResponseDto, Long>) controller);
        }
    },
    DELETE_TAG(15, "Delete tag"){
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new TagDelete(scanner, (BaseController<TagRequestDto, TagResponseDto, Long>) controller);
        }
    },
    EXIT_COMMAND(0, "Exit") {
        @Override
        public <T> Command getOperation(Scanner scanner, T controller) {
            return new ExitCommand();
        }
    };

    private final Integer operationNumber;
    private final String operationName;

    Operation(Integer operationNumber, String operationName) {
        this.operationNumber = operationNumber;
        this.operationName = operationName;
    }

    public abstract <T> Command getOperation(Scanner scanner, T controller);

    public Integer getOperationNumber() {
        return operationNumber;
    }

    public String getOperationName() {
        return operationName;
    }
}