package com.sonlong.orderfoodserver.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sonlong.orderfoodserver.Common.Common;
import com.sonlong.orderfoodserver.Interface.ItemClickListener;
import com.sonlong.orderfoodserver.R;


public class MenuViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener {
        public TextView menu_name;
        public ImageView menu_image;

        private ItemClickListener itemClickListener;

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public MenuViewHolder(View itemView) {
            super(itemView);
            menu_name= itemView.findViewById(R.id.menu_name);
            menu_image = itemView.findViewById(R.id.menu_image);

            itemView.setOnCreateContextMenuListener(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.OnClick(view,getAdapterPosition(),false);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(0,0,getAdapterPosition(), Common.UPDATE);
            menu.add(0,1,getAdapterPosition(), Common.DELETE);
        }
}
