package com.tapan.retrofitrxandroid.home.view;

import com.tapan.retrofitrxandroid.core.base.view.BaseView;
import com.tapan.retrofitrxandroid.core.network.response.CellPhone;
import java.util.List;

public interface HomeView extends BaseView {

  void updateCellPhoneContent(List<CellPhone> cellPhones);
}
