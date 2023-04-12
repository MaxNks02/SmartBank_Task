package com.example.smartbank_task.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
@Log

// можно динамически изменять поведение кода с помощью аспектов
public class LoggingAspect {

    //аспект будет выполняться для всех методов из пакета контроллеров
    @Around("execution(* com.example.smartbank_task.controller..*(..)))")
    public Object profileControllerMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // считываем метаданные - что сейчас выполняется
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        // получить информацию о том, какой класс и метод выполняется
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        log.info("-------- Executing " + className + "." + methodName + "   ----------- " +
                LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")) + " | | " + LocalDate.now());

        StopWatch countdown = new StopWatch();

        //  засекаем время
        countdown.start();
        Object result = proceedingJoinPoint.proceed(); // выполняем сам метод
        countdown.stop();

        log.info("-------- Execution time of " + className + "." + methodName + " :: " + countdown.getTotalTimeMillis() + " ms");

        return result;
    }

}
