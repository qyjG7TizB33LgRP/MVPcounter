package com.example.mvpcounter;

public class CounterPresenter

 implements PresenterContracts.CounterPresenter {
    PresenterContracts.CounterView counterView;
    CounterModel counterModel;

    public CounterPresenter() {
        counterModel = new CounterModel();

    }

    @Override
    public void increment() {
        counterModel.increment();
        counterView.updateCount(counterModel.getCount());
        checkIsFive();
        checkIsTen();
    }

    @Override
    public void decrement() {
        counterModel.decrement();
        counterView.updateCount(counterModel.getCount());
        checkIsFive();
        checkIsTen();
    }

    @Override
    public void checkIsFive() {
        if(counterModel.isFive()){
            counterView.toast();
        }
    }

    @Override
    public void checkIsTen() {
        if(counterModel.isTen()){
            counterView.setColor();
        }
    }

    @Override
    public void attachView(PresenterContracts.CounterView counterView) {
        this.counterView = counterView;
    }

}

