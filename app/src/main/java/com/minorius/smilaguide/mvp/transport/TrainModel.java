package com.minorius.smilaguide.mvp.transport;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.minorius.smilaguide.adapter.pojo.transport.MarkerTransport;
import com.minorius.smilaguide.adapter.pojo.transport.Train;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by minorius on 18.09.2017.
 */

public class TrainModel {

    Runnable runnable;

    public static final String URL_PATH_TRAIN_CHERKASY_SMILA = "http://poezdato.net/raspisanie-poezdov/cherkassy--im-tarasa-shevchenko/";
    public static final String URL_PATH_TRAIN_SMILA_CHERKASY = "http://poezdato.net/raspisanie-poezdov/smela--cherkassy/";

    ArrayList<MarkerTransport> listTransport = new ArrayList<>();

    public void loadListTrainSmilaCherkassy(Runnable runnable){
        this.runnable = runnable;
        TrainTimeTable trainTimeTable = new TrainTimeTable();
        trainTimeTable.execute(URL_PATH_TRAIN_SMILA_CHERKASY);
    }


    public void loadListTrainCherkassySmila(Runnable runnable){
        this.runnable = runnable;
        TrainTimeTable trainTimeTable = new TrainTimeTable();
        trainTimeTable.execute(URL_PATH_TRAIN_CHERKASY_SMILA);
    }




    private class TrainTimeTable extends AsyncTask<String, Void, ArrayList<MarkerTransport>> {

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<MarkerTransport> doInBackground(String... params) {
            ArrayList<MarkerTransport> trains = null;
            String url = params[0];
            try {
                Document doc = Jsoup.connect(url).get();
                Elements data = doc.select("tbody").select("tr");

                trains = new ArrayList<>();

                ArrayList<String> parseData = new ArrayList<>();

                for (int i = 0; i < data.size(); i++) {

                    Elements data_1 = data.get(i).select("td");

                    parseData.addAll(data_1.eachText());

                    trains.add(new Train(parseData.get(0), parseData.get(1), parseData.get(2), parseData.get(3), parseData.get(4)));
                    parseData.clear();

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return trains;
        }

        @Override
        protected void onPostExecute(ArrayList<MarkerTransport> list) {
            setListTransport(list);
            runnable.run();
            super.onPostExecute(list);
        }
    }

    public ArrayList<MarkerTransport> getList() {
        return listTransport;
    }

    public void setListTransport(ArrayList<MarkerTransport> listTransport) {
        this.listTransport = listTransport;
    }
}
