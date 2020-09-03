package com.appian.footballappgame.app.detailnews.presenter;

import com.appian.footballappgame.app.BasePresenter;
import com.appian.footballappgame.app.detailnews.view.DetailNewsView;
import com.appian.footballappgame.data.interactor.NewsInteractor;
import com.appian.footballappgame.data.interactor.OnDetailNewsResponseListener;
import com.appnet.android.football.fbvn.data.DetailNewsAuto;

public class DetailNewsPresenter extends BasePresenter<DetailNewsView> implements OnDetailNewsResponseListener<DetailNewsAuto> {
    private final NewsInteractor mInteractor;

    public DetailNewsPresenter(NewsInteractor interactor) {
        mInteractor = interactor;
    }

    public void loadNewsDetail(String link) {
        if(link == "") {
            return;
        }
        mInteractor.loadNewsDetail(link, this);
    }

    @Override
    public void onSuccess(DetailNewsAuto data) {
        if(getView() == null) {
            return;
        }
        getView().showNews(data);
    }

    @Override
    public void onFailure(String error) {

    }
}
