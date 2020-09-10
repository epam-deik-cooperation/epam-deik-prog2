package com.epam.training;

public class ExceptionHandling {

    public void test(Object input) {
        try {
            System.out.println("Try!");
            if (input instanceof Float) {
                throw new ChildException();
            } else if (input instanceof String) {
                throw new ParentException();
            } else {
                throw new RuntimeException();
            }
        } catch (ChildException e) {
            System.out.println("Child Exception is caught!");
            if (e instanceof ParentException) {
                throw new ParentException();
            }
        } catch (ParentException e) {
            System.out.println("Parent Exception is caught!");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Exception is caught!");
        } finally {
            System.out.println("Finally!");
        }
    }

}
