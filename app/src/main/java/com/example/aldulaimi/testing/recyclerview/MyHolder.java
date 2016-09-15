package com.example.aldulaimi.testing.recyclerview;

/**
 * Created by Aldulaimi on 9/6/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.aldulaimi.testing.R;
import com.example.aldulaimi.testing.SecondActivity;
import com.example.aldulaimi.testing.TypeList;

/**
 * Created by Hp on 3/17/2016.
 */
public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    //OUR VIEWS
    ImageView img;
    ImageView img2;
    TextView nameTxt,posTxt;
    ItemClickListener itemClickListener;

    public MyHolder(final View itemView) {
        super(itemView);
        this.img= (ImageView) itemView.findViewById(R.id.imageView);
        this.img2= (ImageView) itemView.findViewById(R.id.imageView);
        this.nameTxt= (TextView) itemView.findViewById(R.id.textView);
        this.posTxt= (TextView) itemView.findViewById(R.id.textView2);

        //Player player = new Player();
        final View finalConvertView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getLayoutPosition() >= 0) {
                    // Start an activity
                    Toast.makeText(finalConvertView.getContext()
                            , "" + getAdapterPosition()
                            , Toast.LENGTH_SHORT).show();
                }


                //Intent intent = new Intent(v.getContext(), SecondActivity.class);
                    //v.getContext().startActivity(intent);


                // Start a fragment
                //TypeList typeList = new TypeList();
                //int i = (int) getItemId();
                //beginTransaction().replace(R.id.content_id, typeList).commit();

            }
        });
    }
    @Override
    public void onClick(View v) {
            this.itemClickListener.onItemClick(v, getLayoutPosition());
    }
    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }
}
