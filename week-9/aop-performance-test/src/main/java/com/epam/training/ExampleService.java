package com.epam.training;

import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @CustomTimer
    public void exampleMethodToTime() throws InterruptedException {
        System.out.println("Testee start!");

        Thread.sleep(1000);

        System.out.println("Testee end!");
    }

}

