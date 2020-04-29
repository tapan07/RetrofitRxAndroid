package com.tapan.retrofitrxandroid.home.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tapan.retrofitrxandroid.R;
import com.tapan.retrofitrxandroid.core.base.activity.BaseActivity;
import com.tapan.retrofitrxandroid.core.network.response.CellPhone;
import com.tapan.retrofitrxandroid.home.adapter.CellPhoneAdapter;
import com.tapan.retrofitrxandroid.home.presenter.HomePresenter;
import com.tapan.retrofitrxandroid.home.view.HomeView;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements HomeView {

  private RecyclerView mListView;
  private CellPhoneAdapter mCellPhoneAdapter;
  private List<CellPhone> mContentData;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setUp();
    initiateData();
  }

  private void initiateData() {
    HomePresenter<HomeView> mHomePresenter = new HomePresenter<>();
    mHomePresenter.onAttach(this);
    mHomePresenter.getCellPhoneContent();
  }

  private void setRecyclerView() {
    LinearLayoutManager manager = new LinearLayoutManager(this);
    mListView.setLayoutManager(manager);
    mCellPhoneAdapter = new CellPhoneAdapter(mContentData, this);
    DividerItemDecoration decoration =
        new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
    mListView.addItemDecoration(decoration);
    mListView.setAdapter(mCellPhoneAdapter);
  }

  @Override
  protected int getLayoutResource() {
    return R.layout.activity_home;
  }

  @Override
  protected void setUp() {
    mListView = findViewById(R.id.list_data);
  }

  @Override
  public void updateCellPhoneContent(List<CellPhone> cellPhones) {
    mContentData = new ArrayList<>();
    mContentData.addAll(cellPhones);
    setRecyclerView();
  }
}
