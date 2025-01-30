package org.example;

import org.example.model.Stack;
import org.example.model.StaticStack;

import static org.example.util.StackUtil.print;

public class App {

    public static void main(String[] args) {
        Stack stack = new StaticStack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        print(stack);
    }

}