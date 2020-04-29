package com.tapan.retrofitrxandroid.home.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tapan.retrofitrxandroid.R;
import com.tapan.retrofitrxandroid.core.network.response.CellPhone;
import java.util.List;

public class CellPhoneAdapter extends RecyclerView.Adapter<CellPhoneAdapter.ViewHolder> {

  private List<CellPhone> cellPhones;
  private Context mContext;

  public CellPhoneAdapter(List<CellPhone> cellPhones, Context context) {
    this.cellPhones = cellPhones;
    this.mContext = context;
  }

  @NonNull
  @Override
  public CellPhoneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.row_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull final CellPhoneAdapter.ViewHolder holder, int position) {
    CellPhone cellPhone = cellPhones.get(position);
    holder.title.setText(cellPhone.getName());
    if (!TextUtils.isEmpty(cellPhone.getImageUrl())) {
      Glide.with(mContext)
          .load(cellPhone.getImageUrl())
          .addListener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model,
                Target<Drawable> target, boolean isFirstResource) {
              return true;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model,
                Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
              holder.image.setImageDrawable(resource);
              return true;
            }
          }).into(holder.image);
    }
  }

  @Override
  public int getItemCount() {
    return cellPhones.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {

    private AppCompatImageView image;
    private AppCompatTextView title;

    ViewHolder(@NonNull View itemView) {
      super(itemView);
      title = itemView.findViewById(R.id.item_title);
      image = itemView.findViewById(R.id.image_url);
    }
  }
}
