package com.example.mvpcounter.ui;

import com.example.mvpcounter.CounterPresenter;

public class Injector {
        public  static CounterPresenter getPresenter(){
            return new CounterPresenter();
        }


}
