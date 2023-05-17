package com.mjc.school.service.validation;

import com.mjc.school.service.dto.AuthorRequestDto;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.exception.ValidationException;
import com.mjc.school.service.validation.annotation.Validate;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import static com.mjc.school.service.validation.constant.Constant.AUTHOR_ID;
import static com.mjc.school.service.validation.constant.Constant.AUTHOR_NAME_MAX;
import static com.mjc.school.service.validation.constant.Constant.AUTHOR_NAME_MIN;
import static com.mjc.school.service.validation.constant.Constant.NEWS_CONTENT_MAX;
import static com.mjc.school.service.validation.constant.Constant.NEWS_CONTENT_MIN;
import static com.mjc.school.service.validation.constant.Constant.NEWS_ID;
import static com.mjc.school.service.validation.constant.Constant.NEWS_TITLE_MAX;
import static com.mjc.school.service.validation.constant.Constant.NEWS_TITLE_MIN;

@Aspect
@Component
public class ValidationAspect {

    @Before(value = "@annotation(com.mjc.school.service.validation.annotation.Validate)&&args(id)")
    public void checkNewsId(JoinPoint joinPoint, Long id) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        methodSignature.getMethod();
        Validate validate = methodSignature.getMethod().getAnnotation(Validate.class);
        String value = validate.value();
        if (value.equals("checkNewsId")) {
            validateId(id, NEWS_ID);
        }
    }

    @Before(value = "@annotation(com.mjc.school.service.validation.annotation.Validate)&&args(newsRequestDto)")
    public void checkNewsRequestDto(JoinPoint joinPoint, NewsRequestDto newsRequestDto) throws ValidationException {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        methodSignature.getMethod();
        Validate validate = methodSignature.getMethod().getAnnotation(Validate.class);
        String value = validate.value();
        if (value.equals("checkNews")) {
            validateString(newsRequestDto.title(), NEWS_ID, NEWS_TITLE_MIN, NEWS_TITLE_MAX);
            validateString(newsRequestDto.content(), NEWS_ID, NEWS_CONTENT_MIN, NEWS_CONTENT_MAX);
            checkNewsId(joinPoint, newsRequestDto.id());
            checkNewsId(joinPoint, newsRequestDto.authorId());
        }
    }

    @Before(value = "@annotation(com.mjc.school.service.validation.annotation.Validate)&&args(authorRequestDto)")
    public void checkAuthorDtoRequest(AuthorRequestDto authorRequestDto) {
        validateString(authorRequestDto.name(), AUTHOR_ID, AUTHOR_NAME_MIN, AUTHOR_NAME_MAX);
    }

    void validateString(String value, String parameter, int minNumber, int maxNumber) {
        if (value == null) {
            throw new ValidationException("Value can not be empty");
        }
        if (value.trim().length() < minNumber || value.trim().length() > maxNumber) {
            throw new ValidationException("Author name should have length from 3 to 15.");
        }
    }

    private void validateId(Long id, String parameter) {
        if (id == null || id < 1) {
            throw new ValidationException("Id can be empty and negative");
        }
    }
}