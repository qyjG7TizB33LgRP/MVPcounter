package com.example.mvpcounter;

public class PresenterContracts{

    interface CounterView {
        void updateCount(int count);
        void toast();
        void setColor();
    }

    interface CounterPresenter {
        void increment();

        void decrement();
        void checkIsFive();
        void checkIsTen();

        void attachView(CounterView counterView);
    }
}


