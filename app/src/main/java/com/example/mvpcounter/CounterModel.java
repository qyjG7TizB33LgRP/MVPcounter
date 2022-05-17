package com.example.mvpcounter;



public class CounterModel {

    private int count = 0;
    private boolean F = false;
    private boolean T = false;

    public void increment() {
        count++;
        switch (count){
            case  10:
                F = true ;
                T = false ;
                break;
            case  15:
                T = true ;
                F = false ;
                break;
            default:
                F = false;
                T = false ;
                break;
        }
    }

    public void decrement() {
        count--;
        switch (count){
            case  10:
                F = true ;
                T = false ;
                break;
            case  15:
                T = true ;
                F = false ;
                break;
            default:
                F = false;
                T = false ;
                break;
        }
    }

    public int getCount() {
        return count;
    }

    public boolean isFive() {
        return F;
    }

    public boolean isTen() {
        return T;
    }

    static class CounterPresenter implements PresenterContracts.CounterPresenter {
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
}


