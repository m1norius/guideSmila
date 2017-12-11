package com.minorius.smilaguide.mvp.transport;

import android.view.View;
import android.widget.ProgressBar;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

/**
 * Created by minorius on 13.09.2017.
 */

public class TransportPresenterImpl extends MvpBasePresenter<TransportView> implements TransportPresenter {

    private BusModel busModel = new BusModel();
    private TrainModel trainModel = new TrainModel();

    @Override
    public void getListSmilaBus() {
        getView().showTransportBus(busModel.loadSmilaBusList());
    }

    @Override
    public void getListOutSmilaBus() {
        getView().showTransportBus(busModel.loadOutSmilaBusList());
    }

    @Override
    public void getListCherkassySmila() {
        getView().showTransportBus(busModel.loadCharkassySmilaList());
    }

    @Override
    public void getListSmilaCherkassy() {
        getView().showTransportBus(busModel.loadSmilaCharkassyList());
    }



    @Override
    public void getListTrainSmilaCherkassy() {
        getView().showProgressBar();
        Runnable runnable = () -> getView().showTransportTrain(trainModel.getList());
        trainModel.loadListTrainSmilaCherkassy(runnable);
    }

    @Override
    public void getListTrainCherkassySmila() {
        getView().showProgressBar();
        Runnable runnable = () -> getView().showTransportTrain(trainModel.getList());
        trainModel.loadListTrainCherkassySmila(runnable);
    }
}
